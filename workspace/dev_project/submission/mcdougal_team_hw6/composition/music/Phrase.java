package composition.music;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import util.RandomUtil;
import app.Debug;

import composition.Composition;
import composition.LilyPondObject;
import composition.meta.Instrument;
import composition.meta.KeySignature;
import composition.meta.TimeSignature;

/**
 * Represents a phrase of music within the sheet music generation project. A
 * phrase is represented as a collection of notes and chords. Phrases are not
 * subdivided into measures because this would isolate groups of notes and make
 * it more difficult to keep them related to each other.
 * 
 * @see Note
 * @see Chord
 */
public class Phrase extends MusicParent implements LilyPondObject {
    
    /**
     * Types of transformations that can be performed on the notes within this
     * Phrase.
     */
    private enum Transformation {
        SPLIT_NOTE, INSERT_REST, HARMONIZE, CHORD
    }
    
    /////////////////////////////////
    //
    //  CONSTRUCTORS
    //
    /////////////////////////////////
    
    /**
     * Constructs a new, pseudo-randomly generated Phrase.
     * 
     */
    public Phrase(Composition composition, int numMeasures) {
        super(composition, numMeasures);
    }
    
    /**
     * Constructs a new Phrase with the given values. It is helpful to use this
     * constructor when cloning a Phrase.
     */
    public Phrase(Composition composition, int numMeasures, List<MusicObject> notes) {
        super(composition, numMeasures, notes);
    }

    /////////////////////////////////
    //
    //  GENERATION
    //
    /////////////////////////////////
    
    /**
     * Returns a pseudo-random List of MusicObject children based on the
     * Composition's properties. Every MusicObject in the returned List will
     * be either of the <code>Note</code> class or the <code>Chord</code> class.
     * 
     * @see Note
     * @see Chord
     */
    public List<MusicObject> generateContents() {
        
        // get composition related variables for easy access
        TimeSignature timeSig = this.getComposition().getTimeSignature();
        KeySignature key = this.getComposition().getKey();
        Instrument instrument = this.getComposition().getInstrument();
        int difficulty = this.getComposition().getDifficulty();
        
        // a note is generated for every beat
        int numBeatsInPhrase = timeSig.getBeatsPerMeasure() * this.getNumMeasures();
        
        List<MusicObject> notes = new ArrayList<MusicObject>(numBeatsInPhrase);
        
        int lowPitch = instrument.getLowestPitchForNote(key.getNote());
        
        if (instrument.getRangeInOctaves() > 2) {
            int lowestPlayablePitch = instrument.getLowestPitch();
            int distToLowestPitch = lowPitch - lowestPlayablePitch;
            
            // guitar plays low notes easily
            if (!instrument.equals(Instrument.GUITAR) && distToLowestPitch < 9)
                lowPitch = lowPitch + Note.NUM_NOTES;
        }
        
        int highPitch;
        if (difficulty > 50) {
            if (instrument.getRangeInOctaves() > 3) {
                int rndm = new Random().nextInt(3);
                if (rndm == 0)
                    highPitch = Note.getPitch(key.getNote(), Note.getOctaveFromPitch(lowPitch) + 2);
                else if (rndm == 1)
                    highPitch = Note.getPitch(key.getNoteAtScaleDegree(3), Note.getOctaveFromPitch(lowPitch) + 2);
                else
                    highPitch = Note.getPitch(key.getNoteAtScaleDegree(4), Note.getOctaveFromPitch(lowPitch) + 2);
            }
            else {
                highPitch = instrument.getHighestPitchForNote(key.getNote());
                
                int highNote = key.getNoteAtScaleDegree(3);
                int tempPitch = instrument.getHighestPitchForNote(highNote);
                if (tempPitch > highPitch)
                    highPitch = tempPitch;
                
                highNote = key.getNoteAtScaleDegree(4);
                tempPitch = instrument.getHighestPitchForNote(highNote);
                if (tempPitch > highPitch)
                    highPitch = tempPitch;
            }
        }
        else {
            highPitch = Note.getPitch(key.getNote(), Note.getOctaveFromPitch(lowPitch) + 1);
        }
        
        if (lowPitch < instrument.getLowestPitch()) {
            // programming error
            Debug.printException(new Exception("Low pitch is out of instrument's range."));
            return null;
        }
        if (highPitch > instrument.getHighestPitch()) {
            // programming error
            Debug.printException(new Exception("High pitch is out of instrument's range."));
            return null;
        }
        
        if (RandomUtil.rndmChance(1, 2))
            notes.addAll(getArchContour(numBeatsInPhrase, lowPitch, lowPitch, highPitch));
        else
            notes.addAll(getInvertedArchContour(numBeatsInPhrase, highPitch, highPitch, lowPitch));
        
        return notes;
    }
    
    /**
     * Returns a List of notes and/or chords that follow the contour of an
     * upwards arch.
     * 
     * @param numBeats the number of beats to make this arch
     * @param firstPitch the first pitch in the arch
     * @param lastPitch the last pitch in the arch
     * @param peakPitch the highest pitch in the arch (MUST be HIGHER than both
     *           the first pitch AND the last pitch
     */
    private List<MusicObject> getArchContour(int numBeats, int firstPitch, int lastPitch, int peakPitch) {
        KeySignature key = this.getComposition().getKey();
        
        int lengthOfDownSection = numBeats / 2;
        int lengthOfUpSection = numBeats - lengthOfDownSection;
        
        int peakOfUpSection = key.getPitchAtInterval(peakPitch, -1);
        
        List<MusicObject> arch = getAscendingRampContour(lengthOfUpSection, firstPitch, peakOfUpSection);
        arch.addAll(getDescendingRampContour(lengthOfDownSection, peakPitch, lastPitch));
        
        return arch;
    }
    
    /**
     * Returns a List of notes and/or chords that follow the contour of a
     * downwards arch.
     * 
     * @param numBeats the number of beats to make this arch
     * @param firstPitch the first pitch in the arch
     * @param lastPitch the last pitch in the arch
     * @param peakPitch the highest pitch in the arch (MUST be LOWER than both
     *           the first pitch AND the last pitch
     */
    private List<MusicObject> getInvertedArchContour(int numBeats, int firstPitch, int lastPitch, int peakPitch) {
        KeySignature key = this.getComposition().getKey();
        
        int lengthOfUpSection = numBeats / 2;
        int lengthOfDownSection = numBeats - lengthOfUpSection;
        
        int peakOfDownSection = key.getPitchAtInterval(peakPitch, 1);
        
        List<MusicObject> arch = getDescendingRampContour(lengthOfDownSection, firstPitch, peakOfDownSection);
        arch.addAll(getAscendingRampContour(lengthOfUpSection, peakPitch, lastPitch));
        
        return arch;
    }
    
    /**
     * Returns a List of notes and/or chords that follow an ascending contour
     * that is shaped like a ramp.
     * 
     * @param numBeats the number of beats to make this ramp
     * @param firstPitch the first pitch in the ramp
     * @param peakPitch the last and highest pitch in the ramp (MUST be HIGHER
     *           than the first pitch
     */
    private List<MusicObject> getAscendingRampContour(int numBeats, int firstPitch, int peakPitch) {
        
        if (firstPitch >= peakPitch) {
            // programming error
            Debug.printException(new Exception("First pitch must be lower than peak pitch for descending ramp contour."));
            return null;
        }
        
        return getRampContour(true, numBeats, firstPitch, peakPitch);
    }
    
    /**
     * Returns a List of notes and/or chords that follow a descending contour
     * that is shaped like a ramp.
     * 
     * @param numBeats the number of beats to make this ramp
     * @param firstPitch the first pitch in the ramp
     * @param peakPitch the last and lowest pitch in the ramp (MUST be LOWER
     *           than the first pitch
     */
    private List<MusicObject> getDescendingRampContour(int numBeats, int firstPitch, int peakPitch) {
        
        if (firstPitch <= peakPitch) {
            // programming error
            Debug.printException(new Exception("First pitch must be higher than peak pitch for descending ramp contour."));
            return null;
        }
        
        return getRampContour(false, numBeats, firstPitch, peakPitch);
    }
    
    /**
     * Returns a List of notes and/or chords that follow a contour that is
     * shaped like a ramp. This method makes the majority of the decisions
     * regarding note generation.
     * 
     * @param ascending if true, the ramp will go up; if false, it will go down
     * @param numBeats the number of beats to make this ramp
     * @param firstPitch the first pitch in the ramp
     * @param peakPitch the last pitch in the ramp
     */
    private List<MusicObject> getRampContour(boolean ascending, int numBeats, int firstPitch, int peakPitch) {
        
        Random r = new Random();

        KeySignature key = this.getComposition().getKey();
        TimeSignature timeSig = this.getComposition().getTimeSignature();

        int rampDirection = ascending ? 1 : -1;
        int beatDuration = Note.SHORTEST_DURATION / timeSig.getBeatDuration();
        
        List<MusicObject> notes = new ArrayList<MusicObject>(numBeats);
        notes.add(new Note(firstPitch, beatDuration));
        
        int pitch = firstPitch;
        int interval = 0;
        
        for (int i = 1; i < numBeats; i++) {
            
            boolean isLastBeat = i == numBeats - 1;
            
            // last note must be peak
            if (isLastBeat) {
                notes.add(new Note(peakPitch, beatDuration));
                break;
            }

            boolean isSecondToLastBeat = i == numBeats - 2;
            boolean isThirdToLastBeat = i == numBeats - 3;
            boolean isFourthToLastBeat = i == numBeats - 4;
            int distanceToPeak = Math.abs(peakPitch - pitch);
            
            // last few notes should be close to peak
            if ((isSecondToLastBeat || isThirdToLastBeat || isFourthToLastBeat)
                    && distanceToPeak > 3) {
                
                interval = rampDirection;
                
                int criticalDistance;
                if (isSecondToLastBeat)
                    criticalDistance = 4;
                else if (isThirdToLastBeat)
                    criticalDistance = 6;
                else
                    criticalDistance = 8;
                
                if (distanceToPeak > criticalDistance) {
                    pitch = key.getPitchAtInterval(pitch, interval);
                    distanceToPeak = Math.abs(peakPitch - pitch);
                    
                    while (distanceToPeak > criticalDistance) {
                        interval = interval + rampDirection;
                        pitch = key.getPitchAtInterval(pitch, interval);
                        distanceToPeak = Math.abs(peakPitch - pitch);
                    }
                    
                    notes.add(new Note(pitch, beatDuration));
                    continue;
                }
            }
            
            // if last interval was up more than 1 scale degree, resolve down a step
            else if (interval > 1) {
                interval = -1;
            }
            
            // if last interval was down more than 1 scale degree, resolve up a step
            else if (interval < -1) {
                interval = 1;
            }
            
            // low chance of staying on same note
            else if (RandomUtil.rndmChance(5, 100)) {
                interval = 0;
            }
            
            // if close to peak, back off
            else if (distanceToPeak <= 2) {
                interval = -rampDirection * (1 + r.nextInt(4));
            }
            
            // if close to first pitch, back off
            else if (Math.abs(pitch - firstPitch) <= 2) {
                interval = rampDirection * (1 + r.nextInt(4));
            }
            
            // if at scale degree 6, tendency to resolve up to tonic
            else if (key.getScaleDegreeOfPitch(pitch) == 6 && RandomUtil.rndmChance(1, 4)) {
                interval = 1;
            }
            
            // if major and at scale degree 3, tendency to resolve down to scale degree 2
            else if (key.isMajor() && key.getScaleDegreeOfPitch(pitch) == 3 && RandomUtil.rndmChance(1, 4)) {
                interval = -1;
            }
            
            else {
                
                // high chance of going in the ramp direction
                boolean moveInRampDir = RandomUtil.rndmChance(8, 10);
                
                // high chance of changing by a small interval;
                // 100% chance if this is the second to last beat
                boolean smallInterval = isSecondToLastBeat ? true : RandomUtil.rndmChance(8, 10);
                
                // small interval means go up or down 1 step
                if (smallInterval)
                    interval = moveInRampDir ? rampDirection : -rampDirection;
                
                // large interval means go up or down more than 1 step
                else {

                    // make sure a large step up doesn't reach or go past the peak
                    if (moveInRampDir) {
                        int maxInterval = rampDirection * 5;
                        int tempPitch = key.getPitchAtInterval(pitch, maxInterval);
                        boolean pastPeak = rampDirection == 1 ? tempPitch >= peakPitch : tempPitch <= peakPitch;
                        
                        while (pastPeak) {
                            maxInterval = maxInterval - rampDirection;
                            tempPitch = key.getPitchAtInterval(pitch, maxInterval);
                            pastPeak = rampDirection == 1 ? tempPitch >= peakPitch : tempPitch <= peakPitch;
                        }
                        
                        interval = rampDirection * (1 + r.nextInt(Math.abs(maxInterval)));
                    }
                    
                    else {
                        int maxInterval = -rampDirection * 5;
                        int tempPitch = key.getPitchAtInterval(pitch, maxInterval);
                        boolean pastFirstPitch = rampDirection == 1 ? tempPitch <= firstPitch : tempPitch >= firstPitch;
                        
                        while (pastFirstPitch) {
                            maxInterval = maxInterval + rampDirection;
                            tempPitch = key.getPitchAtInterval(pitch, maxInterval);
                            pastFirstPitch = rampDirection == 1 ? tempPitch <= firstPitch : tempPitch >= firstPitch;
                        }
                        
                        interval = -rampDirection * (1 + r.nextInt(Math.abs(maxInterval)));
                    }
                }
            }
            
            pitch = key.getPitchAtInterval(pitch, interval);

            Instrument instrument = this.getComposition().getInstrument();
            if (pitch < instrument.getLowestPitch() || pitch > instrument.getHighestPitch()) {
                // programming error
                Debug.printException(new Exception("Pitch is out of instrument's range."));
                return null;
            }
            
            notes.add(new Note(pitch, beatDuration));
        }
        
        return notes;
    }

    /////////////////////////////////
    //
    //  TRANSFORMATIONS
    //
    /////////////////////////////////

    @Override
    public void simplify() {
        TimeSignature timeSig = this.getComposition().getTimeSignature();
        
        int beatDuration = Note.SHORTEST_DURATION / timeSig.getBeatDuration();
        int beatsPerMeasure = timeSig.getBeatsPerMeasure();
        int durationPerMeasure = beatDuration * beatsPerMeasure;
        
        List<MusicObject> newContents = new ArrayList<MusicObject>();
        
        int currentUnit = 0;
        
        for (int i = 0; i < this.getContents().size(); i++) {
            MusicObject musicObject = this.getContents().get(i);
            
            MusicObject newObject = musicObject.clone();
            newContents.add(newObject);
            
            boolean isLastObject = i == this.getContents().size() - 1;
            
            if (!isLastObject) {
                MusicNode nextNode = (MusicNode) this.getContents().get(i + 1);
                int nextUnit = (currentUnit % durationPerMeasure) + nextNode.getLength();
                
                if (newObject.getClass().equals(Note.class)) {
                    Note note = (Note) newObject;
                    
                    if (nextUnit < durationPerMeasure) {
                        note.setLength(note.getLength() + nextNode.getLength());
                        i++;
                    }
                }
                else if (newObject.getClass().equals(Chord.class)) {
                    Chord chord = (Chord) newObject;
                    
                    if (nextUnit < durationPerMeasure) {
                        chord.setLength(chord.getLength() + nextNode.getLength());
                        i++;
                    }
                }
            }
            
            currentUnit = currentUnit + ((MusicNode) newObject).getLength();
        }
        
        this.setContents(newContents);
    }

    @Override
    public void complicate() {
        // small chance to split note into two shorter notes
        if (RandomUtil.rndmChance(1, 2))
            transformOnRandomPattern(Transformation.SPLIT_NOTE);

        // small chance to insert rests
        if (RandomUtil.rndmChance(1, 40))
            transformOnRandomPattern(Transformation.INSERT_REST);

        // small chance to replace note with harmony
        if (RandomUtil.rndmChance(1, 25))
            transformOnRandomPattern(Transformation.HARMONIZE);

        Instrument instrument = this.getComposition().getInstrument();
        
        // small chance to replace note with chord
        if (instrument.canPlayChords() && RandomUtil.rndmChance(1, 10)) {
            transformOnRandomPattern(Transformation.CHORD);
        }
    }
    
    @Override
    public void shiftNOctaves(int n) {
        Instrument instrument = this.getComposition().getInstrument();
        
        for (MusicObject musicObject : this.getContents()) {
            if (musicObject.getClass().equals(Note.class)) {
                Note note = (Note) musicObject;
                int newPitch = note.getPitch() + (Note.NUM_NOTES * n);
                
                if (newPitch >= instrument.getLowestPitch()
                        && newPitch <= instrument.getHighestPitch())
                    note.shiftNOctaves(n);
            }
            else if (musicObject.getClass().equals(Chord.class)) {
                Chord chord = (Chord) musicObject;
                int newRoot = chord.getRoot() + (Note.NUM_NOTES * n);
                
                KeySignature key = this.getComposition().getKey();
                
                if (newRoot >= instrument.getLowestPitch()
                        && newRoot <= instrument.getHighestPitch())
                    musicObject = new Chord(newRoot, instrument, key, chord.getLength());
            }
        }
    }
    
    @Override
    public void chordify() {
        List<MusicObject> newContents = new ArrayList<MusicObject>();
        
        for (MusicObject musicObject : this.getContents()) {
            if (musicObject.getClass().equals(Note.class))
                addChord((Note) musicObject, newContents, true);
        }
        
        this.setContents(newContents);
    }

    @Override
    public void harmonize() {
        List<MusicObject> newContents = new ArrayList<MusicObject>();
        
        for (MusicObject musicObject : this.getContents()) {
            if (musicObject.getClass().equals(Note.class))
                shiftToHarmony((Note) musicObject, newContents);
        }
        
        this.setContents(newContents);
    }
    
    /**
     * Performs the given transformation at a pseudo-randomly selected interval.
     * If the transformation would break the constraints set by the
     * Composition's properties, it is not performed.
     */
    private void transformOnRandomPattern(Transformation type) {
        TimeSignature timeSig = this.getComposition().getTimeSignature();
        
        Random r = new Random();

        int beatsPerMeasure = timeSig.getBeatsPerMeasure();
        int beatDuration = Note.SHORTEST_DURATION / timeSig.getBeatDuration();
        
        int beatInterval = r.nextInt(beatsPerMeasure);
        int measureInterval = 1 + r.nextInt(3);
        
        if (measureInterval > this.getNumMeasures())
            measureInterval = this.getNumMeasures();
        
        if (measureInterval == 0)
            return;
        
        List<MusicObject> newContents = new ArrayList<MusicObject>();
        
        int currentMeasure = 0;
        int currentBeat = 0;
        int currentUnit = 0;
        
        for (MusicObject musicObject : this.getContents()) {
            boolean takeAction =
                currentMeasure % measureInterval == 0
                && currentBeat == beatInterval;
            
            if (takeAction) {
                MusicNode node = (MusicNode) musicObject;
                
                switch(type) {
                    case SPLIT_NOTE : splitNote(node, newContents); break;
                    case INSERT_REST : insertRest(node, newContents); break;
                    case HARMONIZE : shiftToHarmony(node, newContents); break;
                    case CHORD : addChord(node, newContents); break;
                    default : newContents.add(node.clone());
                }
            }
            else {
                newContents.add(musicObject.clone());
            }

            currentUnit = currentUnit + ((MusicNode) musicObject).getLength();
            if (currentUnit % beatDuration == 0)
                currentBeat = (currentBeat + 1) % beatsPerMeasure;
            if (currentBeat == 0)
                currentMeasure++;
        }
        
        this.setContents(newContents);
    }
    
    /**
     * Splits the given MusicNode into two MusicNodes of equal length (if this
     * transformation is possible) and adds them both to the end of the given
     * list. The first MusicNode will always be the same pitch as the given
     * node, but the second one may or may not be different.
     * 
     * @param node the node to split
     * @param newList the list to add the new notes to
     */
    private void splitNote(MusicNode node, List<MusicObject> newList) {
        
        int nodeLength = node.getLength();
        MusicNode clone = (MusicNode) node.clone();
        
        // if the note can't be split any further
        if (nodeLength >= Note.SHORTEST_DURATION || nodeLength % 2 != 0) {
            newList.add(clone);
            return;
        }
        
        clone.setLength(node.getLength() / 2);
        newList.add(clone);
        
        // high chance of using a different note for split
        if (RandomUtil.rndmChance(85, 100)) {
            KeySignature key = this.getComposition().getKey();
            Instrument instrument = this.getComposition().getInstrument();
            
            int nextNoteInterval = RandomUtil.rndmChance(1, 2) ? 1 : -1;
            
            int addedPitch;
            if (node.getClass().equals(Note.class))
                addedPitch = key.getPitchAtInterval(((Note) node).getPitch(), nextNoteInterval);
            else // chord
                addedPitch = key.getPitchAtInterval(((Chord) node).getRoot(), nextNoteInterval);

            if (!instrument.pitchIsOutOfRange(addedPitch))
                newList.add(new Note(addedPitch, node.getLength() / 2));
            else
                newList.add((MusicObject) clone.clone());
        }
        else
            newList.add((MusicObject) clone.clone());
    }
    
    /**
     * Adds a rest of the same duration as the given MusicNode to the given
     * List of MusicObjects.
     * 
     * @param node provides the length for the rest
     * @param newList the list to add the rest to
     */
    private void insertRest(MusicNode node, List<MusicObject> newList) {
        newList.add(new Note(Note.NOTE_VALUES.REST, Note.NONE, node.getLength()));
    }
    
    /**
     * Adds a harmony of the given MusicNode to the given List of MusicObjects.
     * If the given MusicNode is not a Note, no action is taken.
     * 
     * @param node provides the root of the harmony
     * @param newList the list to add the new note to
     */
    private void shiftToHarmony(MusicNode node, List<MusicObject> newList) {
        if (!node.getClass().equals(Note.class))
            return;
        
        Note note = (Note) node;
        
        KeySignature key = this.getComposition().getKey();

        int newPitch;
        if (RandomUtil.rndmChance(3, 4))
            // third
            newPitch = key.getPitchAtInterval(note.getPitch(), 2);
        else
            // fifth
            newPitch = key.getPitchAtInterval(note.getPitch(), 4);
        
        Instrument instrument = this.getComposition().getInstrument();
        
        if (newPitch <= instrument.getHighestPitch())
            newList.add(new Note(newPitch, note.getLength()));
        else
            newList.add(note.clone());
    }
    
    /**
     * Adds a chord, using the given MusicNode as its root, to the given List
     * of MusicObjects. If the given MusicNode is not a Note, no action is
     * taken. If any of the notes in the chord are outside the range of the
     * instrument, those notes are not included in the chord.
     * 
     * @param node provides the root of the chord
     * @param newList the list to add the chord to
     */
    private void addChord(MusicNode node, List<MusicObject> newList) {
        if (!node.getClass().equals(Note.class))
            return;
        
        addChord((Note) node, newList, RandomUtil.rndmChance(1, 2));
    }
    
    /**
     * Adds a chord, using the given MusicNode as its root, to the given List
     * of MusicObjects. If the given MusicNode is not a Note, no action is
     * taken. If any of the notes in the chord are outside the range of the
     * instrument, those notes are not included in the chord.
     * 
     * @param node provides the root of the chord
     * @param newList the list to add the chord to
     * @param full if true, add a 3-note chord; if false, add a 2-note chord
     */
    private void addChord(Note note, List<MusicObject> newList, boolean full) {
        KeySignature key = this.getComposition().getKey();
        Instrument instrument = this.getComposition().getInstrument();
        
        int highestPlayablePitch = instrument.getHighestPitch();
        
        int rootPitch = note.getPitch();
        
        int thirdPitch = key.getPitchAtInterval(rootPitch, 2);
        if (thirdPitch > highestPlayablePitch)
            thirdPitch = Chord.NONE;
        
        int fifthPitch;
        if (full) {
            fifthPitch = key.getPitchAtInterval(rootPitch, 4);

            if (fifthPitch > highestPlayablePitch)
                fifthPitch = Chord.NONE;
        }
        else
            fifthPitch = Chord.NONE;
        
        newList.add(new Chord(rootPitch, thirdPitch, fifthPitch, note.getLength()));
    }

    /////////////////////////////////
    //
    //  GENERIC
    //
    /////////////////////////////////

    @Override
    public MusicObject clone() {
        return new Phrase(this.getComposition(),
                this.getNumMeasures(), this.cloneContents());
    }

    @Override
    public String getLilyPondHeader() {
        return "";
    }

    @Override
    public String getLilyPondSpacer() {
        return " ";
    }
}

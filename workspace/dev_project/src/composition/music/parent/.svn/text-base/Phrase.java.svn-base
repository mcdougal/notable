package composition.music.parent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import util.Debug;
import util.RandomUtil;

import composition.Composition;
import composition.LilyPondObject;
import composition.meta.Instrument;
import composition.meta.KeySignature;
import composition.meta.TimeSignature;
import composition.music.MusicObject;
import composition.music.node.Chord;
import composition.music.node.MusicNode;
import composition.music.node.Note;

/**
 * Represents a phrase of music within the sheet music generation project. A
 * phrase is represented as a collection of notes and chords. Phrases are not
 * subdivided into measures because this would isolate small groups of notes,
 * making it more difficult to relate them to each other.
 * 
 * @see Note
 * @see Chord
 */
public class Phrase extends MusicParent implements LilyPondObject {
	
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
     * Returns a melody in which there is a note on every beat.
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
    	
    	// the lowest pitch in the melody
    	int lowPitch = instrument.getLowestPitchForNote(key.getNote());
    	
    	// increase the lowest pitch if the instrument has a large range and the
    	// current lowest pitch is close to the lowest playable pitch
    	if (instrument.getRangeInOctaves() > 2) {
        	int lowestPlayablePitch = instrument.getLowestPitch();
    		int distToLowestPitch = lowPitch - lowestPlayablePitch;
    		
    		if (distToLowestPitch < 9)
    			lowPitch = lowPitch + Note.NUM_NOTES;
    	}
    	
    	// determine the highest pitch in the melody based on the difficulty
    	// and the instrument
    	int highPitch;
    	if (difficulty > 50) {
    		if (instrument.getRangeInOctaves() > 3) {
    			int rndm = RandomUtil.getRndm().nextInt(3);
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
    	
    	// randomly choose the melody's contour
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
     * 		  the first pitch AND the last pitch
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
     * 		  the first pitch AND the last pitch
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
     * 		  than the first pitch
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
     * 		  than the first pitch
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
    	
    	Random r = RandomUtil.getRndm();

    	KeySignature key = this.getComposition().getKey();
    	TimeSignature timeSig = this.getComposition().getTimeSignature();

    	int rampDirection = ascending ? 1 : -1;
    	int beatDuration = Note.SHORTEST_DURATION / timeSig.getBeatDuration();
    	
    	List<MusicObject> notes = new ArrayList<MusicObject>(numBeats);
    	notes.add(new Note(this.getComposition(), firstPitch, beatDuration));
    	
    	int pitch = firstPitch;
		int interval = 0;
		
    	for (int i = 1; i < numBeats; i++) {
    		
    		boolean isLastBeat = i == numBeats - 1;
    		
    		// last note must be peak
    		if (isLastBeat) {
    			notes.add(new Note(this.getComposition(), peakPitch, beatDuration));
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
        			
                	notes.add(new Note(this.getComposition(), pitch, beatDuration));
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
			
        	notes.add(new Note(this.getComposition(), pitch, beatDuration));
    	}
    	
    	return notes;
    }

    /////////////////////////////////
	//
    //  GENERIC
    //
	/////////////////////////////////
    
    @Override
    public String toLilyPondString() {
    	StringBuilder s = new StringBuilder();
    	
    	Composition c = this.getComposition();
    	TimeSignature timeSig = c.getTimeSignature();
    	
		int beatsPerMeasure = timeSig.getBeatsPerMeasure();
    	int beatDuration = Note.SHORTEST_DURATION / timeSig.getBeatDuration();
    	int measureLength = beatsPerMeasure * beatDuration;
    	
    	int currentUnit = 0;
		
		for (MusicObject musicObject : this.getContents()) {
			MusicNode node = (MusicNode) musicObject.clone();
			
			while (currentUnit + node.getLength() > measureLength) {
				MusicNode newNode = (MusicNode) node.clone();
				newNode.setLength(measureLength - currentUnit);
				s.append(newNode.toLilyPondString());
				s.append("~");
				
				node.setLength(node.getLength() - newNode.getLength());
				currentUnit = (currentUnit + newNode.getLength()) % measureLength;
			}
			
			s.append(node.toLilyPondString());
			currentUnit = (currentUnit + node.getLength()) % measureLength;
			
			s.append(getLilyPondSpacer());
		}
		
		return s.toString();
    }

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

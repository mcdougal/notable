//package composition.music;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//import composition.meta.Instrument;
//import composition.meta.KeySignature;
//import composition.meta.TimeSignature;
//
///**
// * Represents a beat within the sheet music generation project. A beat is
// * represented as a collection of notes.
// */
//public class Beat extends MusicObjectContainer {
//
//    /////////////////////////////////
//    //
//    //  VARIABLES
//    //
//    /////////////////////////////////
//
//    /** Note around which the other notes in this Beat are based */
//    Note root;
//
//    int[] durations;
//    
//
//    /////////////////////////////////
//    //
//    //  CONSTRUCTOR
//    //
//    /////////////////////////////////
//    
//    /**
//     * Constructs a new, pseudo-randomly generated Beat.
//     * 
//     * @param instrument the instrument on which this Beat should be played
//     * @param key the key signature of this Beat
//     * @param root note around which the other notes in this Beat are based
//     * @param durations the durations for each Note in this Measure
//     */
//    public Beat(
//            Instrument instrument,
//            TimeSignature timeSignature,
//            KeySignature key,
//            int length,
//            int difficulty,
//            Note root) {
//        
//        super(instrument, timeSignature, key, length, difficulty);
//
//        this.root = root;
//        this.durations = getRandomBeatDurations();
//        
//        this.generateSequentialContents();
//    }
//
//    /////////////////////////////////
//    //
//    //  GENERATION
//    //
//    /////////////////////////////////
//    
//    /**
//     * 
//     */
//    public int getTotalNumberOfSections() {
//        return this.getLength() * Note.SHORTEST_DURATION;
//    }
//    
//    /**
//     * 
//     */
//    public int getNumberOfUniqueSections() {
//        return this.getLength() * Note.SHORTEST_DURATION;
//    }
//    
//    /**
//     * 
//     * @return
//     */
//    public MusicObject createChild(int length) {
//        Note nextNote;
//        
//        if (this.getContents()[0] == null) {
//            nextNote = this.getKey().getRandomNote(this.getRoot(), this.getInstrument());
//        }
//        else {
//            int nextEmptyIndex = 0;
//            for (int i = 0; i < this.getContents().length; i++) {
//                if (this.getContents()[i] == null) {
//                    nextEmptyIndex = i;
//                    break;
//                }
//            }
//            
//            Note lastNote = (Note) this.getContents()[nextEmptyIndex - 1];
//            nextNote = this.getKey().getRandomNote(lastNote, this.getInstrument());
//        }
//        
//        nextNote.setLength(length);
//        
//        return nextNote;
//    }
//    
//    /**
//     * Returns an array of beat durations for a single beat. Beat durations are
//     * represented as an array of integers which signify how many notes to split
//     * a beat into, and how long each note should be. Length is measured in
//     * terms of the shortest note duration supported by this application.
//     * 
//     * For example, if every beat is 4 1/16 notes long and 1/16 notes are the
//     * shortest supported note duration, a possible value returned by this
//     * method might be:
//     * 
//     *     {1, 1, 1, 1}
//     *     
//     * which signifies that the beat is split into 4 consecutive 16th notes.
//     * Another possible return value is:
//     * 
//     *     {1, 1, 2}
//     *     
//     * which signifies that the beat is split into a 1/16 note followed by a
//     * 1/16 note followed by 2 1/16 notes played together (an 1/8 note). The sum
//     * of the values in the returned array MUST add to the length of the beat.
//     * 
//     * @param timeSignature contains information about the length of each beat
//     */
//    private int[] getRandomBeatDurations() {
//        TimeSignature timeSignature = this.getTimeSignature();
//        
//        int remainingLength = timeSignature.getLengthPerBeat();
//        
//        Random r = new Random();
//        
//        List<Integer> durationList = new ArrayList<Integer>();
//        
//        while (remainingLength > 0) {
//            int duration = 1 + r.nextInt(remainingLength);
//            durationList.add(new Integer(duration));
//            remainingLength = remainingLength - duration;
//        }
//        
//        int[] durations = new int[durationList.size()];
//        for (int i = 0; i < durationList.size(); i++) {
//            durations[i] = durationList.get(i).intValue();
//        }
//        
//        return durations;
//    }
//
//    /////////////////////////////////
//    //
//    //  LILYPOND
//    //
//    /////////////////////////////////
//    
//    /**
//     * Returns a LilyPond formatted String representing this Beat.
//     */
//    public String toLilyPondString() {
//        StringBuilder s = new StringBuilder();
//        
//        for (MusicObject note : this.getContents()) {
//            s.append(note.toLilyPondString());
//            s.append("  ");
//        }
//        
//        return s.toString();
//    }
//
//    /////////////////////////////////
//    //
//    //  GETTERS / SETTERS
//    //
//    /////////////////////////////////
//    
//    /**
//     * @return the note around which the other notes in this Beat are based
//     */
//    public Note getRoot() {
//        return root;
//    }
//    
//}

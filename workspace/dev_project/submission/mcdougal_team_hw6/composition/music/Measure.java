//package composition.music;
//
//import composition.meta.Instrument;
//import composition.meta.KeySignature;
//import composition.meta.TimeSignature;
//
///**
// * Represents a measure within the sheet music generation project. A measure is
// * represented as a collection of beats.
// */
//public class Measure extends MusicObjectContainer {
//
//    /////////////////////////////////
//    //
//    //  CONSTRUCTOR
//    //
//    /////////////////////////////////
//    
//    /**
//     * Constructs a new, pseudo-randomly generated Measure.
//     * 
//     * @param instrument the instrument on which this Measure should be played
//     * @param timeSignature the time signature of this Measure
//     * @param key the key signature of this Measure
//     * @param root note around which the other notes in this Measure are based
//     * @param durations the durations for each beat in this Measure
//     */
//    public Measure(
//            Instrument instrument,
//            TimeSignature timeSignature,
//            KeySignature key,
//            int length,
//            int difficulty) {
//        
//        super(instrument, timeSignature, key, length, difficulty);
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
//        return this.getLength();
//    }
//    
//    /**
//     * 
//     */
//    public int getNumberOfUniqueSections() {
//        return this.getLength();
//    }
//    
//    /**
//     * 
//     * @return
//     */
//    public MusicObject createChild(int length) {
//        Note root;
//        
//        if (this.getContents()[0] == null) {
//            root = this.getKey().getRandomNote(this.getRoot(), this.getInstrument());
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
//            Beat lastBeat = (Beat) this.getContents()[nextEmptyIndex - 1];
//            root = this.getKey().getRandomNote(lastBeat.getRoot(), this.getInstrument());
//        }
//        
//        return new Beat(
//                this.getInstrument(),
//                this.getTimeSignature(),
//                this.getKey(),
//                this.getTimeSignature().getBeatsPerMeasure(),
//                this.getDifficulty(),
//                root
//        );
//    }
//
//    /////////////////////////////////
//    //
//    //  LILYPOND
//    //
//    /////////////////////////////////
//    
//    /**
//     * Returns a LilyPond formatted String representing this Measure.
//     */
//    public String toLilyPondString(String indentation) {
//        StringBuilder s = new StringBuilder();
//        
//        for (MusicObject beat : this.getContents()) {
//            s.append(beat.toLilyPondString(indentation));
//            s.append("\t");
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
//     * @return the note around which the other notes in this Measure are based
//     */
//    public Note getRoot() {
//        return new Note(this.getKey().getKey(), this.getInstrument().getLowestOctave() + 1, Note.NONE);
//    }
//}

package composition;

import app.Debug;

import composition.meta.Instrument;
import composition.meta.Instrument.Clef;
import composition.meta.KeySignature;
import composition.meta.TimeSignature;
import composition.music.Chord;
import composition.music.MusicNode;
import composition.music.MusicObject;
import composition.music.Note;
import composition.music.Note.NOTE_VALUES;
import composition.music.Phrase;
import composition.music.Section;
import composition.music.Song;

/**
 * Represents an entire piece of music. This not only includes the notes but
 * also the meta-data like time signature and key signature.
 */
public class Composition implements LilyPondObject {

    /////////////////////////////////
    //
    //  CONSTANTS
    //
    /////////////////////////////////
    
    /**
     * Default properties
     */
    public static interface DEFAULT {
        public static final Instrument INSTRUMENT = Instrument.SOPRANO_RECORDER;
        public static final TimeSignature TIME_SIGNATURE = new TimeSignature(4, 4);
        public static final KeySignature KEY_SIGNATURE = new KeySignature(NOTE_VALUES.C, true);
        public static final int LENGTH = 32;
        public static final int DIFFICULTY = 50;
    }

    /////////////////////////////////
    //
    //  VARIABLES
    //
    /////////////////////////////////

    /** Instrument on which this music should be played */
    private Instrument instrument;
    
    /** Time signature */
    private TimeSignature timeSignature;
    
    /** Key signature */
    private KeySignature key;
    
    /** Length in measures */
    private int length;
    
    /** Difficulty of this music (1-100 inclusive) */
    private int difficulty;
    
    /** Music (i.e. bars, notes, etc.) */
    private Song song;

    /** Bass line for instruments that can play more than one note at a time */
    private Song bass;

    /////////////////////////////////
    //
    //  CONSTRUCTORS
    //
    /////////////////////////////////

    /**
     * Constructs a new MusicObject with the default values.
     */
    public Composition() {
        this(
                DEFAULT.INSTRUMENT,
                DEFAULT.TIME_SIGNATURE,
                DEFAULT.KEY_SIGNATURE,
                DEFAULT.LENGTH,
                DEFAULT.DIFFICULTY
        );
    }

    /**
     * Constructs a new MusicObject with the given values.
     */
    public Composition(
            Instrument instrument,
            TimeSignature timeSignature,
            KeySignature key,
            int length,
            int difficulty) {
        
        this.instrument = instrument;
        this.timeSignature = timeSignature;
        this.key = key;
        this.length = length;
        this.difficulty = difficulty;
    }

    /////////////////////////////////
    //
    //  SONG GENERATION
    //
    /////////////////////////////////
    
    /**
     * Pseudo-randomly generates a song based on the properties of this
     * Composition.
     */
    public void generateSong() {
        if (this.getInstrument().equals(Instrument.PIANO)) {
            bass = new Song(this, this.getLength());
            song = (Song) bass.clone();

            song.shiftNOctaves(2);
            song.harmonize();
            
            if (difficulty <= 20) {
                bass.simplify();
                bass.simplify();
            }
            else if (difficulty <= 50) {
                bass.simplify();
            }
            
            if (difficulty > 20) {
                bass.chordify();
            }
        }
        else if (this.getInstrument().equals(Instrument.GUITAR)) {
            bass = new Song(this, this.getLength());
            song = (Song) bass.clone();
                
            bass.shiftNOctaves(-1);
            
            if (difficulty <= 20) {
                bass.simplify();
                bass.simplify();
            }
            else if (difficulty <= 50) {
                bass.simplify();
            }
        }
        else {
            song = new Song(this, this.getLength());
        }
        
        int difficulty = this.getDifficulty();
        
        if (difficulty <= 10) {
            song.simplify();
            song.simplify();
        }
        if (difficulty <= 20)
            song.simplify();
        
        for (int i = 30; i < difficulty; i+=10) {
            song.complicate();
        }
        
        if (Debug.ON)
            checkSongAccuracy();
    }
    
    /**
     * Checks the song to make sure its notes are within the boundaries of
     * this Composition's properties. Used for debugging purposes.
     */
    public void checkSongAccuracy() {
        int lowestPitch = instrument.getLowestPitch();
        int highestPitch = instrument.getHighestPitch();
        
        int beatsPerMeasure = timeSignature.getBeatsPerMeasure();
        int beatDuration = Note.SHORTEST_DURATION / timeSignature.getBeatDuration();
        
        int lengthOfSong = beatsPerMeasure * beatDuration * length;
        int actualLength = 0;
        
        for (MusicObject section : song.getContents()) {
            Section s = (Section) section;
            
            for (MusicObject phrase : s.getContents()) {
                Phrase p = (Phrase) phrase;
                
                for (MusicObject node : p.getContents()) {
                    MusicNode n = (MusicNode) node;
                    
                    boolean failure = true;
                    if (n.getClass().equals(Note.class)) {
                        Note note = (Note) n;
                        int pitch = note.getPitch();
                        
                        failure = pitch != Note.NONE &&
                            (pitch < lowestPitch || pitch > highestPitch);
                        
                        if (failure) {
                            System.out.println("FAILURE: instrument range test on Note");
                            System.out.println("       : note pitch = "+note.getPitch());
                        }
                    }
                    else if (n.getClass().equals(Chord.class)) {
                        Chord chord = (Chord) n;
                        
                        int lowPitch = chord.getRoot();
                        int highPitch = lowPitch;
                        if (chord.getFifth() != Chord.NONE)
                            highPitch = chord.getFifth();
                        else if (chord.getThird() != Chord.NONE)
                            highPitch = chord.getThird();
                        
                        failure = lowPitch < lowestPitch || highPitch > highestPitch;
                        
                        if (failure) {
                            System.out.println("FAILURE: instrument range test on Chord");
                            System.out.println("       : low pitch = "+lowPitch);
                            System.out.println("       : high pitch = "+highPitch);
                        }
                    }
                    
                    if (failure) {
                        System.out.println("       : instr low  = "+lowestPitch);
                        System.out.println("       : instr high = "+highestPitch);
                        System.out.println("       : key = "+key.getNote());
                        System.out.println("       : difficulty = "+difficulty);
                    }
                    
                    actualLength = actualLength + n.getLength();
                }
            }
        }
        
        if (lengthOfSong != actualLength) {
            System.out.println("FAILURE: song length");
            System.out.println("       : expected length = "+lengthOfSong);
            System.out.println("       : actual length   = "+actualLength);
        }
    }

    /////////////////////////////////
    //
    //  LILYPOND
    //
    /////////////////////////////////
    
    /**
     * Returns a LilyPond formatted String representing this Composition.
     */
    public String toLilyPondString() {
        StringBuilder s = new StringBuilder();

        s.append("\\version \"2.12.0\" \n");
        s.append("\n");
        s.append("\\book {\n");
        s.append("\t\\score {\n");
        
        s.append("\t\t<<\n");
        s.append("\t\t\\new Staff {\n");
        
        s.append("\t\t\t<<\n");
        s.append("\t\t\t\\new Voice {\n");
        s.append("\t\t\t\t{ \n");
        s.append("\t\t\t\t\t% instrument: "+this.getInstrument().getName()+" \n");
        s.append("\t\t\t\t\t% measures: "+this.getLength()+" \n");
        s.append("\t\t\t\t\t% difficulty: "+this.getDifficulty()+" \n");
        s.append("\t\t\t\t\t\n");
        s.append("\t\t\t\t\t"+this.getInstrument().toLilyPondString()+" \n");
        s.append("\t\t\t\t\t"+this.getTimeSignature().toLilyPondString()+" \n");
        s.append("\t\t\t\t\t"+this.getKey().toLilyPondString()+" \n");
        s.append("\t\t\t\t\t\\tempo 4 = 120 \n");
        s.append("\t\t\t\t\t\n");
        s.append(song.toLilyPondString());
        s.append("\t\t\t\t}\n");
        s.append("\t\t\t}\n");
        
        if (this.getInstrument().equals(Instrument.GUITAR)) {
            s.append("\t\t\t\\new Voice {\n");
            s.append("\t\t\t\t{ \n");
//            s.append("\t\t\t\t\t"+this.getInstrument().toLilyPondString()+" \n");
//            s.append("\t\t\t\t\t"+this.getTimeSignature().toLilyPondString()+" \n");
//            s.append("\t\t\t\t\t"+this.getKey().toLilyPondString()+" \n");
//            s.append("\t\t\t\t\t\\tempo 4 = 120 \n");
//            s.append("\t\t\t\t\t\n");
            s.append(bass.toLilyPondString());
            s.append("\t\t\t\t}\n");
            s.append("\t\t\t}\n");
            
        }
        s.append("\t\t\t>>\n");
        s.append("\t\t}\n");
        
        if (this.getInstrument().equals(Instrument.PIANO)) {
            s.append("\t\t\\new Staff {\n");
            s.append("\t\t\t\\new Voice {\n");
            s.append("\t\t\t\t{ \n");
            s.append("\t\t\t\t\t"+Instrument.clefToLilyPondString(Clef.BASS)+" \n");
            s.append("\t\t\t\t\t"+this.getTimeSignature().toLilyPondString()+" \n");
            s.append("\t\t\t\t\t"+this.getKey().toLilyPondString()+" \n");
            s.append("\t\t\t\t\t\\tempo 4 = 120 \n");
            s.append("\t\t\t\t\t\n");
            s.append(bass.toLilyPondString());
            s.append("\t\t\t\t}\n");
            s.append("\t\t\t}\n");
            s.append("\t\t}\n");
        }
        
        s.append("\t\t>>\n\n");
        
        if (Debug.ON)
            s.append("\t\t\\midi { }\n");
        s.append("\t\t\\layout { }\n");
        s.append("\t}\n");
        s.append("}\n");
        
        return s.toString();
    }
    
    /////////////////////////////////
    //
    //  GETTERS / SETTERS
    //
    /////////////////////////////////
    
    /**
     * @return instrument on which this composition should be played
     */
    public Instrument getInstrument() {
        return instrument;
    }

    /**
     * Sets the instrument on which this composition should be played to the
     * given value.
     */
    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    /**
     * @return the time signature of this composition
     */
    public TimeSignature getTimeSignature() {
        return timeSignature;
    }

    /**
     * Sets the time signature of this composition to the given value.
     */
    public void setTimeSignature(TimeSignature timeSignature) {
        this.timeSignature = timeSignature;
    }

    /**
     * @return the key signature of this composition
     */
    public KeySignature getKey() {
        return key;
    }

    /**
     * Sets the key signature of this composition to the given value.
     */
    public void setKey(KeySignature key) {
        this.key = key;
    }

    /**
     * @return the length of this composition (in measures)
     */
    public int getLength() {
        return length;
    }

    /**
     * Sets the length of this composition (in measures) to the given value.
     * 
     * @param length 0 <= value < 100000
     * @throws Exception if the given parameter is invalid
     */
    public void setLength(int length) throws Exception {
        if (length < 0 || length >= 100000)
            throw new Exception(
                    "Length must be positive and less than 100,000.");
        
        this.length = length;
    }

    /**
     * @return the difficulty of this composition (1-100 inclusive)
     */
    public int getDifficulty() {
        return difficulty;
    }

    /**
     * Sets the difficulty of this composition to the given value.
     * 
     * @param difficulty 1-100 inclusive
     * @throws Exception if the given parameter is invalid
     */
    public void setDifficulty(int difficulty) throws Exception {
        if (difficulty < 1 || difficulty > 100)
            throw new Exception(
                    "Difficulty must be between 1 and 100, inclusive.");
        
        this.difficulty = difficulty;
    }
    
    /**
     * Returns the Song associated with this Composition. Used for testing
     * that the generated music falls within this Composition's parameters.
     */
    public Song getSong() {
        return song;
    }
    
    /**
     * Returns the bass line associated with this Composition. Used for testing
     * that the generated music falls within this Composition's parameters.
     */
    public Song getBass() {
        return bass;
    }
}

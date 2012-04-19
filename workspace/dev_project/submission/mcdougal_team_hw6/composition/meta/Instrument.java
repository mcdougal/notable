package composition.meta;

import composition.music.Note;
import composition.music.Note.NOTE_VALUES;
import composition.music.Note.OCTAVE_VALUES;

/**
 * Represents an instrument within the sheet music generation project.
 */
public class Instrument {
    
    /**
     * Supported clefs
     */
    public static enum Clef {
        TREBLE, BASS, GRAND_STAFF
    }

    /////////////////////////////////
    //
    //  VARIABLES
    //
    /////////////////////////////////
    
    /** Used to identify the instrument in the LilyPond output */
    private String name;

    /** Represents the lowest note and octave playable by this Instrument */
    private int lowestPitch;
    
    /** Represents the highest note and octave playable by this Instrument */
    private int highestPitch;

    /**
     * The size of this instrument's playable range, in terms of half-steps.
     * For example, a range of 2 octaves would 24 half-steps.
     */
    private int range;
    
    /** True if this instrument can play more than one note at a time */
    private boolean canPlayChords;

    /** The clef on which this instrument's sheet music is written */
    private Clef clef;

    /////////////////////////////////
    //
    //  CONSTRUCTOR
    //
    /////////////////////////////////

    /**
     * Constructs a new Instrument with the given values.
     */
    public Instrument(String name, int lowestNote, int lowestOctave,
            int rangeInOctaves, boolean canPlayChords, Clef clef) {
        
        this.name = name;
        this.lowestPitch = Note.getPitch(lowestNote, lowestOctave);
        this.range = rangeInOctaves * Note.NUM_NOTES;
        this.canPlayChords = canPlayChords;
        this.clef = clef;
        
        this.highestPitch = this.lowestPitch + this.range;
    }

    /////////////////////////////////
    //
    //  METHODS
    //
    /////////////////////////////////
    
    /**
     * Returns true if the given pitch is out of the playable range of this
     * Instrument.
     */
    public boolean pitchIsOutOfRange(int pitch) {
        return this.getLowestPitch() > pitch || pitch > this.getHighestPitch();
    }
    
    /**
     * Returns the lowest possible pitch on which this Instrument can play
     * the given note.
     */
    public int getLowestPitchForNote(int note) {
        int pitch = this.getLowestPitch();
        
        while (Note.getNoteFromPitch(pitch) != note) {
            pitch++;
        }
        
        return pitch;
    }
    
    /**
     * Returns the highest possible pitch on which this Instrument can play
     * the given note.
     */
    public int getHighestPitchForNote(int note) {
        int pitch = this.getHighestPitch();
        
        while (Note.getNoteFromPitch(pitch) != note) {
            pitch--;
        }
        
        return pitch;
    }
    
    /**
     * Returns a LilyPond formatted String representing this Instrument's clef.
     */
    public String toLilyPondString() {
        if (clef.equals(Clef.GRAND_STAFF))
            // bass staff is added individually
            return clefToLilyPondString(Clef.TREBLE);
        
        return clefToLilyPondString(this.getClef());
    }
    
    /**
     * Returns a LilyPond formatted String representing the given clef.
     */
    public static String clefToLilyPondString(Clef clef) {
        if (clef.equals(Instrument.Clef.TREBLE))
            return "\\clef treble";
        else
            return "\\clef bass";
    }

    /////////////////////////////////
    //
    //  GETTERS / SETTERS
    //
    /////////////////////////////////
    
    /**
     * Returns the name of this instrument.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Returns an integer representing the lowest note and octave playable by
     * this Instrument.
     */
    public int getLowestPitch() {
        return lowestPitch;
    }
    
    /**
     * Returns an integer representing the highest note and octave playable by
     * this Instrument.
     */
    public int getHighestPitch() {
        return this.highestPitch;
    }
    
    /**
     * Returns the size of this instrument's playable range, in terms of
     * half-steps. For example, a range of 2 octaves would 24 half-steps.
     */
    public int getRange() {
        return range;
    }
    
    /**
     * Returns the size of this instrument's playable range in octaves.
     */
    public int getRangeInOctaves() {
        return range / Note.NUM_NOTES;
    }

    /**
     * Returns true if this instrument can play more than one note at a time.
     */
    public boolean canPlayChords() {
        return canPlayChords;
    }
    
    /**
     * Returns the clef on which this instrument's sheet music is written.
     */
    public Clef getClef() {
        return clef;
    }

    /////////////////////////////////
    //
    //  INSTANCES
    //
    /////////////////////////////////

    /**
     * Instance of a soprano recorder instrument.
     */
    public static final Instrument SOPRANO_RECORDER = new Instrument(
            "Soprano Recorder",
            NOTE_VALUES.C, OCTAVE_VALUES.OCTAVE_4, // lowest written note and octave
            2, // range in octaves
            false, // can play chords
            Clef.TREBLE
    );
    

    /**
     * Instance of an alto recorder instrument.
     */
    public static final Instrument ALTO_RECORDER = new Instrument(
            "Alto Recorder",
            NOTE_VALUES.F, OCTAVE_VALUES.OCTAVE_3, // lowest written note and octave
            2, // range in octaves
            false, // can play chords
            Clef.TREBLE
    );

    /**
     * Instance of a concert flute instrument.
     */
    public static final Instrument CONCERT_FLUTE = new Instrument(
            "Concert Flute",
            NOTE_VALUES.B, OCTAVE_VALUES.OCTAVE_3, // lowest written note and octave
            3, // range in octaves
            false, // can play chords
            Clef.TREBLE
    );

    /**
     * Instance of an oboe instrument.
     */
    public static final Instrument OBOE = new Instrument(
            "Oboe",
            NOTE_VALUES.A_SHARP, OCTAVE_VALUES.OCTAVE_3, // lowest written note and octave
            2, // range in octaves
            false, // can play chords
            Clef.TREBLE
    );

    /**
     * Instance of a bassoon instrument.
     */
    public static final Instrument BASSOON = new Instrument(
            "Bassoon",
            NOTE_VALUES.A_SHARP, OCTAVE_VALUES.OCTAVE_1, // lowest written note and octave
            3, // range in octaves
            false, // can play chords
            Clef.BASS
    );

    /**
     * Instance of a violin instrument.
     */
    public static final Instrument VIOLIN = new Instrument(
            "Violin",
            NOTE_VALUES.G, OCTAVE_VALUES.OCTAVE_3, // lowest written note and octave
            2, // range in octaves
            false, // can play chords
            Clef.TREBLE
    );

    /**
     * Instance of a cello instrument.
     */
    public static final Instrument CELLO = new Instrument(
            "Cello",
            NOTE_VALUES.C, OCTAVE_VALUES.OCTAVE_2, // lowest written note and octave
            3, // range in octaves
            false, // can play chords
            Clef.BASS
    );

    /**
     * Instance of a guitar instrument.
     */
    public static final Instrument GUITAR = new Instrument(
            "Guitar",
            NOTE_VALUES.E, OCTAVE_VALUES.OCTAVE_3, // lowest written note and octave
            3, // range in octaves
            true, // can play chords
            Clef.TREBLE
    );

    /**
     * Instance of a piano instrument.
     */
    public static final Instrument PIANO = new Instrument(
            "Piano",
            NOTE_VALUES.C, OCTAVE_VALUES.OCTAVE_1, // lowest written note and octave
            6, // range in octaves
            true, // can play chords
            Clef.GRAND_STAFF
    );
}
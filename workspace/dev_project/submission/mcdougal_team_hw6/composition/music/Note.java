package composition.music;

import composition.LilyPondObject;

/**
 * Represents a note within the sheet music generation project. A note is
 * represented by a name (A, A#, B, etc.), an octave, and a duration.
 */
public class Note extends MusicNode implements LilyPondObject {

    /////////////////////////////////
    //
    //  CONSTANTS
    //
    /////////////////////////////////

    /** Used to signify no value for note, octave, or duration */
    public static final int NONE = -1;

    /** Inverse of the shortest note duration supported (i.e. 32 = 1/32 note) */
    public static final int SHORTEST_DURATION = 32;
    
    /**
     * The total number of notes. This is used to prevent the code from being
     * littered with random 12s whose meaning is not readily apparent.
     */
    public static final int NUM_NOTES = 12;

    /**
     * Integer values of each note name. A note name is the letter
     * representation of the note, possibly followed by a sharp sign (for
     * example: A, A#, B, etc.). The note name contains no information about the
     * octave or duration.
     * 
     * Note names are represented as integers in order to make transposition a
     * lot easier. For example, in order to transpose a song into a key that is
     * one half step higher, you simply have to add 1 to every note.
     * 
     * Keep in mind that there is a distinction made in the code between a
     * "note" and a "pitch." A "note" does not contain any information about
     * the octave, whereas a "pitch" is a unique integer representing both the
     * note and the octave.
     */
    public static interface NOTE_VALUES {
        public static final int REST = -1;
        public static final int C = 0;
        public static final int C_SHARP = 1;
        public static final int D = 2;
        public static final int D_SHARP = 3;
        public static final int E = 4;
        public static final int F = 5;
        public static final int F_SHARP = 6;
        public static final int G = 7;
        public static final int G_SHARP = 8;
        public static final int A = 9;
        public static final int A_SHARP = 10;
        public static final int B = 11;
    }
    
    /**
     * Integer values of every supported octave. Octaves range from 0-8. Octave
     * 4 contains middle C.
     * 
     * Octaves are represented as integers to make transposition a lot easier.
     * For example, in order to raise every note in a song by an octave, you
     * simply have to add 1 to every note's octave.
     */
    public static interface OCTAVE_VALUES {
        public static final int OCTAVE_0 = 0;
        public static final int OCTAVE_1 = 1;
        public static final int OCTAVE_2 = 2;
        public static final int OCTAVE_3 = 3;
        public static final int OCTAVE_4 = 4;
        public static final int OCTAVE_5 = 5;
        public static final int OCTAVE_6 = 6;
        public static final int OCTAVE_7 = 7;
        public static final int OCTAVE_8 = 8;
    }

    /////////////////////////////////
    //
    //  VARIABLES
    //
    /////////////////////////////////
    
    /** Note name (i.e. A, A#, B, C, etc.) */
    private int note;
    
    /** Note octave */
    private int octave;

    /////////////////////////////////
    //
    //  CONSTRUCTORS
    //
    /////////////////////////////////

    /**
     * Constructs a new Note with the given values.
     */
    public Note(int note, int octave, int length) {
        super(length);
        
        this.note = note;
        this.octave = octave;
    }
    
    /**
     * Constructs a new Note with the given values. The note and octave are
     * extracted from the given pitch.
     */
    public Note(int pitch, int length) {
        this(getNoteFromPitch(pitch), getOctaveFromPitch(pitch), length);
    }

    /////////////////////////////////
    //
    //  METHODS
    //
    /////////////////////////////////
    
    /**
     * Shifts the octave of this Note by the given amount.
     */
    public void shiftNOctaves(int n) {
        octave = octave + n;
    }
    
    /**
     * Returns the unique integer value of this note's pitch. The integer value
     * is derived in terms of the note and the octave.
     */
    public int getPitch() {
        return getPitch(this.getNote(), this.getOctave());
    }
    
    /**
     * Returns the unique integer value of the given note at the given octave.
     */
    public static int getPitch(int note, int octave) {
        if (note == NONE)
            return NONE;
        
        return (octave * NUM_NOTES) + note;
    }
    
    /**
     * Returns the integer note value extracted from the given pitch.
     */
    public static int getNoteFromPitch(int pitch) {
        if (pitch == NONE)
            return NONE;
        
        return pitch % NUM_NOTES;
    }
    
    /**
     * Returns the integer octave value extracted from the given pitch.
     */
    public static int getOctaveFromPitch(int pitch) {
        if (pitch == NONE)
            return NONE;
        
        return pitch / NUM_NOTES;
    }

    /////////////////////////////////
    //
    //  GENERIC
    //
    /////////////////////////////////
    
    @Override
    public String toTimelessLilyPondString() {
        StringBuilder s = new StringBuilder();
        
        switch(getNote()) {
            case NOTE_VALUES.REST : s.append("r"); break;
            case NOTE_VALUES.C : s.append("c"); break;
            case NOTE_VALUES.C_SHARP : s.append("cis"); break;
            case NOTE_VALUES.D : s.append("d"); break;
            case NOTE_VALUES.D_SHARP : s.append("dis"); break;
            case NOTE_VALUES.E : s.append("e"); break;
            case NOTE_VALUES.F : s.append("f"); break;
            case NOTE_VALUES.F_SHARP : s.append("fis"); break;
            case NOTE_VALUES.G : s.append("g"); break;
            case NOTE_VALUES.G_SHARP : s.append("gis"); break;
            case NOTE_VALUES.A : s.append("a"); break;
            case NOTE_VALUES.A_SHARP : s.append("ais"); break;
            case NOTE_VALUES.B : s.append("b"); break;
        }
        
        if (getNote() != NOTE_VALUES.REST) {
            switch(getOctave()) {
                case OCTAVE_VALUES.OCTAVE_0 : s.append(",,,"); break;
                case OCTAVE_VALUES.OCTAVE_1 : s.append(",,"); break;
                case OCTAVE_VALUES.OCTAVE_2 : s.append(","); break;
                case OCTAVE_VALUES.OCTAVE_3 : s.append(""); break;
                case OCTAVE_VALUES.OCTAVE_4 : s.append("'"); break;
                case OCTAVE_VALUES.OCTAVE_5 : s.append("''"); break;
                case OCTAVE_VALUES.OCTAVE_6 : s.append("'''"); break;
                case OCTAVE_VALUES.OCTAVE_7 : s.append("''''"); break;
                case OCTAVE_VALUES.OCTAVE_8 : s.append("'''''"); break;
            }
        }
        
        return s.toString();
    }
    
    @Override
    public Note clone() {
        return new Note(this.getNote(), this.getOctave(), this.getLength());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.getLength();
        result = prime * result + note;
        result = prime * result + octave;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Note other = (Note) obj;
        if (this.getLength() != other.getLength())
            return false;
        if (note != other.note)
            return false;
        if (octave != other.octave)
            return false;
        return true;
    }

    /////////////////////////////////
    //
    //  GETTERS / SETTERS
    //
    /////////////////////////////////

    /**
     * Returns the integer representation of this Note's note.
     * For example, A, A#, B, C, etc.
     */
    public int getNote() {
        return note;
    }

    /**
     * Returns the  integer representation of this Note's octave.
     */
    public int getOctave() {
        return octave;
    }
}
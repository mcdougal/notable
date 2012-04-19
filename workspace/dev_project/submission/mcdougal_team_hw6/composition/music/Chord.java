package composition.music;

import composition.meta.Instrument;
import composition.meta.KeySignature;

/**
 * Represents a chord that is made up of three notes.
 */
public class Chord extends MusicNode {

    /** Used to signify that a pitch has no value */
    public static final int NONE = -1;
    
    /////////////////////////////////
    //
    //  VARIABLES
    //
    /////////////////////////////////
    
    /** The root pitch of this Chord */
    private int rootPitch;
    
    /** The pitch at the third scale degree of the root */
    private int thirdPitch;
    
    /** The pitch at the fifth scale degree of the root */
    private int fifthPitch;
    
    /////////////////////////////////
    //
    //  CONSTRUCTORS
    //
    /////////////////////////////////
    
    /**
     * Constructs a new Chord with the given values.
     */
    public Chord(int rootPitch, int thirdPitch, int fifthPitch, int length) {
        super(length);
        
        this.rootPitch = rootPitch;
        this.thirdPitch = thirdPitch;
        this.fifthPitch = fifthPitch;
    }
    
    /**
     * Constructs a new Chord based on the given values.
     * 
     * @param rootPitch determines the values of the third and fifth pitches
     * @param instrument provides pitch boundaries
     * @param key the key signature that this Chord should conform to
     * @param length the length of this Chord, in terms of the smallest
     *           note duration supported by this application
     */
    public Chord(int rootPitch, Instrument instrument, KeySignature key, int length) {
        this(
            rootPitch,
            key.getPitchAtInterval(rootPitch, 2),
            key.getPitchAtInterval(rootPitch, 4),
            length
        );
        
        if (thirdPitch > instrument.getHighestPitch())
            thirdPitch = NONE;
        if (fifthPitch > instrument.getHighestPitch())
            fifthPitch = NONE;
    }
    
    /////////////////////////////////
    //
    //  GENERIC
    //
    /////////////////////////////////

    @Override
    public MusicObject clone() {
        return new Chord(rootPitch, thirdPitch, fifthPitch, this.getLength());
    }
    
    @Override
    public String toTimelessLilyPondString() {
        StringBuilder s = new StringBuilder();
        
        s.append("<");

        Note root = new Note(rootPitch, this.getLength());
        s.append(root.toTimelessLilyPondString()+" ");
        
        if (thirdPitch != NONE) {
            Note third = new Note(thirdPitch, this.getLength());
            s.append(third.toTimelessLilyPondString()+" ");
        }
        
        if (fifthPitch != NONE) {
            Note fifth = new Note(fifthPitch, this.getLength());
            s.append(fifth.toTimelessLilyPondString());
        }
        
        s.append(">");
        
        return s.toString();
    }
    
    /////////////////////////////////
    //
    //  GETTERS / SETTERS
    //
    /////////////////////////////////
    
    /**
     * Returns the root pitch of this Chord.
     */
    public int getRoot() {
        return rootPitch;
    }

    /**
     * Returns the pitch at the third scale degree of the root.
     */
    public int getThird() {
        return thirdPitch;
    }

    /**
     * Returns the pitch at the fifth scale degree of the root.
     */
    public int getFifth() {
        return fifthPitch;
    }
    
}

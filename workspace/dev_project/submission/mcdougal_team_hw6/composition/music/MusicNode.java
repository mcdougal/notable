package composition.music;

import util.MathUtil;

import composition.LilyPondObject;

/**
 * Represents a MusicObject that does not contain any other MusicObjects. This
 * might be a note or a chord.
 */
public abstract class MusicNode extends MusicObject implements LilyPondObject {

    /////////////////////////////////
    //
    //  VARIABLES
    //
    /////////////////////////////////

    /**
     * Returns the length of this MusicNode, in terms of the smallest note
     * duration supported by this application.
     * 
     * @see Note.SHORTEST_DURATION
     */
    private int length;
    
    /////////////////////////////////
    //
    //  ABSTRACT METHODS
    //
    /////////////////////////////////
    
    /**
     * Returns a LilyPond formatted String representing this MusicNode that
     * does NOT take into account the length of this MusicNode.
     */
    public abstract String toTimelessLilyPondString();

    /////////////////////////////////
    //
    //  CONSTRUCTORS
    //
    /////////////////////////////////

    /**
     * Constructs a new MusicNode with the given values.
     */
    public MusicNode(int length) {
        this.length = length;
    }

    /////////////////////////////////
    //
    //  METHODS
    //
    /////////////////////////////////
    
    /**
     * Returns a LilyPond formatted String representing this MusicNode. If the
     * node's duration does not translate into a single written note or chord
     * then it is either dotted or tied.
     * 
     * For example, a note of duration 7/16 cannot be represented as a single
     * note. Instead, it must be represented as a dotted 1/4 note tied to a
     * 1/16 note.
     */
    public String toLilyPondString() {
        StringBuilder s = new StringBuilder();

        int remainingLength = this.getLength();
        
        int currentLength;
        if (Note.SHORTEST_DURATION % remainingLength == 0 && Note.SHORTEST_DURATION / remainingLength == 1)
            currentLength = 1;
        else
            currentLength = MathUtil.getPowerOf2Ceiling(Note.SHORTEST_DURATION / remainingLength);
        
        s.append(toTimelessLilyPondString()+currentLength);
        remainingLength = remainingLength - (Note.SHORTEST_DURATION / currentLength);
        
        while (remainingLength > 0) {
            int nextLength = MathUtil.getPowerOf2Ceiling(Note.SHORTEST_DURATION / remainingLength);
            
            if (nextLength == currentLength * 2)
                s.append(".");
            else
                s.append("~"+toTimelessLilyPondString()+currentLength);
            
            currentLength = nextLength;
            remainingLength = remainingLength - (Note.SHORTEST_DURATION / currentLength);
        }
        
        return s.toString();
    }

    /**
     * The length of this MusicNode, in terms of the smallest note duration
     * supported by this application. For example, if the smallest supported
     * duration was 32nd notes, a length of 8 would mean this MusicNode is
     * 8 32nd notes long.
     * 
     * @see Note.SHORTEST_DURATION
     */
    public int getLength() {
        return length;
    }

    /**
     * Sets the length of this MusicNode to the given value. Length is measured
     * in terms of the smallest note duration supported by this application.
     * 
     * @see Note.SHORTEST_DURATION
     */
    public void setLength(int length) {
        this.length = length;
    }
}

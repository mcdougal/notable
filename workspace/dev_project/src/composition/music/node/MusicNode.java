package composition.music.node;

import java.util.List;

import composition.Composition;
import composition.LilyPondObject;
import composition.music.MusicObject;
import composition.music.transformation.Transformation;

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

	/** The root pitch of this node */
	private int rootPitch;
	
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
	public MusicNode(Composition composition, int rootPitch, int length) {
		super(composition);
		
		this.rootPitch = rootPitch;
		this.length = length;
	}

    /////////////////////////////////
	//
    //  METHODS
    //
	/////////////////////////////////
	
    /**
     * Returns the List of MusicNodes that results from applying the given
     * transformation to this MusicNode.
     */
    public List<MusicNode> applyTransformation(Transformation t) {
    	return t.transform(this);
    }
    
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
        int lastLength = this.getLength();
        
        while (remainingLength > 0) {
	        int curLength = 1;
	        while (curLength * 2 <= remainingLength && curLength * 2 <= Note.SHORTEST_DURATION) {
	        	curLength = curLength * 2;
	        }
	        
	        boolean dotted = curLength == lastLength / 2;
	        if (dotted) {
	        	s.append(".");
	        }
	        else {
	        	if (lastLength < this.getLength())
		        	s.append("~");
	        	
		        int lilyPondLength = Note.SHORTEST_DURATION / curLength;
		        s.append(toTimelessLilyPondString()+lilyPondLength);
	        }
	        
	        remainingLength = remainingLength - curLength;
	        lastLength = curLength;
        }
        
        return s.toString();
    }

    /////////////////////////////////
	//
    //  GETTERS / SETTERS
    //
	/////////////////////////////////
	
	/**
	 * Returns the root pitch of this MusicNode.
	 */
	public int getRootPitch() {
		return rootPitch;
	}
	
	/**
	 * Sets the root pitch of this MusicNode to the given value.
	 */
	public void setRootPitch(int rootPitch) {
		this.rootPitch = rootPitch;
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

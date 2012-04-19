package composition.music.parent;

import java.util.ArrayList;
import java.util.List;

import composition.Composition;
import composition.music.MusicObject;
import composition.music.transformation.Transformation;

/**
 * Represents a MusicObject that contains a List of MusicObjects. This could be
 * a List of other MusicParents or a list of MusicNodes.
 */
public abstract class MusicParent extends MusicObject {

    /////////////////////////////////
	//
    //  VARIABLES
    //
	/////////////////////////////////
	
	/** The length of this MusicParent in measures */
	private int numMeasures;

	/** The MusicObjects contained by this MusicParent */
	private List<MusicObject> contents;
	
    /////////////////////////////////
	//
    //  ABSTRACT METHODS
    //
	/////////////////////////////////

	/**
     * Returns a pseudo-random List of MusicObject children based on the
     * Composition's properties.
     */
    public abstract List<MusicObject> generateContents();
	
	/**
	 * Returns the header to use when converting this MusicParent to a String
	 * that can be read by LilyPond. The header will be inserted before the
	 * String representation of each child in this MusicParent.
	 * 
	 * Comment characters are NOT automatically added, and must be specified in
	 * the String returned by this method, or else the input to LilyPond might
	 * be invalid.
	 */
	public abstract String getLilyPondHeader();
	
	/**
	 * Returns a String that will be used to add space between the LilyPond
	 * String representations of this MusicParent's children.
	 */
	public abstract String getLilyPondSpacer();

    /////////////////////////////////
	//
    //  CONSTRUCTORS
    //
	/////////////////////////////////

    /**
     * Constructs a new MusicParent with the given values. Generates children
     * pseudo-randomly.
     */
    public MusicParent(Composition composition, int numMeasures) {
    	super(composition);
    	
    	this.numMeasures = numMeasures;
    	this.contents = generateContents();
    }

    /**
     * Constructs a new MusicParent with the given values.
     */
    public MusicParent(Composition composition,
    		int numMeasures, List<MusicObject> contents) {
    	
    	super(composition);
    	
    	this.numMeasures = numMeasures;
    	this.contents = contents;
    }

    /////////////////////////////////
	//
    //  TRANSFORMS
    //
	/////////////////////////////////
    
    /**
     * Applies the given transformation to all children of this MusicParent.
     */
    public void applyTransformation(Transformation t) {
    	if (this.getContents().size() == 0)
    		return;
    	
    	MusicObject car = this.getContents().get(0);
    	
    	if (car instanceof MusicParent) {
        	// if the children are MusicParents, pass the transformation to them
    		for (MusicObject musicObject : this.getContents()) {
            	((MusicParent) musicObject).applyTransformation(t);
        	}
    	}
    	else {
    		// if the children are MusicNodes, pass this MusicParent to the
    		// transformation object so the nodes can be transformed
    		t.transform(this);
    	}
    }
    
    /////////////////////////////////
	//
    //  GENERIC
    //
	/////////////////////////////////
    
    /**
     * Returns a DEEP copy of this MusicParent's children.
     */
    public List<MusicObject> cloneContents() {
    	List<MusicObject> clone = new ArrayList<MusicObject>(this.getContents().size());
    	
    	for (MusicObject object : this.getContents()) {
    		clone.add(object.clone());
    	}
    	
    	return clone;
    }
    
    /**
     * Returns a LilyPond formatted String representing this MusicParent.
     */
    public String toLilyPondString() {
        StringBuilder s = new StringBuilder();
        
        for (MusicObject musicObject : this.getContents()) {
        	s.append(this.getLilyPondHeader());
            s.append(musicObject.toLilyPondString());
            s.append(this.getLilyPondSpacer());
        }
        
        return s.toString();
    }
    
    /////////////////////////////////
	//
    //  GETTERS / SETTERS
    //
	/////////////////////////////////
	
	/**
	 * Returns the length of this MusicParent in measures.
	 */
	public int getNumMeasures() {
		return numMeasures;
	}
    
	/**
	 * Returns the MusicObject children of this MusicParent.
	 */
	public List<MusicObject> getContents() {
		return contents;
	}
	
	/**
	 * Sets the MusicObjects contained by this MusicParent to the given List
	 * of MusicObjects.
	 */
	public void setContents(List<MusicObject> contents) {
		this.contents = contents;
	}

}

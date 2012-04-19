package composition.music;

import java.util.ArrayList;
import java.util.List;

import composition.Composition;

/**
 * Represents any object that contains a List of MusicObjects. This could be
 * a List of other MusicParents or a list of MusicNodes.
 */
public abstract class MusicParent extends MusicObject {

    /////////////////////////////////
    //
    //  VARIABLES
    //
    /////////////////////////////////
    
    /** The composition that this MusicParent is a part of */
    private Composition composition;
    
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
     * Constructs a new MusicObject with the given values. Generates children
     * pseudo-randomly.
     */
    public MusicParent(Composition composition, int numMeasures) {
        this.composition = composition;
        this.numMeasures = numMeasures;
        this.contents = generateContents();
    }

    /**
     * Constructs a new MusicObject with the given values.
     */
    public MusicParent(Composition composition,
            int numMeasures, List<MusicObject> contents) {
        
        this.composition = composition;
        this.numMeasures = numMeasures;
        this.contents = contents;
    }

    /////////////////////////////////
    //
    //  TRANSFORMS
    //
    /////////////////////////////////

    /**
     * Transforms this MusicParent's contents so they are easier to play. 
     * 
     * All children affected by the transformation will still be within the
     * bounds of the Composition's properties.
     * 
     * The parameter <code>this.contents</code> MAY GET CHANGED by this method.
     */
    public void simplify() {
        for (MusicObject musicObject : this.getContents()) {
            if (musicObject instanceof MusicParent)
                ((MusicParent) musicObject).simplify();
        }
    }

    /**
     * Transforms this MusicParent's contents so they are more difficult
     * to play.
     * 
     * All children affected by the transformation will still be within the
     * bounds of the Composition's properties.
     * 
     * The parameter <code>this.contents</code> MAY GET CHANGED by this method
     */
    public void complicate() {
        for (MusicObject musicObject : this.getContents()) {
            if (musicObject instanceof MusicParent)
                ((MusicParent) musicObject).complicate();
        }
    }
    
    /**
     * Shifts the octaves of all children by the given integer.
     * 
     * All children affected by the transformation will still be within the
     * bounds of the Composition's properties. As such, this method may do
     * nothing if the octaves cannot be shifted without leaving the playable
     * range of the instrument.
     * 
     * The parameter <code>this.contents</code> MAY GET CHANGED by this method
     * 
     * @param n shift amount; can be negative, positive, or 0
     */
    public void shiftNOctaves(int n) {
        for (MusicObject musicObject : this.getContents()) {
            if (musicObject instanceof MusicParent)
                ((MusicParent) musicObject).shiftNOctaves(n);
        }
    }

    /**
     * Transforms every non-Chord MusicObject child to a Chord. This is
     * especially convenient when creating piano music because the left hand
     * often plays the bass part in chords.
     * 
     * All children affected by the transformation will still be within the
     * bounds of the Composition's properties.
     * 
     * The parameter <code>this.contents</code> MAY GET CHANGED by this method
     */
    public void chordify() {
        for (MusicObject musicObject : this.getContents()) {
            if (musicObject instanceof MusicParent)
                ((MusicParent) musicObject).chordify();
        }
    }

    /**
     * Shifts notes at a pseudo-randomly selected interval to notes that are
     * part of the changed note's harmony. For example, the tonic might be
     * converted into the third or fifth scale degree.
     * 
     * All children affected by the transformation will still be within the
     * bounds of the Composition's properties.
     * 
     * The parameter <code>this.contents</code> MAY GET CHANGED by this method
     */
    public void harmonize() {
        for (MusicObject musicObject : this.getContents()) {
            if (musicObject instanceof MusicParent)
                ((MusicParent) musicObject).harmonize();
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
     * Returns a LilyPond formatted String representing this Song.
     * 
     * @param indentation a String of tab or space chars to insert before each
     *           measure; this allows the output to be readable
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
     * Returns the composition that this MusicParent is a part of.
     */
    public Composition getComposition() {
        return composition;
    }
    
    /**
     * Returns the length of this MusicParent in measures.
     */
    public int getNumMeasures() {
        return numMeasures;
    }
    
    /**
     * Returns the MusicObjects contained by this MusicParent.
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

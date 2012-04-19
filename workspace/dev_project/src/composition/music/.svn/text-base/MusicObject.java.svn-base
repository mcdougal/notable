package composition.music;

import composition.Composition;
import composition.LilyPondObject;

/**
 * Top level class representing all objects that are a part of the generated
 * music. This could include things like sections, phrases, chords, and notes.
 * Every MusicObject belongs to some composition.
 */
public abstract class MusicObject implements LilyPondObject {
	
	/** The composition that this MusicObject is a part of */
	private Composition composition;
	
	/**
	 * Returns a DEEP copy of this MusicObject.
	 */
	public abstract MusicObject clone();
	
	/**
	 * Constructs a new MusicObject that belongs to the given Composition.
	 */
	public MusicObject(Composition composition) {
		this.composition = composition;
	}

    /**
     * Returns the composition that this MusicObject is a part of. This allows
     * for easy access of the composition's meta-data, like the instrument and
	 * time signature.
     */
	public Composition getComposition() {
		return composition;
	}
	
}

package composition.music;

import composition.LilyPondObject;

/**
 * Top level class representing all objects that are a part of the generated
 * music. This could include things like sections, phrases, chords, and notes.
 */
public abstract class MusicObject implements LilyPondObject {
    
    /**
     * Returns a DEEP copy of this MusicObject.
     */
    public abstract MusicObject clone();
    
}

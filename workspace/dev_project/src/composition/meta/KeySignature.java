package composition.meta;

import composition.LilyPondObject;
import composition.music.node.Note;
import composition.music.node.Note.NOTE_VALUES;

/**
 * Represents a key signature of a piece of music. Every key signature is either
 * of the major or the minor scale, and has a single note representing the first
 * note in the scale. There are always 7 notes in the scale.
 */
public class KeySignature implements LilyPondObject {

    /////////////////////////////////
	//
    //  CONSTANTS
    //
	/////////////////////////////////

	/**
	 * Intervals within the chromatic scale at which there are notes in the
	 * major scale. To figure out which note each number represents, set 0 to
	 * the tonic of the key signature, then every following number represents
	 * the number of half steps from the tonic. For example, for the key of A
	 * major, 0 will be A, 2 will be 2 half steps from A, which is B, 4 will be
	 * 4 half steps from A, which is C#, etc. You end up with:
	 * 
	 *     A major: {A, B, C#, D, E, F#, G#}
	 */
	private static final int[] MAJOR_NOTE_INTERVALS = {0, 2, 4, 5, 7, 9, 11};

	/**
	 * Intervals within the chromatic scale at which there are notes in the
	 * major scale.
	 * 
	 * @see KeySignature.MAJOR_NOTE_INTERVALS
	 */
	private static final int[] MINOR_NOTE_INTERVALS = {0, 2, 3, 5, 7, 8, 10};

    /////////////////////////////////
	//
    //  VARIABLES
    //
	/////////////////////////////////

    /** The note of the key */
    private int note;
    
    /** The scale of the key (false means minor) */
    private boolean major;

    /////////////////////////////////
	//
    //  CONSTRUCTOR
    //
	/////////////////////////////////
    
    /**
     * Constructs a new KeySignature with the given values.
     */
    public KeySignature(int note, boolean major) {
        this.note = note;
        this.major = major;
    }

    /////////////////////////////////
	//
    //  METHODS
    //
	/////////////////////////////////
    
    /**
     * Returns the note that is at the given interval from the given starting
     * note within the framework of this KeySignature.
     */
    public int getNoteAtInterval(int startNote, int interval) {
    	int startNoteScaleDegree = getScaleDegreeOfNote(startNote);
    	
    	int noteScaleDegree = (startNoteScaleDegree + interval) % 7;
    	
    	if (noteScaleDegree < 0)
    		noteScaleDegree =  7 - Math.abs(noteScaleDegree);
    	
    	return getNoteAtScaleDegree(noteScaleDegree);
    }
    
    /**
     * Returns the pitch that is at the given interval from the given starting
     * note within the framework of this KeySignature.
     */
    public int getPitchAtInterval(int startPitch, int interval) {
    	int startNote = Note.getNoteFromPitch(startPitch);
    	int startOctave = Note.getOctaveFromPitch(startPitch);
    	
    	int note = getNoteAtInterval(startNote, interval);
    	int octave = startOctave;
    	
    	if (interval < 0 && note > startNote)
    		octave--;
    	else if (interval > 0 && note < startNote)
    		octave++;
    	
    	return Note.getPitch(note, octave);
    }
    
    /**
     * Returns a note within this key signature at the given scale degree.
     * 
     * @param scaleDegree an integer between 0 and 6, 0 being the first note in
     * 		  the scale, 6 being the last note in the scale
     */
    public int getNoteAtScaleDegree(int scaleDegree) {
    	int baseNote;
    	
    	if (this.isMajor())
            baseNote = KeySignature.MAJOR_NOTE_INTERVALS[scaleDegree];
        else
            baseNote = KeySignature.MINOR_NOTE_INTERVALS[scaleDegree];
    	
    	// transpose the base note into the proper key
    	return (baseNote + this.getNote()) % Note.NUM_NOTES;
    }
    
    /**
     * Returns the scale degree of the given note within the framework of this
     * KeySignature. Returns -1 if the given note is not in this KeySignature's
     * scale.
     */
    public int getScaleDegreeOfNote(int note) {
    	for (int i = 0; i < 7; i++) {
    		if (note == this.getNoteAtScaleDegree(i))
    			return i;
    	}
    	
    	return -1;
    }
    
    /**
     * Returns the scale degree of the given pitch within the framework of this
     * KeySignature.
     */
    public int getScaleDegreeOfPitch(int pitch) {
    	return getScaleDegreeOfNote(Note.getNoteFromPitch(pitch));
    }
    
    /**
     * Returns a LilyPond formatted String representing this KeySignature.
     */
    public String toLilyPondString() {
        StringBuilder s = new StringBuilder();
        
        s.append("\\key ");
        
        switch(note) {
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
        
        if (major)
            s.append(" \\major");
        else
            s.append(" \\minor");
        
        return s.toString();
    }

    /////////////////////////////////
	//
    //  GETTERS / SETTERS
    //
	/////////////////////////////////

    /**
     * Returns the note of this KeySignature.
     */
    public int getNote() {
        return note;
    }

    /**
     * Returns true if this KeySignature is in the major scale, false if this
     * KeySignature is in the minor scale.
     */
    public boolean isMajor() {
        return major;
    }
}

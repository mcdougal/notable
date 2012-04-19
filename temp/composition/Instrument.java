package composition;

/**
 * Represents an instrument. The range is represented by integer values
 * specifying the lowest/highest notes and octaves. See
 * <code>CompositionConst.java</code> for a more detailed explanation of
 * this representation.
 * 
 */
public class Instrument {

    //
    // VARIABLES
    //
	
	/** Name of instrument */
	private String name;
	
	/** Lowest playable note */
	private int lowestNote;
	
	/** Octave of the lowest playable note */
	private int lowestOctave;

	/** Highest playable note */
	private int highestNote;
	
	/** Octave of the highest playable note */
	private int highestOctave;
	
	/** Clef for which this instrument's sheet music is written */
	private String clef;

    //
    // METHODS
    //
	
	/**
	 * Constructs a new instrument with the default values.
	 */
	public Instrument() {
		this(
				CompositionConst.SOPRANO_RECORDER.NAME,
				CompositionConst.SOPRANO_RECORDER.LOWEST_NOTE,
				CompositionConst.SOPRANO_RECORDER.LOWEST_OCTAVE,
				CompositionConst.SOPRANO_RECORDER.HIGHEST_NOTE,
				CompositionConst.SOPRANO_RECORDER.HIGHEST_OCTAVE,
				CompositionConst.SOPRANO_RECORDER.CLEF
		);
	}
	
	/**
	 * Constructs a new instrument with the given values.
	 */
	public Instrument(String name, int lowestNote, int lowestOctave,
			int highestNote, int highestOctave, String clef) {
		
		this.name = name;
		this.lowestNote = lowestNote;
		this.lowestOctave = lowestOctave;
		this.highestNote = highestNote;
		this.highestOctave = highestOctave;
		this.clef = clef;
	}
	
	/**
	 * Returns a LilyPond formatted string representing this instrument's clef.
	 */
	public String toLilyPondString() {
		if (clef.equals(CompositionConst.TREBLE_CLEF))
			return "\\clef treble";
		else
			return "\\clef bass";
	}

    //
    // GETTERS
    //

	public int getLowestNote() {
		return lowestNote;
	}

	public int getLowestOctave() {
		return lowestOctave;
	}

	public int getHighestNote() {
		return highestNote;
	}

	public int getHighestOctave() {
		return highestOctave;
	}
	
}
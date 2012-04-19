package composition;

/**
 * Represents a time signature of a piece of music.
 * 
 */
public class TimeSignature {
	
    //
    // VARIABLES
    //
	
	/** Top integer in time signature; number of beats in each measure */
	private int beatsPerMeasure;
	
	/** Bottom integer in time signature; note duration for each beat */
	private int beatDuration;
	
    //
    // METHODS
    //
	
	/**
	 * Constructs a time signature with the default values.
	 */
	public TimeSignature() {
		this(4, 4);
	}
	
	/**
	 * Constructs a time signature with the given values.
	 */
	public TimeSignature(int beatsPerMeasure, int noteValuePerBeat) {
		this.beatsPerMeasure = beatsPerMeasure;
		this.beatDuration = noteValuePerBeat;
	}
	
	/**
	 * Returns a LilyPond formatted String representing this TimeSignature.
	 */
	public String toLilyPondString() {
		return "\\time " + beatsPerMeasure + "/" + beatDuration;
	}
	
    //
    // GETTERS/SETTERS
    //
	
	public int getBeatsPerMeasure() {
		return beatsPerMeasure;
	}

	public void setBeatsPerMeasure(int beatsPerMeasure) {
		this.beatsPerMeasure = beatsPerMeasure;
	}
	
	public int getBeatDuration() {
		return beatDuration;
	}
	
	public void setBeatDuration(int beatDuration) {
		this.beatDuration = beatDuration;
	}
}

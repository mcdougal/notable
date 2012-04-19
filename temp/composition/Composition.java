package composition;

/**
 * Represents an entire piece of music. This not only includes the notes but
 * also the meta-data like time signature and key signature.
 * 
 */
public class Composition {

    //
    // VARIABLES
    //
	
	/** Instrument on which this composition should be played */
	private Instrument instrument;
	
	/** Time signature */
	private TimeSignature timeSignature;
	
	/** Key signature */
	private KeySignature key;
	
	/** Number of bars */
	private int length;
	
	/** Music (i.e. bars, notes, etc.) */
	private Song song;

    //
    // METHODS
    //

	/**
	 * Constructs a new composition with the default values.
	 */
	public Composition() {
		instrument = new Instrument();
		timeSignature = new TimeSignature();
		key = new KeySignature();
		length = CompositionConst.DEFAULT_LENGTH;
	}
	
	/**
	 * Pseudo-randomly generates a song, including bars, notes, etc.
	 */
	public void generateSong() {
		song = new Song(instrument, timeSignature, key, length);
	}
	
	/**
	 * Returns a LilyPond formatted String representing this composition.
	 */
	public String toLilyPondString() {
		StringBuilder s = new StringBuilder();
		
		s.append("\\version \"2.12.0\" \n");
		s.append("\n");
		s.append("{ \n");
		s.append("    "+instrument.toLilyPondString()+" \n");
		s.append("    "+key.toLilyPondString()+" \n");
		s.append("    "+timeSignature.toLilyPondString()+" \n");
		s.append("\n");
		s.append(song.toLilyPondString());
		s.append("}");
		
		return s.toString();
	}

    //
    // GETTERS/SETTERS
    //
	
	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	public TimeSignature getTimeSignature() {
		return timeSignature;
	}

	public void setTimeSignature(TimeSignature timeSignature) {
		this.timeSignature = timeSignature;
	}

	public KeySignature getKey() {
		return key;
	}

	public void setKey(KeySignature key) {
		this.key = key;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public Song getSong() {
		return song;
	}

	public void setSong(Song song) {
		this.song = song;
	}
	
	
}

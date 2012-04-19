package composition;

import java.util.LinkedList;
import java.util.List;

/**
 * Represents a song, which is just a collection of measures.
 * 
 */
public class Song {
	
    //
    // VARIABLES
    //
	
	/** Generated music */
	private List<Measure> music;

    //
    // METHODS
    //
	
	/**
	 * Constructs a new, pseudo-randomly generated song based off the given values.
	 */
	public Song(Instrument instrument, TimeSignature timeSignature, KeySignature key, int length) {
		music = getRandomMusic(instrument, timeSignature, key, length);
	}
	
	/**
	 * Returns a list of pseudo-randomly generated measures.
	 */
	private List<Measure> getRandomMusic(Instrument instrument,
			TimeSignature timeSignature, KeySignature key, int length){
		
		List<Measure> barList = new LinkedList<Measure>();
		
		for (int i = 0; i < length; i++){
			barList.add(new Measure(instrument, timeSignature, key));
		}
		
		return barList;
	}
	
	/**
	 * Returns a LilyPond formatted String representing this song.
	 */
	public String toLilyPondString() {
		StringBuilder s = new StringBuilder();
		
		for (Measure bar : music){
			s.append("    "+bar.toLilyPondString());
			s.append("\n");
		}
		
		return s.toString();
	}

}

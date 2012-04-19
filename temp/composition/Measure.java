package composition;

import java.util.LinkedList;
import java.util.List;

/**
 * Represents a measure of notes.
 * 
 */
public class Measure {
	
    //
    // VARIABLES
    //
	
	/** Notes within the measure */
	private List<Note> notes;
	
    //
    // METHODS
    //
	
	/**
	 * Constructs a new measure with random notes. Note generation falls within
	 * the bounds of the given parameters.
	 */
	public Measure(Instrument instrument, TimeSignature timeSignature, KeySignature key) {
		notes = getRandomNotes(instrument, timeSignature, key);
	}
	
	/**
	 * Returns a list of pseudo-randomly generated notes that are constrained
	 * by the given parameters.
	 */
	private List<Note> getRandomNotes(
			Instrument instrument, TimeSignature timeSignature, KeySignature key) {
		
		List<Note> noteList = new LinkedList<Note>();
		
		for (int i = 0; i < timeSignature.getBeatsPerMeasure(); i++){
			noteList.add(new Note(instrument, timeSignature, key));
		}
		
		return noteList;
	}
	
	
	/**
	 * Returns a LilyPond formatted String representing this measure.
	 */
	public String toLilyPondString() {
		StringBuilder s = new StringBuilder();
		
		for (Note note : notes) {
			s.append(note.toLilyPondString());
			s.append("\t");
		}
		
		return s.toString();
	}
}

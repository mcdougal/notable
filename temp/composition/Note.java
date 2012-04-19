package composition;

import java.util.Random;

/**
 * Represents a note. The note value is stored as an integer. See
 * <code>CompositionConst.java</code> for a more detailed explanation of
 * this representation.
 * 
 */
public class Note {
	
    //
    // VARIABLES
    //
	
	/** The note value */
	private int note;
	
	/** The octave */
	private int octave;
	
	/** The duration of the note */
	private int duration;
	
    //
    // METHODS
    //
	
	/**
	 * Constructs a random note within the bounds of the given parameters.
	 */
	public Note(Instrument instrument, TimeSignature timeSignature, KeySignature key) {
		// get random note and octave
		note = getRandomNote(key);
		octave = getRandomOctave(instrument);
		
		// if lower bound was exceeded, set note to lower bound
		if (octave == instrument.getLowestOctave()
				&& note < instrument.getLowestNote())
			note = instrument.getLowestNote();
		
		// if upper bound was exceeded, set note to upper bound
		else if (octave == instrument.getHighestOctave()
				&& note > instrument.getHighestNote())
			note = instrument.getHighestNote();
		
		duration = timeSignature.getBeatDuration();
	}
	
	/**
	 * Returns a random octave within the range of the given instrument.
	 */
	private int getRandomOctave(Instrument instrument){
		int lowestOctave = instrument.getLowestOctave();
		int highestOctave = instrument.getHighestOctave();
		
		return lowestOctave + new Random().nextInt(highestOctave - lowestOctave);
	}
	
	/**
	 * Returns a random note within the given key.
	 */
	private int getRandomNote(KeySignature key) {
		Random r = new Random();
		
		int baseNote;
		
		if (key.isMajor()){
			int index = r.nextInt(CompositionConst.MAJOR_NOTE_INDICES.length);
			baseNote = CompositionConst.MAJOR_NOTE_INDICES[index];
		}
		else{
			int index = r.nextInt(CompositionConst.MINOR_NOTE_INDICES.length);
			baseNote = CompositionConst.MINOR_NOTE_INDICES[index];
		}
		
		return (baseNote + key.getNote()) % CompositionConst.NUM_NOTES;
	}

	/**
	 * Returns a LilyPond formatted String representing this note.
	 */
	public String toLilyPondString() {
		StringBuilder s = new StringBuilder();
		
		switch(note) {
			case CompositionConst.C : s.append("c"); break;
			case CompositionConst.C_SHARP : s.append("cis"); break;
			case CompositionConst.D : s.append("d"); break;
			case CompositionConst.D_SHARP : s.append("dis"); break;
			case CompositionConst.E : s.append("e"); break;
			case CompositionConst.F : s.append("f"); break;
			case CompositionConst.F_SHARP : s.append("fis"); break;
			case CompositionConst.G : s.append("g"); break;
			case CompositionConst.G_SHARP : s.append("gis"); break;
			case CompositionConst.A : s.append("a"); break;
			case CompositionConst.A_SHARP : s.append("ais"); break;
			case CompositionConst.B : s.append("b"); break;
		}
		
		switch(octave) {
			case CompositionConst.OCTAVE_0 : s.append(",,,"); break;
			case CompositionConst.OCTAVE_1 : s.append(",,"); break;
			case CompositionConst.OCTAVE_2 : s.append(","); break;
			case CompositionConst.OCTAVE_3 : s.append(""); break;
			case CompositionConst.OCTAVE_4 : s.append("'"); break;
			case CompositionConst.OCTAVE_5 : s.append("''"); break;
			case CompositionConst.OCTAVE_6 : s.append("'''"); break;
			case CompositionConst.OCTAVE_7 : s.append("''''"); break;
			case CompositionConst.OCTAVE_8 : s.append("'''''"); break;
		}
		
		s.append(duration);
		
		return s.toString();
	}
}

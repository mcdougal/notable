package composition;
/**
 * Contains all constants related to the composition classes.
 * 
 */
public class CompositionConst {

	//
	// MEASURE
	//
	
	/** The default number of measures for a song */
	public static final int DEFAULT_LENGTH = 32;
	
	//
	// NOTE
	//
	// Notes are represented as integers because it is much easier to
	// generate sensible music when you can perform mathematical operations
	// on the notes. This representation is also very quick to work with
	// since integers are primitive values.
	//
	// Octaves are represented as integers for the same reasons as notes. Having
	// both notes and octaves represented this way means that you can easily
	// generate a set of 108 unique notes by doing the following:
	//
	//     (octave * number of notes) + note
	//
	// This allows for the range of C0 to B8, which is necessary for the piano
	// which covers almost this entire range.
	//

	/**
	 * Indices within the chromatic scale at which there are notes in the major
	 * scale. To figure out which note each number represents, set 0 to the
	 * tonic of the key signature, then every following number represents the
	 * number of half steps from the tonic. For example, for the key of A:
	 * 
	 *     {A, B, C#, D, E, F#, G#}
	 */
	public static final int[] MAJOR_NOTE_INDICES = {0, 2, 4, 5, 7, 9, 11};
	
	/**
	 * Indices within the chromatic scale at which there are notes in the major
	 * scale. See <code>MAJOR_NOTE_INDICES</code>.
	 */
	public static final int[] MINOR_NOTE_INDICES = {0, 2, 3, 5, 7, 8, 10};
	
	/**
	 * The total number of notes. This is used when transposing notes because
	 * if a note's number representation is greater than 12 then you must do
	 * note# modulo 12 to get the actual representation.
	 */
	public static final int NUM_NOTES = 12;
	
	// Notes represented as integers.
	// Starts on C because this makes it easy to calculate notes based off
	// middle C -- middle C is 12*4, and any C is 12*octave.

	public static final int C = 0;
	public static final int C_SHARP = 1;
	public static final int D = 2;
	public static final int D_SHARP = 3;
	public static final int E = 4;
	public static final int F = 5;
	public static final int F_SHARP = 6;
	public static final int G = 7;
	public static final int G_SHARP = 8;
	public static final int A = 9;
	public static final int A_SHARP = 10;
	public static final int B = 11;
	
	// Octaves represented as integers.
	// This makes it easy to transpose notes to different octaves. Just do
	// note*octave#.
	
	public static final int OCTAVE_0 = 0;
	public static final int OCTAVE_1 = 1;
	public static final int OCTAVE_2 = 2;
	public static final int OCTAVE_3 = 3;
	public static final int OCTAVE_4 = 4;
	public static final int OCTAVE_5 = 5;
	public static final int OCTAVE_6 = 6;
	public static final int OCTAVE_7 = 7;
	public static final int OCTAVE_8 = 8;
	
	//
	// CLEFS
	//
	// Internal representation of clefs. A grand staff signifies that both
	// clefs are present on two different staffs.
	//
	
	public static final String TREBLE_CLEF = "treble";
	public static final String BASS_CLEF = "bass";
	public static final String GRAND_STAFF = "grand staff";
	
	//
	// INSTRUMENTS
	//
	// Instrument data is stored as static constants until a better method is
	// devised. The sources for all instrument range values are included in
	// comments above the instruments. Also, some of the ranges were modified
	// so that the instrument's notes would transpose properly for sheet music.
	//
	
	/**
	 * http://www.ehow.com/facts_7484758_information-soprano-recorder.html
	 * NOTE: These values are decreased an octave to account for sheet music transposition
	 */
	public static interface SOPRANO_RECORDER {
		public static final String NAME = "Soprano Recorder";
		public static final int LOWEST_NOTE = C;
		public static final int LOWEST_OCTAVE = OCTAVE_4;
		public static final int HIGHEST_NOTE = C;
		public static final int HIGHEST_OCTAVE = OCTAVE_6;
		public static final String CLEF = TREBLE_CLEF;
	}
	
	/**
	 * http://www.altorecorder.com/
	 */
	public static interface ALTO_RECORDER {
		public static final String NAME = "Alto Recorder";
		public static final int LOWEST_NOTE = F;
		public static final int LOWEST_OCTAVE = OCTAVE_4;
		public static final int HIGHEST_NOTE = F;
		public static final int HIGHEST_OCTAVE = OCTAVE_6;
		public static final String CLEF = TREBLE_CLEF;
	}
	
	/**
	 * http://en.wikipedia.org/wiki/Western_concert_flute
	 * NOTE: These values are decreased an octave to account for sheet music transposition
	 */
	public static interface CONCERT_FLUTE {
		public static final String NAME = "Concert Flute";
		public static final int LOWEST_NOTE = C;
		public static final int LOWEST_OCTAVE = OCTAVE_3;
		public static final int HIGHEST_NOTE = F;
		public static final int HIGHEST_OCTAVE = OCTAVE_6;
		public static final String CLEF = TREBLE_CLEF;
	}
	
	/**
	 * http://www.8notes.com/f/27_237142.asp
	 */
	public static interface OBOE {
		public static final String NAME = "Oboe";
		public static final int LOWEST_NOTE = A_SHARP;
		public static final int LOWEST_OCTAVE = OCTAVE_3;
		public static final int HIGHEST_NOTE = G;
		public static final int HIGHEST_OCTAVE = OCTAVE_6;
		public static final String CLEF = TREBLE_CLEF;
	}
	
	/**
	 * http://www.mti.dmu.ac.uk/~ahugill/manual/bassoon/range.html
	 */
	public static interface BASSOON {
		public static final String NAME = "Bassoon";
		public static final int LOWEST_NOTE = A_SHARP;
		public static final int LOWEST_OCTAVE = OCTAVE_1;
		public static final int HIGHEST_NOTE = E;
		public static final int HIGHEST_OCTAVE = OCTAVE_5;
		public static final String CLEF = BASS_CLEF;
	}
	
	/**
	 * http://www.music.vt.edu/musicdictionary/textv/Violin.html
	 */
	public static interface VIOLIN {
		public static final String NAME = "Violin";
		public static final int LOWEST_NOTE = G;
		public static final int LOWEST_OCTAVE = OCTAVE_3;
		public static final int HIGHEST_NOTE = E;
		public static final int HIGHEST_OCTAVE = OCTAVE_7;
		public static final String CLEF = TREBLE_CLEF;
	}
	
	/**
	 * http://www.abrsm.org/forum/lofiversion/index.php/t12249.html
	 * http://wiki.answers.com/Q/What_is_the_cello's_range
	 * NOTE: These values are decreased an octave to account for sheet music transposition
	 */
	public static interface CELLO {
		public static final String NAME = "Cello";
		public static final int LOWEST_NOTE = C;
		public static final int LOWEST_OCTAVE = OCTAVE_1;
		public static final int HIGHEST_NOTE = C;
		public static final int HIGHEST_OCTAVE = OCTAVE_5;
		public static final String CLEF = BASS_CLEF;
	}
	
	/**
	 * http://wiki.answers.com/Q/What_is_the_pitch_range_of_a_guitar
	 * NOTE: These values are increased an octave to account for sheet music transposition
	 */
	public static interface GUITAR {
		public static final String NAME = "Guitar";
		public static final int LOWEST_NOTE = E;
		public static final int LOWEST_OCTAVE = OCTAVE_3;
		public static final int HIGHEST_NOTE = A;
		public static final int HIGHEST_OCTAVE = OCTAVE_6;
		public static final String CLEF = TREBLE_CLEF;
	}
	
	/**
	 * http://wiki.answers.com/Q/What_is_the_piano_pitch_range
	 */
	public static interface PIANO {
		public static final String NAME = "Piano";
		public static final int LOWEST_NOTE = A;
		public static final int LOWEST_OCTAVE = OCTAVE_0;
		public static final int HIGHEST_NOTE = C;
		public static final int HIGHEST_OCTAVE = OCTAVE_8;
		public static final String CLEF = GRAND_STAFF;
	}
}

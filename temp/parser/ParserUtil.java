package parser;

import composition.CompositionConst;
import composition.Instrument;
import composition.KeySignature;

/**
 * Provides methods for converting external data into an internally
 * recognized representation.
 * 
 */
public class ParserUtil {
	
	/**
	 * Converts the given instrument String, as parsed from the input file, into
	 * an Instrument object that can be used by the application.
	 */
	public static Instrument convertInputToInstrument(String inputInstrument) {
		
		Instrument instrument = null;
		
		if (inputInstrument.equals(ParserConst.INSTRUMENTS.SOPRANO_RECORDER))
			instrument = new Instrument(
					CompositionConst.SOPRANO_RECORDER.NAME,
					CompositionConst.SOPRANO_RECORDER.LOWEST_NOTE,
					CompositionConst.SOPRANO_RECORDER.LOWEST_OCTAVE,
					CompositionConst.SOPRANO_RECORDER.HIGHEST_NOTE,
					CompositionConst.SOPRANO_RECORDER.HIGHEST_OCTAVE,
					CompositionConst.SOPRANO_RECORDER.CLEF
			);
		
		else if (inputInstrument.equals(ParserConst.INSTRUMENTS.ALTO_RECORDER))
			instrument = new Instrument(
					CompositionConst.ALTO_RECORDER.NAME,
					CompositionConst.ALTO_RECORDER.LOWEST_NOTE,
					CompositionConst.ALTO_RECORDER.LOWEST_OCTAVE,
					CompositionConst.ALTO_RECORDER.HIGHEST_NOTE,
					CompositionConst.ALTO_RECORDER.HIGHEST_OCTAVE,
					CompositionConst.ALTO_RECORDER.CLEF
			);
		
		else if (inputInstrument.equals(ParserConst.INSTRUMENTS.CONCERT_FLUTE))
			instrument = new Instrument(
					CompositionConst.CONCERT_FLUTE.NAME,
					CompositionConst.CONCERT_FLUTE.LOWEST_NOTE,
					CompositionConst.CONCERT_FLUTE.LOWEST_OCTAVE,
					CompositionConst.CONCERT_FLUTE.HIGHEST_NOTE,
					CompositionConst.CONCERT_FLUTE.HIGHEST_OCTAVE,
					CompositionConst.CONCERT_FLUTE.CLEF
			);
		
		else if (inputInstrument.equals(ParserConst.INSTRUMENTS.OBOE))
			instrument = new Instrument(
					CompositionConst.OBOE.NAME,
					CompositionConst.OBOE.LOWEST_NOTE,
					CompositionConst.OBOE.LOWEST_OCTAVE,
					CompositionConst.OBOE.HIGHEST_NOTE,
					CompositionConst.OBOE.HIGHEST_OCTAVE,
					CompositionConst.OBOE.CLEF
			);
		
		else if (inputInstrument.equals(ParserConst.INSTRUMENTS.BASSOON))
			instrument = new Instrument(
					CompositionConst.BASSOON.NAME,
					CompositionConst.BASSOON.LOWEST_NOTE,
					CompositionConst.BASSOON.LOWEST_OCTAVE,
					CompositionConst.BASSOON.HIGHEST_NOTE,
					CompositionConst.BASSOON.HIGHEST_OCTAVE,
					CompositionConst.BASSOON.CLEF
			);
		
		else if (inputInstrument.equals(ParserConst.INSTRUMENTS.VIOLIN))
			instrument = new Instrument(
					CompositionConst.VIOLIN.NAME,
					CompositionConst.VIOLIN.LOWEST_NOTE,
					CompositionConst.VIOLIN.LOWEST_OCTAVE,
					CompositionConst.VIOLIN.HIGHEST_NOTE,
					CompositionConst.VIOLIN.HIGHEST_OCTAVE,
					CompositionConst.VIOLIN.CLEF
			);
		
		else if (inputInstrument.equals(ParserConst.INSTRUMENTS.CELLO))
			instrument = new Instrument(
					CompositionConst.CELLO.NAME,
					CompositionConst.CELLO.LOWEST_NOTE,
					CompositionConst.CELLO.LOWEST_OCTAVE,
					CompositionConst.CELLO.HIGHEST_NOTE,
					CompositionConst.CELLO.HIGHEST_OCTAVE,
					CompositionConst.CELLO.CLEF
			);
		
		else if (inputInstrument.equals(ParserConst.INSTRUMENTS.GUITAR))
			instrument = new Instrument(
					CompositionConst.GUITAR.NAME,
					CompositionConst.GUITAR.LOWEST_NOTE,
					CompositionConst.GUITAR.LOWEST_OCTAVE,
					CompositionConst.GUITAR.HIGHEST_NOTE,
					CompositionConst.GUITAR.HIGHEST_OCTAVE,
					CompositionConst.GUITAR.CLEF
			);
		
		else if (inputInstrument.equals(ParserConst.INSTRUMENTS.PIANO))
			instrument = new Instrument(
					CompositionConst.PIANO.NAME,
					CompositionConst.PIANO.LOWEST_NOTE,
					CompositionConst.PIANO.LOWEST_OCTAVE,
					CompositionConst.PIANO.HIGHEST_NOTE,
					CompositionConst.PIANO.HIGHEST_OCTAVE,
					CompositionConst.PIANO.CLEF
			);
		
		return instrument;
	}
	
	/**
	 * Converts the given pitch and scale, as parsed from the input file, into
	 * a KeySignature object that can be used by the application.
	 */
	public static KeySignature convertInputToKeySignature(String pitch, String scale) {
		
		KeySignature key = null;
		
		boolean major = scale.equals(ParserConst.MAJOR_KEY);
		
		if (pitch.equals(ParserConst.KEYS.C)
				|| pitch.equals(ParserConst.KEYS.B_SHARP))
			key = new KeySignature(CompositionConst.C, major);
		
		else if (pitch.equals(ParserConst.KEYS.C_SHARP)
				|| pitch.equals(ParserConst.KEYS.D_FLAT))
			key = new KeySignature(CompositionConst.C_SHARP, major);
		
		else if (pitch.equals(ParserConst.KEYS.D))
			key = new KeySignature(CompositionConst.D, major);
		
		else if (pitch.equals(ParserConst.KEYS.D_SHARP)
				|| pitch.equals(ParserConst.KEYS.E_FLAT))
			key = new KeySignature(CompositionConst.D_SHARP, major);
		
		else if (pitch.equals(ParserConst.KEYS.E)
				|| pitch.equals(ParserConst.KEYS.F_FLAT))
			key = new KeySignature(CompositionConst.E, major);
		
		else if (pitch.equals(ParserConst.KEYS.F)
				|| pitch.equals(ParserConst.KEYS.E_SHARP))
			key = new KeySignature(CompositionConst.F, major);
		
		else if (pitch.equals(ParserConst.KEYS.F_SHARP)
				|| pitch.equals(ParserConst.KEYS.G_FLAT))
			key = new KeySignature(CompositionConst.F_SHARP, major);
		
		else if (pitch.equals(ParserConst.KEYS.G))
			key = new KeySignature(CompositionConst.G, major);
		
		else if (pitch.equals(ParserConst.KEYS.G_SHARP)
				|| pitch.equals(ParserConst.KEYS.A_FLAT))
			key = new KeySignature(CompositionConst.G_SHARP, major);
		
		else if (pitch.equals(ParserConst.KEYS.A))
			key = new KeySignature(CompositionConst.A, major);
		
		else if (pitch.equals(ParserConst.KEYS.A_SHARP)
				|| pitch.equals(ParserConst.KEYS.B_FLAT))
			key = new KeySignature(CompositionConst.A_SHARP, major);
		
		else if (pitch.equals(ParserConst.KEYS.B)
				|| pitch.equals(ParserConst.KEYS.C_FLAT))
			key = new KeySignature(CompositionConst.B, major);
		
		return key;
	}
}

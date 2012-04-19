package parser;

import composition.meta.Instrument;
import composition.meta.KeySignature;
import composition.music.Note.NOTE_VALUES;

/**
 * Provides methods for converting external data into an internally
 * recognized representation.
 */
public class ParserUtil {
    
    /**
     * Converts the given instrument String, as parsed from the input file, into
     * an Instrument object that can be used by the application.
     */
    public static Instrument convertInputToInstrument(String inputInstrument) {
        
        Instrument instrument = null;
        
        if (inputInstrument.equals(ParserConst.INSTRUMENTS.SOPRANO_RECORDER))
            instrument = Instrument.SOPRANO_RECORDER;
        else if (inputInstrument.equals(ParserConst.INSTRUMENTS.ALTO_RECORDER))
            instrument = Instrument.ALTO_RECORDER;
        else if (inputInstrument.equals(ParserConst.INSTRUMENTS.CONCERT_FLUTE))
            instrument = Instrument.CONCERT_FLUTE;
        else if (inputInstrument.equals(ParserConst.INSTRUMENTS.OBOE))
            instrument = Instrument.OBOE;
        else if (inputInstrument.equals(ParserConst.INSTRUMENTS.BASSOON))
            instrument = Instrument.BASSOON;
        else if (inputInstrument.equals(ParserConst.INSTRUMENTS.VIOLIN))
            instrument = Instrument.VIOLIN;
        else if (inputInstrument.equals(ParserConst.INSTRUMENTS.CELLO))
            instrument = Instrument.CELLO;
        else if (inputInstrument.equals(ParserConst.INSTRUMENTS.GUITAR))
            instrument = Instrument.GUITAR;
        else if (inputInstrument.equals(ParserConst.INSTRUMENTS.PIANO))
            instrument = Instrument.PIANO;
        
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
            key = new KeySignature(NOTE_VALUES.C, major);
        
        else if (pitch.equals(ParserConst.KEYS.C_SHARP)
                || pitch.equals(ParserConst.KEYS.D_FLAT))
            key = new KeySignature(NOTE_VALUES.C_SHARP, major);
        
        else if (pitch.equals(ParserConst.KEYS.D))
            key = new KeySignature(NOTE_VALUES.D, major);
        
        else if (pitch.equals(ParserConst.KEYS.D_SHARP)
                || pitch.equals(ParserConst.KEYS.E_FLAT))
            key = new KeySignature(NOTE_VALUES.D_SHARP, major);
        
        else if (pitch.equals(ParserConst.KEYS.E)
                || pitch.equals(ParserConst.KEYS.F_FLAT))
            key = new KeySignature(NOTE_VALUES.E, major);
        
        else if (pitch.equals(ParserConst.KEYS.F)
                || pitch.equals(ParserConst.KEYS.E_SHARP))
            key = new KeySignature(NOTE_VALUES.F, major);
        
        else if (pitch.equals(ParserConst.KEYS.F_SHARP)
                || pitch.equals(ParserConst.KEYS.G_FLAT))
            key = new KeySignature(NOTE_VALUES.F_SHARP, major);
        
        else if (pitch.equals(ParserConst.KEYS.G))
            key = new KeySignature(NOTE_VALUES.G, major);
        
        else if (pitch.equals(ParserConst.KEYS.G_SHARP)
                || pitch.equals(ParserConst.KEYS.A_FLAT))
            key = new KeySignature(NOTE_VALUES.G_SHARP, major);
        
        else if (pitch.equals(ParserConst.KEYS.A))
            key = new KeySignature(NOTE_VALUES.A, major);
        
        else if (pitch.equals(ParserConst.KEYS.A_SHARP)
                || pitch.equals(ParserConst.KEYS.B_FLAT))
            key = new KeySignature(NOTE_VALUES.A_SHARP, major);
        
        else if (pitch.equals(ParserConst.KEYS.B)
                || pitch.equals(ParserConst.KEYS.C_FLAT))
            key = new KeySignature(NOTE_VALUES.B, major);
        
        return key;
    }
}

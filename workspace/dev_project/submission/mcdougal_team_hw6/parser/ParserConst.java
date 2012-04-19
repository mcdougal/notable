package parser;

/**
 * Contains all constants related to input parsing.
 */
public class ParserConst {
    
    // tags for determining which property is being set
    public static final String INSTRUMENT_TAG = "instrument:";
    public static final String TIME_SIG_TAG = "time signature:";
    public static final String KEY_TAG = "key:";
    public static final String LENGTH_TAG = "length:";
    public static final String DIFFICULTY_TAG = "difficulty:";
    
    // separates upper integer of time signature from lower integer
    public static final String TIME_SIG_DELIMETER = "/";
    
    // supported instruments
    public static interface INSTRUMENTS {
        public static final String SOPRANO_RECORDER = "soprano recorder";
        public static final String ALTO_RECORDER = "alto recorder";
        public static final String CONCERT_FLUTE = "concert flute";
        public static final String OBOE = "oboe";
        public static final String BASSOON = "bassoon";
        public static final String VIOLIN = "violin";
        public static final String CELLO = "cello";
        public static final String GUITAR = "guitar";
        public static final String PIANO = "piano";
    }
    
    // used to check if the next input value is any of these instruments
    public static final String[] INSTRUMENT_ARRAY =
        {INSTRUMENTS.SOPRANO_RECORDER, INSTRUMENTS.ALTO_RECORDER,
         INSTRUMENTS.CONCERT_FLUTE, INSTRUMENTS.OBOE, INSTRUMENTS.BASSOON,
         INSTRUMENTS.VIOLIN, INSTRUMENTS.CELLO, INSTRUMENTS.GUITAR,
         INSTRUMENTS.PIANO};
    
    // represents major or minor keys
    public static final String MAJOR_KEY = "major";
    public static final String MINOR_KEY = "minor";
    
    // supported pitches for key signature
    public static interface KEYS {
        public static final String A_FLAT = "Ab";
        public static final String A = "A";
        public static final String A_SHARP = "A#";
        public static final String B_FLAT = "Bb";
        public static final String B = "B";
        public static final String B_SHARP = "B#";
        public static final String C_FLAT = "Cb";
        public static final String C = "C";
        public static final String C_SHARP = "C#";
        public static final String D_FLAT = "Db";
        public static final String D = "D";
        public static final String D_SHARP = "D#";
        public static final String E_FLAT = "Eb";
        public static final String E = "E";
        public static final String E_SHARP = "E#";
        public static final String F_FLAT = "Fb";
        public static final String F = "F";
        public static final String F_SHARP = "F#";
        public static final String G_FLAT = "Gb";
        public static final String G = "G";
        public static final String G_SHARP = "G#";
    }
    
    // used to check if the next input value is any of these key signatures
    public static final String[] KEY_ARRAY =
        {KEYS.A_FLAT, KEYS.A, KEYS.A_SHARP, KEYS.B_FLAT, KEYS.B, KEYS.B_SHARP,
         KEYS.C_FLAT, KEYS.C, KEYS.C_SHARP, KEYS.D_FLAT, KEYS.D, KEYS.D_SHARP,
         KEYS.E_FLAT, KEYS.E, KEYS.E_SHARP, KEYS.F_FLAT, KEYS.F, KEYS.F_SHARP,
         KEYS.G_FLAT, KEYS.G, KEYS.G_SHARP};
    
    // digits used to construct integers
    public static final String[] DIGITS =
        {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
}

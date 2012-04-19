package composition;

/**
 * Represents a key signature. Note values are represented by integers. See
 * <code>CompositionConst.java</code> for a more detailed explanation of
 * this representation.
 * 
 */
public class KeySignature {
	
    //
    // VARIABLES
    //

	/** The note of the key */
	private int note;
	
	/** The scale of the key */
	private boolean major;
	
    //
    // METHODS
    //
	
	/**
	 * Constructs a new key signature with default values.
	 */
	public KeySignature() {
		this(CompositionConst.C, true);
	}
	
	/**
	 * Constructs a new key signature with the given values.
	 */
	public KeySignature(int note, boolean major) {
		this.note = note;
		this.major = major;
	}
	
	/**
	 * Returns a LilyPond formatted String representing this key signature.
	 */
	public String toLilyPondString() {
		StringBuilder s = new StringBuilder();
		
		s.append("\\key ");
		
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
		
		if (major)
			s.append(" \\major");
		else
			s.append(" \\minor");
		
		return s.toString();
	}
	
    //
    // GETTERS
    //

	public int getNote() {
		return note;
	}

	public boolean isMajor() {
		return major;
	}
}

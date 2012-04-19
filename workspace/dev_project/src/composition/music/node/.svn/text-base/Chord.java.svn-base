package composition.music.node;

import composition.Composition;
import composition.meta.Instrument;
import composition.meta.KeySignature;
import composition.music.MusicObject;

/**
 * Represents a chord that is made up of three notes.
 */
public class Chord extends MusicNode {

	/** Used to signify that a pitch has no value */
	public static final int NONE = -1;
	
    /////////////////////////////////
	//
    //  VARIABLES
    //
	/////////////////////////////////
	
	/** The pitch at the third scale degree from the root */
	private int thirdPitch;
	
	/** The pitch at the fifth scale degree from the root */
	private int fifthPitch;
	
    /////////////////////////////////
	//
    //  CONSTRUCTORS
    //
	/////////////////////////////////
	
	/**
	 * Constructs a new Chord based on the given values.
	 * 
	 * @param composition the composition that this Chord belongs to
	 * @param rootPitch the root pitch of this Chord
	 * @param length the length in terms of the smallest supported duration
	 */
	public Chord(Composition composition, int rootPitch, int length) {
		super(composition, rootPitch, length);
		
		this.setRootPitch(rootPitch);
	}
	
    /////////////////////////////////
	//
    //  GENERIC
    //
	/////////////////////////////////
	
	@Override
	public String toTimelessLilyPondString() {
		StringBuilder s = new StringBuilder();
		
		s.append("<");

		Note root = new Note(this.getComposition(), this.getRootPitch(), this.getLength());
		s.append(root.toTimelessLilyPondString()+" ");
		
		if (thirdPitch != NONE) {
			Note third = new Note(this.getComposition(), thirdPitch, this.getLength());
			s.append(third.toTimelessLilyPondString()+" ");
		}
		
		if (fifthPitch != NONE) {
			Note fifth = new Note(this.getComposition(), fifthPitch, this.getLength());
			s.append(fifth.toTimelessLilyPondString());
		}
		
		s.append(">");
		
		return s.toString();
	}

	@Override
	public MusicObject clone() {
		return new Chord(this.getComposition(), this.getRootPitch(),
				this.getLength());
	}
	
    /////////////////////////////////
	//
    //  GETTERS / SETTERS
    //
	/////////////////////////////////
	
	/**
	 * Sets the root, third, and fifth pitches of this Chord. The third and
	 * fifth are based off the given root pitch.
	 */
	public void setRootPitch(int rootPitch) {
		super.setRootPitch(rootPitch);
		this.setThird(rootPitch);
		this.setFifth(rootPitch);
	}

	/**
	 * Returns the pitch at the third scale degree of the root.
	 */
	public int getThird() {
		return thirdPitch;
	}
	
	/**
	 * Sets the third pitch to the third scale degree from the given pitch, as
	 * long as that pitch is within the instrument's range.
	 */
	public void setThird(int rootPitch) {
		Instrument instrument = this.getComposition().getInstrument();
		KeySignature key = this.getComposition().getKey();
		
		int third = key.getPitchAtInterval(rootPitch, 2);
		if (third <= instrument.getHighestPitch())
			this.thirdPitch = third;
		else
			this.thirdPitch = NONE;
	}

	/**
	 * Returns the pitch at the fifth scale degree of the root.
	 */
	public int getFifth() {
		return fifthPitch;
	}
	
	/**
	 * Sets the fifth pitch to the fifth scale degree from the given pitch, as
	 * long as that pitch is within the instrument's range.
	 */
	public void setFifth(int rootPitch) {
		Instrument instrument = this.getComposition().getInstrument();
		KeySignature key = this.getComposition().getKey();
		
		int fifth = key.getPitchAtInterval(rootPitch, 4);
		if (fifth <= instrument.getHighestPitch())
			this.fifthPitch = fifth;
		else
			this.fifthPitch = NONE;
	}
}

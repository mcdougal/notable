package composition.music.transformation;

import java.util.ArrayList;
import java.util.List;

import composition.music.MusicObject;
import composition.music.node.MusicNode;
import composition.music.node.Note;
import composition.music.node.Note.NOTE_VALUES;
import composition.music.parent.MusicParent;

/**
 * Shifts notes and chords by some number of octaves. The shift can be up or
 * down.
 * 
 * - This transformation doesn't affect rests.
 * - This transformation won't occur if it would result in notes outside the
 *   instrument's range.
 */
public class ShiftOctave implements Transformation {
	
	/** The number of octaves to shift (negative means shift down) */
	private int shiftAmount;
	
	/**
	 * Constructs a new ShiftOctave transformation.
	 * 
	 * @param shiftAmount the number of octaves to shift (negative means shift down)
	 */
	public ShiftOctave(int shiftAmount) {
		this.shiftAmount = shiftAmount;
	}
	
	@Override
	public void transform(MusicParent parent) {
		List<MusicObject> oldContents = parent.getContents();
		List<MusicObject> newContents = new ArrayList<MusicObject>(oldContents.size());
		
    	for (MusicObject musicObject : oldContents) {
    		newContents.add(shiftOctave((MusicNode) musicObject));
    	}
    	
    	parent.setContents(newContents);
	}
	
	@Override
	public List<MusicNode> transform(MusicNode node) {
		List<MusicNode> returnList = new ArrayList<MusicNode>();
		returnList.add(shiftOctave(node));
		
		return returnList;
	}
	
	/**
	 * Returns a MusicNode whose octave is shifted in relation to the given
	 * MusicNode by the shift amount specified when this ShiftOctave was
	 * constructed.
	 * 
	 * @param node the base node for the transformation
	 * @return a clone of the given node with its octave shifted, or the given
	 * 		node if it cannot be shifted
	 */
	private MusicNode shiftOctave(MusicNode node) {
		if (node.getRootPitch() == NOTE_VALUES.REST)
			return node;
		
		int newPitch = node.getRootPitch() + (Note.NUM_NOTES * shiftAmount);
		
		if (!node.getComposition().getInstrument().pitchIsOutOfRange(newPitch)) {
			MusicNode newNode = (MusicNode) node.clone();
			newNode.setRootPitch(newPitch);
			
			return newNode;
		}
		
		return node;
	}
}

package composition.music.transformation;

import java.util.ArrayList;
import java.util.List;

import composition.music.MusicObject;
import composition.music.node.Chord;
import composition.music.node.MusicNode;
import composition.music.node.Note.NOTE_VALUES;
import composition.music.parent.MusicParent;

/**
 * Transforms notes into chords. The root pitch of the chord is the same as the
 * root pitch of the note. The other notes in the chord are the third and fifth
 * scale intervals from the root pitch.
 * 
 * - The third and fifth are omitted if they are out of the instrument's range.
 * - Rests are not converted.
 * - This transformation doesn't affect chords.
 * - This transformation won't occur if it would result in notes outside the
 *   instrument's range.
 */
public class Chordify implements Transformation {

	@Override
	public void transform(MusicParent parent) {
		List<MusicObject> oldContents = parent.getContents();
		List<MusicObject> newContents = new ArrayList<MusicObject>(oldContents.size());
		
    	for (MusicObject musicObject : oldContents) {
    		newContents.add(convertToChord((MusicNode) musicObject));
    	}
    	
    	parent.setContents(newContents);
	}
	
	@Override
	public List<MusicNode> transform(MusicNode node) {
		List<MusicNode> returnList = new ArrayList<MusicNode>();
		returnList.add(convertToChord(node));
		
		return returnList;
	}
	
	/**
	 * Converts the given MusicNode to a Chord object. The given node is not
	 * converted if it is already a chord, if it is a rest, or if the instrument
	 * can't play chords. 
	 * 
	 * @param node the base node for the transformation
	 * @return the Chord constructed from the given node, or the given node if
	 * 		it cannot be converted to a chord
	 */
	private MusicNode convertToChord(MusicNode node) {
		if (!node.getComposition().getInstrument().canPlayChords()
				|| node.getClass().equals(Chord.class)
				|| node.getRootPitch() == NOTE_VALUES.REST)
			return node;
		
		return new Chord(node.getComposition(), node.getRootPitch(),
				node.getLength());
	}

}

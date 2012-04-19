package composition.music.transformation;

import java.util.ArrayList;
import java.util.List;

import composition.music.MusicObject;
import composition.music.node.MusicNode;
import composition.music.node.Note;
import composition.music.node.Note.NOTE_VALUES;
import composition.music.parent.MusicParent;

/**
 * Converts notes and chords to rests.
 */
public class Restify implements Transformation {
	
	@Override
	public void transform(MusicParent parent) {
		List<MusicObject> oldContents = parent.getContents();
		List<MusicObject> newContents = new ArrayList<MusicObject>(oldContents.size());
		
    	for (MusicObject musicObject : oldContents) {
    		newContents.add(convertToRest((MusicNode) musicObject));
    	}
    	
    	parent.setContents(newContents);
	}
	
	@Override
	public List<MusicNode> transform(MusicNode node) {
		List<MusicNode> returnList = new ArrayList<MusicNode>();
		returnList.add(convertToRest(node));
		
		return returnList;
	}
	
	/**
	 * Returns a MusicNode representing a rest that is the same duration as the
	 * given MusicNode.
	 * 
	 * @param node the base node for the transformation
	 * @return a rest
	 */
	private Note convertToRest(MusicNode node) {
		return new Note(node.getComposition(), NOTE_VALUES.REST,
				node.getLength());
	}
	
}

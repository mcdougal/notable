package composition.music.transformation;

import java.util.ArrayList;
import java.util.List;

import util.RandomUtil;

import composition.meta.Instrument;
import composition.meta.KeySignature;
import composition.music.MusicObject;
import composition.music.node.MusicNode;
import composition.music.node.Note;
import composition.music.node.Note.NOTE_VALUES;
import composition.music.parent.MusicParent;

/**
 * Replaces notes with either the third or fifth scale interval.
 * 
 * - Rests are not converted.
 * - This transformation only affects notes.
 * - This transformation won't occur if it would result in notes outside the
 *   instrument's range.
 */
public class Harmonize implements Transformation {

	@Override
	public void transform(MusicParent parent) {
		List<MusicObject> oldContents = parent.getContents();
		List<MusicObject> newContents = new ArrayList<MusicObject>(oldContents.size());
		
    	for (MusicObject musicObject : oldContents) {
    		newContents.add(convertToHarmony((MusicNode) musicObject));
    	}
    	
    	parent.setContents(newContents);
	}
	
	@Override
	public List<MusicNode> transform(MusicNode node) {
		List<MusicNode> returnList = new ArrayList<MusicNode>();
		returnList.add(convertToHarmony(node));
		
		return returnList;
	}
	
	/**
	 * Returns a MusicNode that is either at the third or fifth scale interval
	 * of the given MusicNode. The given node is returned if it is not a note,
	 * if it is a rest, or if the transformation would result in a note outside
	 * the instrument's range.
	 * 
	 * @param node the base node for the transformation
	 * @return the harmonized node, or the given node if it cannot be harmonized
	 */
	private MusicNode convertToHarmony(MusicNode node) {
		if (!node.getClass().equals(Note.class)
				|| node.getRootPitch() == NOTE_VALUES.REST)
			return node;
		
		KeySignature key = node.getComposition().getKey();
		
		int newPitch;
		if (RandomUtil.rndmChance(3, 4))
			// third
			newPitch = key.getPitchAtInterval(node.getRootPitch(), 2);
		else
			// fifth
			newPitch = key.getPitchAtInterval(node.getRootPitch(), 4);
		
		Instrument instrument = node.getComposition().getInstrument();
		
		if (newPitch <= instrument.getHighestPitch()) {
			Note newNote = (Note) node.clone();
			newNote.setRootPitch(newPitch);
			
			return newNote;
		}
		
		return node;
	}

}

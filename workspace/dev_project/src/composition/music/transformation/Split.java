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
 * Splits nodes into two separate nodes whose lengths are half that of the
 * original node. The first node will always have the same pitch value as the
 * original node, but the second one may not.
 * 
 * - Rests are not converted.
 * - All new pitches will be within the instrument's range.
 */
public class Split implements Transformation {

	@Override
	public void transform(MusicParent parent) {
		List<MusicObject> oldContents = parent.getContents();
		List<MusicObject> newContents = new ArrayList<MusicObject>(oldContents.size());
		
    	for (MusicObject musicObject : oldContents) {
    		newContents.addAll(transform((MusicNode) musicObject));
    	}
    	
    	parent.setContents(newContents);
	}
	
	@Override
	public List<MusicNode> transform(MusicNode node) {
		List<MusicNode> returnList = new ArrayList<MusicNode>();
		
		MusicNode first = (MusicNode) node.clone();
		
		if (!canSplitNode(node)) {
			returnList.add(first);
			return returnList;
		}
		
		first.setLength(node.getLength() / 2);
		MusicNode second = (MusicNode) first.clone();
		
		// high chance of using a different note for split
		if (RandomUtil.rndmChance(85, 100)) {
			KeySignature key = node.getComposition().getKey();
			Instrument instrument = node.getComposition().getInstrument();
			
			int nextNoteInterval = RandomUtil.rndmChance(1, 2) ? 1 : -1;
			
			int newPitch  = key.getPitchAtInterval(node.getRootPitch(),
					nextNoteInterval);
			
			if (!instrument.pitchIsOutOfRange(newPitch))
				second.setRootPitch(newPitch);
		}
		
		returnList.add(first);
		returnList.add(second);
		return returnList;
	}
	
	/**
	 * Returns true if the given node can be split into two nodes.
	 */
	private boolean canSplitNode(MusicNode node) {
		int nodeLength = node.getLength();
		
		if (nodeLength >= Note.SHORTEST_DURATION
				|| nodeLength % 2 != 0
				|| node.getRootPitch() == NOTE_VALUES.REST)
			return false;
		
		int difficulty = node.getComposition().getDifficulty();
		
		if (difficulty <= 40 && nodeLength <= Note.SHORTEST_DURATION / 4)
			return false;
		if (difficulty <= 80 && nodeLength <= Note.SHORTEST_DURATION / 8)
			return false;
		
		return true;
	}
}

package composition.music.transformation;

import java.util.ArrayList;
import java.util.List;

import composition.music.MusicObject;
import composition.music.node.MusicNode;
import composition.music.parent.MusicParent;

/**
 * Merges two nodes into one node. The resulting note will have the same pitch
 * information as the first node, but will be the combined length of both nodes.
 */
public class Simplify implements Transformation {
	
	@Override
	public void transform(MusicParent parent) {
		List<MusicObject> oldContents = parent.getContents();
		List<MusicObject> newContents = new ArrayList<MusicObject>();
		
		for (int i = 0; i < oldContents.size(); i += 2) {
    		// can't merge if you're on the last node
    		if (i != oldContents.size() - 1) {
    			MusicNode node1 = (MusicNode) oldContents.get(i);
    			MusicNode node2 = (MusicNode) oldContents.get(i+1);
    			
    			newContents.add(merge(node1, node2));
    		}
    		else {
    			newContents.add(oldContents.get(i));
    		}
		}
		
		parent.setContents(newContents);
	}
	
	@Override
	public List<MusicNode> transform(MusicNode node) {
		// single nodes cannot be simplified any further
		List<MusicNode> returnList = new ArrayList<MusicNode>(1);
		returnList.add(node);
		
		return returnList;
	}
	
	/**
	 * Returns a clone of the first MusicNode whose duration is that of both
	 * given MusicNodes combined.
	 */
	private MusicNode merge(MusicNode node1, MusicNode node2) {
    	int newLength = node1.getLength() + node2.getLength();
    	
    	MusicNode mergedNode = (MusicNode) node1.clone();
    	mergedNode.setLength(newLength);
    	
    	return mergedNode;
	}
}

package composition.music.transformation;

import java.util.List;

import composition.music.node.MusicNode;
import composition.music.parent.MusicParent;

/**
 * Represents a transformation of a MusicObject. For example, one such
 * transformation might be to convert every note to a chord. Another might be
 * to take a single note and split it into two notes whose durations are half
 * that of the original note.
 */
public interface Transformation {

	/**
	 * Transforms all the MusicNode children of the given MusicParent. After the
	 * transformation the children will still conform to the properties of the
	 * composition to which they belong. For example, a transformation will
	 * never result in a note that is outside the instrument's range.
	 * 
	 * WARNING: The given MusicParent will be MUTATED by this method.
	 * 
	 * @param parent a MusicParent object whose children are MusicNodes
	 */
	public void transform(MusicParent parent);
	
	/**
	 * Transforms the given MusicNode and returns the transformation as a List
	 * of MusicNodes. A list is returned because the transformation of a single
	 * MusicNode might result in more than one MusicNode (as in
	 * the case of splitting a note into two notes).
	 * 
	 * The returned MusicNode will still conform to the properties of the
	 * composition to which it belongs. For example, a transformation will never
	 * result in a note that is outside the instrument's range.
	 * 
	 * @param node the node to transform
	 * @return the node(s) that resulted from the transformation
	 */
	public List<MusicNode> transform(MusicNode node);
}

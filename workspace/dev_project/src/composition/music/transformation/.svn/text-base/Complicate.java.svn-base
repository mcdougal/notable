package composition.music.transformation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import util.RandomUtil;

import composition.Composition;
import composition.meta.TimeSignature;
import composition.music.MusicObject;
import composition.music.node.MusicNode;
import composition.music.node.Note;
import composition.music.parent.MusicParent;

/**
 * Applies random transformations to nodes at randomly chosen regular intervals.
 * For example, this transformation might result in the second beat of every
 * measure being split into two notes, or the first beat of every other measure
 * being converted to a rest.
 */
public class Complicate implements Transformation {

	@Override
	public void transform(MusicParent target) {
		
		// split note into two shorter notes
    	if (RandomUtil.rndmChance(1, 2))
    		transformOnRandomPattern(new Split(), target);

    	// insert rests
    	if (RandomUtil.rndmChance(1, 40))
    		transformOnRandomPattern(new Restify(), target);

    	// replace note with harmony
    	if (RandomUtil.rndmChance(1, 25))
    		transformOnRandomPattern(new Harmonize(), target);
    	
    	// replace note with chord
    	if (RandomUtil.rndmChance(1, 10))
    		transformOnRandomPattern(new Chordify(), target);
	}
	
	@Override
	public List<MusicNode> transform(MusicNode node) {
		List<MusicNode> returnList = new ArrayList<MusicNode>();
		
		int rndmInt = RandomUtil.getRndm().nextInt(4);
		
		if (rndmInt == 0)
			returnList.addAll(node.applyTransformation(new Split()));
		else if (rndmInt == 1)
			returnList.addAll(node.applyTransformation(new Restify()));
		else if (rndmInt == 2)
			returnList.addAll(node.applyTransformation(new Harmonize()));
		else
			returnList.addAll(node.applyTransformation(new Chordify()));
		
		return returnList;
	}
	
    /**
     * Performs the given transformation on the given MusicParent's child
     * MusicNodes at a pseudo-randomly selected interval. If the transformation
     * would break the constraints set by the Composition's properties, it is
     * not performed.
     * 
     * WARNING: The given MusicParent will be MUTATED by this method.
     * 
     * @param t the transformation to apply
     * @param target a MusicParent whose children are MusicNodes
     */
    private void transformOnRandomPattern(Transformation t, MusicParent target) {
    	
    	if (target.getNumMeasures() == 0)
    		return;
    	
    	Composition c = target.getComposition();
    	TimeSignature timeSig = c.getTimeSignature();

    	int beatsPerMeasure = timeSig.getBeatsPerMeasure();
    	int beatDuration = Note.SHORTEST_DURATION / timeSig.getBeatDuration();
    	
    	Random r = RandomUtil.getRndm();
    	
    	// randomly select the beat and measure intervals at which to apply
    	// the transformation
    	int beatInterval = r.nextInt(beatsPerMeasure);
    	int measureInterval = 1 + r.nextInt(3);
    	
    	if (measureInterval > target.getNumMeasures())
    		measureInterval = target.getNumMeasures();
    	
    	List<MusicObject> newContents = new ArrayList<MusicObject>();
    	
    	int currentMeasure = 0;
    	int currentBeat = 0;
    	int currentUnit = 0;
    	
    	for (MusicObject musicObject : target.getContents()) {
    		
    		// only take the action if you're on the right beat in the right measure
    		boolean takeAction =
    			currentMeasure % measureInterval == 0
    			&& currentBeat == beatInterval;
    		
    		if (takeAction) {
    			MusicNode node = (MusicNode) musicObject;
    			newContents.addAll(node.applyTransformation(t));
    		}
    		else {
    			newContents.add(musicObject.clone());
    		}

    		// increment the location tracking variables
    		currentUnit = currentUnit + ((MusicNode) musicObject).getLength();
    		if (currentUnit % beatDuration == 0)
    			currentBeat = (currentBeat + 1) % beatsPerMeasure;
    		if (currentBeat == 0)
    			currentMeasure++;
    	}
    	
    	target.setContents(newContents);
    }
}

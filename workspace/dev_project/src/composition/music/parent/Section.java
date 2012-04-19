package composition.music.parent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import util.RandomUtil;

import composition.Composition;
import composition.LilyPondObject;
import composition.meta.TimeSignature;
import composition.music.MusicObject;

/**
 * Represents a section of music within the sheet music generation project. A
 * section is represented as a collection of musical phrases.
 * 
 * @see Phrase
 */
public class Section extends MusicParent implements LilyPondObject {

    /////////////////////////////////
	//
    //  CONSTRUCTORS
    //
	/////////////////////////////////
    
    /**
     * Constructs a new, pseudo-randomly generated Section.
     */
    public Section(Composition composition, int numMeasures) {
    	super(composition, numMeasures);
    }
    
    /**
     * Constructs a new Section with the given values. It is helpful to use this
     * constructor when cloning a Section.
     */
    public Section(Composition composition, int numMeasures, List<MusicObject> phrases) {
    	super(composition, numMeasures, phrases);
    	
    	generateContents();
    }

    /////////////////////////////////
	//
    //  METHODS
    //
	/////////////////////////////////
	
    @Override
    public List<MusicObject> generateContents() {
    	Composition c = this.getComposition();
    	TimeSignature timeSig = c.getTimeSignature();
    	
		int beatsPerMeasure = timeSig.getBeatsPerMeasure();

    	int numPhrases = 1;
    	int phraseLength = this.getNumMeasures() / numPhrases;
    	int phraseLengthInBeats = phraseLength * beatsPerMeasure;
    	
    	while (phraseLengthInBeats > 24) {
    		numPhrases++;
    		phraseLength = this.getNumMeasures() / numPhrases;
    		phraseLengthInBeats = phraseLength * beatsPerMeasure;
    	}
    	
    	numPhrases = this.getNumMeasures() / phraseLength;
    	
    	int lastPhraseLength = this.getNumMeasures() % numPhrases;
    	
    	int dictSize = getDictionarySize();
    	
    	List<MusicObject> dictionary = new ArrayList<MusicObject>(dictSize);
    	for (int i = 0; i < dictSize; i++) {
    		dictionary.add(new Phrase(this.getComposition(), phraseLength));
    	}
    	
    	Random r = RandomUtil.getRndm();
    	
    	List<MusicObject> phrases;
    	if (lastPhraseLength != 0)
    		phrases = new ArrayList<MusicObject>(numPhrases + 1);
    	else
    		phrases = new ArrayList<MusicObject>(numPhrases);
    	
    	for (int i = 0; i < numPhrases; i++) {
    		int dictIndex = r.nextInt(dictionary.size());
    		MusicObject dictEntry = dictionary.get(dictIndex);
    		
    		phrases.add(dictEntry.clone());
    	}
    	
    	if (lastPhraseLength != 0)
    		phrases.add(new Phrase(this.getComposition(), lastPhraseLength));
    	
    	return phrases;
    }
	
    /**
     * Returns a size to use for this Section's dictionary of phrases.
     */
    private int getDictionarySize() {
    	return 1 + (this.getNumMeasures() / 4);
    }

	@Override
	public MusicObject clone() {
		return new Section(this.getComposition(),
				this.getNumMeasures(), this.cloneContents());
	}

	@Override
	public String getLilyPondHeader() {
		return "% Phrase:\n";
	}
	
	@Override
	public String getLilyPondSpacer() {
		return "\n";
	}
	
}

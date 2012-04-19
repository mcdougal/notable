package composition.music.parent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import util.RandomUtil;

import composition.Composition;
import composition.LilyPondObject;
import composition.music.MusicObject;

/**
 * Represents a song within the sheet music generation project. A song is
 * represented as a collection of sections.
 * 
 * @see Section
 */
public class Song extends MusicParent implements LilyPondObject {

    /////////////////////////////////
	//
    //  CONSTRUCTORS
    //
	/////////////////////////////////
    
    /**
     * Constructs a new, pseudo-randomly generated Song.
     */
    public Song(Composition composition, int numMeasures) {
    	super(composition, numMeasures);
    }
    
    /**
     * Constructs a new Song with the given values. It is helpful to use this
     * constructor when cloning a Song.
     */
    public Song(Composition composition, int numMeasures, List<MusicObject> sections) {
    	super(composition, numMeasures, sections);
    }

    /////////////////////////////////
	//
    //  METHODS
    //
	/////////////////////////////////
	
    @Override
    public List<MusicObject> generateContents() {
    	
    	if (this.getNumMeasures() == 0)
    		return new ArrayList<MusicObject>(0);

    	int numSections = getNumberOfSections();
    	int dictSize = getDictionarySize();
    	int sectionLength = this.getNumMeasures() / numSections;
    	int lastSectionLength = this.getNumMeasures() % numSections;
    	
    	List<MusicObject> dictionary = new ArrayList<MusicObject>(dictSize);
    	for (int i = 0; i < dictSize; i++) {
    		dictionary.add(new Section(this.getComposition(), sectionLength));
    	}
    	
    	Random r = RandomUtil.getRndm();
    	
    	List<MusicObject> sections;
    	if (lastSectionLength != 0)
    		sections = new ArrayList<MusicObject>(numSections + 1);
    	else
    		sections = new ArrayList<MusicObject>(numSections);
    	
    	for (int i = 0; i < numSections; i++) {
    		int dictIndex = r.nextInt(dictionary.size());
    		MusicObject dictEntry = dictionary.get(dictIndex);
    		
    		sections.add(dictEntry.clone());
    	}
    	
    	if (lastSectionLength != 0)
    		sections.add(new Section(this.getComposition(), lastSectionLength));
    	
    	return sections;
    }
    
    /**
     * Returns the number of sections that will best split up this Song.
     */
    private int getNumberOfSections() {
    	if (this.getNumMeasures() < 15)
    		return 1;
    	else if (this.getNumMeasures() < 30)
    		return 2;
    	else if (this.getNumMeasures() < 45)
    		return 3;
    	else if (this.getNumMeasures() < 60)
    		return 4;
    	else
    		return 5;
    }
	
    /**
     * Returns a size to use for this Song's dictionary of sections.
     */
    private int getDictionarySize() {
    	return 1 + (this.getNumMeasures() / 8);
    }

    @Override
	public MusicObject clone() {
		return new Song(this.getComposition(),
				this.getNumMeasures(), this.cloneContents());
	}
    
	@Override
	public String getLilyPondHeader() {
		return "% Section ----------\n\n";
	}
	
	@Override
	public String getLilyPondSpacer() {
		return "\n";
	}
}

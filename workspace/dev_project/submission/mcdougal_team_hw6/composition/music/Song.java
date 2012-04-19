package composition.music;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import util.RandomUtil;

import composition.Composition;
import composition.LilyPondObject;

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
    
    /**
     * Returns a pseudo-random List of MusicObject children based on the
     * Composition's properties. Every MusicObject in the returned List will
     * be of the <code>Section</code> class.
     * 
     * @see Section
     */
    public List<MusicObject> generateContents() {
        
        if (this.getNumMeasures() == 0)
            return new ArrayList<MusicObject>(0);
        
        int dictSize = getDictionarySize();
        int numSections = RandomUtil.getRandomDivisorLessThan(this.getNumMeasures(), 5);
        int sectionLength = this.getNumMeasures() / numSections;
        
        List<MusicObject> dictionary = new ArrayList<MusicObject>(dictSize);
        for (int i = 0; i < dictSize; i++) {
            dictionary.add(new Section(this.getComposition(), sectionLength));
        }
        
        Random r = new Random();
        
        List<MusicObject> sections = new ArrayList<MusicObject>(numSections);
        
        for (int i = 0; i < numSections; i++) {
            int dictIndex = r.nextInt(dictionary.size());
            MusicObject dictEntry = dictionary.get(dictIndex);
            
            sections.add(dictEntry.clone());
        }
        
        return sections;
    }
    
    /**
     * Returns a size to use for this Song's dictionary of sections. The size
     * is based on the difficulty of the Composition: the higher the difficulty,
     * the larger the dictionary, which will lead to more variety in the music.
     */
    public int getDictionarySize() {
        int difficulty = this.getComposition().getDifficulty();
        
        if (difficulty <= 20)
            return 1;
        else if (difficulty <= 40)
            return 2;
        else if (difficulty <= 60)
            return 3;
        else if (difficulty <= 80)
            return 4;
        else
            return 5;
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

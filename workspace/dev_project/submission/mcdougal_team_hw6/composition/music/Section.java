package composition.music;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import composition.Composition;
import composition.LilyPondObject;

/**
 * Represents a section of music within the sheet music generation project. A
 * section is represented as a collection of musical phrases. A section could
 * take on different interpretations depending on the style of music. In
 * classical music, for example, a section might be a movement. In rock music,
 * a section might be a verse or chorus.
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
    
    /**
     * Returns a pseudo-random List of MusicObject children based on the
     * Composition's properties. Every MusicObject in the returned List will
     * be of the <code>Phrase</code> class.
     * 
     * @see Phrase
     */
    public List<MusicObject> generateContents() {
        int dictSize = getDictionarySize();

        int numPhrases = 1;
        int phraseLength = this.getNumMeasures() / numPhrases;
        
        if (phraseLength > 1) {
            while (phraseLength > 8) {
                numPhrases++;
                phraseLength = this.getNumMeasures() / numPhrases;
            }
        }
        
        int lastPhraseLength = this.getNumMeasures() % numPhrases;
        
        List<MusicObject> dictionary = new ArrayList<MusicObject>(dictSize);
        for (int i = 0; i < dictSize; i++) {
            dictionary.add(new Phrase(this.getComposition(), phraseLength));
        }
        
        Random r = new Random();
        
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
     * Returns a size to use for this Section's dictionary of phrases. The size
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
        return new Section(this.getComposition(),
                this.getNumMeasures(), this.cloneContents());
    }

    @Override
    public String getLilyPondHeader() {
        return "";
    }
    
    @Override
    public String getLilyPondSpacer() {
        return "\n";
    }
    
    
}

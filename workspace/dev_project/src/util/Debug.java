package util;

import composition.Composition;
import composition.meta.Instrument;
import composition.meta.KeySignature;
import composition.meta.TimeSignature;
import composition.music.MusicObject;
import composition.music.node.Chord;
import composition.music.node.MusicNode;
import composition.music.node.Note;
import composition.music.parent.Phrase;
import composition.music.parent.Section;
import composition.music.parent.Song;

/**
 * Contains methods and variables used for debugging.
 */
public class Debug {

    /** Prints debug information and more detailed errors when set to true */
    private static boolean activated = false;
    
    /**
     * Returns true if debug-mode is activated.
     */
    public static boolean isOn() {
    	return Debug.activated;
    }
	
    /**
     * Activates debug-mode if the given boolean is true; deactivates it if the
     * given boolean is false.
     */
    public static void turnOn(boolean on) {
    	Debug.activated = on;
    }
    
	/**
	 * Prints the given String only if the debug flag is set to true.
	 * 
	 * @param s printed to the console
	 */
    public static void printMsg(String s) {
    	if (activated)
    		System.out.print(s);
    }
    
    /**
     * Prints a stack trace if the debug flag is set to true. Prints the
     * given Exceptions message if the debug flag is set to false.
     * 
     * @param e the Exception to provide details for
     */
    public static void printException(Exception e) {
    	if (activated)
    		e.printStackTrace();
    	else
    		System.out.println(e.getMessage());
    }
    
    /**
     * Checks the given Song to make sure its notes are within the boundaries of
     * its Composition's properties.
     */
    public static String checkSongAccuracy(Song song) {
    	if (!activated)
    		return "";
    	
    	Composition c = song.getComposition();
    	Instrument instrument = c.getInstrument();
    	TimeSignature timeSignature = c.getTimeSignature();
    	KeySignature key = c.getKey();
    	int length = c.getLength();
    	int difficulty = c.getDifficulty();
    	
    	int lowestPitch = instrument.getLowestPitch();
        int highestPitch = instrument.getHighestPitch();
        
        int beatsPerMeasure = timeSignature.getBeatsPerMeasure();
        int beatDuration = Note.SHORTEST_DURATION / timeSignature.getBeatDuration();
        
        int lengthOfSong = beatsPerMeasure * beatDuration * length;
        int actualLength = 0;
        
        StringBuilder errorMsg = new StringBuilder();
        
        for (MusicObject section : song.getContents()) {
        	Section s = (Section) section;
        	
        	for (MusicObject phrase : s.getContents()) {
        		Phrase p = (Phrase) phrase;
        		
        		for (MusicObject node : p.getContents()) {
        			MusicNode n = (MusicNode) node;
        			
        			boolean failure = true;
        			if (n.getClass().equals(Note.class)) {
        				Note note = (Note) n;
        				int pitch = note.getRootPitch();
        				
	        			failure = pitch != Note.NONE &&
	        				(pitch < lowestPitch || pitch > highestPitch);
	        			
	        			if (failure) {
	        				errorMsg.append("\nFAILURE: instrument range test on Note\n");
	        				errorMsg.append("       : note pitch = "+note.getRootPitch()+"\n");
	        			}
        			}
        			else if (n.getClass().equals(Chord.class)) {
        				Chord chord = (Chord) n;
        				
        				int lowPitch = chord.getRootPitch();
        				int highPitch = lowPitch;
        				if (chord.getFifth() != Chord.NONE)
        					highPitch = chord.getFifth();
        				else if (chord.getThird() != Chord.NONE)
        					highPitch = chord.getThird();
        				
	        			failure = lowPitch < lowestPitch || highPitch > highestPitch;
	        			
	        			if (failure) {
	        				errorMsg.append("\nFAILURE: instrument range test on Chord\n");
	        				errorMsg.append("       : low pitch = "+lowPitch+"\n");
	        				errorMsg.append("       : high pitch = "+highPitch+"\n");
	        			}
        			}
        			
        			if (failure) {
        				errorMsg.append("       : instr low  = "+lowestPitch+"\n");
        				errorMsg.append("       : instr high = "+highestPitch+"\n");
        				errorMsg.append("       : key = "+key.getNote()+"\n");
        				errorMsg.append("       : difficulty = "+difficulty+"\n");
        			}
        			
        			actualLength = actualLength + n.getLength();
        		}
        	}
        }
        
        if (lengthOfSong != actualLength) {
        	errorMsg.append("\nFAILURE: song length\n");
        	errorMsg.append("       : expected length = "+lengthOfSong+"\n");
        	errorMsg.append("       : actual length   = "+actualLength+"\n");
        }
        
        return errorMsg.toString();
    }
	
}

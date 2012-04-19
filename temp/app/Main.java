package app;

import parser.InputParser;

import composition.Composition;

import fileio.FileIO;

/**
 * Entry point for the random sheet music generation project. Contains the
 * main method that accepts user input and runs the application.
 * 
 * @author Cedric McDougal, Ben Johnson, Kevin Castiglia
 * @since 2/25/2011
 */
public class Main {

	/** Prints debug information and more detailed errors when set to true */
	public static final boolean DEBUG = false;
	
    /**
     * Accepts command line arguments and runs the application.
     * 
     * @param args[0] the name of the input file
     * @param args[1] the name to be used for the output file
     */
    public static void main(String[] args) {
    	// check for proper number of arguments
        if (args.length != 2){
        	System.out.println("Usage: java Main <inputFileName> <outputFileName>");
        	return;
        }
        
        String inputFileName = args[0];
        String outputFileName = args[1];
        
        new Main().run(inputFileName, outputFileName);
    }
    
    /**
     * Runs the application:
     * - parses input file
     * - generates pseudo-random music
     * - converts composition to LilyPond format
     * - writes LilyPond output to file
     * 
     * Note: method is public so it can be tested.
     * 
     * @param inputFileName the name of the input file
     * @param outputFileName the name to be used for the output file
     */
    public void run(String inputFileName, String outputFileName) {
    	try {
    		String fileContents = FileIO.readFile(inputFileName);
    		
    		Composition composition = new InputParser().parse(fileContents);
    		composition.generateSong();
    		
    		FileIO.writeFile(outputFileName, composition.toLilyPondString());
    	}
	    catch (Exception e){
	    	if (DEBUG)
	    		e.printStackTrace();
	    	else
	    		System.out.println(e.getMessage());
	    }
    }
}
package app;

import parser.InputParser;

import composition.Composition;

import fileio.FileIO;

/**
 * Entry point for the random sheet music generation project. Contains the
 * main method that accepts user input and runs the application.
 * 
 * @author Cedric McDougal, Ben Johnson, Kevin Castiglia
 * @since 3/12/2011
 */
public class Main {
    
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
            long startTime = System.currentTimeMillis();
            
            Debug.printMsg("Reading input file...");
            String fileContents = FileIO.readFile(inputFileName);
            Debug.printMsg(" success\n");
            
            Debug.printMsg("Parsing input file...");
            Composition composition = new InputParser().parse(fileContents);
            Debug.printMsg(" success\n");
            
            Debug.printMsg("Generating song...");
            composition.generateSong();
            Debug.printMsg(" success\n");
            
            Debug.printMsg("Writing output...");
            FileIO.writeFile(outputFileName, composition.toLilyPondString());
            Debug.printMsg(" success\n");
            
            double totalSeconds = (System.currentTimeMillis() - startTime) / 1000;
            
            Debug.printMsg("\nFinished in "+totalSeconds+" seconds");
        }
        catch (Exception e){
            Debug.printException(e);
        }
    }
}
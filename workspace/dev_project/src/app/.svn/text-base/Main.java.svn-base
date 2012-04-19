package app;

import parser.InputParser;
import util.Debug;
import util.FileIO;
import util.RandomUtil;

import composition.Composition;


/**
 * Entry point for the random sheet music generation project. Contains the
 * main method that accepts user input and runs the application.
 * 
 * @author Cedric McDougal, Ben Johnson, Kevin Castiglia
 * @since 4/3/2011
 */
public class Main {
    
    /**
     * Accepts command line arguments and runs the application.
     * 
     * Usage:
     * > java Main [-d] [-seed <seed>] <inputFileName> <outputFileName>
     * > [] = optional
     * > -d = debug flag (displays console debugging output)
     * > -seed = the seed used for randomization (a Java long value)
     */
    public static void main(String[] args) {
    	
    	if (args[0].equals("-d")) {
    		Debug.turnOn(true);
    		
    		if (args[1].equals("-seed")) {
    			if (args.length != 5) {
    				displayUsageMessage();
    				return;
    			}
    			
    			long seed = Long.parseLong(args[2]);
    			String inputFileName = args[3];
                String outputFileName = args[4];
                
                new Main().run(seed, inputFileName, outputFileName);
    		}
    		else {
    			if (args.length != 3) {
    				displayUsageMessage();
    				return;
    			}
    			
    			long seed = RandomUtil.generateNewSeed();
    			String inputFileName = args[1];
                String outputFileName = args[2];
                
                new Main().run(seed, inputFileName, outputFileName);
    		}
    	}
    	else {
			if (args.length != 2) {
				displayUsageMessage();
				return;
			}

			long seed = RandomUtil.generateNewSeed();
			String inputFileName = args[0];
            String outputFileName = args[1];
            
            new Main().run(seed, inputFileName, outputFileName);
    	}
    }
    
    /**
     * 
     */
    private static void displayUsageMessage() {
    	System.out.println(
    			"Usage:\n"+
    			"* java Main [-d] [-seed <seed>] <inputFileName> <outputFileName>\n"+
    			"* [] = optional\n"+
    			"* -d = debug flag (displays console debugging output)\n"+
    			"* -seed = the seed used for randomization (a Java long value)\n");
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
    public void run(long seed, String inputFileName, String outputFileName) {
        try {
        	long startTime = System.currentTimeMillis();
        	
        	RandomUtil.setSeed(seed);
        	Debug.printMsg("seed = "+RandomUtil.getSeed()+"\n\n");
        	
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
        	
        	double totalSeconds =
        		(double)(System.currentTimeMillis() - startTime) / (double)1000;
        	
            Debug.printMsg("\nFinished in "+totalSeconds+" seconds");
        }
        catch (Exception e){
        	Debug.printException(e);
        }
    }
}
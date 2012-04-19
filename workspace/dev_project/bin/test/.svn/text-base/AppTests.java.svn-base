package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import parser.InputParser;
import util.Debug;
import util.FileIO;
import util.RandomUtil;
import app.Main;

import composition.Composition;

public class AppTests {
    
    private static final String INPUT_FILE = "test/testfile.txt";
    private static final String OUTPUT_FILE = "test/output.ly";
    
    Main main;
    
    StringBuilder errors = new StringBuilder();
    
    public static void main(String[] args) {
    	int cycles = Integer.parseInt(args[0]);
        new AppTests().run(cycles);
    }
    
    /**
     * 
     */
    private void run(int cycles) {
        setup();
        
        Debug.turnOn(true);
        
        for (int i = 0; i < cycles; i++) {
	        testGroup("blank", GenerateTestData.BLANK_TEST);
	        testGroup("instrument", GenerateTestData.INSTURMENT_TESTS);
	        testGroup("time_signature", GenerateTestData.TIME_SIGNATURE_TESTS);
	        testGroup("key_signature", GenerateTestData.KEY_SIGNATURE_TESTS);
	        testGroup("length", GenerateTestData.LENGTH_TESTS);
	        testGroup("difficulty", GenerateTestData.DIFFICULTY_TESTS);
        }
        
        try {
        	FileIO.writeFile("error.log", errors.toString());
        }
        catch (Exception e) {}
        
        teardown();
    }
    
    /**
     * 
     */
    private void setup() {
    	main = new Main();
        outputStringToFile("", INPUT_FILE);
    }
    
    /**
     * 
     */
    private void teardown() {
    	main = null;
        boolean deleteSuccess = new File(INPUT_FILE).delete();
        System.out.println("\nTest file deleted: "+deleteSuccess);
    }
    
    /**
     * 
     */
    private void outputStringToFile(String s, String fileName) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            PrintStream out = new PrintStream(fos);
            out.print(s);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 
     */
    private void testGroup(String groupName, String[] dataset) {
        System.out.println("Testing "+groupName);
        
        for (int i = 0; i < dataset.length; i++) {
            testInput(dataset[i], i);
        }
        
        System.out.println("\n---------------------------");
    }
    
    /**
     * 
     */
    private void testInput(String input, int testNumber){
        System.out.println("\nTest "+testNumber);
        outputStringToFile(input, INPUT_FILE);
        checkOutput();
        System.out.print("\n");
    }
    
    /**
     * 
     */
    private void checkOutput() {
    	run(RandomUtil.generateNewSeed(), INPUT_FILE, OUTPUT_FILE);
    }
    
    private void run(long seed, String inputFileName, String outputFileName) {
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
            
        	errors.append(Debug.checkSongAccuracy(composition.getSong()));
        	
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

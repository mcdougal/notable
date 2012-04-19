package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import parser.InputParser;
import app.Main;

import composition.Composition;

import fileio.FileIO;

public class AppTests {
    
    private static final String INPUT_FILE = "testfile.txt";
    private static final String OUTPUT_FILE = "output.ly";
    
    Main main;
    
    public static void main(String[] args) {
        new AppTests().run();
    }
    
    /**
     * 
     */
    private void run() {
        setup();
        
        testGroup("blank", GenerateTestData.BLANK_TEST);
        testGroup("instrument", GenerateTestData.INSTURMENT_TESTS);
        testGroup("time_signature", GenerateTestData.TIME_SIGNATURE_TESTS);
        testGroup("key_signature", GenerateTestData.KEY_SIGNATURE_TESTS);
        testGroup("length", GenerateTestData.LENGTH_TESTS);
        testGroup("difficulty", GenerateTestData.DIFFICULTY_TESTS);
        
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
        System.out.println("Testing "+groupName+"\n");
        
        for (int i = 0; i < dataset.length; i++) {
            testInput(dataset[i], i);
        }
        
        System.out.println("\n---------------------------");
    }
    
    /**
     * 
     */
    private void testInput(String input, int testNumber){
        System.out.println("Test "+testNumber);
        outputStringToFile(input, INPUT_FILE);
        checkOutput();
        System.out.print("\n");
    }
    
    /**
     * 
     */
    private void checkOutput() {
        try {
            String fileContents = FileIO.readFile(INPUT_FILE);
            Composition composition = new InputParser().parse(fileContents);
            
            composition.generateSong();
            composition.checkSongAccuracy();
            
            FileIO.writeFile(OUTPUT_FILE, composition.toLilyPondString());
            
            System.out.println("PASS");
        }
        catch (Exception e) {
            System.out.println("ERROR");
        }
    }

}

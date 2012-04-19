package test;

import java.io.File;
import java.io.FileWriter;

import app.Main;

/**
 * 
 */
public class AppTests {

    //
    // TEST DATA
    //
	
	public static final String TEST_FILE_PREFIX = "testfile_";
	public static final String TEST_DIR_ROOT = "tests";
	public static final String TEST_DIR_PREFIX = "group_";
	
	public static final String[] BLANK_TEST = {""};
	
	public static final String[] INSTURMENT_TESTS =
		{"instrument:soprano recorder\n",
		 "instrument:alto recorder\n",
		 "instrument:concert flute\n",
		 "instrument:oboe\n",
		 "instrument:bassoon\n",
		 "instrument:violin\n",
		 "instrument:cello\n",
		 "instrument:guitar\n",
		 "instrument:piano\n"
		};
	
	public static final String[] TIME_SIGNATURE_TESTS =
		{"time signature:4/4\n",
		 "time signature:5/4\n",
		 "time signature:3/4\n",
		 "time signature:8/8\n",
		 "time signature:9/8\n"
		};
	
	public static final String[] KEY_SIGNATURE_TESTS =
		{"key:Ab\n",
		 "key:Abmajor\n",
		 "key:Abminor\n",
		 "key:A\n",
		 "key:A#\n",
		 "key:Bb\n",
		 "key:B\n",
		 "key:B#\n",
		 "key:Cb\n",
		 "key:C\n",
		 "key:C#\n",
		 "key:Db\n",
		 "key:D\n",
		 "key:D#\n",
		 "key:Eb\n",
		 "key:E\n",
		 "key:E#\n",
		 "key:Fb\n",
		 "key:F\n",
		 "key:F#\n",
		 "key:Gb\n",
		 "key:G\n",
		 "key:G#\n"
		};
	
	public static final String[] LENGTH_TESTS =
		{"length:0\n",
		 "length:5\n",
		 "length:32\n",
		 "length:100\n",
		 "length:200\n"
		};
	
    //
    // VARIABLES
    //

	FileWriter writer;
	File file;
	Main main;
	
    //
    // MAIN METHOD
    //
	
	public static void main(String[] args) {
		new AppTests().run();
    }

    //
    // TEST METHODS
    //
	
	/**
	 * 
	 */
	private void run() {
		System.out.println("Running tests...");
		
		main = new Main();
		file = new File(TEST_DIR_ROOT);
		file.mkdir();
		
		testGroup("blank", BLANK_TEST);
		testGroup("instrument", INSTURMENT_TESTS);
		testGroup("time_signature", TIME_SIGNATURE_TESTS);
		testGroup("key_signature", KEY_SIGNATURE_TESTS);
		testGroup("length", LENGTH_TESTS);
		
		main = null;
		file = null;
		writer = null;
		
		System.out.println("Done");
	}
	
	/**
	 * 
	 */
	private void testGroup(String groupName, String[] dataset) {
		System.out.println("Testing "+groupName+"\n");
		
		for (int i = 0; i < dataset.length; i++) {
			testInput(dataset[i], groupName, i);
		}
		
		System.out.println("\n---------------------------");
	}
	
	/**
	 * 
	 */
	private void testInput(String input, String groupName, int testNumber){
		System.out.println("Test "+testNumber);
		
		// create the test directory
		String dirName = TEST_DIR_ROOT+"/"+TEST_DIR_PREFIX+"_"+groupName;
		file = new File(dirName);
		file.mkdir();
		
		// create and write the input file
		String inputFilePath = dirName+"/"+TEST_FILE_PREFIX+testNumber+".txt";
		outputStringToFile(input, inputFilePath);
		
		// get the output file name
		String outputFilePath = dirName+"/output_"+testNumber+".ly";
		
		runTest(inputFilePath, outputFilePath);
		System.out.print("\n");
	}
	
	/**
	 * 
	 */
	private void runTest(String inputFileName, String outputFileName) {
		try {
			main.run(inputFileName, outputFileName);
			System.out.println("PASS");
		}
		catch (Exception e) {
			System.out.println("ERROR");
		}
	}
	
	/**
	 * 
	 */
	private void outputStringToFile(String s, String fileName) {
        try {
        	writer = new FileWriter(fileName);
        	writer.write(s);
        	writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

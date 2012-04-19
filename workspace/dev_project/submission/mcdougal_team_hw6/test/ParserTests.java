package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import fileio.FileIO;

import parser.InputParser;

/**
 * 
 */
public class ParserTests {

    /////////////////////////////////
    //
    //  TEST DATA
    //
    /////////////////////////////////
    
    private static final String TEST_FILE = "testfile.txt";
    
    private static final String[] TEST_CASES_BASE_GOOD = {""};
    private static final String[] TEST_CASES_BASE_BAD =
        {"    ",
         "\n", "\r", "\r\n",
         "akegrnakngr"
        };
    
    private static final String[] TEST_CASES_INSTRUMENT_GOOD =
        {"instrument:soprano recorder\n",
         "instrument:oboe\r",
         "    instrument:concert flute\r\n",
         "  instrument:     alto recorder\n",
         "      instrument:    concert flute     \r",
         "instrument: cello  \r\n",
         "                          instrument:piano                     \n"
        };

    private static final String[] TEST_CASES_INSTRUMENT_BAD =
        {"intsrument:soprano recorder\n",
         "  instrument:oboee\r",
         "instrument:oboe\r\r",
         "   instrument:oboe\n\r",
         "instrument:oboe",
         "  instrument   :oboe",
         "intsrument:soprano  recorder\n"
        };
    
    private static final String[] TEST_CASES_TIME_SIG_GOOD =
        {"                          time signature:05/04                    \n",
         "time signature:4/4\n",
         "time signature:000/8\r",
         "    time signature:00999999/64\r\n",
         "  time signature:     100/32\n",
         "      time signature:    1/2     \r",
         "time signature: 0/2  \r\n"
        };

    private static final String[] TEST_CASES_TIME_SIG_BAD =
        {"  tmie signature:4/4\n",
         "time signature:4/4a\n",
         "timesignature:4/4\n",
         " time signature  :4/4\n",
         "time signature:4/4",
         "   time signature:4/4\n\r",
         "time signature:4//4\n",
         "time signature://4\n",
         "time signature:a/4\n",
         "    time signature:4/a\n",
         "time signature:-12/4\n",
         "time signature:4/4.0\n",
         " time signature:4.2/4\n",
         "time signature:4 /4\n",
         "time signature:4/ 4\n",
         "time signature:4/3\n"
        };
    
    private static final String[] TEST_CASES_KEY_GOOD =
        {"      key:    B#       major     \r\n",
         "key: Cb  \n",
         "                          key:G#minor                     \r",
         "key:Ab\n",
         "key:Aminor\r",
         "key:A#major\r\n",
         "    key:Bb\n",
         "  key:     B   minor\r"
        };
    
    private static final String[] TEST_CASES_KEY_BAD =
        {"kye:Ab\n",
         "key:Abb\n",
         " key :Ab\n",
         "key:Abminormajor\n",
         "   key:Ab major minor\n",
         "key:A b\n",
         "key:A #\n",
         " key:H\n",
         "key:Ab",
         "   key:Ab\n\r",
        };
    
    private static final String[] TEST_CASES_LENGTH_GOOD =
        {"  length:     99999\n",
         "      length:    0123     \r",
         "length: 0  \r\n",
         "                          length:1                    \n",
         "length:12\n",
         "length:0000000\r",
         "    length:00099998\r\n"
        };

    private static final String[] TEST_CASES_LENGTH_BAD =
        {" lnegth:12\n",
         "length:12a\n",
         "   length:a\n",
         "length:-12\n",
         " length:12.0\n",
         "  length:1 2\n",
         "length  :12\n",
         "length:12",
         "    length:12\n\r"
        };
    
    private static final String[] TEST_CASES_DIFFICULTY_GOOD =
        {"difficulty:1\n",
         "difficulty: 10\r",
         "    difficulty:100\r\n",
         "  difficulty:     97\n",
         "      difficulty:    22     \r",
         "difficulty: 21  \r\n",
         "                          difficulty:50                     \n"
        };

    private static final String[] TEST_CASES_DIFFICULTY_BAD =
        {"difficulyt:1\n",
         "  difficulty:oboe\r",
         "difficulty:0\r",
         "difficulty:101\r",
         "difficulty:100\r\r",
         "   difficulty:1\n\r",
         "difficulty:5",
         "  difficulty   :10",
         "difficulty:1 0\n"
        };
    
    private static final String[][] TEST_GROUPS =
        {TEST_CASES_INSTRUMENT_GOOD,
         TEST_CASES_TIME_SIG_GOOD,
         TEST_CASES_KEY_GOOD,
         TEST_CASES_LENGTH_GOOD,
         TEST_CASES_DIFFICULTY_GOOD
        };

    /////////////////////////////////
    //
    //  INSTANCE VARIABLES
    //
    /////////////////////////////////

    private InputParser parser;

    /////////////////////////////////
    //
    //  MAIN METHOD
    //
    /////////////////////////////////
    
    public static void main(String[] args) {
        new ParserTests().run();
    }

    /////////////////////////////////
    //
    //  TEST METHODS
    //
    /////////////////////////////////
    
    /**
     * 
     */
    private void run() {
        setup();
        
        System.out.println("-------------------------------");
        System.out.println("     Running good tests");
        System.out.println("-------------------------------");
        
        testGroup("base", TEST_CASES_BASE_GOOD);
        testGroup("instrument", TEST_CASES_INSTRUMENT_GOOD);
        testGroup("time signature", TEST_CASES_TIME_SIG_GOOD);
        testGroup("key signature", TEST_CASES_KEY_GOOD);
        testGroup("length", TEST_CASES_LENGTH_GOOD);
        testGroup("difficulty", TEST_CASES_DIFFICULTY_GOOD);
        testGroupsComposite(TEST_GROUPS);
        
        System.out.println("-------------------------------");
        System.out.println("     Running bad tests");
        System.out.println("-------------------------------");
        
        testGroup("base", TEST_CASES_BASE_BAD);
        testGroup("instrument", TEST_CASES_INSTRUMENT_BAD);
        testGroup("time signature", TEST_CASES_TIME_SIG_BAD);
        testGroup("key signature", TEST_CASES_KEY_BAD);
        testGroup("length", TEST_CASES_LENGTH_BAD);
        testGroup("difficulty", TEST_CASES_DIFFICULTY_BAD);
        
        teardown();
    }
    
    /**
     * 
     */
    private void setup() {
        parser = new InputParser();
        outputStringToFile("", TEST_FILE);
    }
    
    /**
     * 
     */
    private void teardown() {
        parser = null;
        boolean deleteSuccess = new File(TEST_FILE).delete();
        System.out.println("\nTest file deleted: "+deleteSuccess);
    }
    
    /**
     * 
     */
    private void testGroupsComposite(String[][] groups) {
        System.out.println("Testing composite\n");
        
        for (int i = 0; i < groups[0].length; i++) {
            StringBuffer testdata = new StringBuffer();
            
            for (int j = 0; j < groups.length; j++) {
                testdata.append(groups[j][i]);
            }
            
            testInput(testdata.toString(), i);
        }
        
        System.out.println("\n---------------------------");
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
        outputStringToFile(input, TEST_FILE);
        parseTestFile();
        System.out.print("\n");
    }
    
    /**
     * 
     */
    private void parseTestFile() {
        try {
            parser.parse(FileIO.readFile(TEST_FILE));
            System.out.println("PASS");
        }
        catch (Exception e) {
            System.out.println("FAIL");
        }
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
}
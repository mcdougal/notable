package fileio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * This class handles file input and output.
 */
public class FileIO {

    /**
     * Reads every character in the input file into a String.
     * 
     * @param fileName the name of the file to read
     * @return a String of the file's contents
     */
    public static String readFile(String fileName) throws Exception {
        File file = new File(fileName);
        
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuffer buffer = new StringBuffer();
        
        int nextChar = reader.read();
        while (nextChar != -1){
            buffer.append((char)nextChar);
            nextChar = reader.read();
        }
        
        return buffer.toString();
    }
    
    /**
     * Writes a String to a file.
     * 
     * @param fileName the name of the file to write to (created if it doesn't
     *     exist)
     * @param output the String to write
     */
    public static
    void writeFile(String fileName, String output) throws Exception {
        FileWriter writer = new FileWriter(fileName);
        writer.write(output);
        writer.close();
    }
}

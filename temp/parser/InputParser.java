package parser;

import java.util.ArrayList;
import java.util.List;

import composition.Composition;
import composition.Instrument;

/**
 * Parses input file in order to extract configuration information for the
 * sheet music generation application. Converts extracted configuration into
 * an internally recognized format and returns an object encapsulating this
 * information.
 * 
 */
public class InputParser {
	
    //
    // VARIABLES
    //
	
	/** Stores all text read from the input file */
	private String fileContents;
	
	/** Stores characters as they are read in order to rollback read position */
	private String tempString;
	
	/** Index within the input String that will be read next */
	private int currentPosition;
	
	/** Internal format for parsed data; returned upon successful parsing */
	private Composition composition;
	
    //
    // ENTRY PUBLIC METHOD
    //
	
	/**
	 * Parses a file following the specification defined at:
	 * http://www.ccs.neu.edu/course/cs4500wc/assignment5.txt
	 * 
	 * @param fileName the name of the file to parse
	 * @return an Object encapsulating the internal representation of the parsed data
	 * @throws Exception if there is an error reading or parsing the file
	 */
	public Composition parse(String s) throws Exception {
		fileContents = s;
		composition = new Composition();
		
		input();
		
		return composition;
	}
	
    //
    // NON-TERMINAL DEFINITIONS
    //
	
	/**
	 * Input non-terminal. Encompasses all input rules.
	 */
	private void input() throws Exception {
		currentPosition = -1;
		tempString = "";
		
		if (!hasNextChar())
			return;
		
		instrumentSpec();
		timeSpec();
		keySpec();
		lengthSpec();
		endOfFile();
	}
	
	/**
	 * Instrument specification non-terminal.
	 */
	private void instrumentSpec() {
		tempString = "";
		
		try {
			whitespace();
			getNextValue(ParserConst.INSTRUMENT_TAG, true);
			whitespace();
			instrument();
			whitespace();
			ls();
		}
		catch (Exception e) {
			rollback(tempString.length());
		}
	}
	
	/**
	 * Time signature specification non-terminal. Saves the parsed value to
	 * the composition.
	 */
	private void timeSpec() {
		tempString = "";
		
		try {
			whitespace();
			getNextValue(ParserConst.TIME_SIG_TAG, true);
			whitespace();
			composition.getTimeSignature().setBeatsPerMeasure((integer()));
			getNextValue(ParserConst.TIME_SIG_DELIMETER, true);
			composition.getTimeSignature().setBeatDuration((integer()));
			whitespace();
			ls();
		}
		catch (Exception e) {
			rollback(tempString.length());
		}
	}
	
	/**
	 * Key signature specification non-terminal.
	 */
	private void keySpec() {
		tempString = "";
		
		try {
			whitespace();
			getNextValue(ParserConst.KEY_TAG, true);
			whitespace();
			key();
			whitespace();
			ls();
		}
		catch (Exception e) {
			rollback(tempString.length());
		}
	}
	
	/**
	 * Length specification non-terminal. Saves the parsed value to the
	 * composition.
	 */
	private void lengthSpec() {
		tempString = "";
		
		try {
			whitespace();
			getNextValue(ParserConst.LENGTH_TAG, true);
			whitespace();
			composition.setLength((integer()));
			whitespace();
			ls();
		}
		catch (Exception e) {
			rollback(tempString.length());
		}
	}
	
	/**
	 * Instrument non-terminal. Saves the parsed value to the composition.
	 */
	private void instrument() throws Exception {
		String inputInstrument = getNextValue(ParserConst.INSTRUMENT_ARRAY, true);
		Instrument instrument = ParserUtil.convertInputToInstrument(inputInstrument);
		
		composition.setInstrument(instrument);
	}
	
	/**
	 * Key non-terminal. Saves the parsed value to the composition.
	 */
	private void key() throws Exception {
		String pitch = pitch();
		String scale = ParserConst.MAJOR_KEY;
		
		whitespace();
		
		if (nextValueEquals(ParserConst.MAJOR_KEY))
			scale = getNextValue(ParserConst.MAJOR_KEY, true);
		else if (nextValueEquals(ParserConst.MINOR_KEY))
			scale = getNextValue(ParserConst.MINOR_KEY, true);
		
		composition.setKey(ParserUtil.convertInputToKeySignature(pitch, scale));
	}
	
	/**
	 * Pitch non-terminal.
	 * 
	 * @return the parsed pitch String
	 */
	private String pitch() throws Exception {
		return getNextValue(ParserConst.KEY_ARRAY, true);
	}
	
	/**
	 * Integer non-terminal.
	 * 
	 * @return the parsed integer
	 */
	private int integer() throws Exception {
		StringBuilder accumulator = new StringBuilder();
		
		while (nextValueIsOneOf(ParserConst.DIGITS)){
			accumulator.append(digit());
		}
		
		return Integer.parseInt(accumulator.toString());
	}
	
	/**
	 * Digit non-terminal.
	 * 
	 * @return the parsed digit
	 */
	private String digit() throws Exception {
		return getNextValue(ParserConst.DIGITS, true);
	}
	
	/**
	 * Whitespace non-terminal.
	 */
	private void whitespace() {
		while (getNextChar(false) == ' '){
			getNextChar(true);
		}
	}
	
	/**
	 * Line seperator non-terminal.
	 */
	private void ls() throws Exception {
		char ch = getNextChar(true);
		
		if (ch == '\r'){
			if (hasNextChar() && getNextChar(true) != '\n')
				rollback();
		}
		
		else if (ch != '\n'){
			throw new Exception("ERROR: Line seperator expected. "
					+ "Received: "+ch);
		}
	}
	
	/**
	 * End of file non-terminal.
	 */
	private void endOfFile() throws Exception {
		if (hasNextChar())
			throw new Exception("End of file expected. "
					+"Received: "+getNextChar(false));
	}

    //
    // HELPER METHODS
    //
	
	/**
	 * Checks if the next value is any of the given values. DOES NOT READ.
	 * 
	 * @param possibleValues an array of possible values to check for
	 * @return true if one of the given values comes next
	 */
	private boolean nextValueIsOneOf(String[] possibleValues) {
		try {
			getNextValue(possibleValues, false);
			return true;
		}
		catch (Exception e){
			return false;
		}
	}
	
	/**
	 * Tries to get or read one of the given values.
	 * 
	 * @param possibleValues an array of possible values to check for
	 * @param read increments the read-head when true
	 * 
	 * @return the value that matches the next String that can be read
	 * 
	 * @throws Exception if none of the given values can be read next
	 */
	private String getNextValue(String[] possibleValues, boolean read)
	throws Exception {
		
		List<String> matches = new ArrayList<String>();
		
		for (int i = 0; i < possibleValues.length; i++){
			if (nextValueEquals(possibleValues[i]))
				matches.add(possibleValues[i]);
		}
		
		if (matches.size() == 0)
			throw new Exception("Unable to read any of the expected values.");
		
		String match = getLongestString(matches);
		
		if (read)
			getNextValue(match, true);
		return match;
	}
	
	/**
	 * Returns true if the given String can be read next. DOES NOT READ.
	 */
	private boolean nextValueEquals(String expectedValue) {
		try {
			return getNextValue(expectedValue, false).equals(expectedValue);
		}
		catch (Exception e) {
			return false;
		}
	}

	/**
	 * Tries to get or read the given value.
	 * 
	 * @param expectedValue the value to be read, if possible
	 * @param read increments the read-head when true
	 * 
	 * @return the given String if it can be read
	 * 
	 * @throws Exception if the given String cannot be read 
	 */
	private String getNextValue(String expectedValue, boolean read)
	throws Exception {
		
		String nextValue = getNextNChars(expectedValue.length(), read);
		
		if (nextValue.equals(expectedValue))
			return nextValue;

		throw new Exception("Unable to read the expected value.");
	}
	
	/**
	 * Returns true if the input String has another character to read.
	 */
	private boolean hasNextChar() {
		return hasNMoreChars(1);
	}
	
	/**
	 * Returns the next character in the input String.
	 * 
	 * @param read increments the read-head when true
	 */
	private char getNextChar(boolean read) {
		return getNextNChars(1, read).charAt(0);
	}

	/**
	 * Returns true if the input String has n more characters that can be read.
	 */
	private boolean hasNMoreChars(int n) {
		try {
			getNextNChars(n, false);
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * Returns the next n characters in the input String.
	 * 
	 * @param n the number of characters to retrieve
	 * @param read increments the read-head when true
	 */
	private String getNextNChars(int n, boolean read) {
		String nextChars = fileContents.substring(
				currentPosition + 1, currentPosition + n + 1);
		
		if (read) {
			tempString = tempString + nextChars;
			currentPosition += n;
		}

		return nextChars;
	}
	
	/**
	 * Rolls the read-head back one character and removes the last character
	 * from the temporary String.
	 */
	private void rollback() {
		rollback(1);
	}
	
	/**
	 * Rolls the read-head back n characters and removes the last n characters
	 * from the temporary String.
	 * 
	 * @param n the number of characters to roll back
	 */
	private void rollback(int n) {
		currentPosition -= n;
		
		tempString = tempString.substring(0, n);
	}
	
	/**
	 * Returns the longest String in the given list of Strings. Used to prevent
	 * false positives when reading a value due to a substring of that value
	 * getting read first.
	 * 
	 * @param list the List of Strings to check
	 * @return the String in the list with the most characters
	 */
	private String getLongestString(List<String> list) {
		String longest = list.get(0);
		
		for (int i = 1; i < list.size(); i++){
			if (list.get(i).length() > longest.length())
				longest = list.get(i);
		}
		
		return longest;
	}
	
}

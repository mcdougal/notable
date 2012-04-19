package app;

/**
 * Contains methods and variables used for debugging.
 * 
 */
public class Debug {

    /** Prints debug information and more detailed errors when set to true */
    public static final boolean ON = true;
    
    /**
     * Prints the given String only if the debug flag is set to true.
     * 
     * @param s printed to the console
     */
    public static void printMsg(String s) {
        if (ON)
            System.out.print(s);
    }
    
    /**
     * Prints a stack trace if the debug flag is set to true. Prints the
     * given Exceptions message if the debug flag is set to false.
     * 
     * @param e the Exception to provide details for
     */
    public static void printException(Exception e) {
        if (ON)
            e.printStackTrace();
        else
            System.out.println(e.getMessage());
    }
    
}

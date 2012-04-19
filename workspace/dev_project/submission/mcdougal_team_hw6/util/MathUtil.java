package util;

public class MathUtil {
    
    /**
     * Returns the closest number, starting at n and counting up, that is a
     * power of 2 greater than 1.
     * 
     * For example, if n is 5, the return value would be 8. If n is 1, the
     * return value would be 2. If n is 16, the return value would be 16.
     * 
     * @param n > 0
     */
    public static int getPowerOf2Ceiling(int n) {
        if (n < 2)
            return 2;
        
        int val = n;
        
        double log = Math.log(val) / Math.log(2);
        
        while (log % 1 != 0) {
            val++;
            log = Math.log(val) / Math.log(2);
        }
        return val;
    }
}

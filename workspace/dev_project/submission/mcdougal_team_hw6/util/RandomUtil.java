package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomUtil {

    /**
     * Chance of returning true is determined by the given chance over the
     * given outOf value. For example, an 85% chance of returning true would
     * involve setting chance = 85 and outOf = 100.
     */
    public static boolean rndmChance(int chance, int outOf) {
        return new Random().nextInt(outOf) < chance;
    }

    /**
     * Returns a random divisor of the given int n that is no greater than the
     * given upper bound.
     */
    public static int getRandomDivisorLessThan(int n, int upperBound) {
        List<Integer> divisors = new ArrayList<Integer>();

        divisors.add(1);
        
        for (int i = 2; i < n && i < upperBound; i++) {
            if (n % i == 0)
                divisors.add(i);
        }

        return divisors.get(new Random().nextInt(divisors.size()));
    }

}

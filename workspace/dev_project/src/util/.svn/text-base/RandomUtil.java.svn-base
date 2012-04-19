package util;

import java.util.Random;

/**
 * Contains randomization methods used by the sheet music generation project.
 * Also stores the randomizing seed.
 */
public class RandomUtil {

	/** The randomizing seed used for all random generation */
	private static long seed;
	
	/** The random number generator */
	private static Random random;
	
	/**
	 * Returns a Random object that uses the randomizing seed.
	 */
	public static Random getRndm() {
		return random;
	}
	
	/**
	 * Returns a new randomizing seed.
	 */
	public static long generateNewSeed() {
		return new Random().nextLong();
	}
	
	/**
	 * Returns the randomizing seed.
	 */
	public static long getSeed() {
		return RandomUtil.seed;
	}
	
	/**
	 * Sets the randomizing seed to the given value and creates a new random
	 * number generator that uses the given seed.
	 */
	public static void setSeed(long seed) {
		RandomUtil.seed = seed;
		RandomUtil.random = new Random(seed);
	}
	
	/**
	 * Chance of returning true is determined by the given chance over the
	 * given outOf value. For example, an 85% chance of returning true would
	 * involve setting chance = 85 and outOf = 100.
	 */
	public static boolean rndmChance(int chance, int outOf) {
		return getRndm().nextInt(outOf) < chance;
	}

}

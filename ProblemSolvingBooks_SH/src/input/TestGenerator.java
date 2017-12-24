package input;

import java.util.Random;

public class TestGenerator {

	public static int[] Gen(int numberOfCases) {
		Random random = new Random(0);
		int[] testSet = new int[numberOfCases];
		
		for(int i=0; i<numberOfCases; i++) {
			testSet[i] = random.nextInt(10000);
		}
		
		return testSet;
	}
}

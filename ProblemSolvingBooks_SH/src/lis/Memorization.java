package lis;

import input.PerformanceTest;
import input.TestGenerator;

public class Memorization {

	public static void main(String[] args) {
		// test case
		int[] testSet = TestGenerator.Gen(100000);
		PerformanceTest.startCheck();
		System.out.println(findLIS(testSet, new int[testSet.length]));
		PerformanceTest.endCheck();
	}
	
	public static int findLIS(int[] set, int[] memorizer) {
		int max = 0;
		int maxLen = set.length;
		
		for(int i=0; i<maxLen; i++) {
			int lis = findLIS(set, i, memorizer);
			max = max > lis ? max : lis;
		}
		
		return max;
	}
	
	// recursive
	public static int findLIS(int[] set, int startIndex, int[] memorizer) {
		int max = 0;
		int maxLen = set.length;
		
		if(memorizer[startIndex] != 0) return memorizer[startIndex];
		
		//
		for(int i=startIndex+1; i< maxLen; i++) {
			int lis = 0;
			if(set[startIndex] < set[i]) lis = findLIS(set, i, memorizer);
			max = max > lis ? max : lis;  
		}
		
		// It is length 1 lis itself.
		memorizer[startIndex] = max+1;
		return (max+1);
	}
}

package lis;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {
		// test case
		int[] testSet = {5, 6, 7, 1, 2, 7, 3, 8, 10};
		System.out.println(findLIS(testSet));
	}
	
	public static int findLIS(int[] set) {
		int max = 0;
		int maxLen = set.length;
		int[] binaryIndex = new int[set.length];
		Arrays.fill(binaryIndex, Integer.MAX_VALUE);
		
		// init first step
		binaryIndex[0] = set[0];
		
		for(int i=1; i<maxLen; i++) findLIS(binaryIndex, set[i]);
		for(max=0; max<maxLen; max++) if(binaryIndex[max] == Integer.MAX_VALUE) break;
		
		return (max);
	}
	
	public static void findLIS(int[] binaryIndex, int pivot) {
		int max = 0;
		// binary search on 'binary index'
		
		int bottom = 0;
		int top = binaryIndex.length-1;
		
		while(true) {
			int index = (bottom+top+1)/2;
			if(binaryIndex[index-1] < pivot && binaryIndex[index] > pivot) {
				binaryIndex[index] = pivot; break;
			}else if(index == 1) {
				binaryIndex[0] = pivot; break;
			}
			
			if(binaryIndex[index] == pivot) break;
			if(binaryIndex[index] < pivot) bottom = index;
			else top = index;
			
		}
	}
}

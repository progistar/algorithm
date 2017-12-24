package lis;

public class Bruteforce {

	public static void main(String[] args) {
		// test case
		int[] testSet = {5, 6, 7, 1, 2, 7, 3, 8, 10};
		System.out.println(findLIS(testSet));
	}
	
	public static int findLIS(int[] set) {
		int max = 0;
		int maxLen = set.length;
		
		for(int i=0; i<maxLen; i++) {
			int lis = findLIS(set, i);
			max = max > lis ? max : lis;
		}
		
		return max;
	}
	
	public static int findLIS(int[] set, int startIndex) {
		int max = 0;
		int maxLen = set.length;
		
		//
		for(int i=startIndex+1; i< maxLen; i++) {
			int lis = 0;
			if(set[startIndex] < set[i]) lis = findLIS(set, i);
			max = max > lis ? max : lis;  
		}
		
		// It is length 1 lis itself.
		return (max+1);
	}
}

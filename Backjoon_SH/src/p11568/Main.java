package p11568;

import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		int[] input = readInput();
		System.out.println(select(input, 0, 0, new int[input.length]));
	}
	
	public static int select(int[] input, int pos, int min, int[] memorization) {
		if(pos >= input.length) return 0;
		
		int maxCnt = 0;
		int thisCnt = 0;
		
		//select
		if(min < input[pos]) {
			if(memorization[pos] == 0) memorization[pos] = 1 + select(input, pos+1, input[pos], memorization);
			thisCnt = memorization[pos];
			maxCnt = Math.max(maxCnt, thisCnt);
		}
		
		//unselect
		thisCnt = select(input, pos+1, min, memorization);
		maxCnt = Math.max(maxCnt, thisCnt);
		
		return maxCnt;
	}
	
	public static int[] readInput() {
		int[] input = null;
		
		Scanner scan = new Scanner(System.in);
		
		int size = scan.nextInt();
		input = new int[size];
		for(int i=0; i<size; i++) input[i] = scan.nextInt();
		
		scan.close();
		
		return input;
		
	}
}

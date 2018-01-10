package p9095;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int[] input = readInput();
		for(int i=0; i<input.length; i++) {
			System.out.println(combination(input[i], new int[input[i]+1]));
		}
	}
	
	public static int combination(int remainScore, int[] memorization) {
		if(remainScore == 0) return 1;
		if(remainScore < 0) return 0;
		if(memorization[remainScore] != 0) return memorization[remainScore];
		
		int firstCase = combination(remainScore-1, memorization);
		int secondCase = combination(remainScore-2, memorization);
		int thirdCase = combination(remainScore-3, memorization);
		
		memorization[remainScore] = firstCase+secondCase+thirdCase;
		
		return memorization[remainScore];
	}
	
	public static int[] readInput() {
		int[] input = null;
		
		Scanner scan = new Scanner(System.in);
		
		int cases = scan.nextInt();
		
		input = new int[cases];
		for(int i=0; i<cases; i++) input[i] = scan.nextInt();
		
		scan.close();
		
		return input;
	}
}

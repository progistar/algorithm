package p1932;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int[][] input = readInput();
		System.out.println(calDist(input, 0, 0, new int[input.length][input.length]));
	}
	
	public static int calDist(int[][] inputs, int row, int col, int[][] memorization) {
		if(inputs.length <= row) return 0;
		if(memorization[row][col] != 0) return memorization[row][col];
		
		int score = inputs[row][col];
		// left
		int leftScore = calDist(inputs, row+1, col, memorization);
		
		// right
		int rightScore = calDist(inputs, row+1, col+1, memorization);
		
		score += Math.max(leftScore, rightScore);
		memorization[row][col] = score;
		
		return score;
	}
	
	public static int[][] readInput() {
		int[][] inputs = null;
		
		Scanner scan = new Scanner(System.in);
		
		int sizeOfInput = scan.nextInt();
		
		inputs = new int[sizeOfInput][sizeOfInput];
		for(int i=0; i<sizeOfInput; i++) {
			for(int j=0; j<=i; j++) {
				inputs[i][j] = scan.nextInt();
			}
		}
		
		scan.close();
		
		return inputs;
	}
}

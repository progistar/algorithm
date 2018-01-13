package p9251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException{
		String[] inputString = readInput();
		System.out.println(inputString[0]);
		System.out.println(inputString[1]);
		globalAlignment(new int[inputString[0].length()][inputString[1].length()], inputString[0], inputString[1]);
	}
	
	public static void globalAlignment(int[][] scoringMatrix, String rowSeq, String colSeq) {
		int row = rowSeq.length();
		int col = colSeq.length();
		
		for(int i=1; i<row; i++) {
			for(int j=1; j<col; j++) {
				// from dig
				int digScore = scoringMatrix[i-1][j-1] + (rowSeq.charAt(i) == colSeq.charAt(j) ? 1 : 0);
				
				// from left
				int leftScore = scoringMatrix[i][j-1];
				
				// from up
				int upScore = scoringMatrix[i-1][j];
				
				int score = Math.max(digScore, leftScore);
				score = Math.max(score, upScore);
				scoringMatrix[i][j] = score;
			}
		}
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) System.out.print(scoringMatrix[i][j]+"\t");
			System.out.println();
		}
	}
	
	public static String[] readInput() throws IOException{
		BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = new String[2];
		input[0] = "-"+BR.readLine();
		input[1] = "-"+BR.readLine();
		
		BR.close();
		
		return input;
	}
}

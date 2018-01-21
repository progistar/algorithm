package p2133;

import java.util.Hashtable;
import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		
		System.out.println(brute(new boolean[n][3], 0, 0, new int[n][3][n][3]));
	}
	
	public static int brute(boolean[][] blocks, int row, int col, int[][][][] memorization) {
		
		int sizeOfRow = blocks.length;
		int sizeOfCol = 3;
		int total = 0;
		
		if(sizeOfRow % 2 == 1) return 0;
		
		if(row == sizeOfRow-1 && col == 2) {
			if(blocks[row][col]) return 1;
			else return 0;
		}
		
		int nextColStep = col +1 < sizeOfCol ? col+1 : 0;
		int nextRowStep = nextColStep == 0 ? row+1 : row;
		
		if(blocks[row][col]) {
			total = brute(blocks, nextRowStep, nextColStep, memorization);
			return total;
		}

		blocks[row][col] = true;
		
		// vertical
		if(row+1 < sizeOfRow && (blocks[row+1][col] == false)) {
			if(memorization[row][col][row+1][col] != 0) total += memorization[row][col][row+1][col];
			else {
				boolean[][] newBlocks = copyBlocks(blocks);
				newBlocks[row+1][col] = true;
				memorization[row][col][row+1][col] = brute(newBlocks, nextRowStep, nextColStep, memorization);
				total += memorization[row][col][row+1][col];
			}
		}
		
		// horizontal
		if(col+1 < sizeOfCol && (blocks[row][col+1] == false)) {
			if(memorization[row][col][row][col+1] != 0) total += memorization[row][col][row][col+1];
			else {
				boolean[][] newBlocks = copyBlocks(blocks);
				newBlocks[row][col+1] = true;
				memorization[row][col][row][col+1] = brute(newBlocks, nextRowStep, nextColStep, memorization);
				total += memorization[row][col][row][col+1];
			}
		}
		
		
		return total;
	}
	
	public static boolean[][] copyBlocks(boolean[][] blocks) {
		boolean[][] newBlocks = new boolean[blocks.length][3];
		
		for(int i=0; i<newBlocks.length; i++) {
			for(int j=0; j<3; j++) {
				newBlocks[i][j] = blocks[i][j];
			}
		}
		
		return newBlocks;
	}
}

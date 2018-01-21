package p2133;

import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		
		System.out.println(draw(n, new int[n+1]));
		System.out.println(brute(new boolean[n][3], 0, 0));
	}
	
	public static int draw(int blocks, int[] memorization) {
		if(blocks % 2 == 1) return 0;
		if(blocks == 2) return 3;
		if(blocks < 2) return 0;
		if(memorization[blocks] != 0) return 2;
		
		int baseCase = 2;
		
		int left = 2;
		int right = blocks - left;
		while(right > 0) {
			baseCase += draw(left, memorization) * draw(right, memorization);
			right -= 2;
			left += 2;
		}
		
		memorization[blocks] = baseCase;
		return baseCase;
	}
	
	public static int brute(boolean[][] blocks, int row, int col) {
		int sizeOfRow = blocks.length;
		int sizeOfCol = 3;
		int total = 0;
		
		if(row == sizeOfRow-1 && col == 2) {
			if(blocks[row][col]) return 1;
			else return 0;
		}
		
		int nextColStep = col +1 < sizeOfCol ? col+1 : 0;
		int nextRowStep = nextColStep == 0 ? row+1 : row;
		
		if(blocks[row][col]) {
			total = brute(blocks, nextRowStep, nextColStep);
			return total;
		}

		blocks[row][col] = true;
		
		// vertical
		if(row+1 < sizeOfRow && (blocks[row+1][col] == false)) {
			boolean[][] newBlocks = copyBlocks(blocks);
			newBlocks[row+1][col] = true;
			total += brute(newBlocks, nextRowStep, nextColStep);
		}
		
		// horizontal
		if(col+1 < sizeOfCol && (blocks[row][col+1] == false)) {
			boolean[][] newBlocks = copyBlocks(blocks);
			newBlocks[row][col+1] = true;
			total += brute(newBlocks, nextRowStep, nextColStep);
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

package lunchBox;

import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int[][][] eating = new int[size][2][];
		
		for(int i=0; i<size; i++) {
			int len = scan.nextInt();
			eating[i][0] = new int[len];
			eating[i][1] = new int[len];
			
			for(int j=0; j<len; j++) eating[i][0][j] = scan.nextInt(); 
			for(int j=0; j<len; j++) eating[i][1][j] = scan.nextInt();
			
		}
		
		for(int i=0; i<size; i++) {
			greedy(eating[i]);
		}
		
		scan.close();
	}
	
	public static int greedy(int[][] eating) {
		
		int len = eating[0].length;
		// the longest eating time is first.
		// Insertion sorting
		for(int i=1; i<len; i++) {
			int pivot0 = eating[0][i];
			int pivot1 = eating[1][i];
			
			int j = i -1;
			while( (j >= 0) && (eating[1][j] < pivot1)) {
				eating[1][j+1] = eating[1][j];
				eating[0][j+1] = eating[0][j];
				j--;
			}
			eating[0][j+1] = pivot0;
			eating[1][j+1] = pivot1;  
		}
		
		System.out.println(time(eating));
		
		return 0;
	}
	
	public static int time(int[][] eating) {
		int initTime = eating[0][0];
		int len = eating[0].length;
		
		int eatingTime = 0;
		for(int i=1; i<len; i++) {
			eatingTime = Math.max(eating[1][i-1] - eating[0][i], eatingTime);
			if(eatingTime < 0) eatingTime = 0;
			initTime += eating[0][i];
		}
		initTime += eating[1][len-1];
		
		return initTime;
	}
}

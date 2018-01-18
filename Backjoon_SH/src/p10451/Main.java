package p10451;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int sizeN = scan.nextInt();
		int[][] data = new int[sizeN][];
		
		for(int i=0; i<sizeN; i++) {
			int n = scan.nextInt();
			data[i] = new int[n+1];
			for(int j=1; j<n+1; j++) {
				data[i][j] = scan.nextInt();
			}
		}
		
		scan.close();
		
		for(int i=0; i<sizeN; i++) {
			int cycle = 0;
			int sizeOfThis = data[i].length;
			int[] state = new int[sizeOfThis];
			for(int j=1; j<sizeOfThis; j++) {
				if(state[j] != 0) continue;
				
				int nextState = data[i][j];
				state[j] = j;
				while(true) {
					if(state[nextState] == j) {
						cycle++; break;
					} else if(state[nextState] != 0) {
						break;
					}
					state[nextState] = j;
					nextState = data[i][nextState];
				}
			}
			
			System.out.println(cycle);
		}
	}
}

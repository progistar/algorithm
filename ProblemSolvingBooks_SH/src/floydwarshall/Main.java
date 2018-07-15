package floydwarshall;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static int testSetSize = 0;
	public static int[] testSet = null;
	
	public static void main(String[] args) throws IOException {
		int[][] data = readInput();
		floyd(data);
		System.out.println(data[testSet[0]][testSet[1]]);
		System.out.println(data[testSet[2]][testSet[3]]);
	}
	
	public static void floyd(int[][] data) {
		int vertex = data.length;
		int[][] optimal = new int[vertex][vertex];
		
		for(int i=1; i<vertex; i++) {
			for(int j=1; j<vertex; j++) {
				if(i==j) optimal[i][j] = 0;
				else optimal[i][j] = data[i][j];
			}
		}
		
		for(int k=1; k<vertex; k++) {
			for(int s=1; s<vertex; s++) {
				for(int d=1; d<vertex; d++) {
					data[s][d] = Math.min(data[s][d], data[s][k] + data[k][d]);
					optimal[s][d] = Math.min(optimal[s][d], data[s][k] + data[k][d] + data[k][0]);
				}
			}
		}
		
		data = optimal;
	}
	
	public static int[][] readInput() throws IOException {
		int[][] data = null;
		
		Scanner scan = new Scanner(System.in);
		
		int vertex = scan.nextInt() + 1;
		int edge = scan.nextInt();
		
		data = new int[vertex][vertex];
		for(int i=0; i<vertex; i++) {
			Arrays.fill(data[i], 1000);
		}
		
		// Non-mid
		for(int i=1; i<vertex; i++) data[i][0] = scan.nextInt(); 
		
		for(int i=0; i<edge; i++) {
			int source = scan.nextInt();
			int dest = scan.nextInt();
			int load = scan.nextInt();
			data[source][dest] = load;
			data[dest][source] = load;
		}
		
		testSetSize = scan.nextInt();
		testSet = new int[testSetSize*2];
		
		for(int i=0; i<testSet.length; i+=2) {
			testSet[i] = scan.nextInt();
			testSet[i+1] = scan.nextInt();
		}
		
		scan.close();
		
		return data;
	}
}

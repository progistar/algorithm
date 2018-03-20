package p1010;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int[][] inputs = readInput();
		
		for(int i=0; i<inputs.length; i++){
			int[][] cross = init(inputs[i]);
			System.out.println(getCross(cross, 0, 0));
		}
		
	}
	
	public static int[][] init(int[] inputs) {
		int[][] cross = new int[inputs[0]][inputs[1]];
		return cross;
	}
	
	public static int getCross(int[][] inputs, int westStart, int eastStart) {
		int cnt = 0;
		int westSize = inputs.length;
		int eastSize = inputs[0].length;
		int[][] memorization = new int[westSize][eastSize];
		for(int i=eastStart; i < eastSize; i++) {
			cnt += getCross(westSize, eastSize, westStart, i, memorization);
		}
		
		return cnt;
	}
	
	public static int getCross(int westSize, int eastSize, int westStart, int eastStart, int[][] memorization) {
		if(memorization[westStart][eastStart] != 0) return memorization[westStart][eastStart];
		
		int cnt = 0;
		westStart++; eastStart++;
		if(westStart == westSize && eastStart <= eastSize) return 1;
		for(int i=eastStart; i < eastSize; i++) {
			if(westSize - westStart > eastSize - eastStart) continue;
			cnt += getCross(westSize, eastSize, westStart, i, memorization);
		}
		memorization[westStart-1][eastStart-1] = cnt;
		return cnt;
	}
	
	public static int[][] readInput() {
		int[][] inputs = null;
		
		Scanner scan = new Scanner(System.in);
		
		int condition = scan.nextInt();
		inputs = new int[condition][2];
		
		for(int i=0; i<condition; i++){
			inputs[i][0] = scan.nextInt();
			inputs[i][1] = scan.nextInt();
		}
		
		scan.close();
		
		return inputs;
	}
}

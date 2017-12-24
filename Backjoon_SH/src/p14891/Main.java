package p14891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
		// wheel states
		boolean[][] wheels = new boolean[4][8];
		for(int i=0; i<4; i++) {
			String line = BR.readLine();
			for(int j=0; j<line.length(); j++) {
				if(line.charAt(j) == '0')  wheels[i][j] = false;
				else wheels[i][j] = true;
			}
		}
		
		int numberOfChanges = Integer.parseInt(BR.readLine());
		int[][] changes = new int[numberOfChanges][2];
		
		for(int i=0; i<numberOfChanges; i++) {
			String[] which = BR.readLine().split("\\s");
			changes[i][0] = Integer.parseInt(which[0]);
			changes[i][1] = Integer.parseInt(which[1]);
		}
		
		int[] pos = new int[4];
		for(int i=0; i<numberOfChanges; i++) {
			int which = changes[i][0];
			int direction = changes[i][1];
			rotation(pos, direction, wheels, which-1, 0);
		}
		
		// cal
		int sum = 0;
		for(int i=0; i<4; i++) {
			sum += Math.pow(2, i)*(wheels[i][pos[i]] == true ? 1 : 0); 
		}
		System.out.println(sum);
	}
	
	public static void rotation(int[] pos, int direction, boolean[][] wheels, int which, int from) {
		int pivot = pos[which];
		// left
		if(which > 0 && from != 1){
			int leftSide = pivot-2 > -1 ? pivot-2 : pivot+6;
			int rightSide = pos[which-1]-6 > -1 ? pos[which-1]-6 : pos[which-1]+2;
			if(wheels[which][leftSide] != wheels[which-1][rightSide]) rotation(pos, -1*direction, wheels, which-1, 2);
		}
		
		
		// right
		if(which < 3 && from != 2){
			int rightSide = pivot-6 > -1 ? pivot-6 : pivot+2;
			int leftSide = pos[which+1]-2 > -1 ? pos[which+1]-2 : pos[which+1]+6;
			if(wheels[which+1][leftSide] != wheels[which][rightSide]) rotation(pos, -1*direction, wheels, which+1, 1);
		}
		
		// 
		if(direction == -1){
			if(pivot == 7) pivot = 0;
			else pivot++;
		}else{
			if(pivot == 0) pivot = 7;
			else pivot--;
		}
		
		pos[which] = pivot;
	}
	
}

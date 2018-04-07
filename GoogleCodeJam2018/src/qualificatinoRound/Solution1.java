package qualificatinoRound;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Instruction {
	int shield = 0;
	// True is a shot
	// False is a change
	int[] inst = null;
}

public class Solution1 {

	public static void main(String[] args) throws IOException {
		Instruction[] insts = readInput();
		for(int i=0; i<insts.length; i++) {
			int result = hacks(insts[i]);
			if(result == -1) {
				System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
			}else {
				System.out.println("Case #"+(i+1)+": "+result);
			}
		}
	}
	
	public static int hacks(Instruction instruction) {
		int[] inst = instruction.inst;
		int shield = instruction.shield;
		int len = inst.length;
		// Check is possible
		int totDam = 0;
		int lastIndex = 0;
		for(int i=0; i<len; i++) {
			if(inst[i] != 0) {
				totDam += 1;
				lastIndex = i;
			}
		}
		if(totDam > shield) return -1;
		
		totDam = 0;
		for(int i=0; i<len; i++) totDam += inst[i];
		
		int swapNum = 0;
		while(true) {
			if(totDam <= shield) break;
			
			for(int i=lastIndex; i>0; i--) {
				if(inst[i] != 0 && inst[i-1] == 0) {
					inst[i-1] = inst[i]/2;
					inst[i] = 0;
					swapNum ++;
					totDam -= inst[i-1];
					if(i == lastIndex) lastIndex--;
				}
			}
		}
		
		return swapNum;
	}
	
	public static Instruction[] readInput() throws IOException {
		Instruction[] insts = null;
		
		BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(BR.readLine());
		insts = new Instruction[testCase];
		
		for(int i=0; i<testCase; i++) {
			insts[i] = new Instruction();
			String[] input = BR.readLine().split("\\s");
			insts[i].shield = Integer.parseInt(input[0]);
			
			int nOfInsts = input[1].length();
			insts[i].inst = new int[nOfInsts];
			
			int dam = 1;
			for(int j=0; j<nOfInsts; j++) {
				if(input[1].charAt(j) == 'S') insts[i].inst[j] = dam;
				else dam *= 2;
			}
		}
		
		
		BR.close();
		return insts;
	}
}

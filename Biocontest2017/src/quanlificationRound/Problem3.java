package quanlificationRound;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;

class CodonMapper {
	Codon codon = new Codon();
	Hashtable<String, Integer> minimumDist = new Hashtable<String, Integer>();
	public String[] aminoAcids = {"A", "C", "D", "E", "F", "G", "H", "I", "K", "L", "M", "N", "P", "Q", "R", "S", "T", "V", "W", "Y"};
	public char[] nucles = {'A','C','G','T'};

	public int getMin(String nucle, String tag) {
		int min = 0;
		
		if(minimumDist.get(nucle+tag) != null) return minimumDist.get(nucle+tag); 
		
		char targetAmino = codon.getAminoFromNucl(nucle);
		
		
		for(char n1 : nucles) {
			StringBuilder SB = new StringBuilder(nucle);
			if(tag.charAt(0) == 'o') {
				SB.setCharAt(0, n1);
			}
			for(char n2 : nucles) {
				if(tag.charAt(0) == 'o') {
					SB.setCharAt(0, n2);
				}
				for(char n3 : nucles) {
					if(tag.charAt(0) == 'o') {
						SB.setCharAt(0, n3);
					}
					
					if(targetAmino == codon.getAminoFromNucl(SB.toString())) {
						int diff = 0;
						for(int i=0; i<3; i++) if(SB.charAt(i) != nucle.charAt(i)) diff++;
						if(diff != 0) {
							if(min == 0) diff = min;
							else min = Math.min(diff, min);
						}
					}
					
				}	
			}
		}
		
		if(min == 0) min = -1;
		
		minimumDist.put(nucle+tag, min);
		
		return min;
	}
}

class TestCase {
	String nucle;
	int[] ranges;
}

public class Problem3 {
	
	public static void main(String[] args) {
		CodonMapper cmapper = set();
		TestCase[] tCase = readInput();
		for(int i=0; i<tCase.length; i++) {
			int min = 0;
			int len = tCase[i].ranges.length/2;
			
			for(int j=0; j<len; j++) {
				int start = tCase[i].ranges[j*2];
				int end = tCase[i].ranges[j*2+1];
				
				start = getInt(start, true);
				end = getInt(end, false);
				
				if(start < 1) start = 1;
				if(end > tCase[i].nucle.length()) end = tCase[i].nucle.length();
				String subString = tCase[i].nucle.substring(start-1,end);
				int loop = subString.length()/3;
				for(int k=0; k<loop; k++) {
					
				}
			}
			
		}
	}
	
	public static int getInt(int num, boolean isStart) {
		int case_ = num%3;
		switch(case_) {
		case 0: 
			if(isStart) num -= 2;
			break;
		case 1:
			if(!isStart) num += 2;
			break;
		case 2:
			if(isStart) num -= 1;
			else num += 1;
			break;
		}
		
		return num;
	}
	
	public static TestCase[] readInput() {
		TestCase[] tCases = null;
		
		try {
			BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
			int testNums = Integer.parseInt(BR.readLine());
			tCases = new TestCase[testNums];
			
			for(int i=0; i<testNums; i++) {
				tCases[i] = new TestCase();
				tCases[i].nucle = BR.readLine();
				int eachNums = Integer.parseInt(BR.readLine());
				tCases[i].ranges = new int[eachNums*2];
				for(int j=0; j<eachNums; j++) {
					String[] range = BR.readLine().split("\\s");
					tCases[i].ranges[j*2] = Integer.parseInt(range[0]);
					tCases[i].ranges[j*2+1] = Integer.parseInt(range[1]);
				}
			}
			
			BR.close();
		}catch(IOException e) {
			
		}
		
		return tCases;
	}
	
	
	// can change o
	// cannot change x
	// => oox, oxo, xoo, ... something else
	public static CodonMapper set() {
		CodonMapper cmapper = new CodonMapper();
		return cmapper;
	}
	
}

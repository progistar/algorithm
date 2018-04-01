package practiceSession;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Senator implements Comparable<Senator>{
	char belong = ' ';
	double member = 0;
	
	@Override
	public int compareTo(Senator o) {
		// TODO Auto-generated method stub
		if(this.member < o.member) return 1;
		else if(this.member > o.member) return -1;
		
		return 0;
	}
}

public class Solution2 {

	
	public static void main(String[] args) throws IOException{
		PriorityQueue<Senator> senators = new PriorityQueue<Senator>();
		BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(BR.readLine());
		int[][] inputs = new int[testCase][];
		
		for(int i=0; i<testCase; i++) {
			int numberOfGroups = Integer.parseInt(BR.readLine());
			inputs[i] = new int[numberOfGroups];
			String[] info = BR.readLine().split("\\s");
			
			for(int j=0; j<info.length; j++) {
				inputs[i][j] = Integer.parseInt(info[j]);
			}
		}
		
		for(int i=0; i<testCase; i++) {
			int len = inputs[i].length;
			
			for(int j=0; j<len; j++) {
				Senator senator = new Senator();
				senator.belong = (char) ('A' + j);
				senator.member = inputs[i][j];
				senators.add(senator);
			}
			
			Senator senator = null;
			System.out.print("Case #"+(i+1)+":");
			while(!senators.isEmpty()) {
				if(senators.size() == 3) {
					senator = senators.poll();
					senator.member--;
					if(senator.member > 0) senators.add(senator);
					System.out.print(" "+senator.belong);
				}else {
					senator = senators.poll();
					senator.member--;
					if(senator.member > 0) senators.add(senator);
					System.out.print(" "+senator.belong);
					
					if(!senators.isEmpty()) {
						senator = senators.poll();
						senator.member--;
						if(senator.member > 0) senators.add(senator);
						System.out.print(senator.belong);
					}
				}
				
				
			}
			System.out.println();

		}
		
	}
}

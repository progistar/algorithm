package contest2696;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.Iterator;

// maximum number of cyclic peptides
public class Main {

	
	public static void main(String[] args) throws IOException{
		BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
		String[] cond = BR.readLine().split("\\s");
		String subject = BR.readLine();
		int inputLen = Integer.parseInt(cond[1]);
		int[] inputs = new int[inputLen];
		for(int i=0; i<inputLen; i++) inputs[i] = Integer.parseInt(BR.readLine());
		BR.close();
		for(int i=0; i<inputLen; i++)
			System.out.println(bruteForce(inputs[i], subject));
	}
	
	/*public static int maxCycles(int len, String genome) {
		
	}*/
	
	public static int bruteForce(int len, String genome) {
		Hashtable<String, Node> tagNumber = new Hashtable<String, Node>();
		int genomeLen = genome.length() -len + 1;
		for(int i=0; i<genomeLen; i++) {
			String tag = genome.substring(i, i+len);
			Node tagNode = tagNumber.get(tag);
			if(tagNode == null) {
				tagNode = new Node();
				tagNumber.put(tag, tagNode);
			}
			
			tagNode.cycles++;
			Hashtable<String, Boolean> isDup = new Hashtable<String, Boolean>();
			isDup.put(tag, true);
			for(int j=1; j<len; j++) {
				String cyclicTag = tag.substring(j);
				if(j!=0) cyclicTag += tag.substring(0, j);
				
				if(isDup.get(cyclicTag) != null) continue;
				isDup.put(cyclicTag, true);
				if(tagNumber.get(cyclicTag) != null) tagNode.cycles = ++tagNumber.get(cyclicTag).cycles;
			}
		}
		
		// get the maximum
		Iterator<String> keys = (Iterator<String>)tagNumber.keys();
		int maxCycle = 0;
		while(keys.hasNext()) maxCycle = Math.max(maxCycle, tagNumber.get(keys.next()).cycles);
		
		return maxCycle;
	}
}

class Node {
	int timeStamp = -1;
	int cycles = 0;
}
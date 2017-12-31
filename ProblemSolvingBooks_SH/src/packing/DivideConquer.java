package packing;

import java.io.IOException;
import java.util.Scanner;

public class DivideConquer {

	public static void main(String[] args) throws IOException {
		Carrier[] carriers = readInput();
		
		for(int i=0; i<carriers.length; i++) {
			System.out.println(decision(carriers[i], 0, 0));
		}
	}
	
	public static int decision(Carrier carrier, int curItem, int curVolume) {
		if(curItem == carrier.items.length) return 0;
		
		// Keep it
		int keep = 0;
		if(!(curVolume + carrier.items[curItem].volume > carrier.allowable)) 
			keep += decision(carrier, curItem+1, curVolume + carrier.items[curItem].volume) + carrier.items[curItem].priority;
		
		// Discard it
		int discard = 0;
		discard += decision(carrier, curItem+1, curVolume);
		
		int maxPriority = Math.max(keep, discard);
		
		return maxPriority;
	}
	
	public static Carrier[] readInput() {
		Carrier[] carrier = null;
		
		Scanner scan = new Scanner(System.in);
		
		int theNumberOfCases = scan.nextInt();
		
		carrier = new Carrier[theNumberOfCases];
		for(int i=0; i<theNumberOfCases; i++) {
			int matters = scan.nextInt();
			int limit = scan.nextInt();
			
			// Set the allowable volumes in a carrier
			carrier[i] = new Carrier(limit);
			Item[] items = new Item[matters];
			
			// Read Item
			for(int j=0; j<matters; j++) items[j] = new Item(scan.next(), scan.nextInt(), scan.nextInt());				
			
			carrier[i].items = items;
			
		}
		
		scan.close();
		
		return carrier;
	}
}

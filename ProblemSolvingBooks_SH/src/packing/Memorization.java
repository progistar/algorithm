package packing;

import java.util.Scanner;

import input.PerformanceTest;

public class Memorization {

	public static void main(String[] args) {
		Carrier[] carriers = readInput();
		PerformanceTest.startCheck();
		for(int i=0; i<carriers.length; i++) {
			System.out.println(packing(carriers[i], carriers[i].allowable, 0, new int[1001][100]));
		}
		PerformanceTest.endCheck();
	}
	
	public static int packing(Carrier carrier, int available, int item, int[][] cache) {
		if(item == carrier.items.length) return 0;
		int ret = cache[available][item];
		if(ret != 0) return ret;
		
		ret = packing(carrier, available, item+1, cache);
		if(available >= carrier.items[item].volume) 
		ret = Math.max(ret, packing(carrier, available-carrier.items[item].volume, item+1, cache) + carrier.items[item].priority);
		cache[available][item] = ret;
		return ret;
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

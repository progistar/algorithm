package p1202;

import java.util.Arrays;
import java.util.Scanner;

class Jewel implements Comparable<Jewel> {
	int weight = 0;
	int value = 0;
	
	public Jewel (int weight, int value) {
		this.weight = weight;
		this.value = value;
	}

	@Override
	//## Sorting by values
	public int compareTo(Jewel jewel) {
		
		if(this.weight > jewel.weight) return 1;
		if(this.weight < jewel.weight) return -1;
		
		return 0;
	}
	
	
}

public class Main {

	public static int[] bags = null;
	public static int[] used = null;
	
	public static void main(String[] args) {
		Jewel[] jewels = readInput();
		
		System.out.println(maxGreedy(jewels));
	}
	
	public static int maxGreedy(Jewel[] jewels) {
		int sum = 0;
		int len = jewels.length;
		int get = 0;
		
		for(int i=0; i<len; i++) {
			
		}
		
		return sum;
	}
	
	public static Jewel[] readInput() {
		Jewel[] jewels = null;
		
		Scanner scan = new Scanner(System.in);
		
		int sizeOfJewels = scan.nextInt();
		int sizeOfBags = scan.nextInt();
		
		jewels = new Jewel[sizeOfJewels];
		bags = new int[sizeOfBags];
		used = new int[sizeOfBags];
		
		for(int i=0; i<sizeOfJewels; i++) {
			int weight = scan.nextInt();
			int value = scan.nextInt();
			jewels[i] = new Jewel(weight, value);
		}
		
		for(int i=0; i<bags.length; i++) {
			bags[i] = scan.nextInt();
		}
		
		Arrays.sort(bags);
		Arrays.sort(jewels);
		
		scan.close();
		
		return jewels;
	}
}

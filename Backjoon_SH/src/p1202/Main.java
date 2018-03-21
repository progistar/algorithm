package p1202;

import java.util.Arrays;
import java.util.Scanner;

class Bag {
	int weight = 0;
	Bag left = null;
	Bag right = null;
}

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
		
		if(this.value < jewel.value) return 1;
		if(this.value > jewel.value) return -1;
		
		return 0;
	}
	
	
}

public class Main {

	public static int[] bags = null;
	public static int[] used = null;
	public static int maxBag = 0;
	public static int inserted = 0;
	
	public static void main(String[] args) {
		Jewel[] jewels = readInput();
		
		System.out.println(maxGreedy(jewels));
	}
	
	public static int maxGreedy(Jewel[] jewels) {
		int len = jewels.length;
		int get = 0;
		
		for(int i=0; i<len; i++) {
			int bagIndex = binarySearch(jewels[i]);
			if(bagIndex != -1) get += used[bagIndex];
			if(inserted == bags.length) break;
		}
		
		return get;
	}
	
	public static int binarySearch(Jewel jewel) {
		if(jewel.weight > maxBag) return -1;
		int left = 0;
		int right = bags.length;
		int nearPos = 0;
		
		while(true) {
			int index = (right+left)/2;
			if(index == left || index == right) {
				nearPos = index;
				break;
			}
			if(bags[index] < jewel.weight) {
				left = index;
			}else if(bags[index] > jewel.weight) {
				right = index;
			}else {
				nearPos = index;
				break;
			}
		}

		boolean isFind = false;
		for(int i=nearPos; i < bags.length; i++) {
			if(bags[i] >= jewel.weight && used[i] == 0) {
				used[i] = jewel.value;
				nearPos = i;
				isFind = true;
				inserted++;
				if(bags[i] >= maxBag) {
					maxBag = -1;
					
					for(int j=i-1; j>=0; j--) {
						if(used[j] == 0) {
							maxBag = bags[j];
							break;
						}
					}
					
					
				}
				break;
			}
		}
		
		if(!isFind) nearPos = -1;
		
		return nearPos;
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
		maxBag = bags[bags.length-1];
		
		
		scan.close();
		
		return jewels;
	}
}

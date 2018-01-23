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
		
		if(this.value > jewel.value) return -1;
		if(this.value < jewel.value) return 1;
		
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
			if(findProperBag(jewels[i].weight)) {
				sum += jewels[i].value;
				get++;
			}
			
			if(get == bags.length-1) break;
		}
		
		return sum;
	}
	
	public static boolean findProperBag(int jewelWeight) {
		// binary search
		int left = 0;
		int right = bags.length - 1;
		boolean isAns = false;
		
		int mid = 0;
		while(true) {
			if((right-left) < 2) break;
			mid = (left + right) / 2;
			if(bags[mid] < jewelWeight) left = mid+1;
			else if(bags[mid] > jewelWeight) right = mid;
			else {
				right = mid;
				break;
			}
			
		}
		
		while(true) {
			if(used[right] == 0) {
				isAns = true;
				used[right] = right;
				break;
			}else {
				right = ++used[right];
			}
			if(right >= bags.length) break;
		}
		
		return isAns;
	}
	
	public static Jewel[] readInput() {
		Jewel[] jewels = null;
		
		Scanner scan = new Scanner(System.in);
		
		int sizeOfJewels = scan.nextInt();
		int sizeOfBags = scan.nextInt();
		
		jewels = new Jewel[sizeOfJewels];
		bags = new int[sizeOfBags+1];
		used = new int[sizeOfBags+1];
		
		for(int i=0; i<sizeOfJewels; i++) {
			int weight = scan.nextInt();
			int value = scan.nextInt();
			jewels[i] = new Jewel(weight, value);
		}
		
		bags[0] = 0;
		for(int i=1; i<bags.length; i++) {
			bags[i] = scan.nextInt();
		}
		
		Arrays.sort(bags);
		Arrays.sort(jewels);
		
		scan.close();
		
		return jewels;
	}
}

package p6603;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer[]> list = new ArrayList<Integer[]>();
		while(true) {
			int numbers = scan.nextInt();
			if(numbers == 0) break;
			Integer[] numberList = new Integer[numbers];
			int index = 0;
			while(index < numbers) {
				numberList[index++] = scan.nextInt();
			}
			list.add(numberList);
		}
		scan.close();
		
		for(int i=0; i<list.size(); i++) {
			subset(list.get(i), 0, 6);
			System.out.println();
		}
		
	}
	
	// Divide set into one and all recursively.
	// ex>
	// {1, 2, 3, 4, 5, 6}
	// {1}, {2, 3, 4, 5, 6}
	// {1}, {2}, {3, 4, 5, 6}
	// etc...
	// So that making this problem as many sub-problems.
	public static void subset(Integer[] sets, int index, int remain) {
		// Release this index
		if(checkThisEnd(sets, remain)) return;
		if(index == sets.length) return;
		
		// Contain this index
		sets[index] *= -1;
		subset(sets.clone(), index+1, remain-1);


		sets[index] *= -1;
		subset(sets.clone(), index+1, remain);
	}
	
	public static boolean checkThisEnd(Integer[] sets, int remain) {
		if(remain == 0) {
			for(int i=0; i<sets.length; i++) {
				if(sets[i] < 0) System.out.print(Math.abs(sets[i])+" ");
			}
			System.out.println();
			return true;
		}
		return false;
	}
}

package p1991;

import java.util.Scanner;

public class Main {

	public static String[] mapper = {"A", "B", "C", "D", "E", "F", "G", "H", "I",
						"J", "K", "L", "M", "N", "O", "P", "Q", "R", 
						"S", "T", "U", "V", "W", "X", "Y", "Z"};
	
	public static void main(String[] args) {
		int[][] inputs = readInput();
		preorder(inputs, 0);
		System.out.println();
		inorder(inputs, 0);
		System.out.println();
		postorder(inputs, 0);
	}
	
	public static void preorder(int[][] inputs, int index) {
		
		int leftChild = inputs[index][0];
		int rightChild = inputs[index][1];
		
		System.out.print(mapper[index]);
		if(leftChild != -1) preorder(inputs, leftChild);
		if(rightChild != -1) preorder(inputs, rightChild);
	}
	
	public static void inorder(int[][] inputs, int index) {
		
		int leftChild = inputs[index][0];
		int rightChild = inputs[index][1];
		
		if(leftChild != -1) inorder(inputs, leftChild);
		System.out.print(mapper[index]);
		if(rightChild != -1) inorder(inputs, rightChild);
	}

	public static void postorder(int[][] inputs, int index) {
	
		int leftChild = inputs[index][0];
		int rightChild = inputs[index][1];
		
		if(leftChild != -1) postorder(inputs, leftChild);
		if(rightChild != -1) postorder(inputs, rightChild);
		System.out.print(mapper[index]);
	}
	
	public static int[][] readInput() {
		// Input
		int[][] inputs = null;
		
		// Take some inputs
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		inputs = new int[n][2];
		
		for(int i=0; i<n; i++) {
			int point = 0;
			for(int j=0; j<3; j++) {
				char input = scan.next().charAt(0);
				if(j == 0) {
					point = input - 'A';
					continue;
				}
				if(input == '.') inputs[point][j-1] = -1;
				else inputs[point][j-1] = (input - 'A');
				
			}
		}
		
		scan.close();
		
		
		return inputs;
	}
}

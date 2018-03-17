package traversal;

import java.util.Scanner;

public class Main {

	public static void main(String[] agrs) {
		int[][][] inputs = readInput();
		for(int i=0; i<inputs.length; i++) {
			getPostorder(inputs[i][0], inputs[i][1]);
			System.out.println();
		}
	}
	
	public static void getPostorder(int[] preorder, int[] inorder) {
		if(preorder.length == 0) return;
		if(preorder.length == 1) {
			System.out.print(preorder[0]+" ");
			return;
		}
		
		int pivot = preorder[0];
		for(int i = 0; i<preorder.length; i++) {
			if(inorder[i] == pivot) {
				//LEFT
				int[] preLeft = new int[i];
				int[] inLeft = new int[i];
				
				for(int j=0; j<i; j++) {
					preLeft[j] = preorder[j+1];
					inLeft[j] = inorder[j];
				}
				
				getPostorder(preLeft, inLeft);
				//RIGHT
				int[] preRight = new int[preorder.length - i - 1];
				int[] inRight = new int[preorder.length - i - 1];
				
				for(int j=0; j<preRight.length; j++) {
					preRight[j] = preorder[i+j+1];
					inRight[j] = inorder[i+j+1];
					
				}
				
				getPostorder(preRight, inRight);
				System.out.print(pivot+" ");
				break;
			}
		}
	}
	
	public static int[][][] readInput() {
		Scanner scan = new Scanner(System.in);
		int case_ = scan.nextInt();
		int[][][] inputs = new int[case_][][];
		
		for(int i=0; i<case_; i++) {
			int nodes = scan.nextInt();
			inputs[i] = new int[2][nodes];
			
			for(int j=0; j<nodes; j++) inputs[i][0][j] = scan.nextInt();
			for(int j=0; j<nodes; j++) inputs[i][1][j] = scan.nextInt();
		}
				
		scan.close();
		return inputs;
		
	}
}

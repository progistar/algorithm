import java.util.Scanner;

public class TrianglePath {
	
	int N;
	int[][] table = {{6}, {1,2}, {3,7,4}, {9,4,1,7}, {2,7,5,9,4}};
	//int[][] table = {{1}, {2,3}, {4,5,6}};
	int MAX = 5;
	int[][] cache = new int[5][5];
	
	public int trianglePath (int x, int y) {
		 if(x>=MAX-1) {
			 return table[x][y];
		 }
		 
		 int leftMax;
		 int rightMax;
		 
		 //calculate left possibility
		 if(cache[x][y] != 0) {
			 return cache[x][y];
		 }
		 
		 leftMax = trianglePath(x+1, y);
		 rightMax = trianglePath(x+1, y+1);
		 
		 if(leftMax >= rightMax) {
			 cache[x][y] = leftMax + table[x][y];
		 }else {
			 cache[x][y] = rightMax + table[x][y];
		 }
		 return cache[x][y];
	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Scanner sc = new Scanner(System.in);
		TrianglePath m = new TrianglePath();
		System.out.println();
		for(int i=0;i<m.MAX;i++) {
			for(int j=0;j<m.MAX;j++) {
				System.out.print(m.cache[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		
		int result = m.trianglePath(0, 0);
		System.out.println(result);
		
		for(int i=0;i<m.MAX;i++) {
			for(int j=0;j<m.MAX;j++) {
				System.out.print(m.cache[i][j]+" ");
			}
			System.out.println();
		}
		
		
		
	}

}

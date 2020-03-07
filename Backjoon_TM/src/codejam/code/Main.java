package codejam.code;
import java.util.ArrayList;

public class Main {
	/*public static int segment (int x, List<Integer> arr) {
		int length = arr.size();
		int[][] dp = new int[length - x + 1][2];
		
		//init
		int min1 = Integer.MAX_VALUE; int min2 = Integer.MAX_VALUE;
		for (int i=0;i<x;i++) {
			if (arr.get(i) < min1) {
				min1 = arr.get(i);
			} else if (arr.get(i) < min2) {
				min2 = arr.get(i);
			}
		}
		dp[0][0] = min1;
		dp[0][1] = min2;
		
		for (int i=1; i<= (length - x); i++) {
			int delete = arr.get(i-1);
			int add = arr.get(i+x-1);
			int subMin1 = dp[i-1][0];
			int subMin2 = dp[i-1][1];
			
		}
	}*/
	void sort(int[][] intervals) {
        for (int i=0; i<intervals.length-1;i++) {
            for(int j=i+1; j<intervals.length;j++) {
                if(intervals[i][0] > intervals[j][0]) {
                    int[] tmp = intervals[i];
                    intervals[i] = intervals[j];
                    intervals[j] = tmp;
                }
            }
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//[[1,3],[2,6],[8,10],[15,18]]
		int[][] arr = {{1,2},{2,6},{8,10}, {15,18}, {0,5}};
		Main m = new Main();
		m.sort(arr);
		for (int i=0;i<arr.length;i++) {
			System.out.println(arr[i][0]+"   "+arr[i][1]);
		}
		
		ArrayList<int[]> list = new ArrayList<>();
		
	}
	
	protected boolean backtrack(int row, int col, String word, int index) {
	    /* Step 1). check the bottom case. */
	    if (index >= word.length())
	      return true;

	    /* Step 2). Check the boundaries. */
	    if (row < 0 || row == this.ROWS || col < 0 || col == this.COLS
	        || this.board[row][col] != word.charAt(index))
	      return false;

	    /* Step 3). explore the neighbors in DFS */
	    // mark the path before the next exploration
	    this.board[row][col] = '#';

	    int[] rowOffsets = {0, 1, 0, -1};
	    int[] colOffsets = {1, 0, -1, 0};
	    for (int d = 0; d < 4; ++d) {
	      if (this.backtrack(row + rowOffsets[d], col + colOffsets[d], word, index + 1))
	        // return without cleanup
	        return true;
	    }

	    /* Step 4). clean up and return the result. */
	    this.board[row][col] = word.charAt(index);
	    return false;
	  }

}

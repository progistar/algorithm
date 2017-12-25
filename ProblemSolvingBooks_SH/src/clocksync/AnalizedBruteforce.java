package clocksync;

import java.util.Scanner;

import input.PerformanceTest;

public class AnalizedBruteforce {
	
	public static void main(String[] args) {
		//TODO: Init sync info
		Integer[][] syncInfo = initSyncInfo();
		
		//TODO: input
		Scanner scan = new Scanner(System.in);
		int numberOfCases = scan.nextInt();
		Integer[][] clocks = new Integer[numberOfCases][16];		
		
		for(int i=0; i<numberOfCases; i++) {
			for(int j=0; j<16; j++) {
				clocks[i][j] = scan.nextInt();
			}
		}
		scan.close();
		PerformanceTest.startCheck();
		//TODO: DFS
		
		for(int i=0; i<numberOfCases; i++) {
			System.out.println(runDFS(clocks[i], syncInfo, 0, 0));
		}
		
		PerformanceTest.endCheck();
	}
	
	public static int runDFS(Integer[] clocks, Integer[][] syncInfo, int depth, int sync) {
		boolean isRight = true;
		for(int i=0; i<clocks.length; i++) if(clocks[i] != 12) isRight = false;
		if(isRight) return depth;
		if(sync == syncInfo.length) return -1;
		
		
		//TODO: Just Pass
		int ans = runDFS(clocks.clone(), syncInfo, depth, sync+1);
		if(ans != -1) return ans;
		
		for(int i=0; i<3; i++) {
			//TODO: Rotation
			depth++;
			for(int j=0; j<syncInfo[sync].length; j++) clocks[syncInfo[sync][j]] = clocks[syncInfo[sync][j]]+3 > 12 ? 3 : clocks[syncInfo[sync][j]]+3;
			ans = runDFS(clocks.clone(), syncInfo, depth, sync+1);
			if(ans != -1) return ans;
		}
		
		return -1;
	} 
	
	
	public static Integer[][] initSyncInfo() {
		Integer[][] syncInfo = new Integer[10][];
		
		syncInfo[0] = new Integer[3];
		syncInfo[0][0] = 0; syncInfo[0][1] = 1; syncInfo[0][2] = 2;
		
		syncInfo[1] = new Integer[4];
		syncInfo[1][0] = 3; syncInfo[1][1] = 7; syncInfo[1][2] = 9; syncInfo[1][3] = 11;
		
		syncInfo[2] = new Integer[4];
		syncInfo[2][0] = 4; syncInfo[2][1] = 10; syncInfo[2][2] = 14; syncInfo[2][3] = 15;

		syncInfo[3] = new Integer[5];
		syncInfo[3][0] = 0; syncInfo[3][1] = 4; syncInfo[3][2] = 5; syncInfo[3][3] = 6; syncInfo[3][4] = 7;
		
		syncInfo[4] = new Integer[5];
		syncInfo[4][0] = 6; syncInfo[4][1] = 7; syncInfo[4][2] = 8; syncInfo[4][3] = 10; syncInfo[4][4] = 12;
		
		syncInfo[5] = new Integer[4];
		syncInfo[5][0] = 0; syncInfo[5][1] = 2; syncInfo[5][2] = 14; syncInfo[5][3] = 15;
		
		syncInfo[6] = new Integer[3];
		syncInfo[6][0] = 3; syncInfo[6][1] = 14; syncInfo[6][2] = 15;
		
		syncInfo[7] = new Integer[5];
		syncInfo[7][0] = 4; syncInfo[7][1] = 5; syncInfo[7][2] = 7; syncInfo[7][3] = 14; syncInfo[7][4] = 15;
		
		syncInfo[8] = new Integer[5];
		syncInfo[8][0] = 1; syncInfo[8][1] = 2; syncInfo[8][2] = 3; syncInfo[8][3] = 4; syncInfo[8][4] = 5;
		
		syncInfo[9] = new Integer[5];
		syncInfo[9][0] = 3; syncInfo[9][1] = 4; syncInfo[9][2] = 5; syncInfo[9][3] = 9; syncInfo[9][4] = 13;
		
		return syncInfo;
	}
}

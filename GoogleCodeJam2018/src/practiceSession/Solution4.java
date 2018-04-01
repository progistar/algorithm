package practiceSession;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Stall implements Comparable<Stall>{
	int priority = 0;
	int leftMostPos = 0;
	int rightMostPos = 0;
	int curPos = 0;
	@Override
	public int compareTo(Stall o) {
		// TODO Auto-generated method stub
		if(this.priority < o.priority) return 1;
		else if(this.priority > o.priority) return -1;
		
		if(this.leftMostPos < o.leftMostPos) return -1;
		else return 1;
	}
	
	
}

public class Solution4 {

	public static void main(String[] args) throws IOException {
		int[][] inputs = readInput();
		for(int i=0; i<inputs.length; i++) {
			int[] priority = minimax(inputs[i]);
			System.out.println("Case #"+(i+1)+": "+Math.max(priority[0], priority[1])+" "+Math.min(priority[0], priority[1]));
		}
	}
	
	public static int[] minimax(int[] input) {
		int[] minimax = new int[2];
		int stalls = input[0]+2;
		int people = input[1];
		
		int[] stallStatus = new int[stalls];
		
		Stall stall = new Stall();
		stall.leftMostPos = 0;
		stall.rightMostPos = stallStatus.length-1;
		stall.curPos = (stall.rightMostPos + stall.leftMostPos)/2;
		stall.priority = Integer.MAX_VALUE;
		
		
		PriorityQueue<Stall> pQueue = new PriorityQueue<Stall>();
		pQueue.add(stall);
		for(int i=0; i<people; i++) {
			stall = pQueue.poll();
			Stall leftStall = new Stall();
			leftStall.leftMostPos = stall.leftMostPos;
			leftStall.rightMostPos = stall.curPos;
			leftStall.priority = leftStall.rightMostPos - leftStall.leftMostPos - 1;
			leftStall.curPos = (leftStall.rightMostPos + leftStall.leftMostPos)/2;
			
			Stall rightStall = new Stall();
			rightStall.leftMostPos = stall.curPos;
			rightStall.rightMostPos = stall.rightMostPos;
			rightStall.priority = rightStall.rightMostPos - rightStall.leftMostPos - 1;
			rightStall.curPos = (rightStall.rightMostPos + rightStall.leftMostPos)/2;
			
			pQueue.add(leftStall);
			pQueue.add(rightStall);
			minimax[0] = leftStall.priority;
			minimax[1] = rightStall.priority;
		}
		
		return minimax;
	}
	
	public static int[][] readInput() throws IOException {
		int[][] inputs = null;
		BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(BR.readLine());	 
		
		inputs = new int[testCases][2];
		
		for(int i=0; i<testCases; i++) {
			String[] reader = BR.readLine().split("\\s");
			inputs[i][0] = Integer.parseInt(reader[0]);
			inputs[i][1] = Integer.parseInt(reader[1]);
		}
		return inputs;
	}
}

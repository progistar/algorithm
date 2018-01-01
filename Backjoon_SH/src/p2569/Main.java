package p2569;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) {
		System.out.println(bruteforce(readInput()));
	}
	
	//## Bruteforce Strategy
	//## BFS
	public static int bruteforce(int[] curStates) {
		LinkedList<Integer[]> queueStates = new LinkedList<Integer[]>();
		LinkedList<Integer> queueBurden = new LinkedList<Integer>();
		LinkedList<Boolean[][]> queueSwitch = new LinkedList<Boolean[][]>();
		
		Integer[] curState = new Integer[curStates.length];
		
		for(int i=0; i<curStates.length; i++) curState[i] = curStates[i];
		
		queueStates.add(curState);
		queueBurden.add(0);
		Boolean[][] memorization = new Boolean[1001][1001];
		for(int i=0; i<curState.length; i++) {
			for(int j=0; j<curState.length; j++) {
				memorization[curState[i]][curState[j]] = false;
			}
		}
		queueSwitch.add(memorization);
		
		int minimumScore = Integer.MAX_VALUE;
		while(!queueStates.isEmpty()) {
			curState = queueStates.pollFirst();
			Integer curScore = queueBurden.pollFirst();
			memorization = queueSwitch.pollFirst();
			boolean isAns = true;
			for(int i=0; i<curState.length-1; i++) {
				if(curState[i] > curState[i+1]) isAns = false;
			}
			if(isAns) {
				minimumScore = Math.min(minimumScore, curScore);
				continue;
			}
				
			for(int i=0; i<curStates.length; i++) {
				for(int j=0; j<curStates.length; j++) {
					if(i==j) continue;
					if(memorization[curState[i]][curState[j]]) continue;
					if(minimumScore <= curScore + curState[i] + curState[j]) continue;
					Integer[] newState = curState.clone();
					newState[j] = curState[i];
					newState[i] = curState[j];
					Boolean[][] newMemorization = new Boolean[1001][1001];
					for(int n=0; n<curState.length; n++) {
						for(int m=0; m<curState.length; m++) {
							if(memorization[curState[n]][curState[m]]) newMemorization[curState[n]][curState[m]] = true;
							else newMemorization[curState[n]][curState[m]] = false;
						}
					}
					newMemorization[curState[i]][curState[j]] = true;
					queueBurden.add(curScore + curState[i] + curState[j]);
					queueStates.add(newState);
					queueSwitch.add(newMemorization);
				}
			}
		}
		
		return minimumScore;
	}
	
	public static int[] readInput() {
		int[] inputs = null;
		
		Scanner scan = new Scanner(System.in);
		
		int sizeOfInputs = scan.nextInt();
		
		inputs = new int[sizeOfInputs];
		
		for(int i=0; i<sizeOfInputs; i++) inputs[i] = scan.nextInt();
		scan.close();
		
		return inputs;
	}
}

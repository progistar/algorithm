package p10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(BR.readLine());
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		LinkedList<Integer> history = new LinkedList<Integer>();
		for(int i=0; i<n; i++) {
			String[] option = BR.readLine().split("\\s");
			int opLen = option.length;
			
			if(opLen == 1) {
				if(option[0].equalsIgnoreCase("front")) {
					if(queue.size() == 0) {
						history.addLast(-1);
					}else {
						history.addLast(queue.getFirst());
					}
				} else if(option[0].equalsIgnoreCase("size")) {
					history.addLast(queue.size());
				} else if(option[0].equalsIgnoreCase("empty")) {
					history.addLast(queue.size() == 0 ? 1 : 0);
				} else if(option[0].equalsIgnoreCase("pop")) {
					if(queue.size() == 0) {
						history.addLast(-1);
					}else {
						history.addLast(queue.pollFirst());
					}
				}else if(option[0].equalsIgnoreCase("back")) {
					if(queue.size() == 0) {
						history.addLast(-1);
					}else {
						history.addLast(queue.getLast());
					}
				}
			}else {
				queue.addLast(Integer.parseInt(option[1]));
			}
			
		}
		
		while(!history.isEmpty()) {
			System.out.println(history.pop());
		}
		
		BR.close();
		
	}
	
}

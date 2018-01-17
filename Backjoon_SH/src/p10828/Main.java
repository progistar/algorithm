package p10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(BR.readLine());
		
		LinkedList<Integer> stack = new LinkedList<Integer>();
		LinkedList<Integer> history = new LinkedList<Integer>();
		for(int i=0; i<n; i++) {
			String[] option = BR.readLine().split("\\s");
			int opLen = option.length;
			
			if(opLen == 1) {
				if(option[0].equalsIgnoreCase("top")) {
					if(stack.size() == 0) {
						history.addLast(-1);
					}else {
						history.addLast(stack.getLast());
					}
				} else if(option[0].equalsIgnoreCase("size")) {
					history.addLast(stack.size());
				} else if(option[0].equalsIgnoreCase("empty")) {
					history.addLast(stack.size() == 0 ? 1 : 0);
				} else if(option[0].equalsIgnoreCase("pop")) {
					if(stack.size() == 0) {
						history.addLast(-1);
					}else {
						history.addLast(stack.pollLast());
					}
				}
			}else {
				stack.addLast(Integer.parseInt(option[1]));
			}
			
		}
		
		while(!history.isEmpty()) {
			System.out.println(history.pop());
		}
		
		BR.close();
		
	}
	
}

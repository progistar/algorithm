package p1152;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
		String[] wordSet = BR.readLine().split("\\s");
		
		int wordCnt = 0;
		for(int i=0; i<wordSet.length; i++) if(wordSet[i].length() != 0) wordCnt++;
		
		System.out.println(wordCnt);
		
		BR.close();
	}
}

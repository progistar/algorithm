package idOCR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OCR {

	public static String[] dictionary = null;
	public static int[][] testCase = null;
	
	public static void main(String[] args) throws IOException{
		readInput();
	}
	
	
	public static double[][][] readInput() throws IOException{
		double[][][] matrix = null;
		
		BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
		
		String line = BR.readLine();
		String[] parser = line.split("\\s");
		
		int words = Integer.parseInt(parser[0]);
		int cases = Integer.parseInt(parser[1]);
		
		parser = BR.readLine().split("\\s");
		dictionary = new String[words];
		for(int i=0; i<words; i++)	dictionary[i] = parser[i];
		
		matrix = new double[3][][];
		matrix[0] = new double[1][words];
		parser = BR.readLine().split("\\s");
		for(int i=0; i<words; i++)	matrix[0][0][i] = Double.parseDouble(parser[i]);
		
		matrix[1] = new double[words][words];
		// transitional matrix
		for(int i=0; i<words; i++){
			parser = BR.readLine().split("\\s");
			for(int j=0; j<words; j++)	matrix[1][i][j] = Double.parseDouble(parser[j]);
		}
		
		matrix[2] = new double[words][words];
		// similar matrix
		for(int i=0; i<words; i++){
			parser = BR.readLine().split("\\s");
			for(int j=0; j<words; j++)	matrix[2][i][j] = Double.parseDouble(parser[j]);
		}
		
		// cases
		testCase = new int[cases][];
		for(int i=0; i<cases; i++){
			parser = BR.readLine().split("\\s");
			testCase[i] = new int[Integer.parseInt(parser[0])];
			for(int j=0; j<words; j++){
				for(int k=0; k<testCase[i].length; k++){
					if(dictionary[j].equalsIgnoreCase(parser[k])) testCase[i][k] = j;
				}
			}
		}
		
		
		BR.close();
		return matrix;
	}
}

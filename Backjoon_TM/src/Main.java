import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	char[][] board;
	int N = 8;
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = 8;
			
			boolean isWhiteFirst = true;
			int count = 0;
			for(int i=0;i<N;i++) {
				char[] line = br.readLine().toCharArray();
				int flag = 1;
				if(isWhiteFirst) flag = 0;  
				for(int j = 0;j<line.length;j++) {
					if(j % 2 != flag) continue;
					if(line[j] == 'F') count++;
				}
				isWhiteFirst = !isWhiteFirst;
			}
			System.out.println(count);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

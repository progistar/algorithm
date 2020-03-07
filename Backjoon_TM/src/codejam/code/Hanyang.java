package codejam.code;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Hanyang {
	int N;
	int[] isHomework, score, duration;
	void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			N = Integer.parseInt(br.readLine());
			isHomework = new int[N];
			score = new int[N];
			duration = new int[N];
			
			for (int i=0; i<N; i++) {
				String[] splitLine = br.readLine().split("\\s");
				int homework = Integer.parseInt(splitLine[0]);
				isHomework[i] = homework;
				if (homework == 0) continue;
				
				score[i] = Integer.parseInt(splitLine[1]);
				duration[i] = Integer.parseInt(splitLine[2]);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	int solve () {
		LinkedList<Integer> list = new LinkedList<>();
		int totalScore = 0;
		
		if (N == 1) {
			totalScore = (isHomework[0] == 0) ? 0 : duration[0] > 1 ? 0: score[0];
			return totalScore;
		}
		
		
		for (int i=0; i<N; i++) {
			if (isHomework[i] == 1) {
				list.addFirst(i);
				duration[i]--;
				
				if (duration[i] == 0) {
					totalScore += score[i];
					list.removeFirst();
				}
				
			} else {
				if (list.size() == 0) continue;
				int index = list.get(0);
				duration[index] --;
				if (duration[index] == 0) {
					totalScore += score[index];
					list.removeFirst();
				}
			}
		}
		
		
		return totalScore;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hanyang s = new Hanyang();
		s.input();
		int ans = s.solve();
		System.out.println(ans);
	}

}

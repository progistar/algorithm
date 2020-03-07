package codejam.code;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LG5 {

	public static void main(String[] args) {
		int processCount = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());
			String[] line = br.readLine().split("\\s");
			LinkedList<Integer> list = new LinkedList<Integer>();
			List<Integer> sortedList = new ArrayList<Integer>();
			for(int i=0;i<N;i++) {
				int item = Integer.parseInt(line[i]);
				list.add(item);
				sortedList.add(item);
			}
			Collections.sort(sortedList);
			Collections.reverse(sortedList);
			int index = -1;
			boolean isLeft = false;
			while(!list.isEmpty()) {
				
				
				
				int findNumber = sortedList.remove(sortedList.size() -1);
				int nextNumber = -1;
				if(sortedList.size() != 0) {
					nextNumber = sortedList.get(sortedList.size() -1);
				}
				if(index != -1) {
					if(isLeft) {
						isLeft = false;
						for(int i=0;i<=index;i++) {
							int item = list.get(i);
							if(item == nextNumber) {
								isLeft = true;
							}
							else if(item == findNumber) {
								list.remove(i);
								processCount += (index-i)+1;
								if(isLeft) {
									index = i-1;
								}else {
									index = i;
								}
								break;
							}
						}
					}else {
						isLeft = true;
						for(int i=list.size()-1;i>=index;i--) {
							int item = list.get(i);
							if(item == nextNumber) {
								isLeft = false;
							}
							else if(item == findNumber) {
								list.remove(i);
								processCount += (i-index)+1;
								if(isLeft) {
									index = i-1;
								}else {
									index = i;
								}
								break;
							}
						}
					}
				}
				else{
					for(int i=0;i<list.size();i++) {
						int item = list.get(i);
						if(item == nextNumber) {
							isLeft = true;
						}
						else if(item == findNumber) {
							list.remove(i);
							processCount = i+1;
							if(isLeft) {
								index = i-1;
							}else {
								index = i;
							}
							break;
						}
					}
				}
				
				
			}
			System.out.println(processCount);
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

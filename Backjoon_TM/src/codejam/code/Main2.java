package codejam.code;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main2 {
	char[][] board;
	int N = 8;
	String[] tttt = {"2","3"};
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		Set<List<Integer>> set = new HashSet<>();
		list.add(1);
		list.add(2);
		list2.add(1); list2.add(2);
		System.out.println(list.toString());
		set.add(list);
		
		
		if (set.contains(list2)) {
			set.add(list2);
		}
		
		for (List<Integer> item : set) {
			System.out.println(item.toString());
		}
		
		String s = "[15.82, 15.870000000000001, 15.92, 16.32, 16.32, 16.32, 16.32, 17.05, 17.05, 17.05, 17.05, 18.29, 18.29, 19.16]";
		List<String> listK = Arrays.asList(s.substring(1, s.length() - 1).split(", "));
		System.out.println(listK.toString());
		
		int[] test= {0,0,0};
		int index = Arrays.binarySearch(test, 0);
		System.out.println(index);
		
		
	}

}

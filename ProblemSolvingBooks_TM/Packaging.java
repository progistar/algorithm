import java.util.Scanner;
import java.util.StringTokenizer;

public class Packaging {
	
	int w;
	int num;
	String[] item;
	int[] volume;
	int[] priority;
	
	int max=0;
	String itemList;
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		w = sc.nextInt();
		item = new String[num];
		volume = new int[num];
		priority = new int[num];
		sc.nextLine();
		
		for(int i=0;i<num;i++) {
			String line = sc.nextLine();
			StringTokenizer st = new StringTokenizer(line, " ");
			item[i] = st.nextToken();
			volume[i] = Integer.parseInt(st.nextToken());
			priority[i] = Integer.parseInt(st.nextToken());
		}
		sc.close();
	}
	
	public void solve(int pos, int pSum, int vSum, String list) {

		if(pos>=num) {
			return;
		}
		
		int vol = volume[pos];
		int pri = priority[pos];
		
		if(vSum> w) {
			//System.out.println("max : "+ (pSum+pri));
			//System.out.println("list : "+ list+pos);
			return;
		}
		
		if(pSum > max) {
			max = pSum;
			itemList = list;
		}		
		
		solve(pos+1, pSum+pri, vSum+vol, list+pos);
		solve(pos+1, pSum, vSum, list);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Packaging p = new Packaging();
		p.input();
		p.solve(0, 0, 0, "");
		char[] itemIndex = p.itemList.toCharArray();
		int theNumberOfItems = itemIndex.length;
		System.out.println(p.max+" "+theNumberOfItems);
		
		for(int i=0;i<theNumberOfItems;i++) {
			//System.out.println(itemIndex[i]);
			int index = itemIndex[i] - 48;
			System.out.println(p.item[index]);
		}
	}

}

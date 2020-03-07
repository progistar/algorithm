package codejam.code;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution m = new Solution();
		int[] nums = {2,3,1};
		m.nextPermutation(nums);
		for (int i=0; i<nums.length; i++) {
			System.out.println(nums[i]+" ");
		}
	}
	
	public void nextPermutation(int[] nums) {
        int length = nums.length;
        if (length <= 1) return;
        
        int index = -1;
        for (int i=0; i<length-1; i++) {
            if (nums[i] < nums[i+1]) {
                index = i;
            }
        }
        System.out.println("index : "+index);
        if (index == -1) {
            reverse(nums, 0, nums.length-1);
        } else {
            int i = index;
            int j = length - 1;
            while (nums[j] < nums[i]) j--;
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            System.out.println("i:"+i+", j:"+j);
            reverse(nums, i+1, length-1);
        }
        
    }
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start ++;
            end--;
        }
        for (int i=0; i<nums.length; i++) {
			System.out.println("aaa   "+ nums[i]+" ");
		}
    }

}

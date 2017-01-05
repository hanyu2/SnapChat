
public class PickNum {
	public static int maxSum(int[] nums, int start, int end){
		if(start > end){
			return 0;
		}
		int s = nums[start];
		int e = nums[end];
		int sum1 = bPick(nums, start + 1, end) + s;
		int sum2 = bPick(nums, start, end - 1) + e;
		return Math.max(sum1, sum2);
	}

	private static int bPick(int[] nums, int start, int end) {
		if(start > end){
			return 0;
		}
		int s = nums[start];
		int e = nums[end];
		if(s > e){
			return maxSum(nums, start + 1, end);
		}else{
			return maxSum(nums, start, end - 1);
		}
	}
	public static void main(String[] args) {
		int[] nums = {1, 3, 7, 2, 6};
		System.out.println(maxSum(nums, 0, nums.length - 1));
	}
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwentyFour {

	public static void main(String[] args) {
		TwentyFour tf = new TwentyFour();
		int[] arr = { 1, 50, 3, 6, 7 };
		System.out.println(tf.canGetTwentyFour(arr, 60));
	}

	public boolean canGetTwentyFour(int[] arr, int target) {
		if (arr == null || arr.length == 0) {
			return false;
		}
		Arrays.sort(arr);
		boolean[] visited = new boolean[arr.length];
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		getPermutation(lists, new ArrayList<Integer>(), arr, visited);

		for (List<Integer> candidate : lists) {
			List<Integer> list = helper(candidate, target, 0, arr.length - 1);
			for (int i : list) {
				if (i == target) {
					return true;
				}
			}
		}
		return false;
	}

	private void getPermutation(List<List<Integer>> lists, ArrayList<Integer> list, int[] arr, boolean[] visited) {
		if (list.size() == arr.length) {
			lists.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (visited[i] || i > 0 && arr[i] == arr[i - 1] && !visited[i - 1]) {
				continue;
			}
			visited[i] = true;
			list.add(arr[i]);
			getPermutation(lists, list, arr, visited);
			list.remove(list.size() - 1);
			visited[i] = false;
		}
	}

	private List<Integer> helper(List<Integer> arr, int target, int start, int end) {
		List<Integer> res = new ArrayList<Integer>();
		if (start > end) {
			return res;
		}
		if (start == end) {
			res.add(arr.get(start));
			return res;
		}
		for (int i = start; i < end; i++) {
			List<Integer> left = helper(arr, target, start, i);
			List<Integer> right = helper(arr, target, i + 1, end);
			for (int l : left) {
				for (int r : right) {
					res.add((l + r));
					res.add((l * r));
					if (r != 0) {
						res.add((l / r));
					}
					res.add((l - r));
				}
			}
		}
		return res;
	}
}

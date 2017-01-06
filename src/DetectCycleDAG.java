import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetectCycleDAG {
	public static boolean hasCycle(Map<Integer, List<Integer>> map){
		boolean[] visited = new boolean[map.size()];
		for(int i : map.keySet()){
			if(check(i, visited, map)){
				return true;
			}
		}
		return false;
	}
	
	public static boolean check(int index, boolean[] visited, Map<Integer, List<Integer>> map){
		visited[index] = true;
		for(int nei : map.get(index)){
			if(visited[nei]){
				return true;
			}else{
				if(check(nei, visited, map)){
					return true;
				}
			}
		}
		visited[index] = false;
		return false;
	}
	public static void main(String[] args) {
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		map.put(0, new ArrayList<Integer>(Arrays.asList(1, 2)));
		map.put(1, new ArrayList<Integer>(Arrays.asList(3, 4)));
		map.put(2, new ArrayList<Integer>());
		map.put(3, new ArrayList<Integer>(Arrays.asList(5)));
		map.put(4, new ArrayList<Integer>());
		map.put(5, new ArrayList<Integer>(Arrays.asList(1)));
		System.out.println(hasCycle(map));
	}
}



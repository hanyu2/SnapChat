import java.util.HashMap;
import java.util.Map;

public class SubstringAnagram {
	public static boolean checkAnagram(String sourceString, String pattern){
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(char c : pattern.toCharArray()){
			if(map.containsKey(c)){
				map.put(c, map.get(c) + 1);
			}else{
				map.put(c, 1);
			}
		}
		int start = 0;
		for(int i = 0; i < sourceString.length(); i++){
			char c = sourceString.charAt(i);
			if(!map.containsKey(c)){
				for(int t = start; t < i; t++){
					map.put(sourceString.charAt(t), map.get(sourceString.charAt(t)) + 1);
				}
				start = i + 1;
				continue;
			}else{
				map.put(c, map.get(c) - 1);
				if(i - start + 1 == pattern.length()){
					return true;
				}
				while(map.get(c) < 0){
					char st = sourceString.charAt(start);
					map.put(st, map.get(st) + 1);
					start++;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		System.out.println(checkAnagram("badagdogg", "gda"));
	}
}

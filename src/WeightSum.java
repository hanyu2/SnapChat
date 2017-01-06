import java.util.HashMap;
import java.util.Map;

public class WeightSum {
	public static int sum(String s){
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int level = 0;
		int num = 0;
		int res = 0;
		s = s.replace(" ", "");
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(c == ','){
				map.put(level, num + map.get(level));
				num = 0;
				continue;
			}else if(c == '['){
				level++;
				if(!map.containsKey(level)){
					map.put(level, 0);
				}
			}else if(c == ']'){
				res += (num + map.get(level)) * level;
				map.put(level, 0);
				num = 0;
				level--;
			}else if(Character.isDigit(c)){
				num = num * 10 + (int)(c - '0');
			}
		}
		return res;
	}
	public static void main(String[] args) {
		System.out.println(sum("[1,[2, 3],[[4]][1,[1]]]"));
	}
}

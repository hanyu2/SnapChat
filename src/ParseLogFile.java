import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ParseLogFile {
	static int end = 0;
	static Stack<Job> stack = new Stack<Job>();
	static Map<String, List<TimeInterval>> map = new HashMap<String, List<TimeInterval>>();
	static List<String> jobNames = new ArrayList<String>();
	public static void parse(String function_name, String start_or_end, int timestamp){
		if(!map.containsKey(function_name)){
			map.put(function_name, new ArrayList<TimeInterval>());
			jobNames.add(function_name);
		}
		if(stack.isEmpty()){
			Job job = new Job(function_name);
			job.start = timestamp;
			stack.push(job);
			end = timestamp;
		}else{
			if(start_or_end.equals("start")){
				if(!stack.peek().name.equals(function_name)){
					Job last = stack.peek();
					last.end = timestamp;
					map.get(last.name).add(new TimeInterval(last.start, last.end));
					stack.push(new Job(function_name));
					stack.peek().start = timestamp;
				}
			}else{
				if(stack.peek().name.equals(function_name)){
					Job j = stack.pop();
					if(j.end == -1){
						map.get(j.name).add(new TimeInterval(j.start, timestamp));
					}else{
						map.get(function_name).add(new TimeInterval(end, timestamp));
					}
				}
				end = timestamp;
			}
		}
	}
	
	public static void print(){
		for(String jobName : jobNames){
			System.out.print(jobName + " : ");
			for(TimeInterval in : map.get(jobName)){
				System.out.print(in.toString());
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
//		parse("f1", "start", 1);
//		parse("f2", "start", 3);
//		parse("f2", "end", 5);
//		parse("f1", "end", 7);
//		parse("f3", "start", 9);
//		parse("f3", "end", 10);
//		print();
		
		parse("f1", "start", 1);
		parse("f1", "start", 2);
		parse("f2", "start", 4);
		parse("f2", "end", 8);
		parse("f1", "end", 16);
		parse("f1", "end", 32);
		parse("f3", "start", 64);
		parse("f3", "end", 128);
		print();
	}
}
class Job{
	String name;
	int start = -1;
	int end = -1;
	public Job(String name){
		this.name = name;
	}
}
class TimeInterval{
	int start;
	int end;
	public TimeInterval(int start, int end) {
		this.start = start;
		this.end = end;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[" + this.start + "," + this.end + "]";
	}
}

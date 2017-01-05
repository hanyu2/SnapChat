import java.util.ArrayList;

public class PickNumber {
	private static boolean helper(ArrayList<Integer> numList, int target) {
		/* empty list, return false */
		if (numList.size() == 0) {
			return false;
		}
		boolean opRes = true; // results of opponent
		for (int i = 0; i < numList.size(); i++) {
			int num = numList.get(i);
			if (num >= target) {
				/* pick this number, I will win */
				return true;
			}
			numList.remove(i); // I pick this one
			if (!helper(numList, target - num)) {
				/* my opponent cannot win */
				opRes = false;
			}
			numList.add(i, num); // I don't pick this one since my opponent will
									// always win, add it back
		}
		return !opRes; // if among these numbers picking one of them will let my
						// opponent lose, then I will win
	}
	/*
	map<pair<set<int>,int>,bool > state;

	bool canWin(set<int>& input, int target) {
	  if (state.find(make_pair(input, target)) != state.end()) {
	    return state[make_pair(input,target)];
	  }
	  if (*input.rbegin() >= target) {
	    state[make_pair(input,target)] = true;
	    return true;
	  }
	  int size = input.size(); 
	  for (int index = 0; index < size; index++) {
	    auto it = input.begin();
	    advance(it, index);
	    auto i = *it;
	    input.erase(input.find(i));
	    if (!canWin(input, target - i)) {
	      state[make_pair(input,target)] = true;
	      input.insert(i);
	      return true;
	    }
	    input.insert(i);
	  }
	  state[make_pair(input,target)] = false;
	  return false;
	}

	int main() {
	  set<int> s;
	  for (int i = 1; i <= 15; i++) {
	    s.insert(i);
	  }
	  cout << canWin(s, 50);
	  return 0;
	}*/
}

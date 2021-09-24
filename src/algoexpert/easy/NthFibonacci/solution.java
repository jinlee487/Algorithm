package algoexpert.easy.NthFibonacci;

import java.util.*;

class solution {
  public static int getNthFib(int n) {
    // Write your code here.
		// O(2^n) time | O(n) space
		if(n==1) return 0;
		if(n==2) return 1;		
    return getNthFib(n-1) + getNthFib(n-2);
  }
}
class solution2 {
  public static int getNthFib(int n) {
    // Write your code here.
		// O(n) time | O(n) space
		Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
		hash.put(1,0);
		hash.put(2,1);
    return getNthFib(n, hash);
  }
	public static int getNthFib(int n, Map<Integer, Integer> memoize) {
		if(memoize.containsKey(n)) {
			return memoize.get(n);
		} 
		memoize.put(n,getNthFib(n-1,memoize) + getNthFib(n-2, memoize));
		return memoize.get(n);
	}
}
class solution3 {
  public static int getNthFib(int n) {
    // Write your code here.
		// O(n) time | O(1) space
		int [] lastTwo = {0,1};
		int counter = 3;
		while(counter <= n) {
			int nextFib = lastTwo[0] + lastTwo[1];
			lastTwo[0] = lastTwo[1];
			lastTwo[1] = nextFib;
			counter ++;
		}
		return n > 1 ? lastTwo[1] : lastTwo[0];
  }
}


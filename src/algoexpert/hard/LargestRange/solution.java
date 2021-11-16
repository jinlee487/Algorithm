package algoexpert.hard.LargestRange;

import java.util.*;

class Program {
  public static int[] largestRange(int[] array) {
    // Write your code here.
		HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
		for(int i=0;i<array.length;i++){
			hash.put(array[i],1);
		} 
		int[] answer = new int[2];
		int longestLength = 0;
		for( int num : array){
			if(hash.get(num)==0){
				continue;
			}
			hash.put(num,0);
			int currentLength = 1;
			int left = num -1;
			int right = num +1;
			while(hash.containsKey(left)) {
				hash.put(left,0);
				currentLength++;
				left --;
			}
			while(hash.containsKey(right)){
				hash.put(right,0);
				currentLength ++;
				right ++;
			}
			if(currentLength > longestLength) {
				longestLength = currentLength;
				answer = new int[] {left + 1, right -1};
			}
		}
		return answer;
  }

}

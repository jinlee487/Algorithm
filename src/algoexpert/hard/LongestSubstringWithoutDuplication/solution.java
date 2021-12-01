package algoexpert.hard.LongestSubstringWithoutDuplication;
import java.util.*;

class Program {
  public static String longestSubstringWithoutDuplication(String str) {
   	//Write your code here.
		//)(n) time | O(min(n,a)) space minimum between n and a set of unique letters
		HashMap<Character,Integer> hash = new HashMap<Character,Integer>();
		int start=0;
		int[] answer = {0,1};
		for(int i=0;i<str.length();i++){
			if(hash.containsKey(str.charAt(i))){
				start = Math.max(hash.get(str.charAt(i))+1,start);
			}
			if(answer[1]-answer[0]<=i+1-start) {
					answer = new int[]{start,i+1};
			}
			hash.put(str.charAt(i),i);
		}
    return str.substring(answer[0],answer[1]);
  }
}

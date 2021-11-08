package algoexpert.medium.GroupAnagrams;

import java.util.*;

class Program {
  public static List<List<String>> groupAnagrams(List<String> words) {
    // Write your code here.
		Map<String,List<String>> anagrams = new HashMap<String,List<String>>();
		for (String word:words){
			char[] charArray = word.toCharArray();
			Arrays.sort(charArray);
			String sorted = new String(charArray);
			if(anagrams.containsKey(sorted)) anagrams.get(sorted).add(word);
			else anagrams.put(sorted,new ArrayList<String>(Arrays.asList(word)));
		}
    return new ArrayList<>(anagrams.values());
  }
}

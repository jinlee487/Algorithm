package algoexpert.medium.MinimumCharactersForWords;

import java.util.*;

class Program {

  public char[] minimumCharactersForWords(String[] words) {
    // Write your code here.
		// O(n*l) time | O(c) space
		// n is the number of words
		// l is hte length of the longest word, 
		// and c is the number of unique characters
		HashMap<Character,Integer> hash = new HashMap<Character,Integer>();
		for(String c : words){
			char[] letters = c.toCharArray();
			HashMap<Character,Integer> word = new HashMap<Character,Integer>();
			for(int i=0;i<letters.length;i++){
				if(word.containsKey(letters[i])) word.put(letters[i],word.get(letters[i])+1);
				else word.put(letters[i],1);
			}
			for (Map.Entry<Character, Integer> entry : word.entrySet()) {
				if(hash.containsKey(entry.getKey())) 
					hash.put(entry.getKey(),Math.max(hash.get(entry.getKey()),entry.getValue()));
				else hash.put(entry.getKey(),entry.getValue());
			}
		}
		int count = 0;
		for (Map.Entry<Character, Integer> entry : hash.entrySet()) {
			for(int i=0;i<entry.getValue();i++) count ++;
		}
		char[] answer = new char[count];
		count  = 0;
		for (Map.Entry<Character, Integer> entry : hash.entrySet()) {
			for(int i=0;i<entry.getValue();i++) answer[count++] = entry.getKey();
		}
    return answer;
  }
}

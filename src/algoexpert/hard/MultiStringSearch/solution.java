package algoexpert.hard.MultiStringSearch;
import java.util.*;

class Program {
  public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
    // Write your code here.
		// O(ns + bs) time | O(ns) space
		// longest time is the longest string and the length of the big string
		HashSet<String> set = new HashSet<String>();
		List<Boolean> answer = new ArrayList<Boolean>();
		Trie trieNode = new Trie();
		for(String word : smallStrings) trieNode.add(word);
		for(int i=0;i<bigString.length();i++) dfs(i, bigString, trieNode, set);
		for(String s : smallStrings) answer.add(set.contains(s));
    return answer;
  }
	public static void dfs(int index, String bigString, Trie trieNode, HashSet<String> set){
		if(trieNode.children.containsKey('*')) set.add(trieNode.word);
		if(index==bigString.length()) return;
		Character c = bigString.charAt(index);
		if(trieNode.children.containsKey(c)) dfs(index+1,bigString,trieNode.children.get(c),set);
		return;
	}
	public static class Trie{
		public HashMap<Character,Trie> children = new HashMap<Character,Trie>();
		public String word = "";
		public void add(String word){
			Trie trieNode = this;
			for(int i=0;i<word.length();i++){
				Character c = word.charAt(i);
				if(!trieNode.children.containsKey(c)) trieNode.children.put(c,new Trie());
				 trieNode = trieNode.children.get(c);
			}
			trieNode.children.put('*',null);
			trieNode.word = word;
			return;
		}	
	}
}

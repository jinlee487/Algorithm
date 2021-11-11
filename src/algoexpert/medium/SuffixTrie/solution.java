package algoexpert.medium.SuffixTrie;

import java.util.*;

class Program {
  // Do not edit the class below except for the
  // populateSuffixTrieFrom and contains methods.
  // Feel free to add new properties and methods
  // to the class.
  static class TrieNode {
    Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
  }

  static class SuffixTrie {
    TrieNode root = new TrieNode();
    char endSymbol = '*';

    public SuffixTrie(String str) {
      populateSuffixTrieFrom(str);
    }

    public void populateSuffixTrieFrom(String str) {
      // Write your code here. 
			// O(n^2) time | O(n^2) space
			for(int i=0;i<str.length();i++){
				TrieNode currentNode = root;
				for(int j=i;j<str.length();j++){
					char key = str.charAt(j);
					if(!currentNode.children.containsKey(key)) currentNode.children.put(key,new TrieNode());
					currentNode = currentNode.children.get(key);
				}
				currentNode.children.put(endSymbol,null);
			}
    }

    public boolean contains(String str) {
      // Write your code here.
			// O(m) time | O(1) space
			TrieNode currentNode = root;
			for(int i=0;i<str.length();i++){
				char letter = str.charAt(i);
				if(!currentNode.children.containsKey(letter)) return false;
				currentNode = currentNode.children.get(letter);
			}
      return currentNode.children.containsKey(endSymbol);
    }
  }
}

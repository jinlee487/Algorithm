package algoexpert.hard.BoggleBoard;
import java.util.*;

class Program {
  public static List<String> boggleBoard(char[][] board, String[] words) {
    // Write your code here.
		//O(nm*8^s + ws) time | O(nm+ws) space 
		// where s is the length of the longest string 
		// w is the count of the words given
		// n is the width of the board, 
		// m is the height of the board
		Trie trie = new Trie();
		for(String word : words) trie.add(word);
		Set<String> finalWords = new HashSet<String>();
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				dfs(i,j,board,trie.root, new boolean[board.length][board[0].length],finalWords);
			}
		}
		List<String> answer = new ArrayList<String>();
		answer.addAll(finalWords);
		return answer;
  }
	private static void dfs(int x, int y, char[][] board, TrieNode trieNode, boolean[][] visited, Set<String> finalWords){
		if(visited[x][y]) return;
		char letter = board[x][y];
		if(!trieNode.children.containsKey(letter)) return;
		visited[x][y] = true;
		trieNode = trieNode.children.get(letter);
		if(trieNode.children.containsKey('*')) finalWords.add(trieNode.word);
		int[] xarr = {-1, -1, -1, 0, 0, 1, 1, 1};
		int[] yarr = {-1, 0, 1, -1, 1, -1, 0, 1};
		for(int i=0;i<xarr.length;i++){
			int nx = xarr[i] + x;
			int ny = yarr[i] + y;
			if(check(nx,ny, board, visited)) dfs(nx,ny,board,trieNode,visited,finalWords);
		}
		visited[x][y] = false;
		return;
	}
	private static boolean check(int x,int y, char[][] board, boolean[][] visited){
		if(x<0 || board.length<= x) return false;
		if(y<0 || board[x].length <= y) return false;
		if(visited[x][y]) return false;
		return true;
	}
	private static class TrieNode {
		public HashMap<Character,TrieNode> children = new HashMap<Character, TrieNode>();
		public String word = "";
	}
	private static class Trie {
		public TrieNode root;
		public Character endSymbol;
		public Trie(){
			this.root = new TrieNode();
			this.endSymbol = '*';
		}
		public void add(String str){
			TrieNode node = this.root;
			for(int i=0;i<str.length();i++){
				char letter = str.charAt(i);
				if(!node.children.containsKey(letter)){
					node.children.put(letter,new TrieNode());
				}
				node = node.children.get(letter);
			}
			node.children.put(this.endSymbol,null);
			node.word = str;
		}
	}
}

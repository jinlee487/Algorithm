Boggle Board

For this problem, we have to use couple different data structure algorithms to solve the problem in optimal complexity. 

We first have to create a trie graph of the given words so that we can look up the letters in constant time.

We then traverse the board using a dfs algorithm. 

		//O(nm*8^s + ws) time | O(nm+ws) space 
		// where s is the length of the longest string 
		// w is the count of the words given
		// n is the width of the board, 
		// m is the height of the board
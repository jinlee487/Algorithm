function boggleBoard(board, words) {
    // Write your code here.
      const trieNode = new Trie();
      for(const word of words) trieNode.add(word);
      const answer = {};
      const visited = board.map(row => row.map(letter => false));
      for(let i=0;i<board.length;i++){
          for(let j=0;j<board[i].length;j++){
              dfs(i,j,board,trieNode.root,visited, answer);
          }
      }
      return Object.keys(answer);
  }
  function dfs(x,y,board,trieNode, visited, finalWords){
      if(visited[x][y]) return;
      const letter = board[x][y];
      if(!(letter in trieNode)) return;
      visited[x][y] = true;
      trieNode = trieNode[letter];
      if('*' in trieNode) finalWords[trieNode['*']] = true;
      const xarr = [-1,-1,-1,0,0,1,1,1];
      const yarr = [-1,0,1,-1,1,-1,0,1];
      for(let i=0;i<xarr.length;i++){
          const nx = xarr[i] + x;
          const ny = yarr[i] + y;
          if(check(nx,ny,board,visited)) dfs(nx,ny,board,trieNode,visited,finalWords);
      }
      visited[x][y] = false;
      return;	
  }
  function check(x,y,board,visited){
      if(x<0||board.length<=x) return false;
      if(y<0||board[x].length<=y) return false;
      if(visited[x][y]) return false;
      return true
  }
  class Trie{
      constructor(){
          this.root = {};
          this.endSymbol = '*';
      }
      add(word){
          let current = this.root;
          for(const letter of word){
              if(!(letter in current)) current[letter] = {};
              current = current[letter];
          }
          current[this.endSymbol] = word;
      }
  }
  
  // Do not edit the line below.
  exports.boggleBoard = boggleBoard;
  
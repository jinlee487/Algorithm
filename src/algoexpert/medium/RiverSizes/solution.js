function riverSizes(matrix) {
    // Write your code here.
      const answer = [];
      const visited = matrix.map(row => row.map(value=>false));
      for(let i=0;i<matrix.length;i++){
          for(let j=0;j<matrix[i].length;j++){
              if(!visited[i][j]&&matrix[i][j]==1){
                  answer.push(dfs(i,j,matrix,visited,1));
              }
          }
      }
      return answer;
  }
  function dfs(x,y,matrix,visited,count){
      visited[x][y] = true;
      const xarr = [0,0,1,-1];
      const yarr = [1,-1,0,0];
      for(let i=0;i<4;i++){
          const nx = x + xarr[i];
          const ny = y + yarr[i];		
          if(check(nx,ny,matrix,visited)){
              count = dfs(nx,ny,matrix,visited,count+1);
          }
      }
      return count;
  }
  function check(x,y,matrix,visited){
      if(x<0||x>=matrix.length) return false;
      if(y<0||y>=matrix[x].length) return false;
      if(visited[x][y]) return false;
      if(matrix[x][y]!=1) return false;
      return true;
  }
  
  function riverSizes(matrix) {
    // Write your code here.
      const answer = [];
      const visited = matrix.map(row => row.map(value=>false));
      for(let i=0;i<matrix.length;i++){
          for(let j=0;j<matrix[i].length;j++){
              if(!visited[i][j]) {
                  traverseNode(i,j,matrix,visited,answer);
              }
          }
      }
      return answer;
  }
  function traverseNode(i,j,matrix,visited,answer){
      let current = 0;
      const nodes = [[i,j]];
      while(nodes.length){
          const currentNode = nodes.pop();
          i = currentNode[0];
          j = currentNode[1];
          if(visited[i][j]) continue;
          visited[i][j] = true;
          if(matrix[i][j]===0) continue;
          current++;
          const neighbors = getNeighbors(i,j,matrix,visited);
          for(const neighbor of neighbors){
              nodes.push(neighbor);
          }
      }
      if(current > 0) answer.push(current);
      return;
  }
  function getNeighbors(i,j,matrix,visited){
      const neighbors=[];
      const iarr = [0,0,1,-1];
      const jarr = [1,-1,0,0];
      for(let k=0;k<4;k++){
          const ni = i + iarr[k];
          const nj = j + jarr[k];
          if(ni<0||ni>=matrix.length||nj<0||nj>=matrix[ni].length){
              continue;
          }
          neighbors.push([ni,nj]);
      }
      return neighbors;
      
      
  }
  // Do not edit the line below.
  exports.riverSizes = riverSizes;
  
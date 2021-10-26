function removeIslands(matrix) {
    // Write your code here.
      const answer = [];
      for(let i=0;i<matrix.length;i++){
          answer.push([]);
          for(let j=0;j<matrix[0].length;j++){
              answer[i].push(0);
          }
      }
      for(let i=0;i<matrix.length;i++){
          for(let j=0;j<matrix[0].length;j++){
              if((0<i&&i<matrix.length-1)&&(0<j&&j<matrix[0].length-1)){
                  continue;
              }
              if(matrix[i][j]==1){
                  dfs(i,j,matrix,answer);
              }
          }
      }
      return answer;
  }
  function dfs(x,y,matrix,answer){
      matrix[x][y] = 0;
      answer[x][y] = 1;
      const xarr = [0,0,1,-1];
      const yarr = [1,-1,0,0];
      for(let i=0;i<4;i++){
          let nx = x + xarr[i];
          let ny = y + yarr[i];
          if(check(nx,ny,matrix)){
              dfs(nx,ny,matrix,answer);
          }
      }
      return;
  }
  function check(x,y,matrix){
      if(x<0||matrix.length<=x) return false;
      if(y<0||matrix[0].length<=y) return false;
      if(matrix[x][y]!=1) return false;
      return true;
  }
  
  // Do not edit the line below.
  exports.removeIslands = removeIslands;
  
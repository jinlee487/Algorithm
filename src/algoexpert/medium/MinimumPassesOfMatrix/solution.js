function minimumPassesOfMatrix(matrix) {
    // Write your code here.
      que = [];
      for(let i=0;i<matrix.length;i++){
          for(let j=0;j<matrix[0].length;j++){
              if(0<matrix[i][j]) que.push([i,j,0]);
          }
      }
      const count = bfs(matrix,que);
      for(let i=0;i<matrix.length;i++){
          for(let j=0;j<matrix[0].length;j++){
              if(matrix[i][j]<0) return -1;
          }
      }
      return count;
  }
  function bfs(matrix, que){
      const xarr = [0,0,-1,1];
      const yarr = [1,-1,0,0];
      let nx,ny,count=0;
      while(que.length > 0){
          const current = que.shift();
          count = Math.max(current[2],count);
          for(let i=0;i<4;i++){
              nx = xarr[i] + current[0];
              ny = yarr[i] + current[1];
              if(check(nx,ny,matrix)){
                  matrix[nx][ny] *= -1;
                  que.push([nx,ny,current[2]+1]);
              }
          }
      }
      return count;
  }
  function check(x,y,matrix){
      if(x<0||matrix.length<=x) return false;
      if(y<0||matrix[0].length<=y) return false;
      if(0<=matrix[x][y]) return false;
      return true;
  }
  // Do not edit the line below.
  exports.minimumPassesOfMatrix = minimumPassesOfMatrix;
  
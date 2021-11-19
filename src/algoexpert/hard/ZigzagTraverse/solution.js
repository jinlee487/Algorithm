function zigzagTraverse(array) {
    // Write your code here.
      const row = array.length-1;
      const column = array[0].length-1;
      let i = 0;
      let j = 0;
      const answer= [];
      answer.push(array[0][0]);
      while(i<=row && j <=column){
          if((i+j)%2==0){
              if(check(i+1,j-1,row,column)) answer.push(array[++i][--j]);
              else if(check(i+1,j,row,column)) answer.push(array[++i][j]);
              else if(check(i,j+1,row,column)) answer.push(array[i][++j]);
          } else {
              if(check(i-1,j+1,row,column)) answer.push(array[--i][++j]);
              else if(check(i,j+1,row,column)) answer.push(array[i][++j]);
              else if(check(i+1,j,row,column)) answer.push(array[++i][j]);
          }
          if(i==row && j==column) break;
      }
      return answer;
  }
  function check(i,j,row,column){
      if(i<0 || row<i) return false;
      if(j<0 || column<j) return false;
      return true;
      
  }
  
  // Do not edit the line below.
  exports.zigzagTraverse = zigzagTraverse;
  
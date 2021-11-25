function solveSudoku(board) {
    // Write your code here.
    zero = [];
      for(let i=0;i<9;i++){
          for(let j=0;j<9;j++){
              if(board[i][j]===0) zero.push([i,j]);
          }
      }
      solveSudokuHelper(zero,board);
      return board;
  }
  function solveSudokuHelper(zero,board){
      if(zero.length===0) return true;
      const [x,y] = zero.pop();
      for(let i=1;i<10;i++){
          board[x][y] = i;
          if(check(x,y,board)) {
              if(solveSudokuHelper(zero,board)) return true;
          }
          board[x][y] = 0;
      }
      zero.push([x,y]);
      return false;
  }
  function check(x,y,board){
      const n = board[x][y];
      for(let i=0;i<9;i++){
          if(i===y) continue;
          if(board[x][i]===n) return false;
      }
      for(let i=0;i<9;i++){
          if(i===x) continue;
          if(board[i][y]===n) return false;
      }
      const nx = Math.floor(x/3) *3;
      const ny = Math.floor(y/3) *3;
      for(let i=0;i<3;i++){
          for(let j=0;j<3;j++){
              if(nx+i === x && ny+j === y) continue;
              if(board[nx+i][ny+j] === n) return false;
          }
      }
      return true;
  }
  
  // Do not edit the line below.
  exports.solveSudoku = solveSudoku;
  
function tournamentWinner(competitions, results) {
    // Write your code here.
      let scores = {};
      let answer = "";
      scores[answer] = 0;
      for(let i=0;i<competitions.length;i++){
          let home = competitions[i][0];
          let away = competitions[i][1];
          let win = results[i]==1?home:away;
          if(win in scores){
              scores[win] = scores[win] + 3;
          } else {
              scores[win] = 3;
          }
          if(scores[answer]<scores[win]){
              answer = win;
          }
      }
    return answer;
  }
  
  // Do not edit the line below.
  exports.tournamentWinner = tournamentWinner;
  
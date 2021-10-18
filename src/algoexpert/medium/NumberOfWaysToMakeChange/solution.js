function numberOfWaysToMakeChange(n, denoms) {
    // Write your code here.
      const answer = new Array(n+1).fill(0);
      answer[0] = 1;
      for(let i=0;i<denoms.length;i++){
          for(let j=1;j<=n+1;j++){
              if(denoms[i]<=j){
                  answer[j] += answer[j-denoms[i]];
              }
          }
      }
      return answer[n];
  }
  
  // Do not edit the line below.
  exports.numberOfWaysToMakeChange = numberOfWaysToMakeChange;
  
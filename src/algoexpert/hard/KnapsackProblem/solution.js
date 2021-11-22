function knapsackProblem(items, capacity) {
    // Write your code here.
      const dp = [];
      for(let i=0;i<items.length+1;i++){
          dp.push(new Array(capacity+1).fill(0));
      }
      for(let i=1;i<items.length+1;i++){
          const currentWeight = items[i-1][1];
          const currentValue = items[i-1][0];
          for(let c=0;c<capacity+1;c++){
              if(currentWeight>c) dp[i][c] = dp[i-1][c];
              else dp[i][c] = Math.max(dp[i-1][c],dp[i-1][c-currentWeight]+currentValue);
          }
      }
    // Replace return below.
    // return [
    //   10, // total value
    //   [1, 2], // item indices
    // ];
      return [dp[dp.length-1][dp[0].length-1], knapsackProblemHelper(dp,items)];
  }
  function knapsackProblemHelper(dp, items){
      const sequence = [];
      let i=dp.length-1;
      let c=dp[0].length-1;
      while(i>0){
          if(dp[i][c]===dp[i-1][c]) i-=1;
          else {
              sequence.unshift(i-1);
              c -= items[i-1][1];
              i-=1;
          }
          if(c===0) break;
      }
      return sequence;
  }
  // Do not edit the line below.
  exports.knapsackProblem = knapsackProblem;
  
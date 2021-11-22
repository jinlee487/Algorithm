function minNumberOfJumps(array) {
    // Write your code here.
      const dp = new Array(array.length).fill(Infinity);
      dp[0] = 0;
      for(let i=0;i<array.length;i++){
          for(let j=1;j<=array[i] && j+i<array.length;j++){
              dp[i+j] = Math.min(dp[i+j],dp[i]+1);
          }
      }
      return dp[dp.length-1];
  }
  function minNumberOfJumps(array) {
    // Write your code here.
      const dp = new Array(array.length).fill(Infinity);
      dp[0] = 0;
      for(let i=1;i<array.length;i++){
          for(let j=0;j<i;j++){
              if(array[j] >= i-j) dp[i] = Math.min(dp[j]+1,dp[i]);
          }
      }
      return dp[dp.length-1];
  }
  function minNumberOfJumps(array) {
    // Write your code here.
      if(array.length <=1) return 0;
      let dp = 0;
      let maxReach = array[0];
      let steps = array[0];
      for(let i=1;i<array.length-1;i++){
          maxReach = Math.max(maxReach,i+array[i]);
          steps--;
          if(steps === 0){
              dp++;
              steps = maxReach-i;
          }
      }
      return dp + 1;
  }
  
  // Do not edit the line below.
  exports.minNumberOfJumps = minNumberOfJumps;
  
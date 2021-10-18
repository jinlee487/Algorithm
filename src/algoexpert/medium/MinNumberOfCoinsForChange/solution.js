function minNumberOfCoinsForChange(n, denoms) {
    // Write your code here.
      const dp = new Array(n+1).fill(Infinity);
      dp[0] = 0;
      for(const denom of denoms){
          for(let i=0;i<dp.length;i++){
              if(i<denom) continue;
              dp[i] = Math.min(dp[i],dp[i-denom] + 1);
          }
      }
      return dp[n] === Infinity ? -1 : dp[n];
  }
  
  // Do not edit the line below.
  exports.minNumberOfCoinsForChange = minNumberOfCoinsForChange;
  
function nonConstructibleChange(coins) {
    // Write your code here.
      coins.sort((o1,o2) => o1-o2);
      let sum = 0; 
      for(let coin of coins){
          if(sum+1<coin){
              return sum+1;
          }
          sum += coin;
      }
    return sum+1;
  }
  
  // Do not edit the line below.
  exports.nonConstructibleChange = nonConstructibleChange;
  
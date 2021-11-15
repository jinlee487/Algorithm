function fourNumberSum(array, targetSum) {
    // Write your code here.
      const answer = [];
      for(let i=0;i<array.length;i++){
          for(let j=i+1;j<array.length;j++){
              for(let k=j+1;k<array.length;k++){
                  for(let l=k+1;l<array.length;l++){
                      if(array[i]+array[j]+array[k]+array[l]===targetSum)
                          answer.push([array[i],array[j],array[k],array[l]]);
                  }
              }
          }
      }
      return answer;
  }
  function fourNumberSum(array, targetSum) {
    // Write your code here.
      const obj = {};
      const answer = [];
      for(let i=1;i<array.length-1;i++){
          for(let j=i+1;j<array.length;j++){
              const key = array[i] + array[j];
              if((targetSum-key) in obj){
                  for(const pairs of obj[targetSum-key]){
                      answer.push([array[i],array[j],pairs[0],pairs[1]]);
                  }
              }
          }
          for(let j=0;j<i;j++){
              const key = array[i] + array[j];
              if(!(key in obj)) obj[key] = [];
              obj[key].push([array[i], array[j]]);
          }
      }
      return answer;
  }
  
  // Do not edit the line below.
  exports.fourNumberSum = fourNumberSum;
  
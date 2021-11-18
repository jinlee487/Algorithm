function minRewards(scores) {
    // Write your code here.
      const array = scores.map(_ => 1);
      for(let i=1;i<scores.length;i++){
          let j = i-1;
          if(scores[j] < scores[i]) array[i] = array[j]+1;
          else {
              while(0<=j && scores[j] > scores[j+1]){
                  array[j] = Math.max(array[j],array[j+1]+1);
                  j--
              }
          }
      }
      return array.reduce((a,b) => a+b);
  }
  
  function minRewards(scores) {
    // Write your code here.
      const array = scores.map(_ => 1);
      const minarray = [];
      for(let i=0;i<scores.length;i++){
          if(scores.length==1){
              minarray.push(i);
              break;
          }
          if(0==i && scores[i]<scores[i+1]) minarray.push(i);
          else if(i==scores.length-1 && scores[i] < scores[i-1]) minarray.push(i);
          else if(0<i && i < scores.length-1 && scores[i] < scores[i-1] && scores[i]<scores[i+1]) {
              minarray.push(i);
          } 
      }
      for(const index of minarray){
          let left = index -1;
          let right = index +1;
          while(0<=left && scores[left+1] < scores[left]) {
              array[left] = Math.max(array[left],array[left+1]+1);
              left--;
          }
          while(right<=scores.length-1 && scores[right-1] < scores[right]) {
              array[right] = Math.max(array[right],array[right-1]+1);
              right++;
          }
      }	
      return array.reduce((a,b) => a+b);
  }
  function minRewards(scores) {
    // Write your code here.
      const arr = scores.map(_ => 1);
      for(let i=1;i<scores.length;i++){
          if(scores[i-1] < scores[i]) arr[i] = arr[i-1] + 1;
      }
      for(let i=scores.length-2;0<=i;i--){
          if(scores[i+1] < scores[i]) arr[i] = Math.max(arr[i+1] + 1,arr[i]);
      }
      return arr.reduce((a,b) => a+b);
  }
  
  // Do not edit the line below.
  exports.minRewards = minRewards;
  
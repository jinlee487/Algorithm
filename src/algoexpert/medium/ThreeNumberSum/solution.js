function threeNumberSum(array, targetSum) {
    // Write your code here.
      array.sort((o1,o2) => o1-o2);
      list = [];
      for(let i=0;i<array.length;i++){
          let left = i+1;
          let right = array.length-1;
          const target = targetSum - array[i];
          while(left < right){
              const current = array[left] + array[right];
              if(target === current){
                  list.push([array[i],array[left],array[right]]);
                  left ++;
                  right --;
              } else if (target < current){
                  right--;
              } else if (target > current){
                  left++;
              }
          }
      }
      return list;
      
  }
  
  // Do not edit the line below.
  exports.threeNumberSum = threeNumberSum;
  
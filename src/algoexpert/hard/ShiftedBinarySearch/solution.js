function shiftedBinarySearch(array, target) {
    // Write your code here.
      let left = 0;
      let v = Infinity;
      for(let i=0;i<array.length;i++){
          if(array[i]<v){
              v=array[i];
              left = i;
          }
      }
      let right = left + array.length -1;
      while(left<=right){
          const middle = Math.floor((right+left)/2);
          const adjusted = check(middle,array.length);
          if(array[adjusted] === target) return adjusted;
          if(target < array[adjusted]){
              right = middle -1;
          } else {
              left = middle +1;
          }
      }
      return -1;
  }
  function check(index, arrayLength){
      if(arrayLength<=index) return index - arrayLength;
      else return index;
  }
  function shiftedBinarySearch(array, target) {
    // Write your code here.
      return shiftedBinarySearchHelper(array,target,0,array.length-1);
  }
  function shiftedBinarySearchHelper(array,target,left,right){
      if(left>right) return -1;
      const middle = Math.floor((left+right)/2);
      if(target === array[middle]) return middle;
      else if(array[left] <= array[middle]){
          if(array[left] <= target && target <= array[middle]){
              return shiftedBinarySearchHelper(array,target,left,middle-1);
          } else {
              return shiftedBinarySearchHelper(array,target,middle+1,right);
          }
      } else {
          if(array[middle] < target && target <= array[right]){
              return shiftedBinarySearchHelper(array,target,middle+1,right);
          } else {
              return shiftedBinarySearchHelper(array,target,left,middle-1);
          }
      }
  }
  function shiftedBinarySearch(array, target) {
    // Write your code here.
      let left = 0;
      let right = array.length-1;
      while(left<=right){
          const middle = Math.floor((left+right)/2);
          if(target === array[middle]) {
              return middle;
          }
          if(array[left] <= array[middle]){
              if(array[left] <= target && target < array[middle]){
                  right = middle -1;
              } else {
                  left = middle +1;
              }
          } else {
              if(array[middle] < target && target <= array[right]){
                  left = middle +1;
              } else {
                  right = middle -1;
              }
          }
      }
      return -1;
  }
  
  // Do not edit the line below.
  exports.shiftedBinarySearch = shiftedBinarySearch;
  
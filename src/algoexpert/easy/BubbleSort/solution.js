function bubbleSort(array) {
    // Write your code here.
      if(array.length < 2) return array;
      let sorted = false;
      let l = array.length;
      while(!sorted) {
          sorted = true;
          for(let i=1, temp;i<l;i++){
              if(array[i]<array[i-1]){
                  temp = array[i];
                  array[i] = array[i-1];
                  array[i-1] = temp;
                  sorted = false;
              }
          }
          l--;
      }
      return array;
  }
  
  // Do not edit the line below.
  exports.bubbleSort = bubbleSort;
  
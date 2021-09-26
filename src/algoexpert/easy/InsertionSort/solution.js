function insertionSort(array) {
    // Write your code here.
      for(let i=0;i<array.length;i++){
          for(let j=i, temp;0<j;j--){
              if(array[j]<array[j-1]){
                  temp = array[j];
                  array[j] = array[j-1];
                  array[j-1] = temp; 
              } else {
                  break;
              }
          }
      }
      return array;
  }
  
  // Do not edit the line below.
  exports.insertionSort = insertionSort;
  
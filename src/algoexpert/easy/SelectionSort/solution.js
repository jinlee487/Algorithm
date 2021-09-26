function selectionSort(array) {
    // Write your code here.
      for(let i=0, temp;i<array.length;i++){
          let smallest=i;
          for(let j=i+1;j<array.length;j++){
              if(array[smallest] > array[j]){
                  smallest = j;
              }
          }
          temp = array[smallest];
          array[smallest] = array[i];
          array[i] = temp;
      }
      return array;
  }
  
  // Do not edit the line below.
  exports.selectionSort = selectionSort;
  
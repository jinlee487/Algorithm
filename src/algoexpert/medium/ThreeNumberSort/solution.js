function threeNumberSort(array, order) {
    // Write your code here.
      const count = new Array(order.length).fill(0);
      for(const e of array){
          count[order.indexOf(e)]++;
      }
      let idx = 0;
      for(let i=0;i<count.length;i++){
          for(let j=0;j<count[i];j++){
              array[idx++] = order[i];
          }
      }
      return array;
  }
  
  function threeNumberSort(array, order) {
    // Write your code here.
      let idx = 0;
      for(let i=0;i<array.length;i++){
          if(array[i]==order[0]){
              swap(i,idx++,array);
          }
      }
      idx = array.length-1;
      for(let i=array.length-1;0<=i;i--){
          if(array[i]==order[2]){
              swap(i,idx--,array);
          }
      }
      return array;
  }
  function swap(i,j,array){
      const temp = array[i];
      array[i] = array[j];
      array[j] = temp;
  }
  function threeNumberSort(array, order) {
    // Write your code here.
      let first = 0;
      let second = 0;
      let third = array.length-1;
      while(second<=third){
          if(array[second]==order[0]){
              swap(first++,second++,array);
          } else if(array[second]==order[1]){
              second++;
          } else {
              swap(second,third--,array);
          }
      }
      return array;
  }
  function swap(i,j,array){
      const temp = array[i];
      array[i] = array[j];
      array[j] = temp;
  }
  
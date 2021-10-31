function powerset(array) {
    // Write your code here.
      const answer = [];
      for(let i=0;i<(1<<array.length);i++){
          const combination = []; 
          for(let j=0;j<array.length;j++){
              if((i&(1<<j))>0){
                  combination.push(array[j]);
              }
          }
          answer.push(combination);
      }
      return answer;
  }

  function powerset(array, idx = null) {
    // Write your code here.
      if(idx === null) idx = array.length-1;
      if(idx < 0) return [[]];
      const value = array[idx];
      const subsets = powerset(array,idx-1);
      const length = subsets.length;
      for(let i=0;i<length;i++){
          const current = subsets[i];
          subsets.push(current.concat(value));
      }
      return subsets;
  }
  function powerset(array) {
    // Write your code here.
      const subsets = [[]];
      for (const value of array){
          const length = subsets.length;
          for(let i=0;i<length;i++){
              const current = subsets[i];
              subsets.push(current.concat(value));
          }
      }
      return subsets;
  }
  // Do not edit the line below.
  exports.powerset = powerset;
  
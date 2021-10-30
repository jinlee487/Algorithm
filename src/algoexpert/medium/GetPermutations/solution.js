function getPermutations(array) {
    // Write your code here.
      const answer = [];
      getPermutationsHelper(array,[],answer);
      return answer;
  }
  function getPermutationsHelper(array,current,answer){
      if(!array.length&&current.length){
          answer.push(current);
      } else {
          for(let i=0;i<array.length;i++){
              const temp = array.slice(0,i).concat(array.slice(i+1));
              const permutation = current.concat([array[i]]);
              getPermutationsHelper(temp, permutation, answer);
          }
      }
  }

  function getPermutations(array) {
    // Write your code here.
      const answer = [];
      getPermutationsHelper(0,array,answer);
      return answer;
  }
  function getPermutationsHelper(i,array,answer){
      if(i==array.length-1) answer.push(array.slice());
      else{
          for(let j=i;j<array.length;j++){
              swap(i,j,array);
              getPermutationsHelper(i+1,array,answer);
              swap(i,j,array);
          }
      }
  }
  function swap(i,j,array){
      temp = array[i];
      array[i] = array[j];
      array[j] = temp;
  }
  // Do not edit the line below.
  exports.getPermutations = getPermutations;
  
  
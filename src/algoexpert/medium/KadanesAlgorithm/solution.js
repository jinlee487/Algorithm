function kadanesAlgorithm(array) {
    // Write your code here.
      let answer = array[0];
      for(let i=1;i<array.length;i++){
          array[i] = Math.max(array[i],array[i-1]+array[i]);
          answer = Math.max(array[i],answer);
      }
      return answer;
  }
  
  // Do not edit the line below.
  exports.kadanesAlgorithm = kadanesAlgorithm;
  
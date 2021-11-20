function sameBsts(arrayOne, arrayTwo) {
    // Write your code here.
      if(arrayOne.length !== arrayTwo.length) return false;
      if(arrayOne.length === 0 && arrayTwo.length ===0) return true;
      if(arrayOne[0] !== arrayTwo[0]) return false;
      
      const leftOne = getSmaller(arrayOne);
      const leftTwo = getSmaller(arrayTwo);
      const rightOne = getBiggerOrEqual(arrayOne);
      const rightTwo = getBiggerOrEqual(arrayTwo);
      return sameBsts(leftOne, leftTwo) && sameBsts(rightOne, rightTwo);
  }
  function getSmaller(array){
      const smaller = [];
      for(let i=1;i<array.length;i++){
          if(array[i] < array[0]) smaller.push(array[i]);
      }
      return smaller;
  }
  function getBiggerOrEqual(array){
      const biggerOrEqual = [];
      for(let i=1;i<array.length;i++){
          if(array[0] <= array[i]) biggerOrEqual.push(array[i]);
      }
      return biggerOrEqual;
  }
  function sameBsts(arrayOne, arrayTwo) {
    // Write your code here.
      return sameBstsHelper(arrayOne, arrayTwo, 0,0, -Infinity, Infinity);
  }
  function sameBstsHelper(arrayOne, arrayTwo, rootIdxOne, rootIdxTwo, minVal, maxVal){
      if(rootIdxOne === -1 || rootIdxTwo === -1) return rootIdxOne === rootIdxTwo;
      if(arrayOne[rootIdxOne] !== arrayTwo[rootIdxTwo]) return false;
      
      const leftRootIdxOne = getIdxOfFirstSmaller(arrayOne, rootIdxOne, minVal);
      const leftRootIdxTwo = getIdxOfFirstSmaller(arrayTwo, rootIdxTwo, minVal);
      const rightRootIdxOne = getIdxOfFirstBiggerOrEqual(arrayOne, rootIdxOne, maxVal);	
      const rightRootIdxTwo = getIdxOfFirstBiggerOrEqual(arrayTwo, rootIdxTwo, maxVal);
      
      const currentValue = arrayOne[rootIdxOne];
      const areLeftSame = sameBstsHelper(arrayOne, arrayTwo, leftRootIdxOne, leftRootIdxTwo, minVal, currentValue);
      const areRightSame = sameBstsHelper(arrayOne, arrayTwo, rightRootIdxOne, rightRootIdxTwo, currentValue, maxVal);
      return areLeftSame && areRightSame;
  }
  function getIdxOfFirstSmaller(array, rootIdx, minVal){
      for(let i=rootIdx+1;i<array.length;i++){
          if(array[i] < array[rootIdx] && array[i] >= minVal) return i;
      }
      return -1;
  }
  function getIdxOfFirstBiggerOrEqual(array, rootIdx, maxVal){
      for(let i=rootIdx+1;i<array.length;i++){
          if(array[rootIdx] <= array[i] && array[i] < maxVal) return i;
      }
      return -1;
  }
  // Do not edit the line below.
  exports.sameBsts = sameBsts;
  
  
function sortedSquaredArray(array) {
    // Write your code here.
      const answer = [];
      for(let num of array){
          answer.push(num*num);
      }
      answer.sort((o1,o2) => o1-o2);
    return answer;
  }
  
  // Do not edit the line below.
  exports.sortedSquaredArray = sortedSquaredArray;
  
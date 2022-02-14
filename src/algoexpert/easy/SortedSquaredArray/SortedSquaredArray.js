function sortedSquaredArray(array) {
    // Write your code here.
      const answer = [];
      for(let num of array){
          answer.push(num*num);
      }
      answer.sort((o1,o2) => o1-o2);
    return answer;
  }
  
  function sortedSquaredArray(array) {
    // Write your code here.
    const answer = new Array(array.length).fill(0);
    let left = 0;
    let right = array.length-1;
    for(let i=right;0<=i;i--){
      const small = array[left];
      const large = array[right];
      if(Math.abs(small)>Math.abs(large)){
        answer[i] = small * small;
        left++;
      } else{
        answer[i] = large * large;
        right--;
      }
    }
    return answer;
  }
  
  // Do not edit the line below.
  exports.sortedSquaredArray = sortedSquaredArray;
  
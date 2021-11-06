function nextGreaterElement(array) {
    // Write your code here.
      const answer = new Array(array.length).fill(-1);
      const stack = [];
      for(let i=0;i<array.length*2;i++) {
          const idx = i%array.length;
           while(stack.length>0 && array[stack[stack.length-1]] < array[idx]){
              answer[stack.pop()] = array[idx];
          }
          stack.push(idx);
      }
    return answer;
  }
  
  // Do not edit the line below.
  exports.nextGreaterElement = nextGreaterElement;
  
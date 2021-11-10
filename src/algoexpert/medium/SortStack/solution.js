function sortStack(stack) {
    // Write your code here.
      if(stack.length===0) return stack;
      let currentNumber = stack.pop();
    sortStack(stack);
      while(stack.length!==0&&currentNumber<stack[stack.length-1]){
          let nextNumber = stack.pop();
          stack.push(currentNumber);
          currentNumber = nextNumber;
          sortStack(stack);
      }
      stack.push(currentNumber);
    return stack;
  }
  
  function sortStack(stack) {
    // Write your code here.
      if(stack.length===0) return stack;
      const current = stack.pop();
      sortStack(stack);
      sortStackHelper(stack,current);
    return stack;
  }
  function sortStackHelper(stack,value){
      if(stack.length===0 || stack[stack.length-1] <= value){
          stack.push(value);
          return;
      }
      const current = stack.pop();
      sortStackHelper(stack,value);
      stack.push(current);
  }
  
  // Do not edit the line below.
  exports.sortStack = sortStack;
  
function numberOfWaysToTraverseGraph(width, height) {
    // Write your code here.
      if(width==1||height==1) return 1;
    return numberOfWaysToTraverseGraph(width-1,height)
          +	numberOfWaysToTraverseGraph(width,height-1);
  }
  function numberOfWaysToTraverseGraph(width, height) {
    // Write your code here.
      const arr = [];
      // zero padding and making array
      for(let i=0;i<height+1;i++){
          arr.push([]);
          for(let j=0;j<width+1;j++){
              arr[i].push(0);
          }
      } 
      for(let i=1;i<height+1;i++){
          for(let j=1;j<width+1;j++){
              if(i===1||j===1) arr[i][j]=1;
              else arr[i][j] = arr[i-1][j] + arr[i][j-1];
          }
      }
      return arr[height][width];
  }
  function numberOfWaysToTraverseGraph(width, height) {
    // Write your code here.
    return factorial(width-1+height-1)/factorial(width-1)/factorial(height-1);
  }
  function factorial(num){
      for(let i=num-1;0<i;i--) num*=i;
      return num===0?1:num;
  }
  // Do not edit the line below.
  exports.numberOfWaysToTraverseGraph = numberOfWaysToTraverseGraph;
  
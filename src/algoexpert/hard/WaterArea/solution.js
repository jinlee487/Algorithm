function waterArea(heights) {
    // Write your code here.
      if(heights.length===0) return 0;
      const maxArr = [0,0];
      for(let i=0;i<heights.length;i++){
          if(maxArr[0]<=heights[i]) {
              maxArr[0] = heights[i];
              maxArr[1] = i;
          }
      }
      let answer = 0;
      let currentMaxHeight = heights[0];
      for(let i=0;i<maxArr[1];i++){
          if(currentMaxHeight<=heights[i]) currentMaxHeight = heights[i];
          else answer += currentMaxHeight - heights[i];
      }
      currentMaxHeight = heights[heights.length-1];
      for(let i=heights.length-1;maxArr[1]<i;i--){
          if(currentMaxHeight<=heights[i]) currentMaxHeight = heights[i];
          else answer += currentMaxHeight - heights[i];
      }	
      return answer;
  }
  
  function waterArea(heights) {
    // Write your code here.
      const maxes = new Array(heights.length).fill(0);
      let leftMax = 0;
      for(let i=0;i<heights.length;i++){
          const height = heights[i];
          maxes[i] = leftMax;
          leftMax = Math.max(leftMax,height);
      }
      let rightMax = 0;
      for(let i=heights.length-1;i>=0;i--){
          const height = heights[i];
          const minHeight = Math.min(rightMax, maxes[i]);
          if(height < minHeight){
              maxes[i] = minHeight - height;
          } else {
              maxes[i] = 0;
          }
          rightMax = Math.max(rightMax,height);
      }
      return maxes.reduce((a,b) => a+b,0);
  }
  
  function waterArea(heights) {
    // Write your code here.
      if(heights.length === 0) return 0;
      let leftIdx = 0;
      let rightIdx = heights.length-1;
      let leftMax = heights[leftIdx];
      let rightMax = heights[rightIdx];
      let surfaceArea = 0;
      
      while(leftIdx < rightIdx){
          if(heights[leftIdx]<heights[rightIdx]){
              leftIdx ++;
              leftMax = Math.max(leftMax,heights[leftIdx]);
              surfaceArea += leftMax - heights[leftIdx];
          } else {
              rightIdx--;
              rightMax = Math.max(rightMax,heights[rightIdx]);
              surfaceArea += rightMax - heights[rightIdx];
          }
      }
      return surfaceArea;
  }
  
  // Do not edit the line below.
  exports.waterArea = waterArea;
  
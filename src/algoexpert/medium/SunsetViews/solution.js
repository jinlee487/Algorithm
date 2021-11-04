function sunsetViews(buildings, direction) {
    // Write your code here.
      const answer = [];
      if(direction==="EAST") right(answer, buildings);
      else left(answer,buildings);
    return answer;
  }
  function right(answer,buildings){
      let max = 0;
      for(let i=buildings.length-1;0<=i;i--){
          if(buildings[i]<=max) continue;
          answer.push(i);
          max = buildings[i];
      }
      answer.reverse();
  }
  function left(answer,buildings){
      let max = 0;
      for(let i=0;i<buildings.length;i++){
          if(buildings[i]<=max) continue;
          answer.push(i);
          max = buildings[i];
      }
  }
  function sunsetViews(buildings, direction) {
    // Write your code here.
      const answer = [];
      let start = buildings.length-1;
      let step = -1;
      if(direction === "EAST"){
          start = 0;
          step = 1;
      }
      let idx = start;
      while(idx >= 0 && idx < buildings.length){
          const current = buildings[idx];
          while(answer.length>0 &&
                   buildings[answer[answer.length-1]]<=current){
              answer.pop();
          }
          answer.push(idx);
          idx = idx + step;
      }
      if(direction==="WEST") answer.reverse();
    return answer;
  }
  
  // Do not edit the line below.
  exports.sunsetViews = sunsetViews;
  
  
function validStartingCity(distances, fuel, mpg) {
    // Write your code here.
  
      for(let i=0;i<distances.length;i++){
          let current = i;
          let count = 0;
          let mile = 0;
          while(true){
              mile += fuel[current]*mpg - distances[current];
              if(mile<0) break;
              current++;
              count++;
              if(distances.length<=current) current = 0;
              if(count==distances.length) return i;
          }
      }
    return -1;
  }
  
  function validStartingCity(distances, fuel, mpg) {
    // Write your code here.
      let miles = 0;
      let answer = 0;
      let start = 0;
      for(let i=1;i<distances.length;i++){
          miles += fuel[i-1]*mpg - distances[i-1];
          if(miles<start){
              start = miles;
              answer = i;
          }
      }
    return answer;
  }
  
  // Do not edit the line below.
  exports.validStartingCity = validStartingCity;
  
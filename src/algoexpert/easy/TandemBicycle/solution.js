function tandemBicycle(redShirtSpeeds, blueShirtSpeeds, fastest) {
    // Write your code here.
      let answer = 0;
      redShirtSpeeds.sort((o1,o2) => o1-o2);
      if(fastest) blueShirtSpeeds.sort((o1,o2) => o2-o1);
      else blueShirtSpeeds.sort((o1,o2) => o1-o2);
      for(let i=0;i<blueShirtSpeeds.length;i++){
          if(redShirtSpeeds[i]<blueShirtSpeeds[i]) answer += blueShirtSpeeds[i];
          else answer += redShirtSpeeds[i];
      }
    return answer;
  }
  
  // Do not edit the line below.
  exports.tandemBicycle = tandemBicycle;
  
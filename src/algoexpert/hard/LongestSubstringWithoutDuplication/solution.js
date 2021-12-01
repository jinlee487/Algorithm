function longestSubstringWithoutDuplication(string) {
    // Write your code here.
      const map = {};
      let answer = [0,1];
      let start = 0;
      for(let i=0;i<string.length;i++){
          if(string[i] in map) {
              start = Math.max(start,map[string[i]] + 1);
          }
          if(answer[1]-answer[0] < i+1-start){
              answer = [start,i+1];
          }
          map[string[i]] = i;
      }
      return string.slice(answer[0],answer[1]);
  }
  
  // Do not edit the line below.
  exports.longestSubstringWithoutDuplication = longestSubstringWithoutDuplication;
  
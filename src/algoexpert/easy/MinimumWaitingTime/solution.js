function minimumWaitingTime(queries) {
    // Write your code here.
      queries.sort((o1,o2) => o1 - o2);
      let answer = 0 ;
      for(let i=0;i<queries.length;i++){
          answer += queries[i] * (queries.length - 1 - i);
      }
    return answer;
  }
  
  // Do not edit the line below.
  exports.minimumWaitingTime = minimumWaitingTime;
  
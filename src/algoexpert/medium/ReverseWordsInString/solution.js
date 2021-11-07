function reverseWordsInString(string) {
    // Write your code here.
      const answer = [];
      let start = 0;
      for(let i=0;i<string.length;i++){
          const character = string[i];
          if(character == ' '){
              answer.push(string.slice(start,i));
              start = i;
          } else if(string[start] === ' '){
              answer.push(' ');
              start = i;
          }
      }
      answer.push(string.slice(start));
      reverse(answer);
    return answer.join('');
  }
  function reverse(list){
      let start = 0;
      let end = list.length-1;
      while(start<end){
          const temp = list[start];
          list[start++] = list[end];
          list[end--] = temp;
      }
  }
  
  function reverseWordsInString(string) {
    // Write your code here.
      const answer = [];
      for(const char of string) answer.push(char);
      reverse(answer,0,answer.length-1);
      let start = 0;
      while(start<answer.length){
          let end = start;
          while(end<answer.length && answer[end] != ' ') end ++;
          reverse(answer, start, end-1);
          start = end + 1;
      }
    return answer.join('');
  }
  function reverse(list,start,end){
      while(start < end){
          const temp = list[start];
          list[start++] = list[end];
          list[end--] = temp;
      }
  }
  
  // Do not edit the line below.
  exports.reverseWordsInString = reverseWordsInString;
  
  
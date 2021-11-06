function longestPalindromicSubstring(string) {
    // Write your code here.
      const answer = [0,1];
      for(let i=1;i<string.length;i++){
          const odd = getLongestPalindrome(string,i-1,i+1);
          const even = getLongestPalindrome(string,i-1,i);
          const longest = odd[1]-odd[0]>even[1]-even[0] ? odd:even;
          if(answer[1]-answer[0]<longest[1]-longest[0]){
              answer[0] = longest[0];
              answer[1] = longest[1];
          }
      }
      return string.slice(answer[0],answer[1]);
  }
  function getLongestPalindrome(string,left,right){
      while(0<=left && right<string.length){
          if(string[left] !== string[right]) break;
          left--;
          right++;
      }
      return [left+1,right];
  }

  function longestPalindromicSubstring(string) {
    // Write your code here.
      let answer = "";
      for(let i=0;i<string.length;i++){
          for(let j=i;j<string.length;j++){
              const substring = string.slice(i,j+1);
              if(substring.length > answer.length && isPalindrome(substring)){
                  answer = substring;
              }
          }
      }
      return answer;
  }
  function isPalindrome(string){
      let left = 0;
      let right = string.length-1;
      while(left<right){
          if(string[left] !== string[right]) return false;
          left++; 
          right--;
      }
      return true;
  }
  
  // Do not edit the line below.
  exports.longestPalindromicSubstring = longestPalindromicSubstring;
  
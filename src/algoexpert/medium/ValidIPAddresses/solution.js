function validIPAddresses(string) {
    // Write your code here.
      const answer = [];
      for(let i=1;i<Math.min(string.length,4);i++){
          const current=['','','',''];
          current[0] = string.slice(0,i);
          if(!check(current[0])) continue;
          for(let j=i+1;j<i+Math.min(string.length-i,4);j++){
              current[1] = string.slice(i,j);
              if(!check(current[1])) continue;
              for(let k=j+1;k<j+Math.min(string.length-j,4);k++){
                  current[2] = string.slice(j,k);
                  current[3] = string.slice(k);
                  if(check(current[2])&&check(current[3])) answer.push(current.join('.'));
              }
          }
      }
    return answer;
  }
  function check(str){
      const num = parseInt(str);
      if(num>255) return false;
      return str.length === num.toString().length;
  }
  // Do not edit the line below.
  exports.validIPAddresses = validIPAddresses;
  
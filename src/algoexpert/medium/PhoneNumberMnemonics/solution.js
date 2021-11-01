function phoneNumberMnemonics(phoneNumber) {
    // Write your code here.
      const mnemonicArray = [['0'],['1'],['a','b','c'],['d','e','f'],['g','h','i'],['j','k','l'],
                                                   ['m','n','o'],['p','q','r','s'],['t','u','v'],['w','x','y','z']];
      // const arr = new Array(phoneNumber.length);
    return phoneNumberMnemonicsHelper(0,phoneNumber,mnemonicArray);
  }
  function phoneNumberMnemonicsHelper(
  idx,phoneNumber,mnemonicArray,arr = new Array(phoneNumber.length),answer=[]){
      if(idx===phoneNumber.length){
          answer.push(arr.join(""));
          return answer;
      }
      const mnemonic = mnemonicArray[parseInt(phoneNumber[idx])];
      for(let i=0;i<mnemonic.length;i++){
          arr[idx] = mnemonic[i];
          answer = phoneNumberMnemonicsHelper(idx+1,phoneNumber,mnemonicArray,arr,answer);
      }
      return answer;
  }
  
  // Do not edit the line below.
  exports.phoneNumberMnemonics = phoneNumberMnemonics;
  
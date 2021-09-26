function isPalindrome(string) {
    // Write your code here.
    let reverse = "";
    for(let i=string.length-1;0<=i;i--){
        reverse += string.charAt(i);
    }
    return reverse === string ? true : false;
}
  
function isPalindrome(string) {
    // Write your code here.
    return isPalindromeHelper(string, 0);
}
function isPalindromeHelper(string, i){
    let j = string.length - i - 1;
    return i >= j ? true : string.charAt(i) === string.charAt(j) && isPalindromeHelper(string, i + 1);
}

function isPalindrome(string) {
    // Write your code here.
    for(let i=0;i<string.length;i++){
        if(string.charAt(i)!==string.charAt(string.length-1-i)){
            return false;
        }
    }
    return true;
}

// Do not edit the line below.
exports.isPalindrome = isPalindrome;
  
  
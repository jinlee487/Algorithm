package algoexpert.easy.Palindrome;

import java.util.*;

class Program {
     public static boolean isPalindrome(String str) {
    // Write your code here.
    //iterativee
    for(int i=0;i<str.length()/2;i++){
        if(str.charAt(i) != str.charAt(str.length()-1-i)){
            return false;
        }
    }
    return true;
    }
}

class Program1 {
    public static boolean isPalindrome(String str) {
        // Write your code here.
        // recursive
    return isPalindrome(str, 0);
}
    public static boolean isPalindrome(String str, int i){
        int j = str.length() - 1 - i;
        return i >= j ? true : str.charAt(i) == str.charAt(j) && isPalindrome(str, i + 1); 
    }
}
  
  
class Program2 {
    public static boolean isPalindrome(String str) {
        // Write your code here.
        String reversedString = "";
        for(int i = str.length() - 1; i >=0; i--){
            reversedString += str.charAt(i);
        }
    return str.equals(reversedString);
}
}
  
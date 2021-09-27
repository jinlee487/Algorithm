package algoexpert.easy.firstNonRepeatingCharacter;

import java.util.*;

class Program {

    public int firstNonRepeatingCharacter(String string) {
    // Write your code here.
    // O(n^2) 
    for(int i=0;i<string.length();i++){
        boolean check = true;
        for(int j=0;j<string.length();j++){
            if(i==j) continue;
            if(string.charAt(i)==string.charAt(j)) {
                check = false;
                break;
            }
        }
        if(check) return i;
    }
    return -1;
    }
}

class Program1 {

    public int firstNonRepeatingCharacter(String string) {
    // Write your code here.
    // O(n) time | O(1) space
    HashMap<Character, Integer> hash = new HashMap<Character,Integer>();
    for(int i=0;i<string.length();i++){
            hash.put(string.charAt(i),hash.getOrDefault(string.charAt(i), 0) + 1);			
    }
    for(int i=0;i<string.length();i++){
        if(hash.get(string.charAt(i)) == 1){
            return i;
        }
    }
    return -1;
    }
}
  

package algoexpert.easy.GenerateDocument;

import java.util.*;

class Program {

  public boolean generateDocument(String characters, String document) {
    // Write your code here.
    // O(m * (n+m)) time | O(1) space
    for(int i=0;i<document.length();i++){
        int d=0;
        int c=0;
        char current = document.charAt(i);
        for(int j=0;j<document.length();j++){
            if(current == document.charAt(j)){
                d++;
            }
        } 
        for(int j=0;j<characters.length();j++){
            if(current == characters.charAt(j)){
                c++;
            }
        } 
        if(c<d){
            return false;
        }
    }
    return true;
    }
}


class Program1 {

    public boolean generateDocument(String characters, String document) {
    // Write your code here.
    // O(c * (n+m)) time | O(c) space
    Set<Character> set = new HashSet<Character>();
    for(int i=0;i<document.length();i++){
        char current = document.charAt(i);
        int d = 0;
        int c = 0;
        if(set.contains(current)){
            continue;
        } else {
            set.add(current);
        }
        for(int j=0;j<document.length();j++){
            if(current == document.charAt(j)){
                d ++;
            }
        }
        for(int j=0;j<characters.length();j++){
            if(current == characters.charAt(j)){
                c ++;
            }
        }	
        if(c<d){
            return false;
        }
    }
    return true;
    }
}


class Program2 {

    public boolean generateDocument(String characters, String document) {
    // Write your code here.
    // O(n+m) time | O(c) space
    HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
    for(int i=0;i<characters.length();i++){
        char current = characters.charAt(i);
        if(hash.containsKey(current)){
            hash.put(current, hash.get(current)+1);
        } else {
            hash.put(current, 1);
        }
    }
    for(int i=0;i<document.length();i++){
        char current = document.charAt(i);
        if(!hash.containsKey(current)||hash.get(current)==0){
            return false;
        }
        if(hash.containsKey(current)){
            hash.put(current, hash.get(current)-1);
        } 
    }
    return true;
    }
}
  

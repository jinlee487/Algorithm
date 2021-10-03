package algoexpert.medium.FirstDuplicateValue;

import java.util.*;

class Program {

    public int firstDuplicateValue(int[] array) {
        // Write your code here.
            // bruteforce
            // O(n^2) time | O(1) space
            for(int i=0;i<array.length;i++){
                for(int j=0;j<i;j++){
                    if(array[i]==array[j]) return array[j];
                }
            }
        return -1;
    }
}

class Program1 {

    public int firstDuplicateValue(int[] array) {
        // Write your code here.
            // O(n) time | O(n) space
            Set<Integer> set = new HashSet<Integer>();
            for(int a : array){
                if(set.contains(a)){
                    return a;
                } else{
                    set.add(a);
                }
            }
        return -1;
    }
}

class Program2 {

    public int firstDuplicateValue(int[] array) {
        // Write your code here.
            // O(n) time | O(1) space
            for(int a : array){
                int abs = Math.abs(a);
                if(array[abs - 1] < 0) return abs;
                array[abs - 1] *= -1;
            }		
        return -1;
    }
}

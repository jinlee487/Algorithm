package algoexpert.medium.MoveElementToEnd;

import java.util.*;

class Program1 {
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        // Write your code here.
        int count = 0;
        ArrayList<Integer> answer = new ArrayList<Integer>();
        for(int i=0;i<array.size();i++){
            if(array.get(i)==toMove){
                count ++;
            } else {
                answer.add(array.get(i));
            }
        }
        for(int i=0;i<count;i++){
            answer.add(toMove);
        }
        return answer;
    }
}


class Program2 {
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        // Write your code here.
        // O(n) time | O(1) space
        int left=0;
        int right=array.size()-1;
        while(left<right){
            while(array.get(right)==toMove && left<right) {
                right --;
            }
            if(array.get(left)==toMove){
                int temp = array.get(right);
                array.set(right,array.get(left));
                array.set(left,temp);
            }
            left ++;
        }
        return array;
    }
  }
  
package algoexpert.easy.FindThreeLargestNumbers;
import java.util.*;

public class solution {
    public static int[] findThreeLargestNumbers1(int[] array) {
        // Write your code here.
        // O(nlog(n)) time | O(3) space
        Arrays.sort(array);
        int[] answer = {array[array.length-3],array[array.length-2],array[array.length-1]};
    return answer;
    }
    public static int[] findThreeLargestNumbers2(int[] array) {
        // Write your code here.
            int[] answer = {Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE};
            for(int n : array){
                findThreeLargestNumbers(answer, n);
            }
        return answer;
      }
    public static void findThreeLargestNumbers(int[] answer, int n){
        if(n > answer[2]) findThreeLargestNumbers(answer, n, 2);
        else if(n > answer[1]) findThreeLargestNumbers(answer, n, 1);
        else if(n > answer[0]) findThreeLargestNumbers(answer, n, 0);
    }
    public static void findThreeLargestNumbers(int[] answer, int n, int idx){
        for(int i=0;i<=idx;i++){
            if(i==idx) answer[i] = n;
            else answer[i] = answer[i + 1];
        }
    }

}

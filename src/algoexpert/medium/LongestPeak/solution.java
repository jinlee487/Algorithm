package algoexpert.medium.LongestPeak;
import java.util.*;

class Program {
    public static int longestPeak(int[] array) {
        // Write your code here.
            // O(n) time | O(1) space
            int answer = 0;
            for(int i=1;i<array.length-1;){
                boolean isPeak = array[i-1] < array[i] && array[i+1] < array[i];
                if(!isPeak){
                    i += 1;
                    continue;
                }
                int leftIdx = i - 2;
                while(leftIdx >= 0 && array[leftIdx] < array[leftIdx+1]) {
                    leftIdx -= 1;
                }
                int rightIdx = i + 2;
                while(rightIdx < array.length && array[rightIdx] < array[rightIdx -1]){
                    rightIdx += 1;
                }
                int currentLength = rightIdx - leftIdx -1;
                if(currentLength > answer){
                    answer = currentLength;
                } 
                i = rightIdx;
            }
        return answer;
    }
}

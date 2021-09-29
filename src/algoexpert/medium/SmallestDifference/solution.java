package algoexpert.medium.SmallestDifference;

import java.util.*;

class Program1 {
  public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
    // Write your code here.
    // O(n^2) time | O(1) space
    int[] answer = new int[2];
    int d = Integer.MAX_VALUE;
    for(int i=0;i<arrayOne.length;i++){
        for(int j=0;j<arrayTwo.length;j++){
            if(Math.abs(arrayOne[i]-arrayTwo[j])<d){
                d = Math.abs(arrayOne[i]-arrayTwo[j]);
                answer[0] = arrayOne[i];
                answer[1] = arrayTwo[j];
            }
        }
    }
    return answer;
  }
}

class Program2 {
  public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
    // Write your code here.
    // O(nlog(n) + mlog(m)) time | O(1) space
    Arrays.sort(arrayOne);
    Arrays.sort(arrayTwo);
    int idxOne  = 0;
    int idxTwo = 0;
    int smallest = Integer.MAX_VALUE;
    int current = Integer.MAX_VALUE;
    int[] answer = new int[2];
    while(idxOne<arrayOne.length && idxTwo<arrayTwo.length){
        int first = arrayOne[idxOne];
        int second = arrayTwo[idxTwo];
        if(first < second) {
            current = second - first;
            idxOne ++;
        } else if(second < first) {
            current = first - second;
            idxTwo ++;
        } else {
            return new int[] {first, second};
        }
        if(smallest > current) {
            smallest = current;
            answer[0] = first;
            answer[1] = second;
        }
    }	
		
    return answer;
  }
}

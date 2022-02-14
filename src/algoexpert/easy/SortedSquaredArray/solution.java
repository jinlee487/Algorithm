package algoexpert.easy.SortedSquaredArray;

import java.util.*;

class Program {

  public int[] sortedSquaredArray(int[] array) {
    // Write your code here.
		int[] answer = new int[array.length];
		for(int i=0;i<array.length;i++){
			answer[i] = array[i]*array[i];
		}
		Arrays.sort(answer);
    return answer;
  }
}

class Program1 {

  public int[] sortedSquaredArray(int[] array) {
    // Write your code here.
		int[] answer = new int[array.length];
		int left = 0;
		int right = array.length-1;
		for(int i=array.length-1;0<=i;i--){
			int small = array[left];
			int large = array[right];
			if(Math.abs(small)>Math.abs(large)) {
				answer[i] = small*small;
				left ++;
			} else {
				answer[i] = large*large;
				right--;
			}
		}
		return answer;
	}
}


package algoexpert.easy.BubbleSort;

import java.util.*;

class Program {
  public static int[] bubbleSort(int[] array) {
    // Write your code here.
		if(array.length < 2) return array;
		boolean sorted = false; 
		int l = array.length;
		while (!sorted) {
			sorted = true;
			for(int i=1, temp;i<l;i++){
				if(array[i]<array[i-1]){
					temp = array[i];
					array[i] = array[i-1];
					array[i-1] = temp;
					sorted = false;
				}
			}
			l--;
		}
    return array;
  }
}

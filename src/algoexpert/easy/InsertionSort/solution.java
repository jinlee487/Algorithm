package algoexpert.easy.InsertionSort;

import java.util.*;

class Program {
  public static int[] insertionSort(int[] array) {
    // Write your code here.
		for(int i=0;i<array.length;i++){
			for(int j=i, temp;0<j;j--){
				if(array[j]<array[j-1]){
					temp = array[j];
					array[j] = array[j-1];
					array[j-1] = temp;
				} else {
					break;
				}
			}
		}
    return array;
  }
}

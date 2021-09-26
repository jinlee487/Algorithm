package algoexpert.easy.SelectionSort;

import java.util.*;

class Program {
  public static int[] selectionSort(int[] array) {
    // Write your code here.
		for(int i=0;i<array.length;i++){
			int smallest = i;
			for(int j=i;j < array.length - 1;j++){
				if(array[smallest] > array[j+1]){
					smallest = j + 1;
				}
			}
			int temp = array[i];
			array[i] = array[smallest];
			array[smallest] = temp;
		}
    return array;
  }
}

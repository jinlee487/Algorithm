package algoexpert.medium.ThreeNumberSort;
import java.util.*;

class Program1{
  public int[] threeNumberSort(int[] array, int[] order) {
    // Write your code here.
		// O(n) time | O(1) space
		int[] count = new int[order.length];
		for(int i=0;i<array.length;i++){
			for(int j=0;j<order.length;j++){
				if(order[j] == array[i]){
					count[j] ++;
					break;
				}
			}
		}
		int idx = 0;
		for(int i=0;i<count.length;i++){
			for(int j=0;j<count[i];j++){
				array[idx++] = order[i]; 
			}
		}
    return array;
  }
}

class Program2 {
  public int[] threeNumberSort(int[] array, int[] order) {
    // Write your code here.
		//O(n) time | O(1) space
		int temp, idx = 0;
		for(int i=0;i<array.length;i++){
			if(array[i] == order[0]){
				temp = array[idx];
				array[idx++] = array[i];
				array[i] = temp;
			}
		}
		idx = array.length-1;
		for(int i=array.length-1;0<=i;i--){
			if(array[i]==order[2]){
				temp = array[idx];
				array[idx--] = array[i];
				array[i] = temp;
			}
		}
    return array;
  }
}

class Program3 {
  public int[] threeNumberSort(int[] array, int[] order) {
    // Write your code here.
		//O(n) time | O(1) space
		int first = 0;
		int second = 0;
		int third = array.length-1;
		while(second<=third){
			if(array[second]==order[0]){
				swap(first++,second++,array);
			} else if(array[second]==order[1]){
				second++;
			} else {
				swap(second,third--,array);
			}
		}
    return array;
  }
	public void swap(int i, int j, int[] array){
		int temp = array[j];
		array[j] = array[i];
		array[i] = temp;
	}
}


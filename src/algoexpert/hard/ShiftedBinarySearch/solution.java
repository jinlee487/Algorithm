package algoexpert.hard.ShiftedBinarySearch;

import java.util.*;

class Program1 {
  public static int shiftedBinarySearch(int[] array, int target) {
    // Write your code here.
		// O(n+log(n)) time | O(1) space
		int left = 0 ;
		for(int i=0;i<array.length;i++){
			if(array[i] == 0) {
				left = i;
				break;
			}
		}
		int right = left + array.length - 1;
		while(left <= right) {
			int mid = (left + right) / 2;
			int adjusted = check(mid, array.length);
			if (target == array[adjusted]) return adjusted;
			else if (target < array[adjusted]) right = mid - 1;
			else left = mid + 1; 
		}
    return -1;
  }
	public static int check(int index, int length){
		if(index<length) return index;
		return index - length;
	}
}


class Program2 {
    public static int shiftedBinarySearch(int[] array, int target) {
      // Write your code here.
          // O(log(n)) time | O(log(n)) space
          return shiftedBinarySearch(array,target,0,array.length-1);
      }
      public static int shiftedBinarySearch(int[] array, int target, int left, int right){
          if(left > right) return -1;
          int middle = (left + right) / 2;
          if(target == array[middle]) return middle;
          else if(array[left] <= array[middle]){
              if(array[left] <= target && target < array[middle]) 
                  return shiftedBinarySearch(array,target,left,right-1);
              else 
                  return shiftedBinarySearch(array,target,middle+1,right);
          } else {
              if(array[middle] < target && target <= array[right]) 
                  return shiftedBinarySearch(array,target,middle+1,right);
              else  
                  return shiftedBinarySearch(array,target,left,middle-1);
          }
      }
  }
  
  
class Program3 {
    public static int shiftedBinarySearch(int[] array, int target) {
      // Write your code here.
          // O(log(n)) time | O(1) space
          int left = 0;
          int right = array.length-1;
          while(left<=right){
              int middle = (left + right) / 2;
              if(target == array[middle]) return middle;
              else if(array[left] <= array[middle]){
                  if(array[left] <= target && target < array[middle]) right = middle-1;
                  else left = middle+1;
              } else {
                  if(array[middle] < target && target <= array[right]) left = middle+1;
                  else right = middle -1;
              }
          }
      return -1;
    }
  }
  
package algoexpert.medium.ThreeNumberSum;

import java.util.*;

class Program {
  public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
    // Write your code here.
		// O(n^3) time | O(n) space.
		Arrays.sort(array);
		ArrayList<Integer[]> arrayList = new ArrayList<Integer[]>(); 
		for(int i=0;i<array.length;i++){
			int targetSum2 = targetSum - array[i];
			for(int j=i+1;j<array.length;j++){
				for(int k=j+1;k<array.length;k++){
					if(array[j] + array[k] == targetSum2){
						Integer[] temp = {array[i], array[j], array[k]};
						arrayList.add(temp);
					}
				}
			}
		}
    return arrayList;
  }
}


class Progra2 {
  public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
    // Write your code here.
		// O(n^2) time | O(n) space
		Arrays.sort(array);
		ArrayList<Integer[]> arrayList = new ArrayList<Integer[]>();
		for(int i=0;i<array.length;i++){
			int target = targetSum - array[i];
			int right=array.length-1, left=i+1; 
			while(left<right){
				int current = array[right] + array[left];
				if(target == current){
					Integer[] temp = {array[i], array[left], array[right]};
					arrayList.add(temp);
					left++;
					right--;
				} else if(target < current){
					right --;
				} else if(target > current){
					left ++;
				}
			}
		}
    return arrayList;
  }
}

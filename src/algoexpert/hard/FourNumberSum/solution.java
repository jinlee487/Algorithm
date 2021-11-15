package algoexpert.hard.FourNumberSum;

import java.util.*;

class Program1 {
  public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
    // Write your code here.
		// Average: )(n^2) time | O(n^2) space
		// worst O(n^3) time | O(n^2) space
		HashMap<Integer,List<Integer[]>> hash = new HashMap<Integer,List<Integer[]>>();
		List<Integer[]> answer = new ArrayList<Integer[]>();
		for(int i=1;i<array.length-1;i++){
			for(int j=i+1;j<array.length;j++){
				int key = array[i]+array[j];
				if(hash.containsKey(targetSum - key)){
					List<Integer[]> fromHash = hash.get(targetSum - key);
					for(Integer[] arr : fromHash){
						answer.add(new Integer[]{array[i],array[j],arr[0],arr[1]});
					}
				}
			}
			for(int j=0;j<i;j++){
				int key = array[i]+array[j];
				if(!hash.containsKey(key)) hash.put(key, new ArrayList<Integer[]>());
				hash.get(key).add(new Integer[]{array[i],array[j]});
			}	
		}
    return answer;
  }
}


class Program2 {
  public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
    // Write your code here.
		// O(n^4) time | O(1) space
		ArrayList<Integer[]> answer = new ArrayList<Integer[]>();
		for(int i=0;i<array.length;i++){
			for(int j=i+1;j<array.length;j++){
				for(int k=j+1;k<array.length;k++){
					for(int l=k+1;l<array.length;l++){
						if(array[i]+array[j]+array[k]+array[l]==targetSum) {
							answer.add(new Integer[] {array[i],array[j],array[k],array[l]});
						}
					}
				}
			}
		}
    return answer;
  }
}

package algoexpert.medium.GetPermutations;
import java.util.*;

class Program1 {
  public static List<List<Integer>> getPermutations(List<Integer> array) {
    // Write your code here.
		// upper bound: O(n^2n!) time | O(n*n!) space
		// O(n*n!) time | O(n*n!) space
		List<List<Integer>> answer = new ArrayList<List<Integer>>();
		getPermutations(array, new ArrayList<Integer>(), answer);
    return answer;
  }
	public static void getPermutations(List<Integer> array, List<Integer> current, List<List<Integer>> answer){
		if(array.size() == 0 && current.size()>0){
			answer.add(current);
			return;
		} 
		for(int i=0;i<array.size();i++){
			List<Integer> temp = new ArrayList<Integer>(array);
			temp.remove(i);
			List<Integer> permutation = new ArrayList<Integer>(current);
			permutation.add(array.get(i));
			getPermutations(temp, permutation, answer);
		}
	}
}

class Program2 {
    public static List<List<Integer>> getPermutations(List<Integer> array) {
      // Write your code here.
          // O(n*n!) time | O(n*n!) space
          List<List<Integer>> answer = new ArrayList<List<Integer>>();
          getPermutations(0,array,answer);
      return answer;
    }
      public static void getPermutations(int i, List<Integer> array, List<List<Integer>> answer){
          if(i==array.size()-1) answer.add(new ArrayList<Integer>(array));
          else {
              for(int j=i;j<array.size();j++){
                  swap(array,i,j);
                  getPermutations(i+1,array,answer);
                  swap(array,i,j);
              }
          }		
      }
      public static void swap(List<Integer> array,int i, int j){
          Integer temp = array.get(i);
          array.set(i,array.get(j));
          array.set(j,temp);
      }
  }
  
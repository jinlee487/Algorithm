package algoexpert.medium.Powerset;

import java.util.*;

class Program1 {
  public static List<List<Integer>> powerset(List<Integer> array) {
    // Write your code here.
		// O(n*2^n) time | O(n*2^n) space
		List<List<Integer>> answer = new ArrayList<List<Integer>>();
		for (int i = 0; i < (1<<array.size()); i++) {
			List<Integer> combination = new ArrayList<Integer>();
			for (int j = 0; j < array.size(); j++) {
				if( (i & (1<<j)) > 0 ) {
					combination.add(array.get(j));
				}	
			}
			answer.add(combination);
		}
    return answer;
  }
}

class Program2 {
    public static List<List<Integer>> powerset(List<Integer> array) {
      // Write your code here.
      return powerset(array,array.size()-1);
    }
      public static List<List<Integer>> powerset(List<Integer> array, int idx){
          if(idx<0){
              List<List<Integer>> empty = new ArrayList<List<Integer>>();
              empty.add(new ArrayList<Integer>());
              return empty;
          }
          int value = array.get(idx);
          List<List<Integer>> subsets = powerset(array,idx - 1);		
          int length = subsets.size();
          for(int i=0;i<length;i++){
              List<Integer> current = new ArrayList<Integer>(subsets.get(i));
              current.add(value);
              subsets.add(current);
          }
          return subsets;
      }
  }
  
class Program3 {
    public static List<List<Integer>> powerset(List<Integer> array) {
      // Write your code here.
          List<List<Integer>> subsets = new ArrayList<List<Integer>>();
          subsets.add(new ArrayList<Integer>());
          for(Integer v : array){
              int length = subsets.size();
              for(int i=0;i<length;i++){
                  List<Integer> current = new ArrayList<Integer>(subsets.get(i));
                  current.add(v);
                  subsets.add(current);
              }
          }
      return subsets;
    }
  }
  
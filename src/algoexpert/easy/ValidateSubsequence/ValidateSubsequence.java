import java.util.*;

class Program {
  public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
    // O(n) time | O(1) space n is the length of the array
		int j=0;
		for(int i=0;i<array.size()&&j<sequence.size();i++){
			if(array.get(i)==sequence.get(j)){
				j+=1; 
			} 			
		}
    return j==sequence.size();
  }
}

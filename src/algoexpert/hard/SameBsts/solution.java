package algoexpert.hard.SameBsts;
import java.util.*;

class Program1 {
  public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
    // Write your code here.
		// O(n^2) time | O(n^2) space
		if(arrayOne.size()!= arrayTwo.size()) return false;
		if(arrayOne.size() == 0 && arrayTwo.size() == 0) return true;
		if(arrayOne.get(0) != arrayTwo.get(0)) return false;

		List<Integer> leftOne = getSmaller(arrayOne);
		List<Integer> leftTwo = getSmaller(arrayTwo);
		List<Integer> rightOne = getBiggerOrEqual(arrayOne);
		List<Integer> rightTwo = getBiggerOrEqual(arrayTwo);
    return sameBsts(leftOne, leftTwo) && sameBsts(rightOne, rightTwo);
  }
	public static List<Integer> getSmaller(List<Integer> array){
		List<Integer> smaller = new ArrayList<Integer>();
		for(int i=1;i<array.size();i++){
			if(array.get(i) < array.get(0)) smaller.add(array.get(i));
		}
		return smaller;
	}
	public static List<Integer> getBiggerOrEqual(List<Integer> array){
		List<Integer> biggerOrEqual = new ArrayList<Integer>();
		for(int i=1;i<array.size();i++){
			if(array.get(i) >= array.get(0)) biggerOrEqual.add(array.get(i));
		}
		return biggerOrEqual;
	}
}

class Program2 {
  public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
    // Write your code here.
		// O(n^2) time | O(d) space
    return sameBsts(arrayOne, arrayTwo, 0,0, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
	public static boolean sameBsts(
		List<Integer> arrayOne,
		List<Integer> arrayTwo,
		int rootIdxOne,
		int rootIdxTwo,
		int minVal,
		int maxVal) {
		if(rootIdxOne == -1 || rootIdxTwo == -1) return rootIdxOne == rootIdxTwo;
		if(arrayOne.get(rootIdxOne) != arrayTwo.get(rootIdxTwo)) return false;
		
		int leftRootIdxOne = getIdxOfFirstSmaller(arrayOne, rootIdxOne, minVal);
		int leftRootIdxTwo = getIdxOfFirstSmaller(arrayTwo, rootIdxTwo, minVal);
		int rightRootIdxOne = getIdxOfFirstBiggerOrEqual(arrayOne, rootIdxOne, maxVal);
		int rightRootIdxTwo = getIdxOfFirstBiggerOrEqual(arrayTwo, rootIdxTwo, maxVal);
		
		int currentValue = arrayOne.get(rootIdxOne);
		boolean leftAreSame = sameBsts(arrayOne, arrayTwo, leftRootIdxOne, leftRootIdxTwo, minVal, currentValue);
		boolean rightAreSame = sameBsts(arrayOne, arrayTwo, rightRootIdxOne, rightRootIdxTwo, currentValue, maxVal);
		return leftAreSame && rightAreSame;
	}
	public static int getIdxOfFirstSmaller(List<Integer> array, int startingIdx, int minVal){
		for(int i=startingIdx+1;i<array.size();i++){
			if(array.get(i) < array.get(startingIdx)){
				if(minVal<=array.get(i)){
					return i;
				}
			}
		}
		return -1;
	}
	public static int getIdxOfFirstBiggerOrEqual(List<Integer> array, int startingIdx, int maxVal){
		for(int i=startingIdx+1;i<array.size();i++){
			if(array.get(startingIdx) <= array.get(i)){
				if(array.get(i) <= maxVal){
					return i;
				}
			}
		}
		return -1;
	}
}

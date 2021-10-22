package algoexpert.medium.HasSingleCycle;
import java.util.*;

class Program {
  public static boolean hasSingleCycle(int[] array) {
    // Write your code here.
		// o(n) time | o(1) space
		int visited = 0;
		int current = 0;
		while(visited<array.length){
			if(visited>0 && current==0) return false;
			visited++;
			current = getNext(current,array);
		}
		return current == 0;
  }
	public static int getNext(int current, int[] array){
		int jump = array[current];
		int next = (current+jump)%array.length;
		return next >= 0 ? next : next + array.length;
	}
}

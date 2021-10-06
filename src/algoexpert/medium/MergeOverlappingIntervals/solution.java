package algoexpert.medium.MergeOverlappingIntervals;

import java.util.*;

class Program {

  public int[][] mergeOverlappingIntervals(int[][] intervals) {
    // Write your code here.
		ArrayList<int[]> answer = new ArrayList<int[]>();
		Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
		int[] currentInterval = intervals[0];
		answer.add(currentInterval);
		for(int[] nextInterval : intervals){
			int currentEnd = currentInterval[1];
			int nextStart = nextInterval[0];
			int nextEnd = nextInterval[1];
			
			if(currentEnd >= nextStart){
				currentInterval[1] = Math.max(currentEnd, nextEnd);
			} else {
				currentInterval = nextInterval;
				answer.add(currentInterval);
			}
		}
		

    return answer.toArray(new int[answer.size()][]);
  }
}

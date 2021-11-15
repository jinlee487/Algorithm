package algoexpert.hard.SubarraySort;

import java.util.*;

class Program1 {
  public static int[] subarraySort(int[] array) {
    // Write your code here.
		int minimum = Integer.MAX_VALUE;
		int maximum = Integer.MIN_VALUE;		
		for(int i=0;i<array.length;i++){
			int num = array[i];
			if(check(i,num,array)){
				minimum = Math.min(minimum,num);
				maximum = Math.max(maximum,num);
			}
		}
		if(minimum == Integer.MAX_VALUE) return new int[]{-1,-1};
		int start = 0;
		int end = array.length-1;
		while(minimum >= array[start]) start++;
		while(maximum <= array[end]) end--;
    return new int[] {start,end};
  }
	public static boolean check(int i, int num, int[] array){
		if (i==0) return num > array[i+1];
		if (i == array.length -1) return num < array[i-1];
		return num > array[i+1] || num < array[i-1];
	}
}

class Program2 {
    public static int[] subarraySort(int[] array) {
      // Write your code here.
          // O(n^2) time | O(1) space
          int max = Integer.MIN_VALUE;
          int start = Integer.MAX_VALUE;
          int end = Integer.MIN_VALUE;
          for(int i=0;i<array.length;i++){
              if(max<array[i]) {
                  max = array[i];
                  continue;
              } else {
                  for(int j=i-1;0<=j;j--){
                      if(array[j]<=array[i]) break;
                      start = Math.min(start, j);
                  }
                  end = Math.max(end,i);
              }
          }
          int[] answer = new int[2];
          answer[0] = start == Integer.MAX_VALUE ? -1 : start;
          answer[1] = answer[0] == -1 ? -1 : end;
      return answer;
    }
  }
  
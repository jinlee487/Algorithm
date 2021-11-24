package algoexpert.hard.WaterArea;

import java.util.*;

class Program1 {
  public static int waterArea(int[] heights) {
    // Write your code here.
		// O(n) time | O(1) space
		if(heights.length==0) return 0;
		int[] maxArr = new int[2];
		for(int i=0;i<heights.length;i++){
			if(maxArr[0] < heights[i]) {
				maxArr[0] = heights[i];
				maxArr[1] = i;
			}
		}
		int answer = 0 ;
		int currentMaxHeight = heights[0];
		for(int i=0;i<maxArr[1];i++){
			if(currentMaxHeight<=heights[i]) currentMaxHeight = heights[i];
			else answer+=currentMaxHeight-heights[i];
		}
		currentMaxHeight = heights[heights.length-1];
		for(int i=heights.length-1;maxArr[1]<i;i--){
			if(currentMaxHeight<=heights[i]) currentMaxHeight = heights[i];
			else answer+=currentMaxHeight-heights[i];
		}		
    return answer;
  }
}

class Program2 {
  public static int waterArea(int[] heights) {
    // Write your code here.
		// O(n) time | O(n) space
		int[] maxes = new int[heights.length];
		int leftMax = 0;
		for(int i=0;i<heights.length;i++){
			int height = heights[i];
			maxes[i] = leftMax;
			leftMax = Math.max(leftMax, height);
		}
		int rightMax = 0;
		for(int i=heights.length-1;i>=0;i--){
			int height = heights[i];
			int minHeight = Math.min(rightMax,maxes[i]);
			if(height < minHeight){
				maxes[i] = minHeight - height;
			} else {
				maxes[i] = 0;
			}
			rightMax = Math.max(rightMax, height);
		}
		int total = 0;
		for(int i=0; i< heights.length; i++){
			total += maxes[i];
		}
    return total;
  }
}

class Program3 {
  public static int waterArea(int[] heights) {
    // Write your code here.
		// O(n) time | O(1) space
		if(heights.length==0) return 0;
		int leftIdx = 0;
		int rightIdx = heights.length-1;
		int leftMax = heights[leftIdx];
		int rightMax = heights[rightIdx];
		int surfaceArea = 0;
		
		while(leftIdx < rightIdx){
			if(heights[leftIdx] < heights[rightIdx]){
				leftIdx ++;
				leftMax = Math.max(leftMax, heights[leftIdx]);
				surfaceArea += leftMax - heights[leftIdx];
			} else {
				rightIdx --;
				rightMax = Math.max(rightMax, heights[rightIdx]);
				surfaceArea += rightMax - heights[rightIdx];
			}
		}
    return surfaceArea;
  }
}

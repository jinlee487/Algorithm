package Stack_Queue;

import java.util.Arrays;

public class Tower {
	public static void main(String[] args) {
		int[] heights = {1,5,3,6,7,6,5};
		System.out.println(Arrays.toString(solution(heights)));
	}
	public static int[] solution(int[] heights) {
		int[] answer = new int[heights.length];
		next:
	    for (int i=heights.length-1;0<=i;i--) {
	    	int curr = heights[i];
	    	for(int j=i-1;0<=j;j--) {
	    		if(curr<heights[j]) {
	    			answer[i]=j+1;
	    			continue next;
	    		}
	    	}
	    }
		return answer;
	}
}

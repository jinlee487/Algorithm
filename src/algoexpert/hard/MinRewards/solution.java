package algoexpert.hard.MinRewards;
import java.util.*;
import java.util.stream.*;

class Program1 {
  public static int minRewards(int[] scores) {
    // Write your code here.
		// O(n^2) time | O(n) space
		int[] arr = new int[scores.length];
		Arrays.fill(arr,1);
		int answer = 0;
		arr[0] = 1;
		for(int i=1;i<scores.length;i++){
			int j = i-1;
			if(scores[i]>scores[j]){
				arr[i] = arr[j] +  1;
			} else {
				while(j >=0 && scores[j] > scores[j+1]){
					arr[j] = Math.max(arr[j] , arr[j+1] + 1);
					j--;
				}
			}
		}
		for(int i : arr) answer += i;
		return answer;
	}
}	

class Program2 {
  public static int minRewards(int[] scores) {
    // Write your code here.
		// 0(n) time | O(n) space
		int[] array = new int[scores.length];
		List<Integer> minarray = new ArrayList<Integer>();
		for(int i=0;i<scores.length;i++){
			if(scores.length==1) {
				minarray.add(0);
				break;
			}
			if( 0<i && i<scores.length-1 ){
				if(scores[i]<scores[i-1]&&scores[i]<scores[i+1]) minarray.add(i);
			} 
			else if(i==0 && scores[i]<scores[i+1]) minarray.add(i);
			else if(i==scores.length-1 && scores[i]<scores[i-1]) minarray.add(i);
		}
		for(Integer index : minarray){
			array[index] = 1;
			int left = index-1;
			int right = index+1;
			while(0<=left){
				if(scores[left]>scores[left+1]) 
					array[left] = Math.max(array[left+1]+1,array[left--]);
				else break;
			}
			while(right<=scores.length-1){
				System.out.println(right);
				if(scores[right]>scores[right-1]) {
					array[right] = Math.max(array[right-1]+1,array[right]);
					System.out.println(Arrays.toString(array));
					right++;
				}
				else break;
			}		
		}
		int answer = 0 ;
		for(int i : array) answer += i;
    return answer;
  }
}

class Program3 {
    public static int minRewards(int[] scores) {
      // Write your code here.
          // 0(n) time | O(n) space
          int[] array = new int[scores.length];
          Arrays.fill(array,1);
          for(int i=1;i<scores.length;i++){
              if(scores[i-1]<scores[i]) array[i] = Math.max(array[i],array[i-1]+1);
          }
          for(int i=scores.length-2;0<=i;i--){
              if(scores[i+1]<scores[i]) array[i] = Math.max(array[i],array[i+1]+1);
          } 
      return IntStream.of(array).sum();
    }
  }
  
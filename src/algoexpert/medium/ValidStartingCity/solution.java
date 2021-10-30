package algoexpert.medium.ValidStartingCity;

import java.util.*;

class Program1 {

  public int validStartingCity(int[] distances, int[] fuel, int mpg) {
    // Write your code here.
		// O(n^2) time | O(1) space
		int mile;
		int current,start;
		int answer = -1;
		for(int i=0;i<distances.length;i++){
			current = i;
			start = i;
			mile = 0;
			do{
				mile += fuel[current]*mpg;
				mile -= distances[current++];
				if(mile<0) break;
				if(distances.length<=current) current = 0;
			}
			while(current!=start);
			if(current==start) return i;
		}
    return answer;
  }
}

class Program2 {

  public int validStartingCity(int[] distances, int[] fuel, int mpg) {
    // Write your code here.
		int mile = 0;
		int current = 0;
		int count = 0;
		int i = 0;
		while(true){
			if(distances.length*2<=i){
				break;
			}
			mile += fuel[current]*mpg;
			mile -= distances[current];
			i++;
			if(mile<0) {
				count =0;
				current ++;
				mile = 0;
				continue;
			}
			current ++;
			count ++;
			if(distances.length<=current) current = 0;
			if(count==distances.length) return current;
		} 
    return -1;
  }
}

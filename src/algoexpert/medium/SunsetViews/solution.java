package algoexpert.medium.SunsetViews;

import java.util.*;

class Program1 {

  public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
    // Write your code here.
		ArrayList<Integer> answer = new ArrayList<Integer>();
		if(direction.equals("EAST")) right(answer,buildings);
		else left(answer, buildings);
    return answer;
  }
	public void left(ArrayList<Integer> answer, int[] buildings){
		int max = Integer.MIN_VALUE;
		for(int i=0;i<buildings.length;i++){
			if(buildings[i]<=max) continue;
			answer.add(i);
			max = buildings[i];
		}
	}
	public void right(ArrayList<Integer> answer, int[] buildings){
		int max = Integer.MIN_VALUE;
		for(int i=buildings.length-1;0<=i;i--){
			if(buildings[i]<=max) continue;
			answer.add(i);
			max = buildings[i];
		}
		Collections.reverse(answer);
	}
}
class Program2 {

    public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
      // Write your code here.
          ArrayList<Integer> answer = new ArrayList<Integer>();
          int start = buildings.length-1;
          int step = -1;
          if(direction.equals("EAST")){
              start = 0;
              step = 1;
          }
          int idx = start;
          while(idx >= 0 && idx < buildings.length){
              while(answer.size()>0 
                          && buildings[answer.get(answer.size()-1)] <=buildings[idx]){
                  answer.remove(answer.size()-1);		 
              }
              answer.add(idx);
              idx+=step;
          }
          if(direction.equals("WEST")) Collections.reverse(answer);
      return answer;
    }
  }
  
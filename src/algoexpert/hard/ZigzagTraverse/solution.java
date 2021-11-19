package algoexpert.hard.ZigzagTraverse;

import java.util.*;

class Program {
  public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
    // Write your code here.
		int row = array.size()-1;
		int column = array.get(0).size()-1;
		int i = 0;
		int j = 0;
		ArrayList<Integer> answer = new ArrayList<Integer>();
		answer.add(array.get(i).get(j));
		while(i<=row && j<=column){
			// down
			if((i+j)%2==0){
				if(check(i+1,j-1,row,column)) answer.add(array.get(++i).get(--j));
				else if(check(i+1,j,row,column)) answer.add(array.get(++i).get(j));
				else if(check(i,j+1,row,column))answer.add(array.get(i).get(++j));
			} else {
				if(check(i-1,j+1,row,column)) answer.add(array.get(--i).get(++j));
				else if(check(i,j+1,row,column)) answer.add(array.get(i).get(++j));
				else if(check(i+1,j,row,column))answer.add(array.get(++i).get(j));
			}
			if(i==row && j==column) break;
		}
		return answer;
  }
	public static boolean check(int i, int j, int row, int column){
		if(i<0 || row<i) return false;
		if(j<0 || column<j) return false;
		return true;
	}
}

package algoexpert.hard.SolveSudoku;

import java.util.*;

class Program {

  public ArrayList<ArrayList<Integer>> solveSudoku(ArrayList<ArrayList<Integer>> board) {
    // Write your code here.
		ArrayList<Integer[]> arrayList = new ArrayList<Integer[]>();
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
		// for(int i=8;0<=i;i--){
		// 	for(int j=8;0<=j;j--){
				if(board.get(i).get(j) == 0) arrayList.add(new Integer[] {i,j});
			}
		}
		solveSudoku(arrayList,board);
    return board;
  }
	public boolean solveSudoku(ArrayList<Integer[]> arrayList, ArrayList<ArrayList<Integer>> board){
		if(arrayList.isEmpty()) return true;
		Integer[] indecies = arrayList.remove(arrayList.size()-1);
		int x = indecies[0];
		int y = indecies[1];

		for(int i=1;i<10;i++){
			board.get(x).set(y,i);
			if(check(x,y,board)) {
				if(solveSudoku(arrayList,board)) return true;
			}
			board.get(x).set(y,0);
		}	
		arrayList.add(indecies);
		return false; 
	}
	public boolean check(int x, int y, ArrayList<ArrayList<Integer>> board){
		int n = board.get(x).get(y);
		for(int i=0;i<9;i++){
			if(i==y) continue;
			int v = board.get(x).get(i);
			if(v==n) return false;
		}
		for(int i=0;i<9;i++){
			if(i==x) continue;
			int v = board.get(i).get(y);
			if(v==n) return false;
		}
		int nx = x/3 * 3;
		int ny = y/3 * 3;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(i+nx==x && j+ny==y) continue;
				int v = board.get(i+nx).get(j+ny);
				if(v==n) return false;
			}
		}
		return true;
	}
}

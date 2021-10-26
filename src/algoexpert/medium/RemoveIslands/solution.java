package algoexpert.medium.RemoveIslands;

import java.util.*;

class Program {

  public int[][] removeIslands(int[][] matrix) {
    // Write your code here.
		//O(wh) time | O(wh) space
		int[][] answer = new int[matrix.length][matrix[0].length];
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				if((0<i&&i<matrix.length-1)&&(0<j&&j<matrix[0].length-1)){
					continue;
				}
				if(matrix[i][j]==1){
					dfs(i,j,matrix,answer);
				}
			}
		}
    return answer;
  }
	public void dfs(int x, int y, int[][] matrix, int[][] answer){
		matrix[x][y] = 0;
		answer[x][y] = 1;
		int[] xarr = {0,0,1,-1};
		int[] yarr = {1,-1,0,0};
		
		for(int i=0;i<4;i++){
			int nx = xarr[i]+x;
			int ny = yarr[i]+y;			
			if(check(nx,ny,matrix)){
				dfs(nx,ny,matrix,answer);
			}
		}
		return;
	}
	public boolean check(int x, int y, int[][] matrix){
		if(x<0||matrix.length-1<x) return false;
		if(y<0||matrix[0].length-1<y) return false;
		if(matrix[x][y]==0) return false;
		return true;
	}
}

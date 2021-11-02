package algoexpert.medium.SearchInSortedMatrix;

import java.util.*;

class Program {
  public static int[] searchInSortedMatrix(int[][] matrix, int target) {
    // Write your code here.
		// O(n+m) time | O(1) space
		int row = 0;
		int col = matrix[0].length - 1;
		while(row<matrix.length && col >= 0){
			if(matrix[row][col]>target){
				col--;
			} else if(matrix[row][col]<target){
				row++;
			} else {
				return new int[] {row,col};
			}
		}
    return new int[] {-1, -1};
  }
}

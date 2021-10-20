package algoexpert.medium.NumberOfWaysToTraverseGraph;


import java.util.*;

class Program {

  public int numberOfWaysToTraverseGraph(int width, int height) {
    // Write your code here.	
		// O(2^n+m)) time | O(n+m) space 
		if(width == 1|| height == 1) return 1;
    return numberOfWaysToTraverseGraph(width-1, height)
			+ numberOfWaysToTraverseGraph(width, height-1);
  }
}

class Program1 {

    public int numberOfWaysToTraverseGraph(int width, int height) {
      // Write your code here.	
          // O(n*m)) time | O(n*m) space 
          // zero padding
          // dynamic programming
          int[][] arr = new int[height+1][width+1];
          for(int i=1;i<height+1;i++){
              for(int j=1;j<width+1;j++){
                  if(i==1||j==1){
                      arr[i][j] = 1;
                  } else {
                      arr[i][j] = arr[i-1][j] + arr[i][j-1];
                  }
              }
          }
          return arr[height][width];
    }
  }
  
  
class Program2 {

    public int numberOfWaysToTraverseGraph(int width, int height) {
      // Write your code here.
          // O(n+m) time | O(1) space 
          // not expected in a coding interview
      return factorial(width-1+height-1)/factorial(width-1)/factorial(height-1);
    }
      public int factorial(int n){
          int f=1;
          for(int i=1;i<n+1;i++){
              f*=i;
          }
          return f;
      }
  }
  
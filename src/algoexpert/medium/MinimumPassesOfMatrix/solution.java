package algoexpert.medium.MinimumPassesOfMatrix;


import java.util.*;

class Program {
	
  public int minimumPassesOfMatrix(int[][] matrix) {
    // Write your code here.
    int count = 0 ;
		boolean[] test = new boolean[1];
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[i].length;j++){
				if(matrix[i][j]<0){
					count = Math.max(count,bfs(matrix, i, j));
				}
			}
		}
		return count<Integer.MAX_VALUE ? count : -1;
  }
	public int bfs(int[][] matrix, int x, int y){
		int[] xarr = {0,0,1,-1};
		int[] yarr = {1,-1,0,0};
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		int nx, ny;
		Queue<Integer[]> que = new LinkedList<Integer[]>();
		Integer[] arr = {x,y,0};
		que.add(arr);
		while(!que.isEmpty()){
			Integer[] current = que.poll();
			visited[current[0]][current[1]] = true;
			for(int i=0;i<4;i++){
				nx = xarr[i] + current[0];
				ny = yarr[i] + current[1];
				if(check(nx,ny,matrix,visited)){
					if(0<matrix[nx][ny]) return current[2]+1;
					Integer[] temp = {nx,ny,current[2]+1};
					que.add(temp);
				}
			}
		}
		return Integer.MAX_VALUE;
	}
	public boolean check(int x, int y,int[][] matrix, boolean[][] visited){
		if(x<0||matrix.length<=x) return false;
		if(y<0||matrix[0].length<=y) return false;
		if(visited[x][y]) return false;
		if(matrix[x][y]==0) return false;
		return true;
	}
}

class Program1 {
	
  public int minimumPassesOfMatrix(int[][] matrix) {
    // Write your code here.
		int count = bfs(matrix);
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				if(matrix[i][j]<0) {
					return -1;
				}
			}	
		}
		return count;
  }
	public int bfs(int[][] matrix){
		int[] xarr = {0,0,1,-1};
		int[] yarr = {1,-1,0,0};
		int nx, ny, count=0;
		Queue<Integer[]> que = new LinkedList<Integer[]>();
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				if(0<matrix[i][j]) {
					Integer[] arr = {i,j,0};
					que.add(arr);
				}
			}	
		}
		while(!que.isEmpty()){
			Integer[] current = que.poll();
			System.out.println(Arrays.toString(current));
			count = Math.max(current[2],count);
			for(int i=0;i<4;i++){
				nx = xarr[i] + current[0];
				ny = yarr[i] + current[1];
				if(check(nx,ny,matrix)){
					matrix[nx][ny] *= -1;
					Integer[] temp = {nx,ny,current[2]+1};
					que.add(temp);
				}
			}
		}
		return count;
	}
	public boolean check(int x, int y,int[][] matrix){
		if(x<0||matrix.length<=x) return false;
		if(y<0||matrix[0].length<=y) return false;
		if(0<=matrix[x][y]) return false;
		return true;
	}
}



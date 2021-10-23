package algoexpert.medium.RiverSizes;

import java.util.*;

class Program {
  public static List<Integer> riverSizes(int[][] matrix) {
    // Write your code here.
		// O(wh) or O(n) time | O(wh) space
		int[] xarr = {0, 0, 1, -1};
		int[] yarr = {1, -1, 0, 0};
		ArrayList<Integer> answer = new ArrayList<Integer>();
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[i].length;j++){
				if(matrix[i][j]==1 && !visited[i][j]){
					answer.add(dfs(i,j,matrix,visited,xarr,yarr,1));
				}
			}
		}
    return answer;
  }
	public static int dfs(int x, int y, int[][] matrix, boolean[][] visited, int[] xarr, int[] yarr,int count){
		visited[x][y] = true;
		for(int i=0;i<4;i++){
			int nx = x + xarr[i];
			int ny = y + yarr[i];
			if(check(nx,ny,matrix,visited)){
				count = dfs(nx,ny,matrix,visited,xarr,yarr,count+1);
			}
		}
		return count;
	}
	public static boolean check(int x, int y,int[][] matrix, boolean[][] visited){
		if(x<0 || x>=matrix.length || y<0 || y>=matrix[x].length) return false;
		if(visited[x][y]) return false;
		if(matrix[x][y]!=1) return false;
		return true;
	}
}

class Program1 {
  public static List<Integer> riverSizes(int[][] matrix) {
    // Write your code here.
		ArrayList<Integer> answer = new ArrayList<Integer>();
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				if(!visited[i][j]){
					traverseNode(i,j,matrix,visited,answer);
				}
			}
		}
    return answer;
  }
	public static void traverseNode(int i,int j, int[][] matrix, boolean[][] visited, List<Integer> answer){
		int current = 0;
		Stack<Integer[]> nodes = new Stack<Integer[]>();
		nodes.push(new Integer[]{i,j});
		while(!nodes.empty()){
			Integer[] currentNode = nodes.pop();
			i = currentNode[0];
			j = currentNode[1];
			if(visited[i][j]){
				continue;
			}
			visited[i][j] = true;
			if(matrix[i][j] == 0){
				continue;
			}
			current ++;
			List<Integer[]> neighbors = getNeighbors(i,j,matrix,visited);
			for(Integer[] neighbor : neighbors){
				nodes.add(neighbor);
			}
		}
		if(current>0){
			answer.add(current);
		}
	}
	public static List<Integer[]> getNeighbors(int i,int j, int[][] matrix, boolean[][] visited){
		List<Integer[]> neighbors = new ArrayList<Integer[]>();
		int[] iarr = {0,0,1,-1};
		int[] jarr = {1,-1,0,0};
		for(int k=0;k<4;k++){
			int ni = i+iarr[k];
			int nj = j+jarr[k];
			if(ni<0||ni>=matrix.length||nj<0||nj>=matrix[ni].length){
				continue;
			}
			neighbors.add(new Integer[] {ni,nj});
		}
		return neighbors;
	}
}

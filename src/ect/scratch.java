package ect;

public class scratch {
	static int N = 5;
	public static void main(String[] args) {
		int[][] board = new int[15][15];
		board[1][4]=8;
		board[4][3]=9;
		printboard(board);
		
	}
    static void printboard(int[][]board) {
    	for(int i=1;i<N+1;i++) {
    		for (int j=1;j<N+1;j++) {
    			System.out.printf("%d ",board[i][j]);
    		}
    		System.out.println("");
    	} 
    }
}

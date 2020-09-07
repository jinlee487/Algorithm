package back_tracking;
/*
 * https://www.acmicpc.net/problem/9663
 * N-Queen
 */
import java.util.Scanner;

public class N_Queen {
	static int N;
	static int input[][]; 
	static int board[][]; 
    static int total=0;
    static int x;
    static int y;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
	    N = sc.nextInt();
	    sc.close();
	    input = new int[15][15];
    	for(int i=1;i<N+1;i++) {
			input=visiting(i,1,input);
			dfs(1,1,1,input);
			input[i][1]=0;
    	}
		System.out.println(total);
    }
    static void dfs(int idx, int yidx,int cnt, int[][] board) {
//    	System.out.println("*new dfs*");
    	int[][]temp = new int [15][15];
    	for (int i = 0; i < 15; i++) {
    		temp[i] = board[i].clone();
    	}
    	if(cnt==N) {
//    		System.out.println("********this is the current total => "+total);
    		total+=1;
    		return;
    	}
//   	System.out.printf("initial i, j and cnt and total=> (%d,%d,%d,%d)\n",idx,yidx,cnt,total);

    	for(int i=idx;i<N+1;i++) {
//    		if(2<i){
//    			System.out.println("*********************\n*********************\n=> "+i);
//    			System.out.println("board");
//    			printboard(board);
//    		}
			for (int j=1;j<N+1;j++) {
				if(checking(i,j,board)==false) 
					continue;
				board=visiting(i,j,board);
//				System.out.println("board");
//				printboard(board);
//		    	System.out.printf("visiting i, j, cnt and total=> (%d,%d,%d,%d)\n",i,j,cnt+1,total);
	    	
				dfs(i,j,cnt+1,board);
		    	for (int k = 0; k < 15; k++) {
		    		board[k] = temp[k].clone();
		    	}
    		}
    	}
    	return;
    }
    static void printboard(int[][]board) {
    	for(int i=1;i<N+1;i++) {
    		for (int j=1;j<N+1;j++) {
    			System.out.printf("%d ",board[i][j]);
    		}
    		System.out.println("");
    	} 
    }
    static boolean checking(int i, int j,int[][] board) {
    	x=1;
		y=j;
		while(x<N+1) {	
			if(board[x][y]==9) return false;
			x++;
		}
		//y-axis
		x=i;
		y=1;
		while(y<N+1) {	
			if(board[x][y]==9) return false;
			y++;
		}
		//up-diag
		x=i;
		y=j;
		while(0<y&&x<N+1) {	
			if(board[x][y]==9) return false;
			y--;
			x++;
		}
		x=i;
		y=j;
		while(0<x&&y<N+1) {	
			if(board[x][y]==9) return false;
			y++;
			x--;
		}
		//down-diag
		x=i;
		y=j;
		while(y<N+1&&x<N+1) {	
			if(board[x][y]==9) return false;
			y++;
			x++;
		}
		x=i;
		y=j;
		while(0<x&&0<y) {	
			if(board[x][y]==9) return false;
			y--;
			x--;
		}
		return true;
    }
    static int[][] visiting(int i, int j,int[][] board) {    	
		x=1;
		y=j;
		while(x<N+1) {	
			board[x][y]=1 ;
			x++;
		}
		//y-axis
		x=i;
		y=1;
		while(y<N+1) {	
			board[x][y]=1;
			y++;
		}
		//up-diag
		x=i;
		y=j;
		while(0<y&&x<N+1) {	
			board[x][y]=1;
			y--;
			x++;
		}
		x=i;
		y=j;
		while(0<x&&y<N+1) {	
			board[x][y]=1;
			y++;
			x--;
		}
		//down-diag
		x=i;
		y=j;
		while(y<N+1&&x<N+1) {	
			board[x][y]=1;
			y++;
			x++;
		}
		x=i;
		y=j;
		while(0<x&&0<y) {	
			board[x][y]=1;
			y--;
			x--;
		}
		board[i][j]=9;
		return board;
    }
//    static int[][] not_visiting(int i, int j, int[][] board) {
//    	int[][]temp = new int [15][15];
//		for (int ti=1;i<N+1;i++) {
//			for (int tj=1;j<N+1;j++) {
//				if (ti==i&&tj==j)
//					continue;
//				else if (board[ti][tj]==9)
//					temp=visiting(ti,tj,temp);
//			}
//		}
//		board = temp;
//		return board; 
//		
//    }
//    
}

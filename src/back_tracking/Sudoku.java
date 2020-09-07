package back_tracking;
/*
 * Solved!!
 * https://www.acmicpc.net/problem/2580
 * 스도쿠
 */
import java.util.Scanner;

public class Sudoku {
	static int[] ilist; // keeps i index of the location of board where value = 0 
	static int[] jlist; //keeps j index of the location of board where value = 0 
	static int[][] board; 
	static int count=0; // counter for list, ilist and j list
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		board = new int[10][10];
		ilist = new int[100];
		jlist = new int[100];
		//[height][row]
		for (int i=1;i<10;i++) {
			for (int j=1;j<10;j++) {
				board[i][j]=sc.nextInt();
				if(board[i][j]==0) {
					ilist[count]=i;
					jlist[count]=j;
					count++;
				}
			}
		}
		sc.close();
		dfs(0); 
	}
    static void printboard(int[][]board) {
    	for(int i=1;i<10;i++) {
    		for (int j=1;j<10;j++) {
    			System.out.printf("%d ",board[i][j]);
    		}
    		System.out.println("");
    	} 
    }
	static void dfs(int cnt) {
		if(cnt==count) {
			printboard(board);
			System.exit(0);
//			return false;
		}
		for (int i=1;i<=9;i++) {
			if(checking(i,cnt)==false) {
				continue;
			}
			else {
				board[ilist[cnt]][jlist[cnt]]=i;
				dfs(cnt+1);
//				boolean cont=dfs(cnt+1);
//				if (cont==false)
//					return false;
				board[ilist[cnt]][jlist[cnt]]=0;
			}
		}
//		return true;
	}
	static boolean checking(int num,int cnt) {
		int height =ilist[cnt];
		int row =jlist[cnt];
		//dfs[i][j];
		//horizontal
		for (int i=1;i<10;i++) 
			if (board[height][i]==num)
				return false;
		//vertical
		for (int i=1;i<10;i++)
			if (board[i][row]==num)
				return false;
		//mini squre
		int hb = 0,ht=0,rb=0,rt=0;
		if (height<4) {hb=1;ht=3;}
		else if (3<height&&height<7) {hb=4;ht=6;}
		else if (6<height) {hb=7;ht=9;}
		if (row<4) {rb=1;rt=3;}
		else if (3<row&&row<7) {rb=4;rt=6;}
		else if (6<row) {rb=7;rt=9;}
		for (int i=hb;i<ht+1;i++) {
			for (int j=rb;j<rt+1;j++) {
				if(board[i][j]==num)
					return false;
			}
		}
		return true;
	}
}

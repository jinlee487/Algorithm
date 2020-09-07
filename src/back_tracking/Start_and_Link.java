package back_tracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * Solved!
 * https://www.acmicpc.net/problem/14889
 * 스타트와 링크
 * https://bcp0109.tistory.com/30
 */
public class Start_and_Link {
	static int[] team; // keeps i index of the location of board where value = 0 
	static int[][] board; 
	static int[] players;
	static int N;
	static int output=2147483647;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		board = new int[N+1][N+1];
		team = new int[N+1];
		players = new int[N+1];
        for(int i=1; i<N+1; i++) {
        	players[i]=i;
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<N+1; j++) {
            	board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
		br.close();
		dfs(1,0);
		System.out.println(output);
	}
	public static void dfs(int idx, int cnt){
		if (cnt==N/2) {
			output = Math.min(output, calc(team,players));
			if (output == 0) {
				System.out.println(output);
				System.exit(0);
				}
			return;
		}
		for (int i=idx;i<N+1;i++) {
			if (players[i]==0) continue;
			int temp=players[i];
			players[i]=0;
			team[i]=temp;
			dfs(i+1,cnt+1);
			team[i]=0;
			players[i]=temp;
		}
		return;
	}	
	public static int calc(int[] start,int[] link) {
		int startsum=0;
		int linksum=0;
		for (int i=1;i<N+1;i++) {
			for (int j=1;j<N+1;j++) {
				if(start[i]!=0)
					startsum += board[start[i]][start[j]];
				else
					linksum += board[link[i]][link[j]];
			}
		}
		return Math.abs(startsum-linksum);
	}
//	public static void printarr() {
//		for (int i=1;i<players.length;i++) {
//			System.out.print(players[i]+" ");
//		}	
//	}
//	public static void printarr1() {
//		for (int i=1;i<team.length;i++) {
//			System.out.print(team[i]+" ");
//		}	
//	}
}

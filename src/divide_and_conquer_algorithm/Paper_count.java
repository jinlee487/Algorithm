package divide_and_conquer_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * Solved!!
 * https://www.acmicpc.net/problem/2630
 * 종이의 개수
 */
public class Paper_count {
    private static int[][] paper;
    static int zero,one,two,N;
    
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	String temp;
    	N = Integer.parseInt(br.readLine());
    	paper = new int[N][N];
    	for (int i=0;i<N;i++) {
    		st = new StringTokenizer(br.readLine()," ");
    		for (int j=0;j<N;j++) {
    			temp = st.nextToken();
    			if(temp.equals("0")) paper[i][j]=0;
    			else if(temp.equals("1")) paper[i][j]=1;
    			else paper[i][j]=2;
    		}
    	}	
//    	for (int i=0;i<N;i++) {
//    		System.out.println("");
//    		for (int j=0;j<N;j++) {
//    			System.out.print(paper[i][j]+" ");
//    		}
//    	}
//    	System.out.println("");
    	quadtree(0,0,N);
    	System.out.println(two);
    	System.out.println(zero);
    	System.out.println(one);
	}
	public static void quadtree(int y, int x, int n) {
		if (n>N)
			return;
		if(n == 1) {
			if (paper[y][x]==0) zero++;
			else if (paper[y][x]==1) one++;
			else two++;
			return; 
		}
		boolean isSame = true;
		int num = paper[y][x];
		out:
		for (int i=y;i<y+n;i++) {
			for (int j=x;j<x+n;j++) {
				if(paper[i][j]!=num) {
					isSame=false;
					break out;
				}
			}
		}
		if(isSame) {
			if(paper[y][x]==0) zero++;
			else if(paper[y][x]==1) one++;
			else two++;
			return; 
		}
		int nthird= n/3;
		
		quadtree(y, x, nthird);
		
		quadtree(y, x+nthird, nthird);
		quadtree(y, x +nthird +nthird, nthird);

		quadtree(y+nthird, x, nthird);
		quadtree(y+nthird+nthird, x, nthird);

		quadtree(y+nthird, x+nthird, nthird);
		
		quadtree(y+nthird+nthird, x+nthird, nthird);
		
		quadtree(y+nthird, x+nthird+nthird, nthird);

		quadtree(y+nthird+nthird, x+nthird+nthird, nthird);
	}
}













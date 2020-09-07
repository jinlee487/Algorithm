package dynamic_programming;

import java.util.Scanner;

/*
 * 
 * https://www.acmicpc.net/problem/9251
 * LCS
 */
public class LCS {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String x = sc.nextLine();
		String y = sc.nextLine();
		sc.close();
		char[] X = x.toCharArray(); 
	    char[] Y = y.toCharArray(); 
		int m = X.length; 
        int n = Y.length; 
        System.out.println(lcs(X,Y,m,n));
	}
	public static int lcs (char[] X, char[] Y, int m, int n) {
		int L[][] = new int [m+1][n+1];
		
        for (int i = 0; i <= m; i++) { 
            for (int j = 0; j <= n; j++) { 
                if (i == 0 || j == 0) //if length = > 0, return 0
                    L[i][j] = 0; 
                else if (X[i - 1] == Y[j - 1]) { // if the letters are the same, add
                    L[i][j] = L[i - 1][j - 1] + 1; 
               //     System.out.printf("\nX[%d - 1] == Y[%d - 1] => %c",i,j,(X[i - 1]));
                }
                else
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
            //    System.out.printf("\nL[%d][%d] => %d",i,j,L[i][j]);
            } 
        } 
        return L[m][n]; 
	}
}

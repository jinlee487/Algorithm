package divide_and_conquer_algorithm;
/*
 * https://onsil-thegreenhouse.github.io/programming/problem/2018/04/02/problem_combination/
 */
import java.util.Scanner;

public class Binomial3 {
	static long z = 1000000007;
	static long[][] dp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		dp = new long[N+1][N+1];
		sc.close();
		df(N);
//		for (int i=0;i<N+1;i++) {
//			for (int j=0;j<i+1;j++)
//				System.out.println(dp[i][j]);
//			System.out.println("");
//		}
		System.out.println((dp[N][K]%z));
	}
	public static void df(int n){
		dp[0][0] = 1;
		for (int i=1;i<n+1;i++) {
			for (int j=0;j<i+1;j++) {
				if (j==0||j==i) dp[i][j] = 1; 
				else dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
				dp[i][j] %=z;
			}
		}
		return;
	}

}

package dynamic_programming;
import java.util.Scanner;
import java.lang.Math;
public class Make_1_second {
    public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
		int[] dp = new int[n+1];
		
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;
    	
    	for(int i = 4; i<=n; i++) {
    		if(i%3==0)
    			dp[i] = Math.min(dp[i/3], dp[i-1]) + 1;
    		else if(i%2==0)
    			dp[i] = Math.min(dp[i/2], dp[i-1]) + 1;
    		else
    			dp[i] = dp[i-1] + 1;
    			
    	}
        System.out.println(dp[n]);
    }
}

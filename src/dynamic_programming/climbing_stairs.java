package dynamic_programming;
/*
 * Solved!
 * https://www.acmicpc.net/problem/2579
 * 계단 오르기 
 */
import java.util.Scanner;

public class climbing_stairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] stair = new int[N+1];
        long[] maxValue = new long[N+1];
        for (int i = 1; i <= N ; i++) {
            stair[i] = scanner.nextInt();
        }
        maxValue[1] = stair[1];
        if (N>1) {
	        maxValue[2] = stair[2] + stair[1];
	        if (N >= 3) {
	            maxValue[3] = Math.max(stair[1], stair[2]) + stair[3];
	            if (N >= 4)
	                for (int i = 4; i <= N; i++) {
	                    maxValue[i] = Math.max(maxValue[i - 3] + stair[i - 1], maxValue[i - 2]) + stair[i]; 
	                }
	        }
        }
        System.out.println(maxValue[N]);
        scanner.close();
    }
}


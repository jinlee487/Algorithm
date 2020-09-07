package dynamic_programming;
import java.util.Scanner;
/*
 * Solved!!
 * https://www.acmicpc.net/board/view/26971
 * https://www.acmicpc.net/problem/2156
 * 포도주 마시기
 */
public class drink_wine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt() + 2;
        
        int[] wine = new int[N+3];
        long[][] maxValue = new long[N+3][3];
        for (int i = 1; i < 3; i++) {
        	wine[i] = 0;
        }
        for (int i = 3; i < N+1; i++) {
        	wine[i] = scanner.nextInt();
        }
        for (int i = N+1; i<N+3;i++) {
        	wine[i]=0;
        }
        scanner.close();
     // 0은 앞에 것도 먹는다. 1은 앞에건 안먹는다  2는 안먹는다.

        for (int i = 3; i < N+3; i++) {
        	maxValue[i][0] = wine[i] + Math.max(maxValue[i-1][1], maxValue[i-1][2]);
        	maxValue[i][1] = wine[i] + Math.max(Math.max(maxValue[i-2][0], maxValue[i-2][1]), maxValue[i-2][2]);
        	maxValue[i][2] = wine[i] + Math.max(Math.max(maxValue[i-3][0], maxValue[i-3][1]), maxValue[i-3][2]);
            }
        long result = Math.max(Math.max(maxValue[N+2][0], maxValue[N+2][1]), maxValue[N+2][2]);
        System.out.println(result);
//        for (int i=1;i<N+3;i++) {
//        	System.out.println("\ni => " + i+ "\nwine[i] => " + wine[i] +"\nmaxValue[i][0] => " +maxValue[i][0] + "\nmaxValue[i][1] => " + maxValue[i][1] +"\nmaxValue[i][2] => " + maxValue[i][2]);
//        }
    }
}

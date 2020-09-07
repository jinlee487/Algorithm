package greedy_algorythm;

import java.util.Scanner;

/*
 * Solved!!
 * https://www.acmicpc.net/problem/11047
 * 동전0
 * 
 * 10 4200
1
5
10
50
100
500
1000
5000
10000
50000
 */
public class Coin_0 {
	static int N, K, sum;
	static int[] money;
	static int coin=0, number=0;
	
	public static void main(String[] args) {      
		Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        money = new int[N];
        for (int i=0;i<N;i++) {
        	money[i]=sc.nextInt();
        }
        sc.close();
        for (int i=N-1;-1<i;i--) {
        	coin = money[i];
        	while (sum+coin<=K) {
        		sum += coin;
        		number++;
        		//System.out.println(sum+" "+coin+" "+ number);
        	}
        }
        System.out.println(number);
	}
}

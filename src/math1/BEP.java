package math1;

import java.util.Scanner;

/*
 * Solved
 * https://www.acmicpc.net/problem/11050
 * 이항계수1
 * https://oper6210.tistory.com/76
 */
public class BEP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        sc.close();
        int bep;
        if (b >= c){
            System.out.println(-1);
        }
        else{
            bep = a/(c-b)+1;
            System.out.println(bep);
        }
	}
}

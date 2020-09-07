package brute_force;

import java.util.Scanner;

/*
 * 
 * https://www.acmicpc.net/problem/1436
 * 영화가독 숌 
 */
public class movie666 {
	static int x;
	static String num = "666";
	static int count = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        sc.close();
        for (int i=665;i<2147483647;i++) {
        	//https://stackoverflow.com/questions/17134773/to-check-if-string-contains-particular-word
        	if ( (Integer.toString(i)).indexOf(num) != -1 ) {
        		count++;
        	}
        	if (count == x) {
        		System.out.println(i);
        		break;
        	}
        }
	}
}

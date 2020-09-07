package string_manipulation;

import java.util.Scanner;

/*
 * Solved
 * https://www.acmicpc.net/problem/11654
 * 아스키 코드
 * https://stackoverflow.com/questions/16458564/convert-character-to-ascii-numeric-value-in-java
 */
public class ASCII_code {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		char N = sc.next().charAt(0); 
		sc.close();
		System.out.println((int) N);
	}
}


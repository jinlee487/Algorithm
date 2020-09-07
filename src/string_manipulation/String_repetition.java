package string_manipulation;

import java.util.HashMap;
import java.util.Scanner;

/*
 * Solved
 * https://www.acmicpc.net/problem/2675
 * 문자열 반복
 * 
 */
public class String_repetition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		int temp=0;
		String[] strings = new String[N];
		for (int i=0;i<N;i++) {
			strings[i] = sc.nextLine();
		}
		for(int i=0;i<N;i++) {
			String[] string = strings[i].split(" ");
			temp=Integer.parseInt(string[0]);
			String[] str = string[1].split("");
			for(String s: str) {
				for(int j=0;j<temp;j++) {
					System.out.print(s);
				}
			}
			System.out.println("");
		}
		sc.close();
	}
}

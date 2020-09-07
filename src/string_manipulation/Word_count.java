package string_manipulation;

import java.util.HashMap;
import java.util.Scanner;

/*
 * Solved
 * https://www.acmicpc.net/problem/1152
 * 단어 개수
 *
 * 
 */
public class Word_count {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		input=input.trim();
        if (input.length()==0) {
			System.out.println(0);
			System.exit(0);
		}
		System.out.println(input.split(" ").length);
		sc.close();
	}
}

package string_manipulation;

import java.util.HashMap;
import java.util.Scanner;

/*
 * Solved
 * https://www.acmicpc.net/problem/1157
 * 단어 공부
 *
 * 
 */
public class Studying_words {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		char[] input = sc.nextLine().trim().toCharArray();
		System.out.println("this is the length => " + input.length);
		if (input.length==0) {
			System.exit(0);
		}
		char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
		for (int i=0;i<alphabet.length;i++) {
			hash.put(alphabet[i],-1);
		}
		char temp = 0;
		for (int i=0;i<input.length;i++) {
			temp=Character.toUpperCase(input[i]);
			hash.put(temp,(hash.get(temp)+1));
		}
		hash.forEach((k,v) -> {
		    System.out.println(k + "[" + v + "]");
		});
		int max=0;
		int second=0;
		for (int i=0;i<alphabet.length;i++) {
			if(max<=hash.get(alphabet[i])) {
				System.out.println("this is the alphabet => " + alphabet[i]);
				second = max;
				max = hash.get(alphabet[i]);
				System.out.println("this is second => " + second);
				System.out.println("this is max => " + max);
				System.out.println("this is temp before=> " + temp);
				temp = alphabet[i];
				System.out.println("this is temp after=> " + temp);

			};	
		}
		if (second == max) {
			System.out.println("?");
		}
		else {
			System.out.println(temp);
		}
		sc.close();
	}
}


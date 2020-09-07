package string_manipulation;

import java.util.HashMap;
import java.util.Scanner;

/*
 * Solved
 * https://www.acmicpc.net/problem/10809
 * 알파벳 찾기
 * 
 */
public class Find_the_alphabet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
		for (int i=0;i<alphabet.length;i++) {
			hash.put(alphabet[i],-1);
		}
		char[] string = sc.nextLine().toCharArray();
		for (int i=0;i<string.length;i++) {
			if(hash.get(string[i]) == -1){
				hash.put(string[i], i);
			}
		}
		sc.close();
		for (Character keys : hash.keySet()){
		   System.out.print(hash.get(keys)+" ");
		}
		}
}
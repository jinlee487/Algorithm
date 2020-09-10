package dynamic_programming;

import java.util.Scanner;

/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/9095
 * 1,2,3 ?”?•˜ê¸? 
 * 
? •?ˆ˜ 4ë¥? 1, 2, 3?˜ ?•©?œ¼ë¡? ?‚˜???‚´?Š” ë°©ë²•?? ì´? 7ê°?ì§?ê°? ?ˆ?‹¤. ?•©?„ ?‚˜???‚¼ ?•Œ?Š” ?ˆ˜ë¥? 1ê°? ?´?ƒ ?‚¬?š©?•´?•¼ ?•œ?‹¤.
    1+1+1+1
    1+1+2
    1+2+1
    2+1+1
    2+2
    1+3
    3+1
? •?ˆ˜ n?´ ì£¼ì–´ì¡Œì„ ?•Œ, n?„ 1, 2, 3?˜ ?•©?œ¼ë¡? ?‚˜???‚´?Š” ë°©ë²•?˜ ?ˆ˜ë¥? êµ¬í•˜?Š” ?”„ë¡œê·¸?¨?„ ?‘?„±?•˜?‹œ?˜¤.
*/
public class Card_Game_2 {
	static int y;
	static int[] list;
	static int[] input;
	static Scanner sc = new Scanner(System.in);

	public static void printarray(int[] x) {
	for (int i=0;i<x.length;i++) {
		System.out.printf("%d\t",x[i]);
	}
	System.out.printf("\n");
	}
	public static void input_int() {
		int n = sc.nextInt();
		y = n;
	}
	public static void make_input_list() {
		input = new int[y+1];
		input[0] = 0;
		for(int i=1;i<=y;i++) {
			input[i]=sc.nextInt();
		}
	}
	public static void loop_input() {
		int max = 0;
		for (int i=1;i<=y;i++) {
			max = (max<input[i]? input[i]:max); 
		}
//		System.out.println("this is the max => "+max);
		list = new int[max+1];
		list[0] = 0;
		list[1] = 1;
		list[2] = 2;
		list[3] = 4;
		for(int i=1;i<=y;i++){	
			if(list[input[i]]>0) {
				System.out.println(list[input[i]]);
				continue;
			}
			System.out.println(calc(input[i]));
		}
	}
	public static int calc(int x) {
		if (x==0)
			return 0;
		if (list[x]>0)
			return list[x];
		for (int i=x-1;(x-i)<=3;i--) {
			list[x]=list[x]+calc(i);
		}
		return list[x];
	}
	public static void main(String[] args) {
		input_int();
		make_input_list();
//		printarray(input);
		loop_input();
	}
}
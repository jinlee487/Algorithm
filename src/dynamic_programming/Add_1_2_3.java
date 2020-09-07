package dynamic_programming;

import java.util.Scanner;

/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/9095
 * 1,2,3 더하기 
 * 
정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.
    1+1+1+1
    1+1+2
    1+2+1
    2+1+1
    2+2
    1+3
    3+1
정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.
*/
public class Add_1_2_3 {
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
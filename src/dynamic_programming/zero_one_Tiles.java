package dynamic_programming;

import java.util.Scanner;

/*
 * Solved!!
 * https://www.acmicpc.net/problem/1904
 * 01타일
 */
public class zero_one_Tiles {
	static int len;
	static Scanner sc = new Scanner(System.in);
	static int[] list;
	public static void input_int() {
		int n = sc.nextInt();
		len = n;
		list = new int[len+1];
	}
	public static void setup() {
		for (int i=0;i<list.length;i++)
			list[i]=-1;
		list[1] = 1;
		if (len>1)
			list[2] = 2;
	}
	public static int calc(int x) {
		if (x==1)
			return 1;
		if (x==2)
			return 2;
		if (list[x]>-1)
			return list[x];
		list[x] = (calc(x-1)+calc(x-2))%15746;
		return list[x];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input_int();
		setup();
		System.out.println(calc(len));	
	}
}

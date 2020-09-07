package dynamic_programming;
/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/2748
 * 피보나치 수 2 
 * 
 */
import java.util.Scanner;

public class fibonacci2 {
	static Scanner sc = new Scanner(System.in);
	static long input;
	//https://stackoverflow.com/questions/5857812/long-vs-integer-long-vs-int-what-to-use-and-when
	static long[] list;
	public static void input_number() {
		input = sc.nextInt(); 
		list = new long[(int) (input+1)];
	}
	public static void calc() {
		list[0] = 0;
		if(input!=0)
			list [1] = 1;
		for (int i=2;i<input+1;i++) {
			list[i]=list[i-1]+list[i-2];
		}
		System.out.println(list[(int) input]);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input_number();
		calc();
	}
}

package dynamic_programming;
/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/1003
 * 피보나치 함수 
 * 
 */
import java.util.Scanner;
public class fibonacci1 {
	static int len;
	static int[] one;
	static int[] zero;
	static int[] input;

	static Scanner sc = new Scanner(System.in);

	public static void input_int() {
		int n = sc.nextInt();
		len = n;
	}
	public static void make_input_list() {
		input = new int[len+1];
		input[0] = 0;
		for(int i=1;i<=len;i++) {
			input[i]=sc.nextInt();
		}
	}
	public static void loop_input() {
		int max = 0;
		for (int i=1;i<=len;i++) {
			max = (max<input[i]? input[i]:max); 
		}
		one = new int[max+1];
		zero = new int[max+1];
		for (int i=0;i<one.length;i++) {
			one[i]=-1;
			zero[i]=-1;
		}
		zero[0]=1;
		zero[1]=0;
		one[0]=0;
		one[1]=1;
		for (int i=1;i<len+1;i++)
			System.out.println(zfib(input[i]) + " "+ ofib(input[i]));
	}
	
	public static int zfib(int x) {
		if (x<0||x==1)   
			return 0; // manual input for list[1]
		
		if (zero[x] > -1) 
			return zero[x];//if list[number] is more than -1, 
								//this will help to reduce the loop 
								//because previous minimum steps have already been calculated 
		zero[x]=zfib(x-1)+zfib(x-2);
		return zero[x];
	}
	public static int ofib(int x) {
		if (x<0)   
			return 0; // manual input for list[1]
		if (one[x] > -1) 
			return one[x];//if list[number] is more than -1, 
								//this will help to reduce the loop 
								//because previous minimum steps have already been calculated 
		one[x]=ofib(x-1)+ofib(x-2);
		return one[x];
	}
	public static void main(String[] args) {
		input_int();
		make_input_list();
		loop_input();
	}
}


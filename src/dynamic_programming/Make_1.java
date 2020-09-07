package dynamic_programming;

import java.util.Scanner;
import java.lang.Math;

/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/1463
 * 1로 만들기
 * https://www.geeksforgeeks.org/minimum-steps-minimize-n-per-given-condition/
 * 
 * example = 20 
 * 180 is a factor of => 1 2 2 3 3 5 
 * 왜 Exception in thread "main" java.lang.StackOverflowError 
 */
public class Make_1 {
	static int number;
	static int result;
	static int[] list;
	public static int calc(int number) {
		if (number == 1)   
			return 0; // manual input for list[1]
		if (list[number] > 0) 
			return list[number];//if list[number] is more than 0, 
								//this will help to reduce the loop 
								//because previous minimum steps have already been calculated 
		list[number] = calc(number-1) + 1;
		//steps it takes to only subtract 1
		if (number%3==0) list[number] = Math.min(list[number], calc(number/3)+1);
		if(number%2==0) list[number] = Math.min(list[number], calc(number/2)+1);
		// replaces the number if there is lesser steps required
		return list[number];
	}
	public static void inputint() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		number = n;
		sc.close();
	}
	public static void main(String[] args) {
		inputint();
	    list = new int[number+1];
		result=calc(number);
		System.out.println(result);
	}
}
//	public void cont() {
//		System.out.println("계속 하시겠습니까? (y/n) => ");
//		//https://www.geeksforgeeks.org/why-is-scanner-skipping-nextline-after-use-of-other-next-functions/
//		sc.nextLine(); 
//		String input = sc.nextLine();
//		run = false;
//		if (input.equals("y")) 
//			run = true;
//	}
//	public void find_factors() {
//		int n = number;
//		int[] nlist = new int[999];
//		for(int i=1, j=0; i<=n && 1<=n;i++) {
//			if (n%i==0) {
//				n=n/i;
//				nlist[j]=i;
//				j++;
//				if(i!=1)
//					i--;
//				else 
//					continue;
//			}
//		}
//		factor = nlist;
//	}
//	public void printarray(int[] x) {
//		for (int i=0;i<x.length;i++) {
//			System.out.printf("%d\t",x[i]);
//		}
//	}


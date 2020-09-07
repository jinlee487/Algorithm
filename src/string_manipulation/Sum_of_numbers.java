package string_manipulation;

import java.util.Scanner;

/*
 * Solved
 * https://www.acmicpc.net/problem/11720
 * 숫자의 합 
 */
public class Sum_of_numbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int sum=0;
		int N = sc.next().charAt(0);
		sc.nextLine();
		String input = sc.nextLine();
		String[] arr = input.split("");
		for (int i=0;i<arr.length;i++) {
			sum+=Integer.parseInt(arr[i]);
//			System.out.println("this is arr["+i+"] => "+arr[i]);
//			System.out.println("this is sum = > " + sum);
		}
		sc.close();
		System.out.println(sum);
	}
}

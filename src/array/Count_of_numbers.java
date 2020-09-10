package array;

import java.util.Scanner;

/*Solved
https://www.acmicpc.net/problem/2577
	숫자의 개수	*/
public class Count_of_numbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=1;
		for (int i=0;i<3;i++) {
			n*=sc.nextInt();
		}
		char[] arr = Integer.toString(n).toCharArray(); 
//		System.out.println(arr);
		int[] count = new int[10];
		for (int i=0;i<arr.length;i++) {
//			System.out.println("this is arr["+ i + "] => " + arr[i]);
			count[Character.getNumericValue(arr[i])]+=1;
		}
		for(int i:count) {
			System.out.println(i);
		}

		sc.close();
	}
}

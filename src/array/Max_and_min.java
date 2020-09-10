package array;

import java.util.Scanner;

/*Solved!!!
https://www.acmicpc.net/problem/10818
	최소, 최대	*/
public class Max_and_min {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i=0;i<arr.length;i++) {
			if (max<arr[i]) max = arr[i];
			if (arr[i]<min) min = arr[i];	
		}
		System.out.println(min + " " + max);
		sc.close();
	}
}

package array;

import java.util.Scanner;

/*Solved
https://www.acmicpc.net/problem/2562
	ÃÖ´ñ°ª	*/
public class Max {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		for (int i=0;i<9;i++) {
			arr[i]=sc.nextInt();
		}
		int idx = -1;
		int max = Integer.MIN_VALUE;
		for (int i=0;i<arr.length;i++) {
			if (max<arr[i]) { 
				max = arr[i];	
				idx = i;
			}
		}
		System.out.println(max);
		System.out.println(idx+1);
		sc.close();
	}
}

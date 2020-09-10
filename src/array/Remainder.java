package array;

import java.util.Scanner;

/*Solved
https://www.acmicpc.net/problem/3052
	³ª¸ÓÁö	*/
public class Remainder {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[42];
		for (int i=0;i<10;i++) {
			arr[sc.nextInt()%42]+=1;
		}
		int count=0;
		for (int i=0;i<arr.length;i++) {
			if (0<arr[i]) { 
				count+=1;
			}
		}
		System.out.println(count);
		sc.close();
	}
}

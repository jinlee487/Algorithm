package array;

import java.util.Arrays;
import java.util.Scanner;

/*Solved
https://www.acmicpc.net/problem/1546
	ЦђБе
	https://www.baeldung.com/java-array-sum-average	*/
public class Average {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Double[] arr = new Double[n];
		
		for (int i=0;i<n;i++) {
			arr[i]=sc.nextDouble();
		}	
		Double max= (double) Integer.MIN_VALUE;
		for (int i=0;i<arr.length;i++) {
			if (max<arr[i]) {
				max=arr[i];
			}
		}
		for (int i=0;i<arr.length;i++) {
			arr[i]=arr[i]/ max*100;
		}	
		Double sum=0.0;
		for (int i=0;i<arr.length;i++) {
			sum+=arr[i];
		}
		System.out.println(sum/n);
		sc.close();
	}
}

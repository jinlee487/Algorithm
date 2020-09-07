package arrangement;

import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/10989
 * https://bowbowbow.tistory.com/8
 */
public class num_order_3_counting_sort {
	static int[] counting;
	static int[] arr;
	static int N;
	static int[] output;
	static int[] adding;
	static StringBuilder sb = new StringBuilder();
	static Scanner sc = new Scanner(System.in);
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N = sc.nextInt();
		arr = new int[N+1];
		output = new int[N+1];
		counting = new int[10001];
		adding = new int[10001];

		for (int i=0; i<N;i++)
			arr[i]=sc.nextInt();
		count();
		printarray();
	}
	public static void count() {
		for (int i=0;i<N;i++) {
			counting[arr[i]]+=1;
		}
		adding[0]=counting[0];
		
		for (int i=1, j=0;i<10001;i++) {
			if (counting[i]!=0) {
				adding[i] = counting[i]+adding[j];
				j=i;
			}
		}
		for (int i=0;i<N;i++) {
			output[adding[arr[i]]]=arr[i];
			adding[arr[i]]-=1;
		}	
	}
	public static void printarray() {
		for (int i=1;i<N+1;i++)
			sb.append(output[i]+"\n");
		System.out.println(sb);
	}
}

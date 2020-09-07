package dynamic_programming;
import java.util.Scanner;

/*
 * Solved!
 * https://www.acmicpc.net/problem/11053
 * 가장 긴 증가하는 부분 수열
 */
 public class Increasing_int_array {
	static int[] arr; 
	static int[] list; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N+1];
        list = new int[N+1];
        for (int i = 1; i < N+1; i++) {
        	arr[i] = sc.nextInt();
        }
        list[0]=1;
        for (int i=1;i<N+1;i++) {
        	list[i]=1;
        	for (int j=1;j<i+1;j++) {
        		if (arr[j]<arr[i]&&list[i]<=list[j]) {
        			list[i] = list[j] + 1;
        		}
        		System.out.printf("arr[%d] => %d, arr[%d] => %d, list[%d] => %d \n",i,arr[i],j,arr[j],j,list[j]);
        	}
        	System.out.println("");
        }
        int max=0;
        for (int i=1; i<N+1; i++) {
        	max = Math.max(max, list[i]);
        }
        System.out.println(max);
        sc.close(); 
	}
}

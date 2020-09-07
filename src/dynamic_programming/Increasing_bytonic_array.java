package dynamic_programming;

import java.util.Scanner;

/*
 * solved!!!
 * https://www.acmicpc.net/problem/11054
 * 가장 긴 바이토닉 부분 수열
 */
public class Increasing_bytonic_array {

	static int[] arr; 
	static int[] inc; 
	static int[] dec; 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N+1];
        inc = new int[N+1];
        dec = new int[N+2];
        for (int i = 1; i < N+1; i++) {
        	arr[i] = sc.nextInt();
        }
        int max=0;
        int imax=0;
        int dmax = 0;
        for (int i=1;i<N+1;i++) {
        	inc[i]=1;
        	imax=0;
        	System.out.println("\nincreasing");
        	for (int j=1;j<i+1;j++) {
        		if (arr[j]<arr[i]&&inc[i]<=inc[j]) {
        			inc[i] = inc[j] + 1;
        		}
        		imax = inc[i]<imax?imax:inc[i];
        		System.out.printf("arr[%d] => %d, arr[%d] => %d, inc[%d] => %d \n",i,arr[i],j,arr[j],j,inc[j]);
        	}
        	dec = new int[N+2];
        	dmax = 0;
        	for (int ii=i;ii<N+1;ii++) {
        		System.out.println("\ndecreasing");
        		dec[ii]=imax;
	        	for (int j=i;j<ii+1;j++) {
					if (arr[ii]<arr[j]&&dec[ii]<=dec[j]) {
						dec[ii] = dec[j] +1; 
					}
					dmax = dec[ii]<dmax? dmax:dec[ii];
					System.out.printf("arr[%d] => %d, arr[%d] => %d, dec[%d] => %d \n",ii,arr[ii],j,arr[j],j,dec[j]);
				}
        	}
        	max=dmax<max?max:dmax;
        	max=imax<max?max:imax;
        	System.out.println(max);
        }
        System.out.println(max);
        sc.close(); 
	}
}

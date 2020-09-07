package dynamic_programming;

import java.util.Scanner;

public class easy_stairs {
/*
 * Solved!
 * https://www.acmicpc.net/problem/10844
 * 쉬운계단수
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        sc.close();
/*
 *         
        long[][] list = new long[N+1][9999999]; //9,223,372,036,854,775,807
        for (int i=0;i<N+1;i++) {
        	for (int j=1;j<10000;j++) {
        		list [i][j] = -1;
        	}
        }
        for (int i=1;i<10;i++) {
        	list[1][i] = i;
        }
        int num=0;
        int count=10;
        next:
        for (int i=2;i<N+1;i++) {
        	count = 1;
        	for (int j=1;j<list[1].length;j++) {
        		if (list[i-1][j]==-1)
        			continue next;
        		num=(int) (list[i-1][j]%10);
        		if (num==0) {
        			list[i][count++]=list[i-1][j]*10+ num+1;
        		}
        		else if (num==9) {
        			list[i][count++]=list[i-1][j]*10+num-1;
        		}
        		else {
        			list[i][count++]=list[i-1][j]*10+num-1;
        			list[i][count++]=list[i-1][j]*10+num+1;
        		}
        	}
        }	
                next:
        for (int i=1; i < N+1;i++) {
        	System.out.println("");
        	System.out.println("i => "+ i);
        	for (int j=1;j<10000;j++) {
        		if (list[i][j]==-1) continue next;
        		System.out.println(list[i][j]);
        	}
        }
        System.out.println((count-1)%1000000000);
*/        
        long [][] quick_list = new long[N+1][10]; //9,223,372,036,854,775,807
        for (int i=1;i<10;i++) {
        	quick_list[1][i] = 1;
        }
        for (int i=2;i<N+1;i++) {
        	for (int j=0;j<10;j++) {
        		if (j==0) {
        			quick_list[i][0]+=quick_list[i-1][1];
        		}
        		else if (j==9) {
        			quick_list[i][9]+=quick_list[i-1][8];
        		}
        		else {
        			quick_list[i][j]+=(quick_list[i-1][j-1]+quick_list[i-1][j+1])%1000000000;
 
        		}
        	}
        }	
        long cnt=0;
        for (int i=0;i<10;i++) {
//        	System.out.println("\ni => "+ i);
//        	System.out.println("[N][i]=> "+ quick_list[N][i]);
        	cnt+= quick_list[N][i];
        }
        System.out.println(cnt%1000000000);
	}
}

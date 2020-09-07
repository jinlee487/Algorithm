package greedy_algorythm;

import java.util.*;
import java.util.Comparator;
import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/1931
 * 회의실배정
 * 11
1 4
3 5
0 6
5 7
3 8
5 9
6 10
8 11
8 12
2 13
12 14
 */
public class Conference_room {
	static int[][] schedule; 
	static int N,time,count;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		schedule = new int[N][2];
		for (int i=0;i<N;i++) {
			schedule[i][0] = sc.nextInt();
			schedule[i][1] = sc.nextInt();
		}
		sc.close();
//		System.out.println("");
		Arrays.sort(schedule,new Comparator<int[]>() { 
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]==o2[1]) {
					return Integer.compare(o1[0],o2[0]);
				}
				return Integer.compare(o1[1], o2[1]);
			}		
		});
//		for(int i=0;i<schedule.length;i++) {
//			
//			System.out.println(schedule[i][0]+" "+schedule[i][1]);
//		}	
//		System.out.println("");
		time = 0;
		count = 1;
		for (int i=1;i<N;i++) {
	         if (schedule[i][0] >= schedule[time][1]) { 
//	              System.out.println(schedule[i][0]+" "+schedule[i][1]); 
	              time = i; 
	              count++;
	          } 
	    } 
		System.out.println(count);
	}
}

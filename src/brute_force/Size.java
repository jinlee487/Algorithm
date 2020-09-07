package brute_force;

import java.util.Scanner;

/*
 * sovled!
 * https://www.acmicpc.net/problem/7568
 * 덩치
 */
public class Size {
	static int len; 
	static int[] weight; 
	static int[] height;
	static int[] score;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        len = sc.nextInt();
        weight = new int[len];
        height = new int[len];
        score = new int[len];
        for (int i=0;i<len;i++) {
        	weight[i] = sc.nextInt();
        	height[i] = sc.nextInt(); 
        }
        sc.close();
        for (int i=0;i<len;i++) {
        	int count = 1;
        	for (int j=0;j<len;j++) {
        		if (weight[i]<weight[j]&&height[i]<height[j]) {
        			count+=1;
        		}	
        	}
        	score[i] = count;	
        }
        for (int i=0;i<len;i++) {
        	System.out.printf("%d ",score[i]);
        }
	}
}

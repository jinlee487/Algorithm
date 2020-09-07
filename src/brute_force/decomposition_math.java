package brute_force;
import java.util.Scanner;
/*
 * Solved!
 * https://www.acmicpc.net/problem/2231
 * 분해합 
 */
public class decomposition_math {
	static int x;
	static int[] input;
	static int min;
	static int temp=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt(); 
        min = x;
        sc.close();
        input = new int[x+1];        	
        for (int i=x/10;i<x+1;i++) {
        	input[i]=i;
        }
    	if (x<=10) 
    		System.out.println(0);
    	else calc();
	}	
	public static void calc() {
		 for (int i=x/10;i<x+1;i++) {
        	String[] d = Integer.toString(input[i]).split("");
        	temp = input[i];
        	for ( int j=0;j<d.length;j++) 
        		temp += Integer.parseInt(d[j]);
        	if (input[i]<min && temp==x) {
        		min = input[i];
        		System.out.println(min);
        		return;
        	}
		}  
		System.out.println(0); 
	}
}


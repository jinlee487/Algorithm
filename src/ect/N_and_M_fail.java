package ect;

import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/15650
 * n 과 m (1)
 */
public class N_and_M_fail {
	static int N, M;
	static int []num;
    static boolean []visited;
    static String[] check;
    static int c=0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();    
        sc.close();

        num = new int[N+1];
        visited = new boolean[N+1];
        check = new String[N*N*N*N*N*N+1];
        for (int i=0;i<check.length;i++)
        	check[i]="";
    	if(N==M) {
    		String temp = "";
    		for(int i=1;i<M+1;i++) {
    			temp= temp+ " " + Integer.toString(i);
    		}
    		System.out.println(temp.substring(1));
    	}
    	else {
    		bt(0);
        	print_answer();
    	}
    }
    static void print_answer() {
    	for(int i=0;i<check.length;i++) {
    		if(check[i].equals("")) {
    			System.out.println(sb);
    			break;
    		}
    		sb.append(check[i]+"\n");
    	}
    }
    static void bt(int count){

        if (count == M) {
        	String temp = "";
            for (int i=0; i<M; i++)
                temp= temp+ " " + num[i];
        	String reverse = new StringBuffer(temp.substring(1)).reverse().toString();    
        	for (int i=0;i<check.length;i++) {
            	if (check[i].equals(reverse)) {
            		return;
            	}
            }
            check[c]=temp.substring(1);
            c++;
            return;        
        }
	    for (int i=1; i<=N; i++){
	        if(!visited[i]){
	            visited[i] = true;
	            num[count] = i;
//	            for (int j=1; j<=4; j++)
//	            	System.out.printf(j+" = "+visited[j]+" ");
//	            System.out.println("\ni = "+i+"\t"+"count ="+count);
//	            System.out.println("");
	            bt(count+1);
	            visited[i] = false;
	        }
	    }
    }
}
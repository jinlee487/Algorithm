package ect;

import java.util.Scanner;

public class note {

	 static int N, M;
	    static int []num;
	    static boolean []visited;
	    static StringBuilder sb = new StringBuilder();
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        N = sc.nextInt();
	        M = sc.nextInt();    
	        sc.close();
	        num = new int[N+1];
	        visited = new boolean[N+1];
	        bt(0);
	        System.out.print(sb);
	    }

	    static void bt(int count){
	        if (count == M) {
	            for (int i=0; i<M; i++)
	                sb.append(num[i]+" ");
	            sb.append("\n");
	            return;        
	        }
	        for (int i=1; i<=N; i++){
	            if(!visited[i])
	            {
	                visited[i] = true;
	                num[count] = i;
	                bt(count+1);
	                visited[i] = false;
	            }
	        }
	    }
}

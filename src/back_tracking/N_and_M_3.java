package back_tracking;

import java.util.Scanner;

/*
 * Solved!
 * https://www.acmicpc.net/problem/15651
 * n 과 m (3)
 */
public class N_and_M_3 {
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
	        if(!visited[i]){
//	            visited[i] = true;
	            num[count] = i;
//	            for (int j=1; j<=4; j++)
//	            	System.out.printf(j+" = "+visited[j]+" ");
//	            System.out.println("\ni = "+i+"\t"+"count ="+count);
//	            System.out.println("");
	            bt(count+1);

	        }
	    }
    }
}



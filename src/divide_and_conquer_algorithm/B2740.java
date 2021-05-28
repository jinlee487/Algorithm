package divide_and_conquer_algorithm;
import java.io.*;
import java.util.*;

/* 
Solved!
https://www.acmicpc.net/problem/2740
행렬 곱셈
문제 해설: https://st-lab.tistory.com/245
*/
class B2740 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[][] arrA = new String[N][M];
        for(int i=0;i<N;i++) {
            arrA[i] = br.readLine().split(" ");
        } 
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String[][] arrB = new String[M][K];
        for(int i=0;i<M;i++) {
            arrB[i] = br.readLine().split(" ");
        }
        StringBuilder sb = new StringBuilder();	
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < K; j++) {
				int sum = 0;
				for(int k = 0; k < M; k++) {
					sum += Integer.parseInt(arrA[i][k]) * Integer.parseInt(arrB[k][j]);
				}
				sb.append(sum).append(' ');
			}
			sb.append('\n');
		}
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

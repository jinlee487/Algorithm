package math3;
import java.io.*;
import java.util.*;
/* 
Solved!
https://www.acmicpc.net/problem/1934
최소공배수
euclid algorithm
문제 해설: https://st-lab.tistory.com/193
*/
class B1934 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int A, B; 
        StringTokenizer st;
        StringBuilder str = new StringBuilder();
        for(int i=0;i<T;i++){
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            str.append(A * B / gcd(A, B)).append("\n");
        }
        bw.write(str.toString());
        bw.flush();
        bw.close();
        br.close();
    }    
	// 최대공약수 반복문 방식
	public static int gcd(int a, int b) {
		while (b != 0) {
			int r = a % b; // 나머지를 구해준다.
 
			// GCD(a, b) = GCD(b, r)이므로 변환한다.
			a = b;
			b = r;
		}
		return a;
	}
}

package divide_and_conquer_algorithm;
import java.io.*;
import java.util.*;
/* 
Solved!
https://www.acmicpc.net/problem/11401
이항 계수 3
문제 해설: https://st-lab.tistory.com/241

previous problems to reference
https://www.acmicpc.net/problem/11050
https://www.acmicpc.net/problem/11051
*/
class B11401 {
    final static long P = 1000000007;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
		long numer = factorial(N); // N!
		long denom = factorial(K) * factorial(N - K) % P; // (K! * (N-K)!) mod p
        bw.write(Long.toString(numer * pow(denom, P - 2) % P)); // N! * ((K! * (N-K)!) 
        bw.flush();
        bw.close();
        br.close();
    }
	public static long factorial(long N) {
		long fac = 1L;
		
		while(N > 1) {
			fac = (fac * N) % P;
			N--;
		}
		return fac;
	}
	public static long pow(long base, long expo) {
		if(expo == 1) {
			return base % P;
		}
		long temp = pow(base, expo / 2);
		if(expo % 2 == 1) {
			return (temp * temp % P) * base % P;
		}
		return temp * temp % P;
		
	}
    
}

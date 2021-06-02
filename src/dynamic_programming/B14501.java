package dynamic_programming;
import java.io.*;
import java.util.*;
/* 
Solved!
https://www.acmicpc.net/problem/14501
퇴사 
basic dynamic programming memoization problem
*/
class B14501 {
    static int[] arr,T,P;
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        T = new int[N+1];
        P = new int[N+1];
        StringTokenizer st;
        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
		int ans = 0;
        arr = new int[N+1]; 
        Arrays.fill(arr,-1);
		for (int i = 1; i <= N; i++) {
			ans = Math.max(ans, dp(i));
		}
        bw.write(Integer.toString(ans));
        bw.flush();
        bw.close();
        br.close();
    }
    public static int dp(int day) {
		if (arr[day] != -1) {
			return arr[day];
		}
		// return when work is after quitting
		if (day + T[day] > N + 1) {
			return 0;
		}
		arr[day] = P[day];
		for (int i = day + T[day]; i <= N; i++) {
			// work until the day of quitting
			if (i + T[i] <= N + 1) {
				arr[day] = Math.max(arr[day], P[day] + dp(i));
			}
		}
		return arr[day];
	}
}

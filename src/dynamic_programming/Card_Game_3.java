package dynamic_programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/problem/10835
 * 카드게임
 * 
  1. 언제든지 왼쪽 카드만 통에 버릴 수도 있고 왼쪽 카드와 오른쪽 카드를 둘 다 통에 버릴 수도 있다. 이때 얻는 점수는 없다.
  2. 오른쪽 카드에 적힌 수가 왼쪽 카드에 적힌 수보다 작은 경우에는 오른쪽 카드만 통에 버릴 수도 있다. 오른쪽 카드만 버리는 경우에는 오른쪽 카드에 적힌 수만큼 점수를 얻는다.
  3. (1)과 (2)의 규칙에 따라 게임을 진행하다가 어느 쪽 더미든 남은 카드가 없다면 게임이 끝나며 그때까지 얻은 점수의 합이 최종 점수가 된다. 

 */
// https://www.acmicpc.net/problem/10835
 
public class Card_Game_3 {
    static int stoi(String s) { return Integer.parseInt(s);}
 
    static int n;
    static int[] left;
    static int[] right;
 
    // dp[왼쪽의 카드 버린 수][오른쪽의 카드 버린 수]
    static int[][] dp;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        n = stoi(br.readLine());
        left = new int[n];
        right = new int[n];
        dp = new int[n][n];
 
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            left[i] = stoi(st.nextToken());
 
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            right[i] = stoi(st.nextToken());
 
        // dp를 전부 1값으로 채움
        for(int i=0; i<n; i++)
            Arrays.fill(dp[i], -1);
 
        // 양쪽 다 0개만큼 버린 상태에서 시작
        System.out.println(sol(0, 0));
    }
 
    static int sol(int l, int r) {
        // 한쪽 카드 전부 소비
        if(l == n || r == n)
            return 0;
 
        // 이미 값이 있으면 중복해서 또 연산할 필요 없음
        if(dp[l][r] != -1)
            return dp[l][r];
 
        // 카드 두개 다 버리거나, 왼쪽 카드를 버리는 경우 중 큰 수
        dp[l][r] = Math.max(sol(l+1, r+1), sol(l+1, r));
 
        // 만약 오른쪽 카드가 더 작다면 연산을 한번 더 해줌. 이 경우에는 오른쪽 카드 값을 더해서 계산
        if(left[l] > right[r])
            dp[l][r] = Math.max(dp[l][r], sol(l, r+1) + right[r]);
        
        return dp[l][r];
    }
}


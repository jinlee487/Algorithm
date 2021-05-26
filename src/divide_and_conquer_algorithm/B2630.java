package divide_and_conquer_algorithm;
import java.io.*;
import java.util.*;
/* 
Solved!
https://www.acmicpc.net/problem/2630
색종이 만들기 
*/
class B2630 {
    static int[] cnt = new int[2];
    static String[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        arr = new String[N][N];
        for (int i = 0; i < N; i++){
            arr[i] = br.readLine().split(" ");
        }
        divide(N, 0, 0);
        bw.write(Integer.toString(cnt[0]) + "\n" + Integer.toString(cnt[1]));
        bw.flush();
        bw.close();
        br.close();
    }
    private static void divide(int n, int x, int y) {
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++)
                if (!arr[i][j].equals(arr[x][y])) {
                    divide(n / 2, x, y);
                    divide(n / 2, x + n / 2, y);
                    divide(n / 2, x, y + n / 2);
                    divide(n / 2, x + n / 2, y + n / 2);
                    return;
                }
        }
        cnt[Integer.parseInt(arr[x][y])]++;
    }
}

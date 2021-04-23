package greedy_algorythm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
 
/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/2812
 * 크게 만들기
*/
public class MakeBig {
    
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
 
        String input = br.readLine();
 
        char[] arr = input.toCharArray();
        Deque<Character> dq = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            while (K > 0 && !dq.isEmpty() && dq.getLast() < arr[i]) {
                dq.removeLast();
                K--;
            }
            dq.addLast(arr[i]);
        }
 
        StringBuilder ans = new StringBuilder();
        while (dq.size() > K) {
            ans.append(dq.removeFirst());
        }
 
        bw.write(ans.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

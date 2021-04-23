package greedy_algorythm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/15903
 * 카드 합체 놀이
 * PriorityQueue 설명 => https://www.geeksforgeeks.org/priority-queue-class-in-java-2/
*/
public class CardAdditionGame {
    
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        StringTokenizer st = new StringTokenizer(br.readLine());
        // int[] arr = new int[N];
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            pq.add(Long.parseLong(st.nextToken()));
        }
        Long x,y;
        for(int i=0;i<m;i++){
            x = pq.poll();
            y = pq.poll();
            x = y = x + y;
            pq.add(x);
            pq.add(y);
        }
        // System.out.println("this is pq => " + pq);
        Long answer=0L;
        for(int i=0;i<n;i++){
            answer+=pq.poll();
        }
 
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

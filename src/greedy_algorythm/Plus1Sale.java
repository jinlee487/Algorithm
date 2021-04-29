package greedy_algorythm;
import java.util.*;
import java.io.*;

/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/11508
 * 2+1 세일
*/

public class Plus1Sale {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Long ans = 0L;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i=0;i<N;i++){
            pq.add(Integer.parseInt(br.readLine()));
        }
        for(int i=1;!pq.isEmpty();i++){
            if(i%3==0){
                pq.poll();
                continue;
            } else{
                ans+=pq.poll();
            }
        }
        bw.write(Long.toString(ans));
        bw.flush();
        bw.close();
        br.close();
    }
}

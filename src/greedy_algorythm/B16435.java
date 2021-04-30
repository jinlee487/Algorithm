package greedy_algorythm;

import java.util.*;
import java.io.*;
 
/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/16435
 * 스네이크버드
*/

public class B16435 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            pq.add(Integer.parseInt(st.nextToken()));
            
        }
        for(;!pq.isEmpty();){
            if(pq.peek()<=L){
                L ++;
                pq.poll();
            }else{
                break;
            }

        }
        
        bw.write(Integer.toString(L));
        bw.flush();
        bw.close();
        br.close();
        
        

    }
}
 
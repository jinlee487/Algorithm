package greedy_algorythm;

import java.util.*;
import java.io.*;
 
/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/1461
 * 도서관
*/

public class B1461 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pqN = new PriorityQueue<Integer>();
        PriorityQueue<Integer> pqP = new PriorityQueue<Integer>(Collections.reverseOrder());

        int temp, maxabs=0;

        st = new StringTokenizer(br.readLine());
        int ans=0;
        for(int i=0;i<N;i++){
            temp = Integer.parseInt(st.nextToken());
            if(maxabs < Math.abs(temp)){
                maxabs = Math.abs(temp);
            }
            if(temp<0){
                pqN.add(temp);
            } else {
                pqP.add(temp);
            }
        }
        for(;!pqN.isEmpty();){
            ans += Math.abs(pqN.poll())*2;
            for(int i=1;i<M&&!pqN.isEmpty();i++){
                pqN.poll();
            } 
        }
        for(;!pqP.isEmpty();){
            ans += pqP.poll()*2;
            for(int i=1;i<M&&!pqP.isEmpty();i++){
                pqP.poll();
            } 
        }
        ans -= maxabs;
        bw.write(Integer.toString(ans));
        bw.flush();
        bw.close();
        br.close();
        
        

    }
}
 
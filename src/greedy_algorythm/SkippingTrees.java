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
 * https://www.acmicpc.net/problem/11497
 * 나무 건너뛰기
 * PriorityQueue 설명 => https://www.geeksforgeeks.org/priority-queue-class-in-java-2/
*/
public class SkippingTrees {
    
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int L = 0; 
        PriorityQueue<Integer> pq; 
        int[] arr;
        int p=0;
        StringBuilder answer = new StringBuilder();         
        for(int i=0;i<N;i++){
            L = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq = new PriorityQueue<>();
            arr = new int[L];
            for(int j=0;j<L;j++){
                pq.add(Integer.parseInt(st.nextToken()));
            }
            for(int j=0;j<L;j++){
                p = pq.poll();
                arr[j] = p;
                if(pq.isEmpty()) break;
                p = pq.poll();
                arr[L-j-1] = p;
                if(pq.isEmpty()) break;
            }
            int max = 0;
            if(arr.length==1){
                max=arr[0];
            }    
            for(int j=1;j<L;j++){
                
                max = Math.max(max,Math.abs(arr[j]-arr[j-1]));
            }
            answer.append(max + "\n");
        } 
        bw.write(answer.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

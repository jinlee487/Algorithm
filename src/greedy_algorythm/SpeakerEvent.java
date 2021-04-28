package greedy_algorythm;

import java.util.*;
import java.io.*;
 
/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/2109
 * 순회 강연
*/
public class SpeakerEvent {
    
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
       PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
       HashMap<Integer,ArrayList<Integer>> hash = new HashMap<Integer,ArrayList<Integer>>();
       int pay, day, max = Integer.MIN_VALUE;
        for (int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            pay = Integer.parseInt(st.nextToken());
            day = Integer.parseInt(st.nextToken());
            if(hash.containsKey(day)){
                ArrayList<Integer> temp = hash.get(day);
                temp.add(pay);
                hash.put(day,temp);
            } else{
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(pay);
                hash.put(day,temp);
            }
            if(max<day){
                max = day;
            }
        }
        Long ans = 0L;
        for(int i=max;0<i;i--){
            if(hash.containsKey(i)){
                pq.addAll(hash.get(i));
                // System.out.println("this is pq => " + pq);
                ans += pq.poll();
            } else {
                if(!pq.isEmpty()){
                    ans += pq.poll();
                }
            }
        }
       
        bw.write(Long.toString(ans) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

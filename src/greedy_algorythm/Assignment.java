package greedy_algorythm;

import java.io.*;
import java.util.*;
/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/13904
 * 과제
*/
 
public class Assignment {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int N = Integer.parseInt(st.nextToken()); 
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<1001;i++){
            arrayList.add(new ArrayList<Integer>());
        }
        ArrayList<Integer> t;
        int max = Integer.MIN_VALUE;
        //we need to put the information into an arraylist because we need to traverse through 
        //from the last day till day 1. on days where there isnt any assignments, we can do future assignemnts
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Integer[] temp = {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
            t=arrayList.get(temp[0]);
            t.add(temp[1]);
            arrayList.set(temp[0],t);
            if(max<temp[0]){
                max = temp[0];
            }

        }
        int ans = 0 ;
        PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>(Collections.reverseOrder());
		for (int i=max;0<i;i--) {
            t = arrayList.get(i);
            if(t.isEmpty()){
                //if day has no assignments, we can do other assignments that are in pq2 
                //as long as pq2 has other assignments from future days
                if(!pq2.isEmpty()){
                    ans+=pq2.poll();
                }
            }else{
                // we add all the assignments that are due the day of and compare with the 
                // other assignments that are due in the future
                for(int j=0;j<t.size();j++){
                    pq2.add(t.get(j));
                }
                //poll the assignment with the highest yield score
                if(!pq2.isEmpty()){
                    ans+=pq2.poll();
                }
            }          
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
 
}

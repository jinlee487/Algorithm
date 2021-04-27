package greedy_algorythm;

import java.util.*;
import java.io.*;

/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/1781
 * 컵라면
*/

class Problem { 
    int deadLine;
    int ramen;
    Problem(int deadLine, int ramen){
        this.deadLine = deadLine; this.ramen=ramen;
    }
    @Override 
    public String toString(){
        return "deadLine: " + this.deadLine + " ramen: " + this.ramen;
    }
}
public class CupRamen {
    
	public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Problem> pq1 = new PriorityQueue<Problem>(new Comparator<Problem>() {        
                // Compare method for place element in
                public int compare(Problem o1, Problem o2)
                {
                    return o2.deadLine - o1.deadLine;
                }
            });
        PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>(Collections.reverseOrder());

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            pq1.add(new Problem(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        // System.out.println("this is pq1 => " + pq1);

        Long ans = 0L;
        // we have to loop backwards and find the max for each day 

        for(int i = pq1.peek().deadLine;0<i;i--){
            if(pq1.isEmpty()&&pq2.isEmpty()){
                break;
                //if they are both empty then the loop can end even if there are days left
            }
            while(!pq1.isEmpty()&&pq1.peek().deadLine==i){
                //this means it is the same day we have to loop and get all the scores
                pq2.add(pq1.poll().ramen);
            }
            if(!pq2.isEmpty()){
                ans+=pq2.poll();
            }
        }
        bw.write(Long.toString(ans));
        bw.flush();
        bw.close();
        br.close();



    }
}

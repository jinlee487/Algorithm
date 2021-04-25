package greedy_algorythm;

import java.io.*;
import java.util.*;
/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/1092
 * 배
*/
class Crane {
    int weight;
    int box;
    int working=0; 
    Crane(int w){
        this.weight=w;
    }
    @Override 
    public String toString(){
        return "weight: " + this.weight + " box: " + this.box;
    }
}
public class Ship {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine()); 
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        PriorityQueue<Crane> pqcrane = new PriorityQueue<Crane>(new Comparator<Crane>() {        
            // Compare method for place element in
            // revers order
            public int compare(Crane a, Crane b)
            {
                if (a.working ==  b.working)
                    return a.weight - b.weight;
                return a.working - b.working;
            }
        });
        for(int i=0;i<N;i++){
            pqcrane.add(new Crane(Integer.parseInt(st.nextToken())));
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pqbox = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i=0;i<M;i++){
            int temp = Integer.parseInt(st.nextToken());
            pqbox.add(temp);
        }

        // System.out.println("this is ordered que => " + pqcrane);
        // System.out.println("this is pq => " + pqbox);
        // we want the smallest crane to pick up the biggest possible load of box first
        // now we loop until pq ( boxex ) is empty
        int b;
        Crane c;
        Queue<Crane> pqList = new LinkedList<Crane>();
        int ans = 0;
        for(;!pqbox.isEmpty();){
            b = pqbox.poll();
            for(;!pqcrane.isEmpty();){
                c=pqcrane.poll();
                if(b<=c.weight){
                    //if crane's weight is more than the box, we can use the crane
                    c.working +=1;
                    ans = Math.max(c.working,ans);
                    c.box = b;
                    pqList.add(c);
                    // System.out.println("crane => "  + c.weight + " box => " + b);
                    b=-1;
                    break;
                } else{
                    //if it is not, we move on to the next available crane in the pqcrane
                    pqList.add(c);
                    continue;
                }
            }
            if(b!=-1){
                ans = -1;
                break;
            }
            for(;!pqList.isEmpty();){
                pqcrane.add(pqList.poll());
            }
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
 
}

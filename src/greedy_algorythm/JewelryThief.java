package greedy_algorythm;

import java.io.*; 
import java.util.*;
/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/1202
 * 보석 도둑
*/
public class JewelryThief { 
    public static void main(String[] args) throws IOException{ 
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(reader.readLine()); 
        int n = Integer.parseInt(st.nextToken()); 
        int m = Integer.parseInt(st.nextToken()); 
        Jewelry [] a = new Jewelry[n]; 
        int [] bag = new int[m]; 
        for(int i=0; i<n; i++) { 
            st = new StringTokenizer(reader.readLine());
            a[i] = new Jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        } 
        for(int i=0; i<m; i++) { 
            bag[i] = Integer.parseInt(reader.readLine()); 
        } 
        Arrays.sort(a); 
        Arrays.sort(bag); 
        // System.out.println(Arrays.toString(a));
        // System.out.println(Arrays.toString(bag));

        Queue<Integer> q = new PriorityQueue<>(); 
        long ans = 0; int j = 0; 
        for(int i=0; i<m; i++) { 
            // System.out.println("forloop i => " + i);
            // System.out.println(" a[j].c = >" +  a[j].c);
            // System.out.println(" bag[i] = >" +  bag[i]);

            while(j < n && a[j].c <= bag[i]) { 
                // System.out.println("whileloop j => " + j);
                // System.out.println("a[j].c = >" +  a[j].c);
                // System.out.println("this is -a[j].v = >" + a[j].v);
                //앞에서 담은것은 제외해야 하므로 while문과 j를 사용 
                q.add(-a[j].v); //into the all of it goes into the prio quenue as long as it matches the weight
                // it does not matter which jewelry goes into which bag as long as it is underweight
                j++; 

            } 
            if(!q.isEmpty()) { //for문 한번에 한번만 더한다. 
                // System.out.println("this is pq => " + q);
                // in the end the jewelery with the highest price is polled and added to ans
                ans+=Math.abs(q.poll()); 
                // System.out.println("this is ans => " + ans);
            } 
        } 
        System.out.println(ans); 
    } 
} 
class Jewelry implements Comparable<Jewelry> { 
    int c; 
    int v;
    public Jewelry(int c, int v) { 
        this.c = c; this.v = v;
    } 
    @Override 
    public int compareTo(Jewelry o) { 
        return this.c - o.c; //basically returns false or true if it is bigger or smaller
    } 
    @Override
    public String toString() {
        return String.format("[c = " + c + " v = " + v +"]");
    }

}


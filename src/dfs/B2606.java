package dfs;
import java.util.*;
import java.io.*;

/*
 * Solved!!
 * https://www.acmicpc.net/problem/2606
 * 
 * 바이러스
 * 
 * this is rather easy but a tricky question
 * I had to realize that the virus can travel two ways between the nodes not a one way. 
 * I had to remove 1 from the set because the question wants us to answer 
 * how many computers gets infect by the virus coming from computer 1
 * 
 */
public class B2606 {
    static HashMap<Integer,Queue<Integer>> hash;
    static HashSet<Integer> set;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        hash = new HashMap<Integer,Queue<Integer>>();
        set = new HashSet<Integer>();
        StringTokenizer st;
        Integer parent, child;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            parent = Integer.parseInt(st.nextToken());
            child = Integer.parseInt(st.nextToken());

            if(!hash.containsKey(parent)){
                Queue<Integer> temp =  new LinkedList<Integer>();
                temp.add(child);
                hash.put(parent, temp);
            } else {
                Queue<Integer> temp = hash.get(parent);
                temp.add(child);
                hash.put(parent,temp);
            }
            if(!hash.containsKey(child)){
                Queue<Integer> temp =  new LinkedList<Integer>();
                temp.add(parent);
                hash.put(child, temp);
            } else {
                Queue<Integer> temp = hash.get(child);
                temp.add(parent);
                hash.put(child,temp);
            }
        }
        //System.out.println(hash);
        dfs(1);
        set.remove(1);
        bw.write(Integer.toString(set.size()));
        bw.flush();
        bw.close();
        br.close();
    }
    static int dfs(Integer node) {
        if(!hash.containsKey(node)){
            //System.out.println("\nthis node is empty => " + node);
            return 0;
        }
        for(;!hash.get(node).isEmpty();){
            Queue<Integer> que = hash.get(node);
            //System.out.println("\nthis is que => " + que);
            Integer nextNode = que.poll();
            //System.out.println("this is nn => " + nextNode);
            set.add(nextNode);
            //System.out.println("this is the set => " + set);
            hash.put(node,que);
            dfs(nextNode);
        }
        return 0;
    }
}

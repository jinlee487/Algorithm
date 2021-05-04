package dfs;
import java.util.*;
import java.io.*;
/*
 * Solved!!
 * https://www.acmicpc.net/problem/11724
 * 
 * 연결 요소의 개수
 * 
 * this question is very similar to https://www.acmicpc.net/problem/2667
 * but also very different
 * the question has a key word "간선" 이있을수있다 
 * 간선이란 정점이 들의 모든 모임이다. 
 * 그래서 N (간선 개수) 가 1000 개이고 M 은 0 이면 총간선의 개수는 1000이다 
 * 
 */
public class B11724 {
    static HashMap<Integer,Queue<Integer>> hash = new HashMap<Integer,Queue<Integer>>();
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n1, n2, count = 0 ;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            n1 = Integer.parseInt(st.nextToken());
            n2 = Integer.parseInt(st.nextToken());
            if(!hash.containsKey(n1)){
                Queue<Integer> q = new LinkedList<Integer>();
                q.add(n2);
                hash.put(n1,q);
            } else {
                Queue<Integer> q = hash.get(n1);
                q.add(n2);
                hash.put(n1,q);
            }
            int t = n1;
            n1 = n2;
            n2 = t;
            if(!hash.containsKey(n1)){
                Queue<Integer> q = new LinkedList<Integer>();
                q.add(n2);
                hash.put(n1,q);
            } else {
                Queue<Integer> q = hash.get(n1);
                q.add(n2);
                hash.put(n1,q);
            }
            arrayList.add(n1);
        }
        for(int j=1;j<N+1;j++){
            if(arr[j] == -1){
                continue;
            }
            dfs(j);
            count++;
        }
        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
        br.close();
    }
    public static int dfs(int node){
        arr[node] = -1;
        if(!hash.containsKey(node)){
            return 0;
        }
        for(;!hash.get(node).isEmpty();){
            Queue<Integer> q = hash.get(node);
            int nextNode = q.poll();
            hash.put(node,q);
            dfs(nextNode);
        }
        return 0;
    }
}

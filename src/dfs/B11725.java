package dfs;
import java.io.*;
import java.util.*;
/* 
Solved!
https://www.acmicpc.net/problem/11725
트리의 부모 찾기 

*/

public class B11725 {
	static int[] parents;
	static ArrayList<ArrayList<Integer>> arrayList;
	static boolean[] visit;
	static int n;
	
	private static void dfs(int v) {
		visit[v] = true;
		
		for(int i : arrayList.get(v)) {
			if(!visit[i]) {
				parents[i] = v;
                // we just need to gather the first occurence of the node
                // into the parents array
                // if there is a node that is referd back, it will not hit because 
                // we have already traversed the node. 
                // since this is a tree, 
				dfs(i);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		
		arrayList = new ArrayList<ArrayList<Integer>>(); 
        arrayList.add(new ArrayList<Integer>());
        parents = new int[n+1];
		for(int i = 1; i <= n; i++) {
            arrayList.add(new ArrayList<Integer>());
        }
		
		visit = new boolean[n+1];
        StringTokenizer st;
        
		for(int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
			arrayList.get(a).add(b); 
            arrayList.get(b).add(a);
		}
		
		dfs(1);
        StringBuilder str = new StringBuilder();
		for(int i = 2; i <= n; i++) {
            str.append(parents[i] + "\n");
        }
        bw.write(str.toString());
        bw.flush();
        bw.close();
        br.close();
	}
}
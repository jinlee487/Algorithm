package dfs_and_bfs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;


/*
 * 
 * https://www.acmicpc.net/problem/1260
 * DFS¿Í BFS 
 * 
 * */
public class Dfs_and_bfs {
	static LinkedList<Integer> adj[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int v = sc.nextInt();
	    adj = new LinkedList[n+1]; 
	    for (int i=0; i<=n; i++) {
	    	adj[i] = new LinkedList(); 
	    }
		for (int i=0;i<m;i++) {
			adj[(int) sc.nextInt()].add((int)sc.nextInt());
		}
		int count=0;
		for (LinkedList l:adj) {
			System.out.println("this is linkedlist => " + (count++) +" "+ l.toString());
		}
		DFS(n+1);
		System.out.println("");
		BFS(v,n+1);

		sc.close();
	}
	public static void DFS(int V) { 
		// Mark all the vertices as not visited(set as 
		// false by default in java) 
		boolean visited[] = new boolean[V]; 
		// Call the recursive helper function to print DFS traversal 
		// starting from all vertices one by one 
		for (int i=1; i<V; ++i) 
			if (visited[i] == false) 
				DFSUtil(i, visited);
		} 
	// A function used by DFS 
	public static void DFSUtil(int v,boolean visited[]) {
		// Mark the current node as visited and print it 
		visited[v] = true; 
		System.out.print(v+" "); 
		// Recur for all the vertices adjacent to this vertex 
		Iterator<Integer> i = adj[v].listIterator(); 
		while (i.hasNext()) { 
	        int n = i.next(); 
	        if (!visited[n]) 
	        	DFSUtil(n,visited); 
        	} 
		} 
	// prints BFS traversal from a given source s 
	public static void BFS(int s,int V) { 
		// Mark all the vertices as not visited(By default 
        // set as false) 
        boolean visited[] = new boolean[V]; 
  
        // Create a queue for BFS 
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
  
        // Mark the current node as visited and enqueue it 
        visited[s]=true; 
        queue.add(s); 
  
        while (queue.size() != 0) 
        { 
        	// Dequeue a vertex from queue and print it 
            s = queue.poll(); 
            System.out.print(s+" "); 
  
            // Get all adjacent vertices of the dequeued vertex s 
            // If a adjacent has not been visited, then mark it 
            // visited and enqueue it 
            Iterator<Integer> i = adj[s].listIterator(); 
            while (i.hasNext()) 
            { 
                int n = i.next(); 
                if (!visited[n]) 
                { 
                    visited[n] = true; 
                    queue.add(n); 
                } 
            } 
        } 
    } 
	
}

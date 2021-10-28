package algoexpert.medium.CycleInGraph;

import java.util.*;

class Program1 {

  public boolean cycleInGraph(int[][] edges) {
    // Write your code here.
		Set<Integer> set = new HashSet<Integer>();
		for(int i=0;i<edges.length;i++) {
			if(cycleInGraph(i,edges,set)) return true;
		}
		return false;
  }
	public boolean cycleInGraph(int edge, int[][] edges, Set<Integer> set){
		if(set.contains(edge)) return true;
		set.add(edge);
		for(int e: edges[edge]) {
			if(cycleInGraph(e,edges,set)) return true;
		}
		set.remove(edge);
		return false;
	}
}

class Program2 {

    public boolean cycleInGraph(int[][] edges) {
      // Write your code here.
          boolean[] visited = new boolean[edges.length];
          boolean[] current = new boolean[edges.length];
          Arrays.fill(visited,false);
          Arrays.fill(current,false);
          for(int node = 0; node < edges.length;node++){
              if(visited[node]) continue;
              if(isNodeInCycle(node,edges,visited,current)) return true;
          }
          return false;
    }
      public boolean isNodeInCycle(int node, int[][] edges, boolean[] visited, boolean[] current){
          visited[node] = true;
          current[node] = true;
          int[] neighbors = edges[node];
          for(int neighbor : neighbors){
              boolean containsCycle = false;
              if(!visited[neighbor]){
                  containsCycle = isNodeInCycle(neighbor,edges, visited, current);				
              }
              if(containsCycle) return true;
              else if(current[neighbor]) return true;
          }
          current[node] = false;
          return false;
      }
  }
  
package algoexpert.hard.DijkstrasAlgorithm;
import java.util.*;

class Program2 {
  public int[] dijkstrasAlgorithm(int start, int[][][] edges) {
    // Write your code here.
		// O((v+e) * log(v)) time | O(v) space 
		int[] dp = new int[edges.length];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[start] = 0;
		ArrayList<Item> arrayList = new ArrayList<Item>();
		HashMap<Integer, Item> hash = new HashMap<Integer, Item>();
		for(int i=0;i<dp.length;i++) {
			Item item = new Item(i,dp[i]);
			arrayList.add(item);
			hash.put(item.vertex,item);
		}
		Collections.sort(arrayList);
		arrayList.get(arrayList.size()-1).distance = 0;
		while(!arrayList.isEmpty()){
			Item currentItem = arrayList.remove(arrayList.size()-1);
			int vertex = currentItem.vertex;
			int currentDistance = currentItem.distance;
			if(currentDistance == Integer.MAX_VALUE) break;
			for(int[] edge : edges[vertex]){
				int nextVertex = edge[0];
				int nextDistance = edge[1];
				if(nextDistance+currentDistance< hash.get(nextVertex).distance){
					hash.get(nextVertex).distance = nextDistance+currentDistance;
					Collections.sort(arrayList);
				}
			}
		}
		for(int i=0;i<dp.length;i++){
			dp[i] = hash.get(i).distance;
			if(dp[i] == Integer.MAX_VALUE) dp[i] = -1;
		}
    return dp;
  }
	public class Item implements Comparable<Item>{
		public int vertex;
		public int distance;
		public Item(int vertex, int distance){
			this.vertex = vertex;
			this.distance = distance;
		}
		@Override
		public String toString(){
			return "vertex: " + vertex + " distance: " + distance;
		}
		@Override
		public int compareTo(Item arg0){
			return arg0.distance - this.distance;
		}
	}
}
class Program1 {
  public int[] dijkstrasAlgorithm(int start, int[][][] edges) {
    // Write your code here.
		//O(v^2 +e) time | O(v) space
		int[] dp = new int[edges.length];
		HashSet<Integer> set = new HashSet<Integer>();
		Arrays.fill(dp,Integer.MAX_VALUE);
		dp[start] = 0;
		while(set.size() != edges.length){
			int currentDistance = Integer.MAX_VALUE;
			int vertex = -1;
			for(int i=0;i<dp.length;i++){
				if(set.contains(i)) continue;
				if(dp[i]<=currentDistance){
					currentDistance = dp[i];
					vertex = i;
				}
			}
			if(currentDistance == Integer.MAX_VALUE) break;
			set.add(vertex);
			for(int[] edge : edges[vertex]){
				int nextVertex = edge[0];
				int nextDistance = edge[1];
				if(set.contains(nextVertex)) continue;
				dp[nextVertex] = Math.min(currentDistance+nextDistance, dp[nextVertex]);
			}
		}
		for(int i=0;i<dp.length;i++) {
			if(dp[i]==Integer.MAX_VALUE) dp[i] = -1;
		}
    return dp;
  }
}

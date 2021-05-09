package kakao_Internship_2021;
import java.util.*;
/* 

for this problem,
we wil use a graph 
and a bfs to find the shortest possible path
we will create two hashmap graphs to use interchangeably 
when the trap doors are opened 

only possible inputs are given!

*/
class Node{
    int start;
    int end;
    int time;
    Node(int start,int end,int time){
        this.start = start;
        this.end = end;
        this.time = time;
    }
    @Override
    public String toString(){
        return "start: " + start + " end: "  + end + " time: "  + time;
    }
}
public class problem4 {
    static HashMap<Integer,ArrayList<Node>> hashOrder = new HashMap<Integer,ArrayList<Node>>();
    static HashMap<Integer,ArrayList<Node>> hashReverse = new HashMap<Integer,ArrayList<Node>>();
    static boolean order;
    static int[] dp;
    static HashSet<Integer> visit =  new HashSet<Integer>();
    static int answer = 0;
    static ArrayList<Integer> trapArrayList = new ArrayList<Integer>();
    static int endNode;
    
    public static void main(String[] args) throws Exception {
        int n = 4;
        int start = 1;
        int end  = 4;
        int[][] roads = {{1, 2, 1}, {3, 2, 1}, {2, 4, 1}};
        int[] traps = {2, 3};
        System.out.println(solution(n, start, end, roads, traps));
    }

    public static int solution(int n, int start, int end, int[][] roads, int[] traps) {
        dp = new int[n+1];
        for(int i=0;i<n-1;i++){
            addHash(roads[i][0],roads[i][1],roads[i][2]);
        }
        for(int i:traps){
            trapArrayList.add(i);
        }
        endNode = end;
        System.out.println("hashOrder => " + hashOrder);
        System.out.println("hashReverse => " + hashReverse);
        dfs(0,start,true,0);
        return answer;
    }

    public static void addHash(int p, int c, int t){
        if(hashOrder.containsKey(p)){
             hashOrder.get(p).add(new Node(p,c,t));       
        } else {
            ArrayList<Node> temp = new ArrayList<Node>();
            temp.add(new Node(p,c,t));
            hashOrder.put(p,temp);
        }
        if(hashReverse.containsKey(c)){
            hashReverse.get(c).add(new Node(c,p,t));       
       } else {
           ArrayList<Node> temp = new ArrayList<Node>();
           temp.add(new Node(c,p,t));
           hashReverse.put(c,temp);
       }    
    }
    public static void dfs (int parent, boolean order, int time){
        System.out.println("new dfs => previous: " + previous+ " parent: " + parent + " order: " + order + " time: " + time);
        if(parent==endNode){
            answer = Math.max(answer, time);
            return;
        }
        ArrayList<Node> arrayList;
        Node node;
        boolean nextOrder;
        if(order ==true){
            if(!hashOrder.containsKey(parent)){
                return;
            }
            arrayList = hashOrder.get(parent);
        } else {
            if(!hashReverse.containsKey(parent)){
                return;
            }
            arrayList = hashReverse.get(parent);
        }
        for(int i=0;i<arrayList.size();i++){
            node = arrayList.get(i);
            if(dp[node.end] != 0){
                node[parent] = Math.min(node[parent],node[]);
                continue;
            }
            if(trapArrayList.contains(node.end)){
                nextOrder = !order;
            } else {
                nextOrder = order;
            }
            dfs(parent,node.end,nextOrder,time+node.time);
        }
       
        return;
    }
    public static boolean check(boolean current,int node){             
        if(trapArrayList.contains(node)){
            order = !order;
        } 
        return order;
    }
}

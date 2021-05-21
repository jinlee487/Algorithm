package greedy_algorythm;
import java.io.*;
import java.util.*;

/*
SOLVED!!
https://www.acmicpc.net/problem/19941
햄버거 분배
for this problem I will use a priority que. the priority que size will be K. 
*/
class HP {
    int index;
    char obj;
    HP(int index,char obj){
        this.index = index;
        this.obj = obj;
    }
}
public class B19941 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[] arr = br.readLine().toCharArray();
        PriorityQueue<HP> hamburger = new PriorityQueue<HP>(new Comparator<HP>(){
            @Override
            public int compare(HP o1, HP o2){
                return o1.index - o2.index;
            }
        });
        PriorityQueue<HP> people = new PriorityQueue<HP>(new Comparator<HP>(){
            @Override
            public int compare(HP o1, HP o2){
                return o1.index - o2.index;
            }
        });
        HP hp;
        for(int i=0, count=0;i<arr.length;i++){
            hp = new HP(i,arr[i]);
            if(hp.obj == 'H'){
                hamburger.add(hp);
            } else {
                people.add(hp); 
            }
            for(;!hamburger.isEmpty()&&hamburger.peek().index<i-K;){
                hamburger.poll();
            }
            for(;!people.isEmpty()&&people.peek().index<i-K;){
                people.poll();
            }
            if(!people.isEmpty()&&!hamburger.isEmpty()){
                people.poll();
                hamburger.poll();
                count ++;
            }
        }
        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
        br.close();
    }
}

package DEV_CARNIVAL_2021;
import java.io.*;
import java.util.*;
//for this problem, we have to sort the array by the index and the amount of food they can eat
class P {
    int index;
    int a;
    P(int index, int a){
        this.index = index;
        this.a = a;
    }
    @Override
    public String toString(){
        return "index: " + index + " a: "+ a;
    }
}
class P1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Queue<P> que = new LinkedList<P>();
        for(int i=1;i<N+1;i++){
            que.add(new P(i,Integer.parseInt(st.nextToken())));
        }
        for(;!que.isEmpty()&&que.peek().index!=K;){
            que.add(que.poll());
        }
        P p;
        StringBuilder str = new StringBuilder();
        for(;!que.isEmpty();){
            p = que.poll();
            p.a --;
            if(p.a<=0){
                str.append(p.index + " ");
            } else {
                que.add(p);
            }
        }
        System.out.println(str.toString());
	}
}
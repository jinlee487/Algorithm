package greedy_algorythm;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/10775
 * 
 *  공항
 * 
 *  당신은 i번째 비행기를 1번부터 gi (1 ≤ gi ≤ G) 번째 게이트중 
 *  하나에 영구적으로 도킹하려 한다. 
 *  비행기가 어느 게이트에도 도킹할 수 없다면 공항이 폐쇄되고, 
 *  이후 어떤 비행기도 도착할 수 없다.
 *  https://steady-coding.tistory.com/114
 * 
*/
public class Airport { 
    static int[] parent;
    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int G = Integer.parseInt(br.readLine()); 
        int P = Integer.parseInt(br.readLine()); 
        int[] incoming = new int[P];

		for(int i=0;i<P;i++){
            incoming[i] = Integer.parseInt(br.readLine());
        }
        
		parent = new int[G + 1];
		for (int i = 1; i <= G; i++) {
			parent[i] = i;
		}

        // System.out.println("this is parent => "  + Arrays.toString(parent));
        // System.out.println("this is incoming arr => " + Arrays.toString(incoming));
        // System.out.println("this is gates => "+ Arrays.toString(gates));

/*         //previous work. timeout! N^2 problem 
        int[] gates = new int[G+1];
        Arrays.fill(gates, -1);
        // System.out.println("this is incoming arr => " + Arrays.toString(incoming));
        // System.out.println("this is gates => "+ Arrays.toString(gates));
        int gi,count=0;
        next:
        for(int i=0;i<P;i++){
            gi = incoming[i];
            // System.out.println("this is gi => "  +gi);
            for(int j=gi;0<j;j--){
                // System.out.println("this is j = > " + j);
                if(G<j){
                    // System.out.println("j is bigger than max gate number changed to => " + G);
                    j=G+1;
                    continue;
                    //if the loop start is bigger than max Gate number, 
                    //must change the start since it is inefficient to loop 
                }
                if(gates[j]==-1){
                    // System.out.println("plane docked in gate => " + j);
                    gates[j]=gi;
                    count++;
                    continue next;
                    //if the particular gate j is empty, dock the plane on that gate
                    //after the docking, continue to the next loop
                }
            }
            // System.out.println("the dock is full! ending loop at i => " + i);
            break;
            //if we reach this break, 
            //that means we could not dock the current plane because the gates were full
        }
        System.out.println(count); 
 */
		int ans = 0;
		for (int i = 0; i < P; i++) {
            // System.out.println("this is i => " + i );
            // System.out.println("finding incoming[i] => " + incoming[i]);
			int emptyGate = find(incoming[i]);

			if (emptyGate == 0) {
				break;
			}

			ans++;
			union(emptyGate, emptyGate - 1);
		}

		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static int find(int x) {
        // System.out.println("this is find method");
		if (x == parent[x]) {
            // System.out.println("matching x => " + x);;
			return x;
		}
        // System.out.println("going to next loop! parent[x]=> " + parent[x]);
		return parent[x] = find(parent[x]);
	}

	public static void union(int x, int y) {
        // System.out.println("this is union method");
        // System.out.println("x => " + x + " y => "+ y);
        x = find(x);
		y = find(y);
        // System.out.println("after find x => " + x + " y => "+ y);
		if (x != y) {
            parent[x] = y;
            // System.out.println("does not match! parent[x] => " + y);
		}
	}
	
}


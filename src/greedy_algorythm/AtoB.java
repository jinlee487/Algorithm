package greedy_algorythm;

import java.io.*; 
import java.util.*;
/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/16953
 * A → B
*/
public class AtoB { 
    static long A, B;
	static int res, cnt;
    public static void main(String[] args) throws IOException{ 
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(reader.readLine()); 
        A = Long.parseLong(st.nextToken()); 
        B = Long.parseLong(st.nextToken()); 
        res = -1;
		
		dfs(A, 0);
		System.out.println(res);
	}
	
	static void dfs(long cur, int cnt) {
		if(cur > B) return;
		if(cur == B) {
			res = cnt + 1;
			return;
		}
		if(res!=-1){
            return;
        }
		dfs(opt1(cur), cnt + 1);
		dfs(opt2(cur), cnt + 1);
		
	}
    static long opt1(long input){
        return input*2;
    }
    static long opt2(long input){
        return input*10+1;
    }
}


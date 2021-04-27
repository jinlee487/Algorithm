package greedy_algorythm;
import java.util.*;
import java.io.*;
import java.awt.*;
/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/12904
 * A와B
*/
public class AandB {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String S = br.readLine();
        String T = br.readLine();
        // System.out.println("this is S: " + S + " T: " + T);
        //we need to turn S into T 
        //add A as the last character of S 
        //reverse S then add B as the last Character of S

        bw.write(Integer.toString(dfs(S,T)));
        bw.flush();
        bw.close();
        br.close();

    }
    public static int dfs(String s, String t){
        
        if(s.equals(t)){
            return 1;
        }
        if(t.length()<s.length()){
            return 0;
        }
        StringBuilder sb = new StringBuilder();

        if(!t.contains(sb.append(s).reverse().toString())&&!t.contains(s)){
            return 0;
        }

        sb = new StringBuilder();
        sb.append(s);
        sb.append("A");
        if(dfs(sb.toString(),t)==1){
            return 1;
        };
        sb = new StringBuilder();
        sb.append(s);
        sb.reverse();
        sb.append("B");
        if(dfs(sb.toString(),t)==1){
            return 1;
        };
        return 0;

    }
}

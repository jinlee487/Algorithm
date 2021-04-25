package step_by_step;

import java.io.*;
import java.util.*;
/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/10998
 * A×B 
*/

public class AxB {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
       

        bw.write(Integer.toString(a*b));
        bw.flush();
        bw.close();
        br.close();
    }
 
}

package step_by_step;

import java.io.*;
import java.util.*;
/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/10171
 * 고양이
*/

public class Cat {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

 
       

        bw.write("\\    /\\ \n" + 
                " )  ( ')\n" +
                "(  /  )\n"+
                " \\(__)|");
        bw.flush();
        bw.close();
        br.close();
    }
 
}

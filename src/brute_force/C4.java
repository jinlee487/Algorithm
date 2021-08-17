package brute_force;
import java.util.*;
import java.io.*;
// https://codeforces.com/problemset/problem/4/A
// A. Watermelon
// solved!
public class C4 {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String answer;
        if(2<n&&n%2==0) {
            answer = "YES";
        } else {
            answer =  "NO";
        }
        bw.write(answer.toString());
        bw.flush();
        bw.close();
        br.close();    
    }
}
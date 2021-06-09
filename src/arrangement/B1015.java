package arrangement;

import java.util.*;
import java.io.*;
/* 
Solved!
https://www.acmicpc.net/problem/1015
수열 정렬
*/

class Number {
    int n;
    int idx;
    Number(int n,int idx) {
        this.n = n; this.idx = idx;
    }
    @Override
    public String toString(){
        return "n: " + n + " idx: " + idx;
    }
}
public class B1015 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Number[] A = new Number[N];
        Number[] B = new Number[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            A[i] = new Number(Integer.parseInt(st.nextToken()),i);
            B[i] = A[i];
        }
        Arrays.sort(A,new Comparator<Number>() { 
            @Override 
            public int compare(Number o1, Number o2) { 
                return o1.n-o2.n; 
            } 
        });
        for(int i=0;i<N;i++){
            A[i].idx = i;
        }
        StringBuilder str = new StringBuilder();
        for(int i=0;i<N;i++){
            str.append(B[i].idx + " ");
        }
        bw.write(str.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

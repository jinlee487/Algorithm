package dynamic_programming;

import java.util.*;
import java.io.*;
/* 
Solved!
https://www.acmicpc.net/problem/1463
1로 만들기
문제 해설: https://seohyun0120.tistory.com/entry/%EB%B0%B1%EC%A4%80-1463-1%EB%A1%9C-%EB%A7%8C%EB%93%A4%EA%B8%B0-%ED%92%80%EC%9D%B4-Dynamic-Programming-python-%ED%8C%8C%EC%9D%B4%EC%8D%AC
*/
class B1463 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        arr[0] = 0;
        arr[1] = 0;
        for(int i=2;i<N+1;i++){
            arr[i] = arr[i-1] + 1;
            if(i%2 == 0){
                arr[i] = Math.min(arr[i/2]+1,arr[i]);
            }
            if(i%3 == 0){
                arr[i] = Math.min(arr[i/3]+1,arr[i]);
            }
        }
        bw.write(Integer.toString(arr[N]));
        bw.flush();
        bw.close();
        br.close();
    }
}



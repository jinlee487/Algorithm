package greedy_algorythm;

import java.util.*;
import java.io.*;
 
/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/1758
 * 알바생 강호
*/
public class PartTimeWorkerKangho {
    
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        int N = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[N];

        for (int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr, Comparator.reverseOrder());
        Long ans = 0L;
        for(int i=0;i<N;i++){
            if((arr[i]-(i+1-1))<0){
                break;
            }
            ans += (arr[i]-(i+1-1));
        }
       
        bw.write(Long.toString(ans) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

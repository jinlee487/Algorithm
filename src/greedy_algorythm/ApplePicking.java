package greedy_algorythm;
import java.util.*;
import java.io.*;

/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/2828
 * 사과 담기 게임
*/
public class ApplePicking {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // size of the game 
        int M = Integer.parseInt(st.nextToken()); // size of the basket 
        int J = Integer.parseInt(br.readLine()); // count of apples
        int[] arr = new int[J];
        int ans=0;
        int min = 0;
        int max = M-1;
        int r,l;
        for(int i=0;i<J;i++){
            arr[i] = Integer.parseInt(br.readLine())-1;
        }

        for(int i=0;i<arr.length;i++){

            if(min<=arr[i] && arr[i]<=max){
                continue;
            }
 

            if(arr[i]<min){  
                l = Math.abs(arr[i]-min);
                ans += l;
                min -= l;
                max -= l;
            } else if (max<arr[i]) {
                r = Math.abs(arr[i]-max);
                ans += r;
                min += r;
                max += r;
            }
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();  
    }    
}

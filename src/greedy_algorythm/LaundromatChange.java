package greedy_algorythm;

import java.util.Arrays;
import java.util.Comparator;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/2720
 * 세탁소 사장 동혁
 * 
*/
public class LaundromatChange {
	public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] ans = new int[4];
		int N = Integer.parseInt(br.readLine());
        int[] change = new int[N];
        for(int i=0;i<N;i++){
            change[i]=Integer.parseInt(br.readLine());
        }  
        // bw.write("this is change => " + Arrays.toString(change) + "\n");
        for(int i=0;i<change.length;i++){
            int c = change[i];
            ans[0]=c/25;
            c = c%25;
            if(c==0) {
                bw.write(ans[0] + " " + ans[1] + " " + ans[2] + " " + ans[3] + "\n");
                Arrays.fill(ans,0);
                continue;
            }
            ans[1]=c/10;
            c = c%10;
            if(c==0) {
                bw.write(ans[0] + " " + ans[1] + " " + ans[2] + " " + ans[3] + "\n");
                Arrays.fill(ans,0);
                continue;
            }
            ans[2]=c/5;
            c = c%5;
            if(c==0) {
                bw.write(ans[0] + " " + ans[1] + " " + ans[2] + " " + ans[3] + "\n");
                Arrays.fill(ans,0);
                continue;
            }
            ans[3]=c/1;
            c = c%1;
            if(c==0) {
                bw.write(ans[0] + " " + ans[1] + " " + ans[2] + " " + ans[3] + "\n");
                Arrays.fill(ans,0);
                continue;
            }
        }
        // bw.write(ans[0] + " " + ans[1] + " " + ans[2] + " " + ans[3] + "\n");
		bw.flush();
		bw.close();
		br.close();
    }
}
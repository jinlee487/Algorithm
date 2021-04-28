package greedy_algorythm;

import java.util.*;
import java.io.*;
 
/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/2873
 * 롤러코스터
 * 해설 => https://dundung.tistory.com/45
 * 
 * 짝짝
 * 홀홀
 * 홀짝
 * 짝홀
 * 
 * 상황을 생각해야한다
 * 
*/
public class RollerCoaster {
    
	public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[][] arr = new int[R][C]; 
        for(int i=0;i<R;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<C;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int[] i : arr){
            System.out.println(Arrays.toString(i));
        }
        
        bw.write("");
        bw.flush();
        bw.close();
        br.close();
    }
}

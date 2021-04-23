package greedy_algorythm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/2810
 * 컵홀더
*/
public class CupHolder {
    
	public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // System.out.println("this is N => " + N);
        char[] arr = br.readLine().toCharArray();
        int count = 1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='S'){
                count++;
            } else{
                count++;
                i++;
            }
        }
        System.out.println(N<count?N:count);
    }
}

package greedy_algorythm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;
/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/1783
 * 병든 나이트
 * https://do-rang.tistory.com/70
*/
public class SickKnight {
    
	public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        Long N = Long.parseLong(arr[0]);
        Long M = Long.parseLong(arr[1]);
        Long total_cnt = 0L;
        if(N == 1){}
        else if(N == 2){
            total_cnt = (M -1) /2;
            total_cnt = total_cnt > 3? 3 : total_cnt;
        }
        else if (M < 7 ) {
            total_cnt = M -1;
            total_cnt = total_cnt > 3 ? 3:total_cnt;
        }
        else{
            total_cnt = 4 + M -7;
        }
        System.out.println(total_cnt+1);
    }
}

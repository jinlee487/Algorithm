package greedy_algorythm;

import java.io.*; 
import java.util.*;
/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/1847
 * 게임을 만든 동준이
*/
public class GameCreatorDongJun { 
    public static void main(String[] args) throws IOException{ 
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
        int N = Integer.parseInt(reader.readLine()); 
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(reader.readLine());
        } 
        // System.out.println("this is arr => " + Arrays.toString(arr));
        Long count = 0L;
        //simply subtract untill the previous level is lower than the current level
		for(int i=arr.length-1; 0<i; i--) {
            if(arr[i]<=arr[i-1]){
                count += arr[i-1]+1-arr[i]; 
                arr[i-1] = arr[i]-1;
            }
		}

		System.out.println(count);

        reader.close();
        

    }
}


package greedy_algorythm;

import java.io.*; 
import java.util.*;
/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/1449
 * 수리공 항승 
*/
public class PipeTape { 
    public static void main(String[] args) throws IOException{ 
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(reader.readLine()); 
        int N = Integer.parseInt(st.nextToken()); 
        int L = Integer.parseInt(st.nextToken()); 
        st = new StringTokenizer(reader.readLine()); 
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        } 
        Arrays.sort(arr);
        System.out.println("this is arr => " + Arrays.toString(arr));
        int min = 0;
        int tapeRange = (int)(arr[0] - 0.5 + L);
		min ++;

        Arrays.sort(arr);
        //tape's starting position till tape legnth, if it is more, we need more tape, hence min ++ 
		for(int i=1; i<arr.length; i++) {
			if (tapeRange < (int)(arr[i] + 0.5)){
				tapeRange = (int)(arr[i] - 0.5 + L);
				min ++;
			}
		}

		System.out.println(min);

        reader.close();
        

    }
}


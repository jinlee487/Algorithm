package greedy_algorythm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;
/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/2437
 * 저울
*/
public class Scale {
    
	public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
        int N = Integer.parseInt(br.readLine());
        long[] arr = Stream.of(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
		Arrays.sort(arr);
        
        // System.out.println("this is input => " + Arrays.toString(arr));
        // System.out.println("\nthis is ans => ");
        Long min = 1L;
        for(int i=0;i<arr.length;i++){
            if(min<arr[i]){
                break;
            } else{
                min+=arr[i];
            }
        }
        System.out.println(min);
    }
}

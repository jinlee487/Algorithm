package greedy_algorythm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/1744
 * 수 묶음
 * 조건 1. 음수* 음수,  양수*양수 최대값,  단!  (양수 *1)은 (양수+1)값보다 작으므로 조건처리
 * 조건 2. 음수*0은 최대값 
*/
public class NumberBundle {
    
	public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
        int N = Integer.parseInt(br.readLine());
        Long[] arr = new Long[N];
        
        for(int i=0;i<N;i++){
            arr[i] = Long.parseLong(br.readLine());
        }
		Arrays.sort(arr, Comparator.reverseOrder());
        // System.out.println("this is the input array => \n" + Arrays.toString(arr));
        Long ans=0L;
        if(N==1){
            System.out.println(arr[0]);
            System.exit(0);
        }
        for(int i=0;i<N;i++){
            if(arr[i]==1){
                ans+=arr[i];
            } else if(1<arr[i]){
                if((i+1)<N&&1<arr[i+1]){
                    ans+=arr[i+1]*arr[i];
                    i++;
                }else{
                    ans+=arr[i];
                }
            } else if(arr[i]<1){
                break;
            }
        }
        for(int i=N-1;0<=i;i--){
            if(0<arr[i]){
                break;
            }
            else {
                if(0<=(i-1)&&arr[i-1]<1){
                    ans+=arr[i]*arr[i-1];
                    i--;
                } else{
                    ans+=arr[i];
                }
            }
        }
        System.out.println(ans);
    }
}

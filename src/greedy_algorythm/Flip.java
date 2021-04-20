package greedy_algorythm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;
/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/1439
 * 뒤집기
*/
public class Flip {
    
	public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        // StringBuffer outputBuffer = new StringBuffer(1000000);
        // for (int i = 0; i < 1000001; i++){
        // outputBuffer.append("1");
        // }
        // String input = outputBuffer.toString();
        String[] arr = input.split("");
        // String[] arr = new String[1000001];
        // Arrays.fill(arr, "0");
        // arr[0]="1";
        // arr[2]="1";
        int one=0,zero=0,current=-1;
        for(int i=0;i<arr.length;i++){
            if (arr[i].equals("1")&&current!=1){
                one+=1;
                current=1;
            }
            else if(arr[i].equals("0")&&current!=0){
                zero+=1;
                current=0;
            }
        }
        if(input.equals("")){
            System.out.println(0);
        }else{
            System.out.println(Math.min(one, zero));
        }
    }
}

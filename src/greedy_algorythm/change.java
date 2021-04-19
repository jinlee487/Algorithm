package greedy_algorythm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/5585
 * 거스름돈
 * 
*/
public class change {
       
	public static void main(String[] args) throws IOException	{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int money = 1000-Integer.parseInt(br.readLine());
		
		int count=0;
		
		int a[] = {500,100,50,10,5,1};
		
        for(int i=0;money>0;i++){
            count += money/a[i];
            money = money%a[i];
            if(money == 0){
                break;
            }
		}
		
		System.out.println(count);
	}
}

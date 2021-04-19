package greedy_algorythm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/13305
 * 주유소
 * https://st-lab.tistory.com/192
*/
public class GasStation {
    
	public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
        int N = Integer.parseInt(br.readLine());
        String[] distance = br.readLine().split(" ");
        String[] gas = br.readLine().split(" ");
        Long[] gp = new Long[N];

        gp[0]=Long.parseLong(gas[0]);

        for(int i=1;i<gas.length;i++){
            gp[i]=Long.parseLong(gas[i]);
            if(gp[i]>gp[i-1]){
                gp[i]=gp[i-1];
            }
        }

        Long total=0L;

        for(int i=0;i<gp.length-1;i++){
            total += gp[i]*Long.parseLong(distance[i]);
        }

        System.out.println(total);
    }
}

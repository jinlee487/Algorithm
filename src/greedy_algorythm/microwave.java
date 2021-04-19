package greedy_algorythm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/10162
 * 전자렌지
 * 
*/
public class microwave {
	public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int time = Integer.parseInt(br.readLine());
				
		int a[] = {300,60,10};
		int b[] = new int[3];
        for(int i=0;time>0&&i<3;i++){
            b[i] = time/a[i];
            time = time%a[i];
            if(time == 0){
                break;
            }
		}
		if(time>0){
            System.out.println(-1);
        } else{
            System.out.println(b[0] + " " + b[1] + " " + b[2]);
        }
    }
}
package greedy_algorythm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/4796
 * 캠핑
*/
public class Camping {

	public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int L,P,V;
        int c=1;
		while(true){
            String LPV = br.readLine();
            if(LPV.equals("0 0 0")){
                break;
            }
            String[] temp = LPV.split(" ");
            L = Integer.parseInt(temp[0]);
            P = Integer.parseInt(temp[1]);
            V = Integer.parseInt(temp[2]);

            System.out.println("Case "+ c++ +": "+ (L*(V/P)+(V%P<L?V%P:L)));
        }
    }
}

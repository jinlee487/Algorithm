package greedy_algorythm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/1339
 * 단어 수학 
 * 
*/
public class lettermath {
    
	public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
        Integer[] alphabet = new Integer[26];
        Arrays.fill(alphabet,0);
        for(int i=0;i<N;i++){
            String[] temp = br.readLine().split("");
            for(int j=0;j<temp.length;j++){
                int idx = 0;
                switch (temp[j]) {
                    case "A":
                        idx=0;
                        break;
                    case "B":
                        idx=1;
                        break;
                    case "C":
                        idx=2;
                        break;                    
                    case "D":
                        idx=3;
                        break;                    
                    case "E":
                        idx=4;
                        break;                   
                    case "F":
                        idx=5;
                        break;                    
                    case "G":
                        idx=6;
                        break;                    
                    case "H":
                        idx=7;
                        break;                    
                    case "I":
                        idx=8;
                        break;                    
                    case "J":
                        idx=9;
                        break; 
                    case "K":
                        idx=10;
                        break;    
                    case "L":
                        idx=11;
                        break;  
                    case "M":
                        idx=12;
                        break;            
                    case "N":
                        idx=13;
                        break;  
                    case "O":
                        idx=14;
                        break; 
                    case "P":
                        idx=15;
                        break;  
                    case "Q":
                        idx=16;
                        break;  
                    case "R":
                        idx=17;
                        break;  
                    case "S":
                        idx=18;
                        break;  
                    case "T":
                        idx=19;
                        break;  
                    case "U":
                        idx=20;
                        break;  
                    case "V":
                        idx=21;
                        break;  
                    case "W":
                        idx=22;
                        break;  
                    case "X":
                        idx=23;
                        break;  
                    case "Y":
                        idx=24;
                        break;  
                    case "Z":
                        idx=25;
                        break;  

                }
                alphabet[idx] += (int) Math.pow(10, temp.length-j-1);

            }
        }
        Arrays.sort(alphabet, Collections.reverseOrder());
        int n = 9;
        int total=0;
        for(int i=0;i<alphabet.length;i++){
            total+=alphabet[i]*n--;
        }
        System.out.println(total);
    }
}

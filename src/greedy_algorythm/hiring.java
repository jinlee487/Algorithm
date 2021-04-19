package greedy_algorythm;

import java.util.Arrays;
import java.util.Comparator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/1946
 * 신입사원
 * 
*/
public class hiring {
	public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());

        for(int t=0;t<tc;t++){
            int app = Integer.parseInt(br.readLine());
            int arr[][]=new int[app][2]; //x좌표 y좌표
            for(int i=0;i<arr.length;i++) {
                String[] temp = br.readLine().split(" ");
                arr[i][0] = Integer.parseInt(temp[0]);              
                arr[i][1] = Integer.parseInt(temp[1]);
            }


            Arrays.sort(arr,new Comparator<int[]>() { //Comparator 인터페이스 재정의

                @Override
                public int compare(int[] o1, int[] o2) {
                    
                        
                     if(o1[0]==o2[0])// x좌표의 값이 같다면 y좌표를 기준으로 정렬		
                        return Integer.compare(o1[1], o2[1]);
                        
                    return Integer.compare(o1[0], o2[0]); // 나머지는 x좌표를 기준으로 정렬
                
                }		
                
            });

            int y = arr[0][1];

            int pass = 1;

            for(int k=1;k<arr.length;k++){
                if(arr[k][1]>y){
                    continue;
                }
                else { 
                    pass+=1; 
                    y = arr[k][1];
                }
            }       

            System.out.println(pass);
        }  
    }
}
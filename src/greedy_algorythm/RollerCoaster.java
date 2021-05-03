package greedy_algorythm;

import java.util.*;
import java.io.*;
 
/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/2873
 * 롤러코스터
 * 해설 => https://dundung.tistory.com/45
 * 
 * 짝짝
 * 홀홀
 * 홀짝
 * 짝홀
 * 
 * 상황을 생각해야한다
 * 
*/
public class RollerCoaster {
    
	public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[][] arr = new int[R][C]; 
        for(int i=0;i<R;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<C;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        StringBuilder str = new StringBuilder();
        if(R%2==1){
            for(int i=0;i<R;i++){
                if(i!=0){
                    str.append("D");
                }   
                for(int j=0;j<C-1;j++){
                    if(i==R-1&&j==C-1){
                        break;
                    }
                    if(i%2==0){
                        str.append("R");
                    } else{
                        str.append("L");
                    }
                }
            }
        }
        else if(C%2==1){
            for(int i=0;i<C;i++){
                if(i!=0){
                    str.append("R");
                }   
                for(int j=0;j<R-1;j++){
                    if(i==C-1&&j==R-1){
                        break;
                    }
                    if(i%2==0){
                        str.append("D");
                    } else{
                        str.append("U");
                    }
                }
            } 
        } else{
            StringBuilder str2 = new StringBuilder();
            int min = Integer.MAX_VALUE;
            int x=0,y=0;
            for(int i=0;i<R;i++){
                for(int j=0;j<C;j++){
                    if((i%2==0&&j%2==0)||(i%2==1&&j%2==1)){
                        continue;
                    }
                    if(arr[i][j]<min){
                        min= arr[i][j];
                        x = i;
                        y = j;
                    }
                }
            }
            int ax=0,ay=0,bx=R-1,by=C-1;
            while(bx-ax>1){
                if(ax/2 < x/2){
                    for (int i=0; i<C-1; i++) {
                        str.append("R");
                    }
                    str.append("D");
                    for (int i=0; i<C-1; i++) {
                        str.append("L");
                    }
                    str.append("D");
                    ax+=2;
                }
                if(x/2 < bx/2){
                    for (int i=0; i<C-1; i++) {
                        str2.append("R");
                    }
                    str2.append("D");
                    for (int i=0; i<C-1; i++) {
                        str2.append("L");
                    }
                    str2.append("D");
                    bx-=2;
                }
            }
            while (by - ay > 1) { //2줄 남았을 경우 인접한 2칸에서 검정칸이 없다면 지우기
                if (ay/2 < y/2) {
                    str.append("D");
                    str.append("R");
                    str.append("U");
                    str.append("R");
                    ay+=2;
                }
                if (y/2 < by/2) {
                    str2.append("D");
                    str2.append("R");
                    str2.append("U");
                    str2.append("R");
                    by-=2;
                }
            }
            if (y == ay) { //2x2칸 남았을 경우
                str.append("R");
                str.append("D");
            } else {
                str.append("D");
                str.append("R");
            }
            str2.reverse(); //도착점에서 출발한 경로 뒤집기
            str.append(str2);
        }
        bw.write(str.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

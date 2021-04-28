package greedy_algorythm;

import java.util.*;
import java.io.*;
 
/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/2437
 * 오셀로 재배치
 * 해설 => https://m.blog.naver.com/PostView.nhn?blogId=occidere&logNo=220871581916&proxyReferer=https:%2F%2Fwww.google.com%2F
 * 접근 방식: W와 B로 이뤄진 문자열을 두개 입력받는다. 
 * 둘 중 아무 문자열이나 기준으로 잡고 다른 문자열과 얼마나 다른지 W와 B를 각각 센다. 
 * 이후 W와 B중 최소값과, |W - B| 를 해준 값을 더해주면 답이 나온다.
 *
 * 초기 상태: BWWBB
 * 목표 상태: WBBWW
 * 기준 : BWWBB, 차이: W 2개, B 3개
 * 맞추는 작업: 1번째와 2번째 자리를 바꾼다(1회), 
 * 3번째와 4번째의 자리를 바꾼다(1회), 
 * 5번째를 뒤집는다(1)회 -> 총 3회
 * 식으로 표현: min(3, 2) + |2 - 3| = 2 + 1 = 3회
*/
public class RearrageReversi {
    
	public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int M;
        int w, b, ans=0;
        String s1,s2;
        StringBuilder str = new StringBuilder();
        for(int i=0;i<N;i++){
            M = Integer.parseInt(br.readLine());
            s1 = br.readLine();
            s2 = br.readLine();
            w=0; b=0;
            for(int j=0;j<M;j++){
                if(s1.charAt(j)!=s2.charAt(j)){
                    if(s1.charAt(j)=='W'){
                        w+=1;
                    } else{
                        b+=1;
                    }
                }
            }
            ans = Math.min(w,b) + Math.abs(w-b);
            str.append(Integer.toString(ans)+"\n");
            
        }
        bw.write(str.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

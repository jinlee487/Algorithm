package geometry;

import java.io.*;
import java.util.StringTokenizer;
/* 
https://www.acmicpc.net/problem/1004
어린왕자
기하학 
*/
public class B1004 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            int answer = 0;

            // 입력 값 초기화
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            int n = Integer.parseInt(br.readLine());

            // 행성 정보 초기화
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int radius = Integer.parseInt(st.nextToken());

                // 출발점이 현재 행성의 안에 있는지 밖에 있는지 여부
                boolean check1 = false;
                // 도착점이 현재 행성의 안에 있는지 밖에 있는지 여부
                boolean check2 = false;

                // 시작점이 행성의 밖에 있으면 true
                if(Math.pow(startX - x, 2) + Math.pow(startY - y, 2) > Math.pow(radius, 2)) check1 = true;
                // 도착점이 행성의 밖에 있으면 true
                if(Math.pow(endX - x, 2) + Math.pow(endY - y, 2) > Math.pow(radius, 2)) check2 = true;

                // 시작점, 도착점 둘 중에 하나만 행성안에 있고 다른점은 밖에 있는 경우
                if(check1 == true && check2 == false) answer++;
                else if(check1 == false && check2 == true) answer++;
            }

            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
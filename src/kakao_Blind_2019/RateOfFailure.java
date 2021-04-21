package kakao_Blind_2019;

import java.util.Arrays;
import java.util.Comparator;
/*
 * SOLVED!!
 * https://programmers.co.kr/learn/courses/30/lessons/42889
 * 실패율
*/
public class RateOfFailure {
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
        int N = 2;
        int[] stages = {1,1};

		System.out.println(Arrays.toString(solution(N,stages)));
	}
    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        float[][] arr = new float[N][2];
        int[] s = new int[N+1];
        Arrays.fill(s, 0);
        // this is the count for stages
        // fill it up 
        for(int i=0;i<stages.length;i++){
            s[stages[i]-1] +=1;
        }
        System.out.println("this is s => " + Arrays.toString(s));

        //now that s is filled, we can loop to calc the rate of failure
        int players = stages.length; 
        // this is the total number of all players in the game

        for(int i=0;i<s.length-1;i++){
            System.out.println("this is i => " + i);
            if(players!=0){
                arr[i][0] = (float) s[i]/players;
            } 
            else{
                arr[i][0]=0;
            }
            System.out.println("this is s[i] => " +s[i]);
            System.out.println("this is players => " +players);
            System.out.println("this is  arr[i][0] => " + arr[i][0]);

            arr[i][1] = i+1;
            players -= s[i];
        }

        Arrays.sort(arr,new Comparator<float[]>() { //Comparator 인터페이스 재정의

            @Override
            public int compare(float[] o1, float[] o2) {
                
                    
                 if(o1[0]==o2[0])// x좌표의 값이 같다면 y좌표를 기준으로 정렬		
                    return Float.compare(o1[1], o2[1]);
                    
                return Float.compare(o2[0], o1[0]); // 나머지는 x좌표를 기준으로 정렬
            
            }		
            
        });
        System.out.println("this is the sorted arr => ");
        for(int i=0;i<arr.length;i++){
            System.out.println(Arrays.toString(arr[i]));
        }
        for(int i=0;i<arr.length;i++){
            answer[i] =  (int) arr[i][1];
        }
        return answer;
    }
}

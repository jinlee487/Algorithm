package Naver_Blind_2021;
import java.util.*;

/*
 *
 * v는 세 점의 좌표가 들어있는 2차원 배열입니다.
 * v의 각 원소는 점의 좌표를 나타내며, 좌표는 [x축 좌표, y축 좌표] 순으로 주어집니다.
 * 좌표값은 1 이상 10억 이하의 자연수입니다.
 * 직사각형을 만드는 데 필요한 나머지 한 점의 좌표를 [x축 좌표, y축 좌표] 순으로 담아 return 해주세요.
 * 
 * 네이버 상반기 코딩 테스트 
 * 데모 테스트 문제 
 * 사각형 만들기 
*/
public class programming1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] v = {{1, 4}, {3, 4}, {3, 10}};
        System.out.println(Arrays.toString(solution(v)));
    }
    public static int[] solution(int[][] v) {
        int[] answer = new int[2];
        //we have to find the coordinate that makes up the rectangle. 
        // [[1, 4], [3, 4], [3, 10]] is the input 
        // which leaves [1, 10]
        // how to find the last coordinate? 
        // find the coordinate x and y where there is not other matching pairs
        HashMap<Integer,Boolean> xmap = new HashMap<Integer,Boolean>();
        HashMap<Integer,Boolean> ymap = new HashMap<Integer,Boolean>();
        for(int i=0;i<3;i++){
            for(int j=0;j<2;j++){
                if(j==0){
                    if(xmap.containsKey(v[i][j])){
                        xmap.put(v[i][j],true);
                    } 
                    else{
                        xmap.put(v[i][j],false);
                    }                
                } 
                else{
                    if(ymap.containsKey(v[i][j])){
                        ymap.put(v[i][j],true);
                    } 
                    else{
                        ymap.put(v[i][j],false);
                    }  
                }
            }
        }
        for (Map.Entry<Integer,Boolean> entry1 : xmap.entrySet()){
            if(entry1.getValue()==false){
                answer[0]=entry1.getKey();
            };
        }
        for (Map.Entry<Integer,Boolean> entry2 : ymap.entrySet()){
            if(entry2.getValue()==false){
                answer[1]=entry2.getKey();
            };
        }
        System.out.println("Hello Java");

        return answer;
    }
}

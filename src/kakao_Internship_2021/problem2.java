package kakao_Internship_2021;
import java.util.*;
/* 
for this problem
we can backtrack the entire array[][]
once we find the person, we use dfs to find the nearest person 
then determin if the seating arrangement is optimal
PXP
POO
*/
public class problem2 {
    static boolean[][] visit;
    static char[][] arr = new char[5][5];
    static int[] arrx = {1,-1,0,0}, arry = {0,0,1,-1};
    static ArrayList<String> arrayList;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[][] places = {{"POPOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPXX", "OXXXP", "POOXX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        System.out.println(Arrays.toString(solution(places)));
    }
    public static int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int i=0;i<places.length;i++){
            for(int j=0;j<places[i].length;j++){
                arr[j] = places[i][j].toCharArray();
            }
            answer = init(i,answer);

        }
        
        return answer;
    }
    public static int[] init(int idx,int[] answer){
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(arr[i][j]=='P'){
                    visit = new boolean[5][5];
                    arrayList = new ArrayList<String>();
                    if(!dfs(i,j,arrayList)){
                        answer[idx] = 0;
                        return answer;
                    } 
                }
            }
        }
        answer[idx] = 1;
        return answer;
    }
    public static boolean dfs(int x, int y,ArrayList<String> al){
        visit[x][y] = true;
        al.add(Character.toString(arr[x][y]));

        if(al.size()==3){
            StringBuilder str = new StringBuilder();
            for(String s:al){
                str.append(s);
            }
            if(!checkStr(str.toString())){
                return false;
            }
            return true;
        }
        int nx, ny;
        for(int i=0;i<4;i++){
            nx = x + arrx[i];
            ny = y + arry[i];
            if(check(nx,ny)){
                if(!dfs(nx,ny,al)){
                    return false;
                }
                al.remove(al.size()-1);
            }
        }
        return true;
    }
    public static boolean checkStr(String s){
        if(s.contains("PP")){
            return false;
        }
        if(s.contains("POP")){
            return false;
        }
        return true;
    }
    public static boolean check(int x, int y) {
        if(x<0||y<0||5<=x||5<=y){
            return false;
        }
        if(visit[x][y]==true){
            return false;
        }
        return true;
    }

}

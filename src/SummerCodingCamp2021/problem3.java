package SummerCodingCamp2021;


import java.util.*;
public class problem3 {
    static boolean[][] visit;
    static int score;
    static int[] arrx1 = {-1,0}, arry1 ={0,1};
    static int[] arrx2 = {-1,0}, arry2 ={0,-1};
    static int[] arrx3 = {1,0}, arry3 ={0,-1};
    static int[] arrx4 = {1,0}, arry4 ={0,1};
    static int x1,x2,x3,x4,y1,y2,y3,y4,power,radius;
    static int[][] arr;
    public static void main(String[] args) {

        int p = 19;
        int r = 6;
        int[][] maps = {{1, 28, 41, 22, 25, 79, 4}, {39, 20, 10, 17, 19, 18, 8}, {21, 4, 13, 12, 9, 29, 19}, {58, 1, 20, 5, 8, 16, 9}, {5, 6, 15, 2, 39, 8, 29},{39, 7, 17, 5, 4, 49, 5}, {74, 46, 8, 11, 25, 2, 11}};
        System.out.println(solution(maps, p, r));
    }
    public static int solution(int[][] maps, int p, int r) {
        power=p;
        radius=r;
        arr=maps;
        int answer = -1;

        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1;j++){
                score = 0;
                visit = new boolean[arr.length][arr.length];
                dfs1(i,j+1,1);
                dfs2(i,j,1);
                dfs3(i+1,j,1);
                dfs4(i+1,j+1,1);
                answer = Math.max(score,answer);
            }
        }
        return answer;
    }

    public static void dfs1(int x, int y, int distance){
        visit[x][y] = true;
        if(kill(x,y,distance)){
            score ++;
            return;
        }
        for(int i=0;i<2;i++){
            int nx = arrx1[i] + x;
            int ny = arry1[i] + y;
            if(check1(nx,ny)){
                dfs1(nx,ny,distance+1);
            }
        }
    }
    public static void dfs2(int x, int y, int distance){
        visit[x][y] = true;
        if(kill(x,y,distance)){
            score ++;
            return;
        }
        for(int i=0;i<2;i++){
            int nx = arrx2[i] + x;
            int ny = arry2[i] + y;
            if(check2(nx,ny)){
                dfs2(nx,ny,distance+1);
            }
        }
    }
    public static void dfs3(int x, int y, int distance){
        visit[x][y] = true;
        if(kill(x,y,distance)){
            score ++;
            return;
        }
        for(int i=0;i<2;i++){
            int nx = arrx3[i] + x;
            int ny = arry3[i] + y;
            if(check3(nx,ny)){
                dfs3(nx,ny,distance+1);
            }
        }
    }
    public static void dfs4(int x,int y, int distance){
        visit[x][y] = true;
        if(kill(x,y,distance)){
            score ++;
            return;
        }
        for(int i=0;i<2;i++){
            int nx = arrx4[i] + x;
            int ny = arry4[i] + y;
            if(check4(nx,ny)){
                dfs4(nx,ny,distance+1);
            }
        }
    }
    public static boolean kill(int x, int y, int distance){
        if(distance < radius/2){
            if(arr[x][y]<=power){
                return true;
            } else {
                return false;
            }
        } else if(distance == radius/2) {
            if(arr[x][y]<=((float) power/2)){
                return true;
            } else {
                return false;
            }
        }
        return false;        
    }

    public static boolean check1(int x, int y){
        if(x<0||y<0||arr.length<=x||arr.length<=y){
            return false;
        }
        if(x1<x){
            return false;
        }
        if(y<y1){
            return false;
        }
        if(visit[x][y]==true){
            return false;
        }
        return true;
    }
    public static boolean check2(int x, int y){
        if(x<0||y<0||arr.length<=x||arr.length<=y){
            return false;
        }
        if(x2<x){
            return false;
        }
        if(y2<y){
            return false;
        }
        if(visit[x][y]==true){
            return false;
        }
        return true;
    }
    public static boolean check3(int x, int y){
        if(x<0||y<0||arr.length<=x||arr.length<=y){
            return false;
        }
        if(x<x3){
            return false;
        }
        if(y2<y){
            return false;
        }
        if(visit[x][y]==true){
            return false;
        }
        return true;
    }
    public static boolean check4(int x, int y){
        if(x<0||y<0||arr.length<=x||arr.length<=y){
            return false;
        }
        if(x<x4){
            return false;
        }
        if(y<y4){
            return false;
        }
        if(visit[x][y]==true){
            return false;
        }
        return true;
    }  

}

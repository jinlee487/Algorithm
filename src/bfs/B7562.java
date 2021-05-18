package bfs;

import java.util.*;
import java.io.*;

/* 
Solved!
https://www.acmicpc.net/problem/7562
나이트의 이동
Solved!
simple bfs problem
*/

class Knight {
    int x;
    int y;
    int c;
    Knight(int x, int y, int c){
        this.x = x;
        this.y = y;
        this.c = c;
    }
    @Override
    public String toString(){
        return "x: " + x + " y: " + y + " c: " + c;
    }
}

class B7562 {
    static boolean[][] visit;
    static Knight destination;
    static int[] xarr = {-1,-2,-1,-2,1,2,1,2};
    static int[] yarr = {-2,-1,2,1,-2,-1,2,1};
    static StringBuilder str = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int x, y, l;
        for(int i=0;i<t;i++){
            l = Integer.parseInt(br.readLine());
            visit = new boolean[l][l];
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            destination = new Knight(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),0);
            bfs(x,y);
        }
        bw.write(str.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    public static void bfs(int x, int y){
        int nx,ny,c=0;
        if(destination.x == x && destination.y == y){
            str.append(c + "\n");
            return;
        }
        Knight knight;
        Queue<Knight> que = new LinkedList<Knight>();
        que.add(new Knight(x,y,c));
        while(!que.isEmpty()){
            knight = que.poll();
            for(int i=0;i<8;i++){
                nx = knight.x + xarr[i];
                ny = knight.y + yarr[i];
                if(destination.x == nx && destination.y == ny){
                    str.append(knight.c+1 + "\n");
                    return;
                }
                if(check(nx,ny)){
                    visit[nx][ny] = true;
                    que.add(new Knight(nx,ny,knight.c+1));
                }
            }
        }
    }
    public static boolean check(int x, int y){
        if(x<0||y<0||visit.length<=x||visit.length<=y){
            return false;
        }
        if(visit[x][y]==true){
            return false;
        }
        return true;
    }
}
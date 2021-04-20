package greedy_algorythm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/1080
 * 행렬
*/
public class Matrix {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[1]);
        int[][] first = new int[N][M];
        int[][] second = new int[N][M];
        // for (int i = 0; i < N; i++) {
        //     for (int j = 0; j < M; j++) {
        //         first[i][j]=1;
        //         second[i][j]=0;
        //     }
        // }
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                if (row.charAt(j) == '1') {
                    first[i][j] = 1;
                } else {
                    first[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                if (row.charAt(j) == '1') {
                    second[i][j] = 1;
                } else {
                    second[i][j] = 0;
                }
            }
        }
        // System.out.println("first array => ");

        // for(int i=0;i<N;i++){
        //     for(int j=0;j<M;j++){
        //         System.out.print(first[i][j]+"\t");
        //     }
        //     System.out.println("");
        // }
        // System.out.println("second array => ");
        // for(int i=0;i<N;i++){
        //     for(int j=0;j<M;j++){
        //         System.out.print(second[i][j]+"\t");
        //     }
        //     System.out.println("");
        // }
        // System.out.println("solve => ");

        if(N<3||M<3){
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (first[i][j] != second[i][j]) {
                        System.out.println(-1);
                        System.exit(0);
                    }
                }
            } 
        }

        int v=0;
        for(int i=0;i<N-2;i++){
            for(int j=0;j<M-2;j++){
                if(first[i][j]!=second[i][j]){
                    v++;
                    for(int k=i;k<i+3;k++){
                        for(int l=j;l<j+3;l++){
                            if(first[k][l]==1){
                                first[k][l]=0;
                            } else {
                                first[k][l]=1;
                            }
                        }
                    }
                }
            }
        }
        // System.out.println("first array => ");

        // for(int i=0;i<N;i++){
        //     for(int j=0;j<M;j++){
        //         System.out.print(first[i][j]+"\t");
        //     }
        //     System.out.println("");
        // }
        // System.out.println("second array => ");
        // for(int i=0;i<N;i++){
        //     for(int j=0;j<M;j++){
        //         System.out.print(second[i][j]+"\t");
        //     }
        //     System.out.println("");
        // }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (first[i][j] != second[i][j]) {
                    System.out.println(-1);
                    System.exit(0);
                }
            }
        } 
        System.out.println(v);
        

    }
}
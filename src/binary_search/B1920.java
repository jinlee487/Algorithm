package binary_search;

import java.io.*;
import java.util.*;

/* 
Solved!
https://www.acmicpc.net/problem/1920
수 찾기
https://www.geeksforgeeks.org/arrays-binarysearch-java-examples-set-1/
binary search 

*/
public class B1920 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        int[] arr2 = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder str = new StringBuilder();
        Arrays.sort(arr);
        for(int i=0;i<M;i++){
            str.append((-1<Arrays.binarySearch(arr, arr2[i])?1:0) + "\n"); 
            // str.append(binarySearch(arr,arr2[i])+"\n");
        }
        bw.write(str.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    private static int binarySearch(int[] arr, int num) {
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left+right)/2;
            if(arr[mid]==num){
                return 1;
            }
            else if(arr[mid]>num){
                right = mid - 1;
            }
            else if(arr[mid]<num){
                left = mid + 1;
            }
        }
        return 0; 
    }
}


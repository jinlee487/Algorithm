package greedy_algorythm;
import java.util.*;
import java.io.*;
/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/11501
 * 주식 
*/
public class Stocks {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int N=0,s;
        Long ans;
        Queue<Integer> que; 
        StringTokenizer st;
        int[] arr;
        int[] maxArr;
        for(int i=0;i<T;i++){
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            
            ans = 0L;
            arr = new int[N];
            maxArr = new int[N];
            Arrays.fill(arr,0);
            Arrays.fill(maxArr,0);

            for(int j=0;j<N;j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            s=maxArr[N-1]=arr[N-1];
            for(int j=N-2;-1<j;j--){
                if(s<arr[j]){
                    s=arr[j];
                    maxArr[j]=s;
                } else{
                    maxArr[j]=s;
                }   
            }
            for(int j=0;j<N;j++){
                ans += (maxArr[j]-arr[j]);
            }
            bw.write(Long.toString(ans) + "\n");

            // //so we have to find out if what is the highest possible yield for each day the stocks come by
            // for(;!que.isEmpty();){
            //     //we have to get the highest stock price in que after every time we take take out from linkedList
            //     s = que.poll();
            //     que.
            // }
            // for(int j=0;j<N+1;j++){

            //     if(que.isEmpty()){
            //         if(!stack.isEmpty()){
            //             int max = stack.pop();
            //             if(stack.isEmpty()){
            //                 break;
            //             } else{
            //                 while(!stack.isEmpty()){
            //                     ans += (max-stack.pop());
            //                 }
            //             }          
            //         }
            //         break;
            //     }

            //     s = que.poll(); 
            //     if(stack.isEmpty()){
            //         stack.add(s);
            //         continue;
            //     } else if(stack.peek()<=s){
            //         stack.add(s);
            //         continue;
            //     } else if(s<stack.peek()){
            //         int max = stack.pop();
            //         if(stack.isEmpty()){
            //             stack.add(s);
            //         } else{
            //             while(!stack.isEmpty()){
            //                 ans += (max-stack.pop());
            //             }
            //             stack.add(s);
            //         }
            //     }
            // }
            // bw.write(Integer.toString(ans) + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}

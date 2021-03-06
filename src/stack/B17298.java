package stack;
import java.util.*;
import java.io.*;
/* 
Solved!
https://www.acmicpc.net/problem/17298
오큰수 
*/
class B17298 {
    public static void main(String[] ars) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> nge = new Stack<Integer>();
        for(int i=0;i<N;i++){
            stack.add(Integer.parseInt(st.nextToken()));
        }
        int[] arr = new int[stack.size()];
        nge.add(stack.pop());
        arr[0] = -1;
        int current;
        for(int i=1;i<arr.length;i++){
            current = stack.pop();
            for(;!nge.isEmpty();){
                if(current < nge.peek()){
                    arr[i] = nge.peek();
                    break;
                } else {
                    nge.pop();
                }
            }
            if(nge.isEmpty()){
                arr[i] = -1;
            }
            nge.add(current);
        }
        StringBuilder str = new StringBuilder();
        for(int i=arr.length-1;-1<i;i--){
            str.append(arr[i]+ " ");
        }
        bw.write(str.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

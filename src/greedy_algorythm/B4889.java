package greedy_algorythm;

import java.util.*;
import java.io.*;
 
/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/4889
 * 안정적인 문자열
*/

public class B4889 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] arr ;
        ArrayList<String> arrayList = new ArrayList<String>();
        Stack<Character> stack ;
        Character c;
        String temp;
        int a, b, ans;
        StringBuilder str = new StringBuilder();
        while(true){
            temp = br.readLine();
            if(temp.contains("-")){
                break;
            }
            arrayList.add(temp);
        }
        //System.out.println("this is arrayList => " + arrayList);
        for(int i=0;i<arrayList.size();i++){
            arr = arrayList.get(i).toCharArray();
            //System.out.println("this is arr => " + Arrays.toString(arr));
            stack = new Stack<Character>();
            for(int j=0;j<arr.length;j++){
                c = arr[j];

                if(!stack.isEmpty()&&c=='}'&&stack.peek()=='{'){
                    //System.out.println("this is stack peek => " + stack.peek());
                    //System.out.println("this is c => " + c);

                    stack.pop();
                    continue;
                }
                //System.out.println("adding stack! c => " + c );
                stack.add(c);
            }
            //System.out.println("this is the left stack => " + stack);
            if(stack.isEmpty()){
                ans = 0;
                str.append(i+1 + ". " + ans + "\n");
            } else {
                a = 0;
                b = 0;
                while(!stack.isEmpty()){
                    if(stack.peek()=='{'){
                        a++;
                        stack.pop();
                    } else {
                        b++;
                        stack.pop();
                    }
                }
                ans = a/2 + a%2 + b/2 + b%2;
                str.append(i+1 + ". " + ans + "\n");
            }
        }
        
        bw.write(str.toString());
        bw.flush();
        bw.close();
        br.close();
        
    }
}
 
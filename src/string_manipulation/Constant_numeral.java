package string_manipulation;
import java.io.*;
/*
 * Solved
 * https://www.acmicpc.net/problem/2908
 * 상수
 * 
 * 
 */
public class Constant_numeral {
	 
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] arr = s.split(" ");
//        // getBytes() method to convert string 
//        // into bytes[]. 
//        byte[] strAsByteArray1 = arr[0].getBytes(); 
//        byte[] strAsByteArray2 = arr[1].getBytes(); 
//
//        byte[] result1 = new byte[strAsByteArray1.length]; 
//        byte[] result2 = new byte[strAsByteArray2.length]; 
//
//        // Store result in reverse order into the 
//        // result byte[] 
//        for (int i = 0; i < strAsByteArray1.length; i++) {
//            result1[i] = strAsByteArray1[strAsByteArray1.length - i - 1]; 
//        	result2[i] = strAsByteArray2[strAsByteArray2.length - i - 1]; 
//        }
//        System.out.println(Math.max(Integer.parseInt(new String(result1)), Integer.parseInt(new String(result2))));
//        
        StringBuilder input1 = new StringBuilder(); 
        StringBuilder input2 = new StringBuilder();         
        // append a string into StringBuilder input1 
        input1.append(arr[0]); 
        input2.append(arr[1]);  
        // reverse StringBuilder input1 

        System.out.println(Math.max(Integer.parseInt(input1.reverse().toString()), Integer.parseInt(input2.reverse().toString())));

    }
}

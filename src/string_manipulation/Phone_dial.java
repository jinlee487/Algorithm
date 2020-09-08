package string_manipulation;
import java.io.*;
/*
 * Solved
 * https://www.acmicpc.net/problem/5622
 * 다이얼
 * 
 * 
 */
public class Phone_dial {
	 
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int sum=0;
        for(char c:arr) {
        	sum+=dial_time(c);
        }
        System.out.println(sum);
        br.close();
    }
    public static int dial_time(char c) {
    	switch (c) {
		case 'A':
		case 'B':
		case 'C':
			return 3;
		case 'D':
		case 'E':
		case 'F':
			return 4;
		case 'G':
		case 'H':
		case 'I':
			return 5;
		case 'J':
		case 'K':
		case 'L':
			return 6;
		case 'M':
		case 'N':
		case 'O':
			return 7;
		case 'P':
		case 'Q':
		case 'R':
		case 'S':			
			return 8;
		case 'T':
		case 'U':
		case 'V':			
			return 9;
		case 'W':			
		case 'X':
		case 'Y':
		case 'Z':
			return 10;
		}
		return 0; 	
    }
}

package greedy_algorythm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 
 * https://www.acmicpc.net/problem/1541
 * 잃어버린 괄호
 */
public class Lost_parenthesis {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] input = br.readLine().split("\\-");
	    for(int i=0;i<input.length;i++) {
	    	System.out.println(input[i]+" ");
	    }
	    int minResult = 0;

	    for (int i = 0; i < input.length; i++) {
	        int calcNum = calc(input[i]);

	        if (i == 0) calcNum *= -1;
	        minResult -= calcNum;
	    }

	    System.out.println(minResult);
	}
	private static int calc(String str) {
	    String[] subNums = str.split("\\+");
	    int result = 0;

	    for (String item : subNums) {
	        result += Integer.parseInt(item);
	    }
	    return result;
	}
}

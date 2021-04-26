package greedy_algorythm;

import java.io.*;
import java.util.*;
/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/17609
 * 회문
*/

public class Palindrome {
    static StringBuilder ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine()); 
        ans = new StringBuilder();
        for(int i=0;i<T;i++){
            ans.append(Integer.toString(palindrome(br.readLine()))+"\n");
        }

        bw.write(ans.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    public static int palindrome(String word) {
		int result = 0;
		int left = 0, right = word.length()-1;
		
		while(left<=right) {
			
			if(word.charAt(left) == word.charAt(right)) {
				left++;
				right--;
			}
			else {
				int l = left;
				int r = right;
				
				l++;
				while(l<=r) {
					if(word.charAt(l) == word.charAt(r)) {
						l++;
						r--;
					}
					else {
						result++;
						break;
					}
				}
				
				l = left;
				r = right;
				
				r--;
				while(l<=r){
					if(word.charAt(l) == word.charAt(r)) {
						l++;
						r--;
					}
					else {
						result++;
						break;
					}
				}
				
				return result;
			}
		}
		
		return result;
	}
 
}

package string_manipulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Solved!
 * https://www.acmicpc.net/problem/1316
 * 그룹단어체커
 * 
 * 
*/
public class Group_letter_check {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(br.readLine());
        String[] arr = new String[s];
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int count = 0; 
        for (int i=0;i<s;i++) {
        	arr[i] = br.readLine();
        }
        for (int i=0;i<arr.length;i++) {
        	char[] carr = arr[i].toCharArray();
        	count += solution(carr,alphabet);
        }
        System.out.println(count);
        br.close();
	}
	public static int solution(char[] carr, char[] alphabet) {
		if(carr.length==0) {return 0;}
		int[] alpha = new int[alphabet.length];
		for(int i=0;i<carr.length;i++) {
			for(int j=0;j<alphabet.length;j++) {
				if(carr[i]==alphabet[j]&&alpha[j]==0) {
					alpha[j]=1;
				}
				else if(carr[i]==alphabet[j]&&alpha[j]>0) {
					if(carr[i-1]==carr[i]) {
						alpha[j]+=1;
					}
					else {
						return 0;
					}
				}
			}
		}
		return 1;
	}
}

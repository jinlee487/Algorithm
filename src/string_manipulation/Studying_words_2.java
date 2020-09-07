package string_manipulation;
import java.io.*;
/*
 * Solved
 * https://www.acmicpc.net/problem/1157
 * 단어 공부
 *https://bcp0109.tistory.com/34
 * 
 */
public class Studying_words_2 {
	 
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] arr = new int[26];
        
        int len = s.length();
 
        // 각 글자 갯수를 arr 배열에 저장
        for(int i=0; i<len; i++) {
            int idx = Character.toLowerCase(s.charAt(i)) - 'a';
            arr[idx]++;
        }
 
        int max = -1;
        char answer = '?';
 
        for(int i=0; i<26; i++) {
            if(arr[i] > max) {
                max = arr[i];
                answer = (char) (i+65);
            } else if(arr[i] == max)
                answer = '?';
        }
 
        System.out.println(answer);
    }
}

package greedy_algorythm;

import java.io.*;
/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/15904
 * UCPC는 무엇의 약자일까? 
*/
public class AacronymOfUCSP {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solution(br.readLine()));
    }

    static String solution(String s) {
        char[] ucpc = {'U', 'C', 'P', 'C'};
        int index = 0;

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == ucpc[index]) {
                index++;
            }

            if(index == 4) {
                return "I love UCPC";
            }
        }

        return "I hate UCPC";
    }
}
package string_manipulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Solved!
 * https://www.acmicpc.net/problem/2941
 * 크로아티아 알파벳
 * 
*/
public class Croatian_alphabet {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] arr = {"c=","c-","dz=","d-","lj","nj","s=","z="};
        int count=0;
        next:
        for (;0<s.length();) {
        	for (String a:arr) {
        		if(s.startsWith(a)) {
        			s=s.replaceFirst(a,"");
        			count+=1;
//        			System.out.println("matching! => " + a);
//        			System.out.println("this is  s => " + s);
//        			System.out.println("this is count => " + count);
        			continue next;
        		}
        	}
        	s=s.substring(1,s.length());
			count+=1;
//			System.out.println("not matching");
//			System.out.println("this is  s => " + s);
//			System.out.println("this is count => " + count);
        }
        System.out.println(count);
        br.close();
	}
}

package arrangement;

/*
 * Solved!
 * https://www.acmicpc.net/problem/1427
 * 소트인사이드
 */
import java.util.Scanner;

public class Sort_inside {
	static int x;
	static String input;
	static char[] list;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        sc.close();
        input = Integer.toString(x);
        int len = input.length();
        list = new char[len];
        for (int i=0;i<len;i++) {
        	list[i]=input.charAt(i);
        }
        for (int i=0;i<len;i++) {
        	for (int j=i;j<len;j++) {
        		if(list[j]>list[i]) {
        			char temp = list[j];
        			list[j] = list[i];
        			list[i] = temp;
        		}
        	}
        } 
        String str = new String(list);
        System.out.println(str);
	}
}

package recursion;
/*
 * https://www.acmicpc.net/problem/2447
 * 별찍기 10
 * 
 */
import java.util.Scanner;

public class Star_10 {
	static StringBuilder sb = new StringBuilder();
	static char[][] list;
	static int input;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextInt();
        scanner.close();
        list = new char[input][input];
    	for (int i = 0; i < input; i++) {
    		for (int j = 0; j < input; j++) 
    			list[i][j] = ' ';
    	}
    	star(0,0,input);
    	for (int i = 0; i < input; i++) {	
    		for (int j = 0; j < input; j++) 
    			sb.append(list[i][j]);
    		sb.append("\n");
    	}
    	System.out.println(sb);
	}
	public static void star(int a,int b,int n) { 
		if(n==1) { 
			list[a][b] = '*';
			return;
		}
		for(int i=0;i<3;i++) { 
			for(int j=0;j<3;j++) {
				if(i==1 && j ==1) 
					continue;
				star(a+(n/3*i),b+(n/3*j),n/3); 
			}
		}
		return;
	}
}

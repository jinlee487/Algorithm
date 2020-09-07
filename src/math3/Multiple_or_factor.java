package math3;
/*
 * SOLVED!
 * https://www.acmicpc.net/problem/5086
 * 배수와 약수 
 */
import java.util.Scanner;

public class Multiple_or_factor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[][] list = new int[10000][2];
		for(int i=0;true;i++) {
			list[i][0] = sc.nextInt();
			list[i][1] = sc.nextInt();
			if(list[i][1]==0)
				break;
		}
		sc.close();
		for(int i=0;i<list.length;i++) {
			if (list[i][0] == 0 )
				System.exit(0);
			calc(list[i][0],list[i][1]);
		}
	}
	public static void calc(int x, int y) {
		 if (x%y==0)
			 System.out.println("multiple");
		 else if (y%x==0)
			 System.out.println("factor");
		 else
			 System.out.println("neither");
	}
}

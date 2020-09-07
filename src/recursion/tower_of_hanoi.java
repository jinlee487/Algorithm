package recursion;
/*
 * Solved!! 
 * 하노이 탑 이동 순서
 * https://www.acmicpc.net/problem/11729
 */
import java.util.Scanner;

public class tower_of_hanoi {
	static int count = 0; 
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		int userinput = 0; //initialize
		char from = '1', tmp = '2', to = '3';
        userinput = scanner.nextInt();
	    hanoifn(userinput, from, tmp, to);
	    System.out.println(count);
	    System.out.println(sb);
	}
	public static void hanoifn(int userinput, char from, char tmp, char to){
		if (userinput == 1)
		{
			sb.append(from + " " +to+"\n");
			count +=1;
		}
		else
		{ 	
			hanoifn((userinput - 1), from, to, tmp);
			sb.append(from + " " +to+"\n");
			count+=1;
			hanoifn((userinput - 1), tmp, from, to);
		}
	}
}

package recursion;

/*
 * solved!
 * https://www.acmicpc.net/problem/10872
 * 팩토리얼
 */
import java.util.Scanner;

public class factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        System.out.println(fact(x));
	}
	public static int fact(int x) {
		if (x==0)
			return 1; 
		return (x*fact(x-1));
	}
}

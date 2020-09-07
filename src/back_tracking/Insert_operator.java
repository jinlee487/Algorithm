package back_tracking;
/*
 * Solve!!
 * https://www.acmicpc.net/problem/14888
 * 연산자 끼어넣기 
 */
import java.util.Scanner;

public class Insert_operator {
	static String[] operators = {"+","-","*","/"};
	static int[] opcount = {0,0,0,0};
	static int[] numlist;
	static int len;
	static int max;
	static int min;
	static String op;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		len = sc.nextInt();
		numlist = new int[len];
		int opcheck=0;
		for (int i=0;i<numlist.length;i++) 
			numlist[i]=sc.nextInt();
		for (int i=0;i<opcount.length;i++) {
			opcount[i]=sc.nextInt();
			opcheck+=opcount[i];
		}
		sc.close();
		max = -2147483648;
		min = 2147483647;	
		if (opcheck!=0) {
			dfs(numlist[0],1);
			System.out.println(max);
			System.out.println(min);
		}
		else {
			System.out.println(0);
			System.out.println(0);
		}
	}
	public static int dfs(int sum, int cnt) {
//		System.out.println("\n****next loop***");
		if (cnt==numlist.length) {
			if (max<sum) max=sum;
			if (sum<min) min=sum;
//			System.out.println("return value");
//			System.out.println("this is max => "+ max);
//			System.out.println("this is min => " + min);
//			System.out.println("");
			return 0;
		}
		for (int i=0;i<4;i++) {
			if(opcount[i]==0) continue;
			opcount[i]-=1;
			op = operators[i];
//			System.out.println("previous sum => "+ sum);
			int temp = sum;
			sum = calc(sum,numlist[cnt],op);
//			System.out.println("op => "+op);
//			System.out.println("numlist[cnt] => "+numlist[cnt]);
//			System.out.println("sum => "+sum);
			
			dfs(sum,cnt+1);
			sum = temp;
			opcount[i]+=1;
		}
		return 0;
	}
	public static int calc(int firstValue, int secondValue, String operator) {
	    switch (operator){
        case "+":
            return firstValue + secondValue;
        case "-":
            return firstValue - secondValue;
        case "/":
            return firstValue / secondValue;
        case "*":
            return firstValue * secondValue;
	    }
		return 0;
	}
}

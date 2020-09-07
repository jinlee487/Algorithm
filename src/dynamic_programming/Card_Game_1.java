package dynamic_programming;

import java.util.Scanner;

/*
 * https://www.acmicpc.net/problem/10835
 * 카드게임
 * 
  1. 언제든지 왼쪽 카드만 통에 버릴 수도 있고 왼쪽 카드와 오른쪽 카드를 둘 다 통에 버릴 수도 있다. 이때 얻는 점수는 없다.
  2. 오른쪽 카드에 적힌 수가 왼쪽 카드에 적힌 수보다 작은 경우에는 오른쪽 카드만 통에 버릴 수도 있다. 오른쪽 카드만 버리는 경우에는 오른쪽 카드에 적힌 수만큼 점수를 얻는다.
  3. (1)과 (2)의 규칙에 따라 게임을 진행하다가 어느 쪽 더미든 남은 카드가 없다면 게임이 끝나며 그때까지 얻은 점수의 합이 최종 점수가 된다. 

 */
public class Card_Game_1 {
	static int x;
	static int[] left;
	static int[] right;
	static int intput_score = 0;
	static int lc = 1;
	static int rc = 1;
	static int count = 0;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input_length();
		input_number();
//		printarray(left);
//		System.out.println();
//		printarray(right);
//		System.out.println();
		int result = calc(intput_score,lc,rc);
		System.out.println(result);
	}
	public static int input_length() {
		int input = sc.nextInt();
		sc.nextLine(); 
		left = new int[input+1];
		right = new int[input+1];	
		return input;
	}
	public static void input_number() {
		//https://stackoverflow.com/questions/23506429/java-reading-multiple-ints-from-a-single-line
		String input = sc.nextLine();    // get the entire line after the prompt 
		String[] numbers = input.split(" "); // split by spaces
//		String[] reverse = new String[numbers.length];
		
//		for (int i=0, j=numbers.length-1; i < numbers.length;i++, j--) 
//			reverse[j] = numbers[i];
		for (int i = 1; i < numbers.length+1; i++) {
			left[i] = Integer.parseInt(numbers[i-1]);
		}
		input = sc.nextLine(); 
		String[] numbers1 = input.split(" ");
//		reverse = new String[numbers.length];
//		for (int i=0, j=numbers.length-1; i < numbers.length;i++, j--) 
//			reverse[j] = numbers[i];
		for (int i = 1; i < numbers1.length+1; i++) {
		    right[i] = Integer.parseInt(numbers1[i-1]);
		} 		
	}
	public static int calc(int score,int leftcount,int rightcount) {
//		System.out.println(count);
//		count++;
		if (leftcount==left.length)
			return 0;
		if (rightcount==right.length)
			return 0;
		score = Math.max(calc(score,leftcount+1,rightcount+1),calc(score,leftcount+1,rightcount));
		if (left[leftcount]>right[rightcount]) {
			score=Math.max(score, calc(score,leftcount,rightcount+1)+right[rightcount]);
		}
		return score;
	}
	public static void printarray(int[] x) {
		for (int i=0;i<x.length;i++) {
			System.out.printf("%d\t",x[i]);
		}	
	}
}

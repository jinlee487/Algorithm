package step_by_step;

import java.util.Scanner;

//https://www.acmicpc.net/problem/10871
//Solved!
public class smaller_than_x {
	static int[] list;
	static int x;
	static String string;
	static Scanner sc = new Scanner(System.in);
	
	public static int[] input_string() {
		String input = sc.nextLine(); 
		string = sc.nextLine(); 
		return string2int(input);
	}
	public static int[] string2int(String input) {
		String[] numbers = input.split(" "); // split by spaces
		int[] intlist = new int[2];
		for (int i=0;i<2;i++)
			intlist[i] = Integer.parseInt(numbers[i]);
		return intlist;
	}
	public static void setlist(int[] intlist) {
		list = new int[intlist[0]];
		x = intlist[1];
		String[] numbers = string.split(" ");
		for (int i=0;i<list.length;i++) {
			list[i]=Integer.parseInt(numbers[i]);
		}
	}
	public static void calc() {
		for(int i=0;i<list.length;i++) {
			if(list[i]<x)
				System.out.printf("%d ",list[i]);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] intlist = input_string();
		setlist(intlist);
		calc();
	}
}

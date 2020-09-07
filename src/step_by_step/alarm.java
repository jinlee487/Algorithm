package step_by_step;

import java.util.Scanner;

// https://www.acmicpc.net/problem/2884
public class alarm {
	static int[] timelist = new int[2];
	static int timemin; 
	static int alarmtime;
	static Scanner sc = new Scanner(System.in);

	public static int[] input_string() {
		String input = sc.nextLine(); 
		return string2int(input);
	}
	public static int[] string2int(String input) {
		String[] numbers = input.split(" "); // split by spaces
		int[] intlist = new int[numbers.length];
		for (int i=0;i<2;i++)
			intlist[i] = Integer.parseInt(numbers[i]);
		return intlist;
	}
	public static int[] calc() {
		timemin=timelist[0]*60+timelist[1];
		int alarmm=timemin-45;
		if (alarmm<0) {
			alarmm=24*60+alarmm;
		}
		int min=alarmm%60;
		int hour = alarmm/60;
		int[] result = {hour, min};
		return result;
	}
	public static void output(int[] result) {
		System.out.println(result[0]+" "+result[1]);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		timelist = input_string();
		output(calc());
	}
}

package dynamic_programming;
/*
 * https://www.acmicpc.net/problem/9461
 * 파도반 수열
 * SOLVED!!
 */
import java.util.Scanner;
public class triangle_wave {
	static long[] list;
	static long[] input; 
	static int len;
	static Scanner sc = new Scanner(System.in);

	
	public static void input_int() {
		int n = sc.nextInt();
		len = n;
	}
	public static void make_input_list() {
		input = new long[len+1];
		input[0] = 0;
		for(int i=1;i<=len;i++) {
			input[i]=sc.nextInt();
		}
	}
	public static void execute() {
		long max = 0;
		for (int i=1;i<input.length;i++) 
			max = (max<input[i]? input[i]:max); 
		list = new long[(int) (max+1)];
		for (int i=0;i<list.length;i++) 
			list[i]=-1;
		list[1] = 1;
		if(1<len)
			list[2] = 1;
			if(2<len)
				list[3] = 1; 
				if(3<len)
					list[4] = 2;
					if(4<len)
						list[5] = 2;
		for (int i=1;i<=len;i++) {
			long result = calc(input[i]);
			System.out.println(result);
		}
	}
	public static long calc(long input2) {
		if (input2<1)
			return 0;
		if (input2==1)
			return 1;
		if (input2==2)
			return 1;
		if (input2==3)
			return 1;
		if (input2==4)
			return 2;
		if(input2==5)
			return 2;
		if (list[(int) input2]>-1)
			return list[(int) input2];
		list[(int) input2] = calc(input2-5)+calc(input2-1);
		return list[(int) input2];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input_int();
		make_input_list();
		execute();		
	}
}

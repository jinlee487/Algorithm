package arrangement;
/*
 * sovled!
 * https://www.acmicpc.net/problem/2750
 * 수 정렬하기
 * https://joshuajangblog.wordpress.com/2016/09/21/time_complexity_big_o_in_easy_explanation/
 */
import java.util.Scanner;

public class num_order {
	static int len;
	static int[] list;
	static int[] output;
	static int temp = 0;
    static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        len = sc.nextInt();
        list = new int[len];
        output = new int[len];
        for (int i=0;i<len;i++) {
        	list[i] = sc.nextInt();
        }
        sc.close();
        for (int i=0;i<len;i++) {
        	output[i]=list[i];
        	for (int j=i;j<len;j++) {
        		if(list[j]<output[i]) {
        			temp = list[j];
        			list[j] = output[i];
        			output[i]=temp;
        		}
        	}
        } 
        for (int i=0;i<len;i++) {
        	sb.append(output[i]+"\n");
        }
        System.out.println(sb);
	}
}

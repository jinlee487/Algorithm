package brute_force;
/*
 * solved!
 * https://www.acmicpc.net/problem/2798
 * 블랙잭 
 */
import java.util.Scanner;

public class black_jack {
	static int len;
	static int lim;
	static int[] input;
	static int max=0;
	static int temp=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        len = sc.nextInt(); 
        lim = sc.nextInt(); 
        input = new int[len];
        for (int i=0;i<len;i++) {
        	input[i]=sc.nextInt();
        }
        sc.close();
        for (int i=0;i<len;i++) {
        	for (int j=0;j<len;j++) {
        		if (i==j)
        			continue;
        		for (int k=0;k<len;k++) {
        			if (k==j||k==i)
        				continue;
        			temp = input[i]+input[j]+input[k];
        			if (temp > lim)
        				continue;
        			max = max < temp ? temp:max;
        		}
        	}
        }
        System.out.println(max);
	}
}

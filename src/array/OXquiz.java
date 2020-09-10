package array;

import java.util.Arrays;
import java.util.Scanner;

/*Solved
https://www.acmicpc.net/problem/8958
	OXquiz
	*/
public class OXquiz {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());		
		String[] arr = new String[n];		
		for (int i=0;i<n;i++) {
			arr[i]=sc.nextLine();
		}	
		char[] temp;
		int score=0;
		int total=0;
		for (int i=0;i<arr.length;i++) {			
			temp = arr[i].toCharArray();
			for (int j=0;j<temp.length;j++) {
				if(temp[j]=='O') {
					score+=1;
					total+=score;
				}
				else {
					score=0;
				}
			}
			System.out.println(total);
			total=0;
			score=0;
		}
		sc.close();
	}
}

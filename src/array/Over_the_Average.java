package array;

import java.util.Scanner;

/*Solved
https://www.acmicpc.net/problem/4344
평균은 넘겠지
	https://www.baeldung.com/java-array-sum-average	*/
public class Over_the_Average {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int m, sum = 0, count = 0;
		double avg;
		String[] temp;
		String[] arr = new String[n];		
		for (int i=0;i<n;i++) {
			arr[i]=sc.nextLine();
		}	
//		System.out.println("this is arr => " + Arrays.toString(arr));
		for (int i=0;i<n;i++) {
			m=Integer.parseInt(arr[i].split(" ")[0]);
			temp=arr[i].split(" ");
//			System.out.println("this is temp => " + Arrays.toString(temp));
			for (int j=1;j<m+1;j++) {
				sum+=Integer.parseInt(temp[j]);
			}
//			System.out.println("this is sum => " + sum);
			avg=(double) sum/m;
//			System.out.println("this is avg => " + avg);
			for (int j=1;j<m+1;j++) {
				if (avg<((double) Integer.parseInt(temp[j]))) {
					count+=1;
				}
			}
//			System.out.println("this is count => " + count);
			System.out.printf("%.3f%%\n", (double)count/m*100);
			sum=0;
			count=0;
			
		}
		
		sc.close();
	}
}

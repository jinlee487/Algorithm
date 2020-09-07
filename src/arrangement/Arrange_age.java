package arrangement;

/*
 * Solved!
 * https://www.acmicpc.net/problem/10814
 * 나이순 정렬
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Arrange_age {
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		
		int n= sc.nextInt();
		
		String arr[][]=new String[n][2]; //x좌표 y좌표
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				arr[i][j] = sc.next();
			}
		}
		sc.close();
		
		Arrays.sort(arr,new Comparator<String[]>() { //Comparator 인터페이스 재정의

			@Override
			public int compare(String[] o1, String[] o2) {
				
				return Integer.compare(Integer.parseInt(o1[0]),Integer.parseInt(o2[0])); // 나머지는 y좌표를 기준으로 정렬
			
			}		
			
		});
		
		for(int i=0;i<arr.length;i++) {
	
				System.out.println(arr[i][0]+" "+arr[i][1]);
		}	
	}
}

package arrangement;
/*
 * solved!
 * https://www.acmicpc.net/problem/2108
 * https://www.acmicpc.net/board/view/40713
 * 통계학
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Statistics {
	static int len;
	static int[] list;
	static int[] output;
	static int temp = 0;
	static int mid;
	static int total=0;
	static int min;
	static int encounter;
	static int absolute;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[8001];
		int[] output = new int[N];
		mid = N/2;
		
		for (int i = 0; i < N; i++) {
			arr[Integer.parseInt(br.readLine())+4000] ++;
		}
		int count = 0;
		encounter = 0;
		for (int i = 0; i < 8001; i++) {
			if (arr[i] > 0) {
				if (arr[i]>arr[encounter]) {
					encounter=i;
				}

				for (int j = 0; j < arr[i]; j++) {
					output[count]=i-4000;
					count +=1;
					total+=(i-4000);
				}
			}
		}
		for (int i=encounter+1;i<8001;i++) {
			if (arr[i]==arr[encounter]) {
				encounter=i;
				break;
			}
		}
		if (N==1)
		{
			absolute=0;
		}
		else {
			absolute=output[N-1]-(output[0]);
		}
		System.out.println((Math.round((double) (total)/N)));
		System.out.println(output[mid]);
		System.out.println(encounter-4000);
		System.out.println(absolute);
		br.close();
	}
}


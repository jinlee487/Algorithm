package arrangement;
/*
 * solved!
 * https://www.acmicpc.net/problem/10989
 * https://bowbowbow.tistory.com/8
 * 수 정렬하기 3
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class num_order_3_counting_sort_2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[10001];
		// 10000000 개이기 때문에 sort를 사용하면 안된다.
		for (int i = 0; i < N; i++) {
			arr[Integer.parseInt(br.readLine())] ++;
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 1; i <= 10000; i++) {
			if (arr[i] > 0) {
				for (int j = 0; j < arr[i]; j++) {
					bw.write(Integer.toString(i) + "\n");
				}
			}
		}
		br.close();
		bw.close();
	}
}
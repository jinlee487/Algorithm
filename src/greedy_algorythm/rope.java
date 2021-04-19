package greedy_algorythm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class rope {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		Integer rope[] = new Integer[N];
		for(int i=0; i<N; i++) {
			rope[i] = Integer.valueOf(br.readLine());
		}
		Arrays.sort(rope, Comparator.reverseOrder());
		int max = 0;
		for(int i=0; i<N; i++) {
			max = Math.max(rope[i]*(i+1), max);
		}
		System.out.println(max);
	}
}

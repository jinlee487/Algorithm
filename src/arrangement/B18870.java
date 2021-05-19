package arrangement;

import java.util.*;
import java.io.*;

/* 
Solved!
https://www.acmicpc.net/problem/18870
좌표 압축 
*/
public class B18870 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] nums = new int[N];
        for (int i = 0; i < N; i++)
            nums[i] = Integer.parseInt(input[i]);

        int[] sortNums = nums.clone();
        Arrays.sort(sortNums);

        Map<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        for (int n : sortNums)
            if (!map.containsKey(n))
                map.put(n, idx++);

        StringBuilder sb = new StringBuilder();
        for (int n : nums)
            sb.append(map.get(n)).append(' ');

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

package greedy_algorythm;

import java.io.*; 
import java.util.*;
/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/1700
 * 멀티탭 스케줄링
*/
public class PowerBarScheduling { 

    public static void main(String[] args) throws IOException{ 
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(reader.readLine()); 
        int N = Integer.parseInt(st.nextToken()); 
        int K = Integer.parseInt(st.nextToken()); 
        st = new StringTokenizer(reader.readLine()); 
        int[] arr = new int[K];

		for(int i=0;i<K;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // System.out.println(Arrays.toString(arr));

        ArrayList<Integer> arrList = new ArrayList<>();
        boolean[] use = new boolean[101];
        int put = 0;
        int ans = 0;
        for (int i = 0; i < K; i++) {
            int temp = arr[i];
 
            if (!use[temp]) { // check if the current plug is plugged in and if it is, skip.
                if (put < N) { // check for space in the power oulet
                    use[temp] = true;
                    put++;
                } else { //no space
                    arrList = new ArrayList<>();

                    for (int j = i; j < K; j++) { 
                        // check if the plugs currently plugged in are going to be used in the future
                        // we record the first appearance of the appliance only
                        if (use[arr[j]] && !arrList.contains(arr[j])) {
                            arrList.add(arr[j]);
                        }
                    }
 
                    if (arrList.size() != N) { 
                        // 나중에도 사용되는 콘센트가 구멍의 개수보다 작을 경우, 
                        // you can take out the plug that is not plugged in
                        for (int j = 0; j < use.length; j++) {
                            if (use[j] && !arrList.contains(j)) { 
                                use[j] = false;
                                break;
                            }
                        }
                    } else { // 현재 꽂혀 있는 모든 콘센트가 나중에도 사용될 경우
                        int remove = arrList.get(arrList.size() - 1); // 가장 마지막에 사용될 콘센트를 제거.
                        // the last index of the list should be the last of the first used appliance 
                        use[remove] = false;
                    }
 
                    use[temp] = true;
                    ans++;
                }
            }
        }

        System.out.println(ans);

	}
	
}


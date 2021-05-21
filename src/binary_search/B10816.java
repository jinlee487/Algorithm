package binary_search;
import java.io.*;
import java.util.*;


/* 
Solved!
https://www.acmicpc.net/problem/10816
숫자 카드 2 
this is not an ordinary binary search problem. I had to use lower bound and upper bound algorithm 
to find the the indexs of first and last occurences of the given integer in the array
*/
public class B10816 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr1 = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        int[] arr2 = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr1);
        StringBuilder str = new StringBuilder();
        for(int i=0;i<M;i++){
            str.append(upper_bound(arr1, arr2[i])-(lower_bound(arr1, arr2[i])) + " ");
        }
        bw.write(str.toString());
        bw.flush();
        bw.close();
        br.close();
    }
	private static int lower_bound(int[] arr, int num) {
		int left = 0;
        int right = arr.length;
        int mid;
		while(left<right) {
			mid = (right+left)/2;
			if(num <= arr[mid]) {
				right = mid;
			}
			else {
				left = mid+1;
			}
		}
		return left;
	}
	private static int upper_bound(int[] arr, int num) {
		int left = 0;
        int right = arr.length;
        int mid;
		while(left<right) {
			mid = (right+left)/2;
			if(num >= arr[mid]){
                left = mid +1;
            }
			else {
                right = mid;
            }
		}
		return left;
	}
}

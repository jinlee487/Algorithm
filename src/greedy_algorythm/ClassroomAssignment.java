package greedy_algorythm;

  
import java.io.*;
import java.util.*;
/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/11000
 * 강의실 배정
 * https://velog.io/@jkh9615/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-11000-%EA%B0%95%EC%9D%98%EC%8B%A4-%EB%B0%B0%EC%A0%95-Java
*/
public class ClassroomAssignment {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		for(int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");	
			arr[i][0] = Integer.parseInt(input[0]);
			arr[i][1] = Integer.parseInt(input[1]);
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) return o1[1] - o2[1];
				return o1[0] - o2[0];
			}
		});
		// System.out.println("this is sorted arr => ");
		// for(int i = 0; i < n; i++) {
		// 	System.out.println(Arrays.toString(arr[i]));
		// }
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		// the pq is basically the classrooms 
		pq.add(arr[0][1]);
		// add the first class
		// System.out.println("added arr[0][1] => " + arr[0][1]);
		// System.out.println("\nstarting loop...");
		for(int i = 1; i < n; i++) {
			// System.out.println("this is i => " + i );
			if(pq.peek() <= arr[i][0]){ 
				// you can find the class that is starting on the same time or after 
				// then the classroom currently being used is extended to the different class instead of 
				// assigning the class to another classroom


				// System.out.println("pq.peek() <= arr[i][0] is true ");
				// System.out.println("pq.peek() => " + pq.peek());
				// System.out.println("arr[i][0] = >" + arr[i][0]);
				pq.poll();
				// System.out.println("this is after poll => " + pq);
			}
			// System.out.println("adding arr[i][1] => " +arr[i][1]);

			pq.add(arr[i][1]);

			// System.out.println("after add " + pq);
		}
		
		System.out.println(pq.size());
		br.close();
	}
}
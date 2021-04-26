package greedy_algorythm;
import java.util.*;
import java.io.*;
import java.awt.*;
/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/2457
 * 공주님의 정원 
 * 해설 => https://lovelyunsh.tistory.com/82
*/
public class PrincessGarden {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		ArrayList<Point> arr = new ArrayList<Point>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a1 = Integer.parseInt(st.nextToken());
			int a2 = Integer.parseInt(st.nextToken());
			int b1 = Integer.parseInt(st.nextToken());
			int b2 = Integer.parseInt(st.nextToken());
			arr.add(new Point(a1 * 100 + a2, b1 * 100 + b2));
		}
		Collections.sort(arr, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				if (o1.x == o2.x)
					return o1.y - o2.y;
				return o1.x - o2.x;
			}
		});
		int last = 301;
		int lastidx = -1;
		int cnt = 0;
        gg: 
        while (true) {
			int temp = last;
			int i = lastidx;
			boolean isget = false;
			while (true) {
				if (++i >= N) {
					if (!isget) {
						cnt = 0;
						break gg;
					}
					break;
				}
				if (arr.get(i).x > temp) {
					if (!isget) {
						cnt = 0;
						break gg;
					}
					break;
				}
				if (arr.get(i).y > last) {
					lastidx = i;
					last = arr.get(i).y;
					isget = true;
				}
			}
			cnt++;
			if (last >= 1201)
				break;
		}
		System.out.println(cnt);

	}
    // public static void main(String[] args) throws IOException{
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //     BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    //     StringTokenizer st;
	// 	int N = Integer.parseInt(br.readLine());
    //     Integer[][] arr = new Integer[N][2];
    //     PriorityQueue<Integer[]> pq = new PriorityQueue<Integer[]>(new Comparator<Integer[]>() {        
    //         // Compare method for place element in
    //         // revers order
    //         public int compare(Integer[] o1, Integer[] o2)
    //         {
    //             if((o1[1]-o1[0]) == (o2[1]-o2[0])) return o2[1] - o1[1];
	// 			return (o2[1]-o2[0]) - (o1[1]-o1[0]);
    //         }
    //     });

	// 	for(int i = 0; i < N; i++) {
    //         st = new StringTokenizer(br.readLine());
    //         arr[i][0] = Integer.parseInt(st.nextToken())*100+Integer.parseInt(st.nextToken());
    //         arr[i][1] = Integer.parseInt(st.nextToken())*100+Integer.parseInt(st.nextToken());
    //         pq.add(arr[i]);
	// 	}
		
	// 	Arrays.sort(arr, new Comparator<Integer[]>() {
	// 		public int compare(Integer[] o1, Integer[] o2) {
	// 			if(o1[0] == o2[0]) return o2[1] - o1[1];
	// 			return o1[0] - o2[0];
	// 		}
    //     });
    //     if(301<arr[0][0]){
    //         System.out.println(0);
    //         System.exit(0);
    //     }
    //     if(1130<=arr[0][1]){
    //         System.out.println(0);
    //         System.exit(0);
    //     }
    //     // System.out.println("this is sorted arr => ");
    //     // for(int i = 0; i < N; i++) {
    //     //     System.out.print(Arrays.toString(arr[i]) + "\t");
	// 	// }
    //     Stack<Integer[]> stack = new Stack<Integer[]>(); 
    //     Queue<Integer[]> que = new LinkedList<Integer[]>();
    //     stack.add(arr[0]);
    //     // System.out.println("\nthis is stack => ");
	// 	// for(;!stack.isEmpty();) {
    //     //     System.out.print(Arrays.toString(stack.pop()) + "\t");
	// 	// }
    //     // System.out.println("\nthis is pq => ");
	// 	// for(;!pq.isEmpty();) {
    //     //     System.out.print(Arrays.toString(pq.poll()) + "\t");
	// 	// }
    //     for(int i=0;i<N;i++){
    //         while(!pq.isEmpty()){
    //             Integer[] temp = pq.poll();
    //             // System.out.println("this is temp => " + Arrays.toString(temp));
    //             if(stack.peek()==temp){
    //                 continue;
    //             }
    //             if(stack.peek()[1]<temp[0]){
    //                 que.add(temp);
    //             } else {
    //                 // System.out.println("stack.peek()[1] => "+ stack.peek()[1]);
    //                 stack.add(temp);
    //                 break;
    //             }
    //         }
    //         if(stack.peek()[1]>=1130){
    //             // System.out.println("found end");

    //             break;
    //         }
    //         while(!que.isEmpty()){
    //             pq.add(que.poll());
    //         }
    //     }
    //     if(stack.peek()[1]<1200){
    //         System.out.println(0);
    //         System.exit(0);
    //     }
    //     bw.write(Integer.toString(stack.size()));
    //     //         System.out.println("\nthis is stack => ");
	// 	// for(;!stack.isEmpty();) {
    //     //     System.out.print(Arrays.toString(stack.pop()) + "\t");
	// 	// }
	// 	// the pq is basically the classrooms 
	// 	// pq.add(arr[0]);
	// 	// // add the first class
	// 	// // System.out.println("added arr[0][1] => " + arr[0][1]);
	// 	// // System.out.println("\nstarting loop...");
	// 	// for(int i = 1; i < N; i++) {
	// 	// 	// System.out.println("this is i => " + i );
	// 	// 	if(pq.peek()[0] >= arr[i][0]){ 
	// 	// 		// you can find the class that is starting on the same time or after 
	// 	// 		// then the classroom currently being used is extended to the different class instead of 
	// 	// 		// assigning the class to another classroom


	// 	// 		// System.out.println("pq.peek() <= arr[i][0] is true ");
	// 	// 		// System.out.println("pq.peek() => " + pq.peek());
	// 	// 		// System.out.println("arr[i][0] = >" + arr[i][0]);
	// 	// 		pq.poll();
	// 	// 		// System.out.println("this is after poll => " + pq);
	// 	// 	}
	// 	// 	// System.out.println("adding arr[i][1] => " +arr[i][1]);

	// 	// 	pq.add(arr[i][1]);
 
	// 	// 	// System.out.println("after add " + pq);
    //     // }
    //     // System.out.println("this is pq => " + pq);
        
    //     bw.flush();
    //     bw.close();
    //     br.close();
    // }
}

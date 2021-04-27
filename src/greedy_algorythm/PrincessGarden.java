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
		// we order by the fastest starting date. if the fastest starting date is the same we order by the faster ending date
		//System.out.println("this is arr => ");
		for(Point a: arr){
			//System.out.print("a.x: " + a.getX() + " a.y: " + a.getY() + " ");
		}
		int last = 301;
		int lastidx = -1;
		int cnt = 0;
		//System.out.println("\nthis is last: " + last + " lastidx: " + lastidx + " cnt: " + cnt);
		// we set the last to 301 because we need it to at least start there 
		// this is the loop!

		
		// 4
		// 1 1 5 31
		// 1 1 6 30
		// 5 15 8 31
		// 6 10 12 10
		// this is arr => 
		// a.x: 101.0 a.y: 531.0 a.x: 101.0 a.y: 630.0 a.x: 515.0 a.y: 831.0 a.x: 610.0 a.y: 1210.0
		// this is last: 301 lastidx: -1 cnt: 0
		// this temp: 301 i: -1 isget: false
		// arr.get(i).y: 531 last: 301 i: 0
		// arr.get(i).y: 531 last: 531 i: 0
		// arr.get(i).y: 630 last: 531 i: 1
		// arr.get(i).y: 630 last: 630 i: 1
		// arr.get(i).x: 515 temp: 301 i: 2
		// arr.get(i).x: 515 temp: 301 i: 2

		// we find all the flowers that are before 3.1. if there is one that is after, 
		// we know that we found all the flowers that blooms before 3.1
		// then, we find flowers until we reach 1201 or till N

		
		// this is cnt => 1
		// this temp: 630 i: 1 isget: false
		// arr.get(i).y: 831 last: 630 i: 2
		// arr.get(i).y: 831 last: 831 i: 2
		// arr.get(i).y: 1210 last: 831 i: 3
		// arr.get(i).y: 1210 last: 1210 i: 3
		// i: 4 N: 4
		// this is cnt => 2
		// 2
        gg: 
        while (true) {
			int temp = last;
			int i = lastidx;
			boolean isget = false;
			//System.out.println("this temp: " + temp + " i: "  + i + " isget: " + isget);
			while (true) {
				if (++i >= N) {
					// need to check if the loop is the last 
					// if it is not, we added i by 1 and we can go on with our loop -1 + 1
					//System.out.println("i: " + i + " N: " + N);

					if (!isget) {
						cnt = 0;
						break gg;
					}
					break;
				}
				
				if (arr.get(i).x > temp) {
					// if the start date is more than then temp, we know that there is a gap between flower blooming 
					// and we need to end current loop and then loop again from the previous flower's end date.
					// and count + 1
					//System.out.println("arr.get(i).x: " + arr.get(i).x + " temp: " + temp + " i: " + i);

					if (!isget) {
						cnt = 0;
						break gg;
					}
					//System.out.println("arr.get(i).x: " + arr.get(i).x + " temp: " + temp + " i: " + i);

					break;
				}
				if (arr.get(i).y > last) {
					//System.out.println("arr.get(i).y: " + arr.get(i).y + " last: " + last + " i: " + i);

					lastidx = i;
					last = arr.get(i).y;
					isget = true;
					//System.out.println("arr.get(i).y: " + arr.get(i).y + " last: " + last + " i: " + i);

				}
			}
			cnt++;
			//System.out.println("this is cnt => " + cnt);
			if (last >= 1201)
				break;
		}
		System.out.println(cnt);

	}
    // public static void main(String[] args) throws IOException{
    //     BufferedReader br = new BufferedReader(new InputStreamReader(//System.in));
    //     BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(//System.out));
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
    //         //System.out.println(0);
    //         //System.exit(0);
    //     }
    //     if(1130<=arr[0][1]){
    //         //System.out.println(0);
    //         //System.exit(0);
    //     }
    //     // //System.out.println("this is sorted arr => ");
    //     // for(int i = 0; i < N; i++) {
    //     //     //System.out.print(Arrays.toString(arr[i]) + "\t");
	// 	// }
    //     Stack<Integer[]> stack = new Stack<Integer[]>(); 
    //     Queue<Integer[]> que = new LinkedList<Integer[]>();
    //     stack.add(arr[0]);
    //     // //System.out.println("\nthis is stack => ");
	// 	// for(;!stack.isEmpty();) {
    //     //     //System.out.print(Arrays.toString(stack.pop()) + "\t");
	// 	// }
    //     // //System.out.println("\nthis is pq => ");
	// 	// for(;!pq.isEmpty();) {
    //     //     //System.out.print(Arrays.toString(pq.poll()) + "\t");
	// 	// }
    //     for(int i=0;i<N;i++){
    //         while(!pq.isEmpty()){
    //             Integer[] temp = pq.poll();
    //             // //System.out.println("this is temp => " + Arrays.toString(temp));
    //             if(stack.peek()==temp){
    //                 continue;
    //             }
    //             if(stack.peek()[1]<temp[0]){
    //                 que.add(temp);
    //             } else {
    //                 // //System.out.println("stack.peek()[1] => "+ stack.peek()[1]);
    //                 stack.add(temp);
    //                 break;
    //             }
    //         }
    //         if(stack.peek()[1]>=1130){
    //             // //System.out.println("found end");

    //             break;
    //         }
    //         while(!que.isEmpty()){
    //             pq.add(que.poll());
    //         }
    //     }
    //     if(stack.peek()[1]<1200){
    //         //System.out.println(0);
    //         //System.exit(0);
    //     }
    //     bw.write(Integer.toString(stack.size()));
    //     //         //System.out.println("\nthis is stack => ");
	// 	// for(;!stack.isEmpty();) {
    //     //     //System.out.print(Arrays.toString(stack.pop()) + "\t");
	// 	// }
	// 	// the pq is basically the classrooms 
	// 	// pq.add(arr[0]);
	// 	// // add the first class
	// 	// // //System.out.println("added arr[0][1] => " + arr[0][1]);
	// 	// // //System.out.println("\nstarting loop...");
	// 	// for(int i = 1; i < N; i++) {
	// 	// 	// //System.out.println("this is i => " + i );
	// 	// 	if(pq.peek()[0] >= arr[i][0]){ 
	// 	// 		// you can find the class that is starting on the same time or after 
	// 	// 		// then the classroom currently being used is extended to the different class instead of 
	// 	// 		// assigning the class to another classroom


	// 	// 		// //System.out.println("pq.peek() <= arr[i][0] is true ");
	// 	// 		// //System.out.println("pq.peek() => " + pq.peek());
	// 	// 		// //System.out.println("arr[i][0] = >" + arr[i][0]);
	// 	// 		pq.poll();
	// 	// 		// //System.out.println("this is after poll => " + pq);
	// 	// 	}
	// 	// 	// //System.out.println("adding arr[i][1] => " +arr[i][1]);

	// 	// 	pq.add(arr[i][1]);
 
	// 	// 	// //System.out.println("after add " + pq);
    //     // }
    //     // //System.out.println("this is pq => " + pq);
        
    //     bw.flush();
    //     bw.close();
    //     br.close();
    // }
}

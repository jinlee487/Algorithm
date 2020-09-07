package heap;

import java.util.PriorityQueue;

public class Spicy {

	public static void main(String[] args) {
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int k = 7;
		System.out.println(solution(scoville, k));
	}
	public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();

        for (int aScoville : scoville) {
            heap.offer(aScoville);
        }

        while (heap.peek() <= K) {
            if (heap.size() == 1) {
                return -1;
            }
            int a = heap.poll();
            int b = heap.poll();


            int result = a + (b * 2);

            heap.offer(result);
            answer ++;
        }
        return answer;
    } 

}

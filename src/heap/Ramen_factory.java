package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Ramen_factory {
   public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        int index = 0;
        for (int i = 0; i < k; i++) {
            if (index < dates.length) {
                if (i == dates[index]) {
                    priorityQueue.offer(supplies[index]);
                    index ++;
                }
            }

            if (i == stock) {
                stock += priorityQueue.remove();
                answer ++;

            }

        }

        return answer;
    }
}

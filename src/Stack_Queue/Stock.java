package Stack_Queue;

/*
 * https://stackoverflow.com/questions/45395664/convert-array-to-queue
 */
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
public class Stock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {1};
		System.out.println(Arrays.toString(solution(prices)));
	}
    public static int[] solution(int[] prices) {
        
        Queue<Integer> que = new LinkedList<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<prices.length;i++) {
        	que.add(prices[i]);
        }

        next:
        for(int i=0;i<prices.length;i++) {
        	int c = que.poll();
        	Iterator<Integer> queloop = que.iterator();  
        	for (int t=1;t<que.size()+1;t++) { 
        		int s = queloop.next();
                if(s<c) {
                	list.add(t);
                	continue next;
                }
                if(!queloop.hasNext()) {
                	list.add(t);
                }
            } 
        }
        list.add(0);
        int[] answer = new int[list.size()];
        for (int i=0;i<list.size();i++) {
        	answer[i] = list.get(i);
        }
      	return answer;
    }
}

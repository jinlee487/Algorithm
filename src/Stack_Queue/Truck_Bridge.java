package Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;

public class Truck_Bridge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int bridge_length=100; 
		int weight=100; 
		int[] truck_weights = {10};
		System.out.println(solution(bridge_length, weight, truck_weights));
	}
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int total_weight=0;
        int times = 1;
        Truck temp = new Truck(0,0);
        Queue <Truck> que = new LinkedList<>();
        que.add(temp);
        for (int i=0;!que.isEmpty();i++,times++) {
        	if(!que.isEmpty()&&times-que.peek().getTime()==bridge_length) {
        		total_weight -= que.poll().getWeight();
        	}
        	if(i<truck_weights.length&&total_weight+truck_weights[i]<=weight) {
        		Truck truck = new Truck(truck_weights[i],times);
	        	que.add(truck);
	        	total_weight += truck_weights[i];
        	}
        	else {
        		i--;
        	}
        }
        answer = times-1;
        return answer;
	}
}
class Truck {
    int weight;
    int time;
    
    Truck(int weight, int time){
        this.weight = weight;
        this.time = time;
    }

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
}

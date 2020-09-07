package Stack_Queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Develop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] progresses = {93,30,55};
		int[] speeds = {1,30,5};
		System.out.println(Arrays.toString(solution(progresses,speeds)));
	}
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        Queue <Project> que = new LinkedList<>();
        for (int i=0;i<progresses.length;i++) {
    		Project project = new Project(progresses[i],speeds[i],0);
    		que.add(project);
        }

        for (int days=1,cnt=0;!que.isEmpty()||(que.isEmpty()&&cnt!=0);) {
        	if(!que.isEmpty()&&days-que.peek().getDay()>=que.peek().getHowlong()) {
        		que.poll();
        		cnt += 1;
//        		System.out.println("cnt is up => "+ cnt);
    		}
    		else {
    			days++;
//    			System.out.println("no more polling");
//    			System.out.println("days => "+days);
//    			System.out.println(que);
    			if(cnt!=0) {list.add(cnt);}
    			cnt = 0;
    		}
        }
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }

}
class Project {
    private int speed;
    private int day;
    private int prog;
    private int howlong;
    public void setProg(int prog) {
		this.prog = prog;
	}
	Project(int prog,int speed,int day){
    	this.speed=speed;
    	this.day=day;
    	this.prog=prog;
    	setHowlong();
    }
	public void setHowlong() {
		this.howlong = (int) Math.ceil((100-prog)/((float) speed));
//		System.out.println("this is how long => " + howlong);
	}
	public int getHowlong() {
		return howlong;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}   
}
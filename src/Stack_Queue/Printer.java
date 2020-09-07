package Stack_Queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Printer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] priorities = {1, 1, 9, 1, 1, 1} ;
//		int location = 0 ;
		int[] priorities = {2, 1, 3, 2} ;
		int location = 2 ;
		System.out.println(solution(priorities, location));
	}	
	
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue <Print> que = new LinkedList<>();
        for (int i = 0;i<priorities.length;i++) {
        	Print temp = new Print(i,priorities[i]);
        	que.add(temp);
        }
        next:
        for (int cnt=0;!que.isEmpty();) {
        	Print p = que.poll();
        	Iterator<Print> queloop = que.iterator();  
        	while (queloop.hasNext()) { 
        		Print t = queloop.next();
                if(p.getScore()<t.getScore()) {
                	que.add(p);
                	continue next;
                }
            } 
        	cnt++;
        	if(p.getLoc()==location) {
        		answer = cnt;
        		break;
        	}
        }
        return answer;
    }
}

class Print {
	private int loc;
	private int score;
	public int getLoc() {
		return loc;
	}
	Print(int loc, int score){
		this.loc = loc;
		this.score = score; 
	}
	public void setLoc(int loc) {
		this.loc = loc;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Print [loc=" + loc + ", score=" + score + "]";
	}
	
}

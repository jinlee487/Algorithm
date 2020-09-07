package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Disk_controller {
	public static void main(String[] args) {
		int[][] jobs = {{1, 4}, {10, 1}, {1, 6}};
		//int[][] jobs = {{0, 9}, {0, 4}, {0, 5}, {0, 7}, {0, 3}};

		System.out.println(solution(jobs));
	}
    public static int solution(int[][] jobs) {
        Queue<Disk> queue = new PriorityQueue<>(
        		Collections.reverseOrder((o1, o2) -> (o2.processTime - o1.processTime)));
        List<Disk> disks = new ArrayList<>();
        int totalTime = 0;
        for (int i = 0; i < jobs.length; i++)
            disks.add(new Disk(jobs[i][0], jobs[i][1]));
 
        Collections.sort(disks, 
        		Collections.reverseOrder((o1, o2) -> (o2.requestTime - o1.requestTime)));
       // int startTime = disks.get(0).requestTime;
        for(int i=0;i<disks.size();i++) {
        	queue.add(disks.get(i));
        	totalTime += (disks.get(i).processTime + disks.get(i).requestTime);
        }

        int sum = 0;
        int job = 0;
        for (int i = 0; i <= totalTime; i++) {
            if(job==0 && !queue.isEmpty() && i>=queue.peek().requestTime) {
                Disk disk = queue.poll();
                job = disk.processTime; // 본인처리시간
                sum += (disk.processTime + i - disk.requestTime); // 본인처시간 - 본인요청시간 + 이전꺼 처리시간
                System.out.println(disk);
                System.out.println(job);
                System.out.println(sum);
            }
            if (job>0) {job--;}
            
        }
 
        return (sum) / jobs.length;
    }
}
class Disk {
    public int requestTime;
    public int processTime;

    public Disk(int requestTime, int processTime) {
        this.requestTime = requestTime;
        this.processTime = processTime;
    }

    @Override
    public String toString() {
        return "Disk{" +
                "requestTime=" + requestTime +
                ", processTime=" + processTime +
                '}';
    }
}

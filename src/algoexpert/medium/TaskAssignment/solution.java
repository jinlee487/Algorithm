package algoexpert.medium.TaskAssignment;
import java.util.*;

class Program {

  public ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
    // Write your code here.
		ArrayList<Task> arrayList = new ArrayList<Task>();
		for(int i=0;i<tasks.size();i++)	arrayList.add(new Task(tasks.get(i),i));
		Collections.sort(arrayList);
		ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<k;i++) answer.add(new ArrayList<Integer>());
		for(int i=0;i<k;i++) answer.get(i).add(arrayList.get(i).index);
		for(int i=0;i<k;i++) answer.get(i).add(arrayList.remove(arrayList.size()-1).index);
    return answer;
  }
}
class Task implements Comparable<Task>{
	public int value;
	public int index;
	Task(int value,int index){
		this.value=value;
		this.index=index;
	}
	@Override
	public int compareTo(Task o2){
		if(this.value == o2.value) return this.index - o2.index;
		else return this.value - o2.value;
	}
	@Override
	public String toString(){
		return "value: " + value + " index: " + index;
	}
}

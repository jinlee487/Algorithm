package algoexpert.hard.FindLoop;
import java.util.*;

class Program1 {
  public static LinkedList findLoop(LinkedList head) {
    // Write your code here.
		// O(n) time | (1) space
		LinkedList first = head.next;
		LinkedList second = head.next.next;
		while(first!=second){
			first = first.next;
			second = second.next.next;
		}
		first = head;
		while(first!= second){
			first = first.next;
			second = second.next;
		}
		return first;
  }

  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }
}

class Program2 {
  public static LinkedList findLoop(LinkedList head) {
    // Write your code here.
		// O(n) time | O(n) space
		HashSet<LinkedList> set = new HashSet<LinkedList>();
    return findLoop(head,set);
  }
	public static LinkedList findLoop(LinkedList node, HashSet<LinkedList> set){
		if(node == null) return null;
		if(set.contains(node)) return node;
		set.add(node);
		return findLoop(node.next,set);
	}

  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }
}

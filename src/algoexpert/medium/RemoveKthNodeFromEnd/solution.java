package algoexpert.medium.RemoveKthNodeFromEnd;

import java.util.*;

class Program1 {
  public static void removeKthNodeFromEnd(LinkedList head, int k) {
    // Write your code here.
		// O(n) time | O(1) space`
		int count=removeKthNodeFromEnd(head,k,0);
		if(k==count) {
			head.value = head.next.value;
			head.next = head.next.next;
		}
  }
	public static int removeKthNodeFromEnd(LinkedList node, int k, int count){
		if(node.next == null) return count+1;
		count=removeKthNodeFromEnd(node.next,k,count);
		if(k==count) node.next=node.next.next;
		return count+1;
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
  public static void removeKthNodeFromEnd(LinkedList head, int k) {
    // Write your code here.
		int count = 1;
		LinkedList first = head;
		LinkedList second = head;
		while(count++ <= k) second = second.next;
		
		if(second == null){
			head.value = head.next.value;
			head.next = head.next.next;
			return;
		}
		while(second.next!=null){
			second = second.next;
			first = first.next;
		}
		first.next = first.next.next;
		
  }

  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }
}

package algoexpert.easy.RemoveDuplicatesFromLinkedList;

import java.util.*;

class Program {
  // This is an input class. Do not edit.
  public static class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      this.next = null;
    }
  }

  public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
    // Write your code here.
		LinkedList node = linkedList;
		while(node != null){
			LinkedList nextNode = node.next;
			while(nextNode != null && node.value == nextNode.value){
				nextNode = nextNode.next;
			}
			node.next = nextNode;
			node = nextNode;
		}
    return linkedList;
  }
}

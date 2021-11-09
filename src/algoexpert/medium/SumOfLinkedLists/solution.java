package algoexpert.medium.SumOfLinkedLists;

import java.util.*;

class Program1 {
  // This is an input class. Do not edit.
  public static class LinkedList {
    public int value;
    public LinkedList next;

    public LinkedList(int value) {
      this.value = value;
      this.next = null;
    }
  }

  public LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
    // Write your code here.
		// O(max(n,m)) time | O(max(n,m)) space where n is the length of the 
		// first Linked List and m is the length of the second Linked List
		LinkedList answer = new LinkedList(0);
		LinkedList currentNode = answer;
		int carry = 0;
		LinkedList nodeOne = linkedListOne;
		LinkedList nodeTwo = linkedListTwo;
		while(nodeOne != null || nodeTwo != null || carry != 0){
			int valueOne = nodeOne != null ? nodeOne.value : 0;
			int valueTwo = nodeTwo != null ? nodeTwo.value : 0;
			currentNode.next = new LinkedList(valueOne + valueTwo + carry);
			currentNode = currentNode.next;
			carry = currentNode.value/10;
			currentNode.value%=10;
			nodeOne = nodeOne != null ? nodeOne.next : null;
			nodeTwo = nodeTwo != null ? nodeTwo.next : null;
		}
    return answer.next;
  }
}


class Program2 {
    // This is an input class. Do not edit.
    public static class LinkedList {
      public int value;
      public LinkedList next;
  
      public LinkedList(int value) {
        this.value = value;
        this.next = null;
      }
    }
  
    public LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
      // Write your code here.
          LinkedList answer = new LinkedList(0);
          sumOfLInkedLists(linkedListOne,linkedListTwo, answer, 0);
      return answer;
    }
      public void sumOfLInkedLists(LinkedList linkedListOne, LinkedList linkedListTwo, LinkedList answer, int carry){
          answer.value = linkedListOne.value + linkedListTwo.value + carry;
          carry = answer.value/10;
          answer.value %= 10;
          if(carry == 0 && linkedListOne.next == null && linkedListTwo.next == null) return;
          LinkedList nextOne = linkedListOne.next == null ? new LinkedList(0) : linkedListOne.next;
          LinkedList nextTwo = linkedListTwo.next == null ? new LinkedList(0) : linkedListTwo.next;
          answer.next = new LinkedList(0);
          sumOfLInkedLists(nextOne,nextTwo,answer.next,carry);
      }
  }

// This is an input class. Do not edit.
class LinkedList {
    constructor(value) {
      this.value = value;
      this.next = null;
    }
  }
  
  function sumOfLinkedLists(linkedListOne, linkedListTwo) {
    // Write your code here.
      const answer = new LinkedList(0);
      sumOfLinkedListsHelper(linkedListOne,linkedListTwo,answer,0);
    return answer;
  }
  function sumOfLinkedListsHelper(linkedListOne, linkedListTwo, answer, carry) {
    // Write your code here.
      answer.value = linkedListOne.value + linkedListTwo.value + carry;
      carry = Math.floor(answer.value / 10);
      answer.value %= 10;
      if(carry===0&&linkedListOne.next===null&&linkedListTwo.next===null) return;
      const nextOne = linkedListOne.next===null ? new LinkedList(0) : linkedListOne.next;
      const nextTwo = linkedListTwo.next===null ? new LinkedList(0) : linkedListTwo.next;
      answer.next = new LinkedList(0);
      sumOfLinkedListsHelper(nextOne, nextTwo, answer.next, carry);
  } 
  
function sumOfLinkedLists(linkedListOne, linkedListTwo) {
    // Write your code here.
      const answer = new LinkedList(0);
      let current = answer;
      let carry = 0;
      let nodeOne = linkedListOne;
      let nodeTwo = linkedListTwo;
      while(nodeOne !== null || nodeTwo !== null || carry !== 0){
          const valueOne = nodeOne !== null ? nodeOne.value : 0;
          const valueTwo = nodeTwo !== null ? nodeTwo.value : 0;
          current.next = new LinkedList(valueOne + valueTwo + carry);
          current = current.next;
          carry = Math.floor(current.value/10);
          current.value %= 10;
          nodeOne = nodeOne !== null ? nodeOne.next : null;
          nodeTwo = nodeTwo !== null ? nodeTwo.next : null;
      }
    return answer.next;
  }
  // Do not edit the lines below.
  exports.LinkedList = LinkedList;
  exports.sumOfLinkedLists = sumOfLinkedLists;
  
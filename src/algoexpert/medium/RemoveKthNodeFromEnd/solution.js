// This is an input class. Do not edit.
class LinkedList {
    constructor(value) {
      this.value = value;
      this.next = null;
    }
  }
  
  function removeKthNodeFromEnd(head, k) {
    // Write your code here.
      const count = removeKthNodeFromEndHelper(head,k,0);
      if(count === k){
          head.value = head.next.value;
          head.next = head.next.next;
      }
  }
  function removeKthNodeFromEndHelper(node, k, count){
      if(node.next === null) return count+1;
      count = removeKthNodeFromEndHelper(node.next,k,count);
      if(count === k) node.next = node.next.next;
      return count+1;
  }
  
// This is an input class. Do not edit.
class LinkedList {
    constructor(value) {
      this.value = value;
      this.next = null;
    }
  }
  
  function removeKthNodeFromEnd(head, k) {
    // Write your code here.
      let first = head;
      let second = head;
      let count = 1;
      while(count++ <= k) second = second.next;
      if(second === null) {
          head.value = head.next.value;
          head.next = head.next.next;
          return;
      }
      while(second.next != null){
          second = second.next;
          first = first.next;
      }
      first.next = first.next.next;
  }
  
  // Do not edit the lines below.
  exports.LinkedList = LinkedList;
  exports.removeKthNodeFromEnd = removeKthNodeFromEnd;
  
  
// This is an input class. Do not edit.
class LinkedList {
    constructor(value) {
        this.value = value;
        this.next = null;
    }
    }
      
    function findLoop(head) {
    // Write your code here.
        let first = head.next;
        let second = head.next.next;
        while(first != second){
            first = first.next;
            second = second.next.next;
        }
        first = head;
        while(first != second){
            first = first.next;
            second = second.next;
        }
        return first;
    }
      
      // Do not edit the lines below.
      exports.LinkedList = LinkedList;
      exports.findLoop = findLoop;
      
      function findLoop(head, set = new Set()) {
        // Write your code here.
          if(head === null) return null;
          if(set.has(head)) return head;
          set.add(head);
          return findLoop(head.next, set);
      }
      
      // Do not edit the lines below.
      exports.LinkedList = LinkedList;
      exports.findLoop = findLoop;
      
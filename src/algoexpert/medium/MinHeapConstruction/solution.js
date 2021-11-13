// Do not edit the class below except for the buildHeap,
// siftDown, siftUp, peek, remove, and insert methods.
// Feel free to add new properties and methods to the class.
class MinHeap {
    constructor(array) {
      this.heap = this.buildHeap(array);
    }
  
    buildHeap(array) {
      // Write your code here.
          const firstParentIdx = Math.floor((array.length-2)/2);
          for(let i=firstParentIdx;0<=i;i--){
              this.siftDown(i,array.length-1,array);
          }
          return array;
    }
  
    siftDown(currentIdx, endIdx, heap) {
      // Write your code here.
          let childOneIdx = currentIdx * 2 + 1;
          let childTwoIdx = currentIdx * 2 + 2;
          while(childOneIdx <= endIdx){
              let idxToSwap;
              if(childTwoIdx<=endIdx && heap[childTwoIdx]<heap[childOneIdx]){
                  idxToSwap = childTwoIdx;
              } else idxToSwap = childOneIdx;
              if(heap[idxToSwap] < heap[currentIdx]) {
                  this.swap(currentIdx, idxToSwap, heap);
                  currentIdx = idxToSwap;
                  childOneIdx = currentIdx * 2 + 1;
                  childTwoIdx = currentIdx * 2 + 2;
              } else return;
          }
          
    }
  
    siftUp(currentIdx, heap) {
      // Write your code here.
          let parentIdx = Math.floor((currentIdx - 1) / 2);
          while(currentIdx > 0 && heap[currentIdx] < heap[parentIdx]){
              this.swap(currentIdx, parentIdx, heap);
              currentIdx = parentIdx;
              parentIdx = Math.floor((currentIdx - 1) / 2);
          }
    }
  
    peek() {
      // Write your code here.
          return this.heap[0];
    }
  
    remove() {
      // Write your code here.
          this.swap(0,this.heap.length-1,this.heap);
          const valueToRemove = this.heap.pop();
          this.siftDown(0,this.heap.length-1,this.heap);
          return valueToRemove;
    }
  
    insert(value) {
      // Write your code here.
          this.heap.push(value);
          this.siftUp(this.heap.length-1,this.heap);
    }
      swap(i,j,heap){
          const temp = heap[j];
          heap[j] = heap[i];
          heap[i] = temp;
      }
  }
  
  // Do not edit the line below.
  exports.MinHeap = MinHeap;
  
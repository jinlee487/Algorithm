// This is an input class. Do not edit.
class BinaryTree {
    constructor(value) {
      this.value = value;
      this.left = null;
      this.right = null;
      this.parent = null;
    }
  }
  
  function findSuccessor(tree, node) {
    // Write your code here.
      const array = findSuccessorHelper(tree);
      for(let i=0; i < array.length;i++){
          const current = array[i];
          if(current !== node) continue;
          if(i === array.length - 1) return null;
          return array[i + 1]; 
      }
      return null;
  }
  function findSuccessorHelper(node, array = []){
      if(node === null) return array;
      findSuccessorHelper(node.left,array);
      array.push(node);
      findSuccessorHelper(node.right,array);
      return array;
  }
// This is an input class. Do not edit.
class BinaryTree {
    constructor(value) {
      this.value = value;
      this.left = null;
      this.right = null;
      this.parent = null;
    }
  }
  
  function findSuccessor(tree, node) {
    // Write your code here.
      if(node.right !== null) return leftChild(node.right);
    return rightParent(node);
  }
  function leftChild(node){
      let current = node;
      while(current.left !== null){
          current = current.left;
      }
      return current;
  }
  function rightParent(node){
      let current = node;
      while(current.parent !== null && current.parent.right === current){
          current = current.parent;
      }
      return current.parent;
  }
  
  // Do not edit the lines below.
  exports.BinaryTree = BinaryTree;
  exports.findSuccessor = findSuccessor;
  
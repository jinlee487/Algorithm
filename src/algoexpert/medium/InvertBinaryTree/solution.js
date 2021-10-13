function invertBinaryTree(tree) {
    // Write your code here.
      const queue = [tree];
      while(queue.length){
          const current = queue.shift();
          if(current === null) continue;
          swap(current);
          queue.push(current.left);
          queue.push(current.right);
      }
  }
  function swap(tree){
      const left = tree.left;
      tree.left = tree.right;
      tree.right = left;
  }
  
  // This is the class of the input binary tree.
  class BinaryTree {
    constructor(value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }

  function invertBinaryTree(tree) {
    // Write your code here.
      if (tree === null) return;
      swap(tree);
      invertBinaryTree(tree.left);
      invertBinaryTree(tree.right);
  }
  // Do not edit the line below.
  exports.invertBinaryTree = invertBinaryTree;
  
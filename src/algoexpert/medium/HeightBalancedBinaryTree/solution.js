// This is an input class. Do not edit.
class BinaryTree {
    constructor(value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }
  class TreeInfo{
      constructor(isBalanced, height){
          this.isBalanced = isBalanced;
          this.height = height; 
      }
  }
  function heightBalancedBinaryTree(tree) {
    // Write your code here.
      const treeInfo = getTreeInfo(tree);
    return treeInfo.isBalanced;
  }
  function getTreeInfo(tree){
      if(tree === null) return new TreeInfo(true, -1);
      const left = getTreeInfo(tree.left);
      const right = getTreeInfo(tree.right);
      const isBalanced = left.isBalanced && right.isBalanced 
                                              && Math.abs(left.height - right.height) <= 1;
      const height = Math.max(left.height,right.height) + 1;
      return new TreeInfo(isBalanced, height);
  }
  
  // Do not edit the lines below.
  exports.BinaryTree = BinaryTree;
  exports.heightBalancedBinaryTree = heightBalancedBinaryTree;
  
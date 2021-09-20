// This is the class of the input root.
// Do not edit it.
class BinaryTree {
    constructor(value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }
  
  function branchSums(root) {
    // Write your code here.
      const sums = [];
      calculateBranchSums(root,0,sums);
      return sums;
  }
  function calculateBranchSums(node, runningSum, sums){
      if(node === null) return;
      let newRunningSum = runningSum + node.value;
      if(node.left === null && node.right === null){
          sums.push(newRunningSum);
      }
      calculateBranchSums(node.left, newRunningSum, sums);
      calculateBranchSums(node.right, newRunningSum, sums);
      return;
  }
  
  // Do not edit the lines below.
  exports.BinaryTree = BinaryTree;
  exports.branchSums = branchSums;
  
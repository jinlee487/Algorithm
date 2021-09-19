function findClosestValueInBst(tree, target) {
    // Write your code here.
      return findClosestValueInBstRecursive(tree, target, tree.value);
    // return findClosestValueInBstIterative(tree, target, tree.value);

  }
  function findClosestValueInBstRecursive(tree, target, closest){
	if(tree === null) return closest;
	if(Math.abs(tree.value-target)<Math.abs(closest-target)){
		closest = tree.value;
	} 
	if(target<tree.value){
		return findClosestValueInBstRecursive(tree.left, target, closest);
	} else if(target>tree.value){
		return findClosestValueInBstRecursive(tree.right, target, closest);
	} else {
		return closest;
	}
}
  function findClosestValueInBstIterative(tree, target, closest){
      let currentNode = tree;
      while(currentNode != null){
          if(Math.abs(currentNode.value - target) < Math.abs(closest - target)){
              closest = currentNode.value;
          }
          if(target < currentNode.value){
              currentNode = currentNode.left;
          } else if(target > currentNode.value){
              currentNode = currentNode.right;
          } else {
              break;
          }
      }
      return closest;
  }
  
  // This is the class of the input tree. Do not edit.
  class BST {
    constructor(value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }
  
  // Do not edit the line below.
  exports.findClosestValueInBst = findClosestValueInBst;
  
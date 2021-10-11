// This is an input class. Do not edit.
class BST {
    constructor(value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
}
  
function findKthLargestValueInBst(tree, k) {
// Write your code here.
    const array = [];
    findKthLargestValueInBstHelper(tree, array);
return array[k-1];
}
function findKthLargestValueInBstHelper(tree, array){
    if(tree === null) return;
    findKthLargestValueInBstHelper(tree.right,array);
    array.push(tree.value);
    findKthLargestValueInBstHelper(tree.left,array);
    return;
}

class Node {
	constructor(count, value) {
		this.value = value;
		this.count = count;
	}
}

function findKthLargestValueInBst(tree, k) {
  // Write your code here.
	const node = new Node(0, -1);
	findKthLargestValueInBstHelper(tree,k, node);
  return node.value;
}
function findKthLargestValueInBstHelper(tree,k, node){
	if(tree === null || node.count >= k) return;
	
	findKthLargestValueInBstHelper(tree.right,k,node);
	if(node.count < k) {
		node.count ++;
		node.value = tree.value;
		findKthLargestValueInBstHelper(tree.left,k,node);
	}
	return;
}
// Do not edit the lines below.
exports.BST = BST;
exports.findKthLargestValueInBst = findKthLargestValueInBst;
  
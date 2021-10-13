// This is an input class. Do not edit.
class BinaryTree {

	constructor(diameter, height, value){
		this.diameter = diameter;
		this.height = height;
		this.value = value;
		this.left = null;
    this.right = null;
	}
}

function binaryTreeDiameter(tree) {
  // Write your code here.
  return binaryTreeDiameterHelper(tree).diameter;
}
function binaryTreeDiameterHelper(tree){
	if(tree === null) return new BinaryTree(0,0,0);
	
	const left = binaryTreeDiameterHelper(tree.left);
	const right = binaryTreeDiameterHelper(tree.right);
	
	const longestPath = left.height + right.height;
	const maxDiameter = Math.max(left.diameter, right.diameter);
	const currentDiameter = Math.max(longestPath, maxDiameter);
	const currentHeight = 1 + Math.max(left.height, right.height);
	return new BinaryTree(currentDiameter, currentHeight, tree.value);
}

// Do not edit the line below.
exports.binaryTreeDiameter = binaryTreeDiameter;
exports.BinaryTree = BinaryTree;

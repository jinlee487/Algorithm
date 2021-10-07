// This is an input class. Do not edit.
class BST {
    constructor(value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
}
  
function validateBst(tree) {
// Write your code here.
    return validateBstHelper(tree,-Infinity, Infinity);
}
function validateBstHelper(tree, minimum, maximum){
    if(tree.value < minimum || tree.value >= maximum){
        return false;
    }
    if(tree.left !== null && !validateBstHelper(tree.left, minimum, tree.value)){
        return false;
    }
    if(tree.right !== null && !validateBstHelper(tree.right, tree.value, maximum)){
        return false;
    }
    return true;
}
function validateBstHelper(tree, minimum, maximum){
	if(tree === null) return true;
	if(tree.value < minimum || tree.value >= maximum) return false;
	const leftIsValid = validateBstHelper(tree.left,minimum,tree.value);
	return leftIsValid && validateBstHelper(tree.right, tree.value, maximum);
}

// Do not edit the line below.
exports.BST = BST;
exports.validateBst = validateBst;
  
// This is an input class. Do not edit.
class BST {
    constructor(value, left = null, right = null) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

function reconstructBst(preOrderTraversalValues) {
    // Write your code here.
    if(preOrderTraversalValues.length === 0) return null;
    const currentValue = preOrderTraversalValues[0];
    let rightSubTreeRootIdx = preOrderTraversalValues.length;
    for(let i=1;i<preOrderTraversalValues.length;i++){
        const value = preOrderTraversalValues[i];
        if(value >= currentValue) {
            rightSubTreeRootIdx = i;
            break;
        }
    }
    const bst = new BST(currentValue);
    bst.left = reconstructBst(preOrderTraversalValues.slice(1,rightSubTreeRootIdx));
    bst.right = reconstructBst(preOrderTraversalValues.slice(rightSubTreeRootIdx,preOrderTraversalValues.length));
    return bst;
}
  
// This is an input class. Do not edit.
class BST {
    constructor(value, left = null, right = null) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
class Tree {
    constructor(rootIdx){
        this.rootIdx = rootIdx;
    }
}
function reconstructBst(preOrderTraversalValues) {
    // Write your code here.
    const tree = new Tree(0);
    return reconstructBstHelper(-Infinity, Infinity, preOrderTraversalValues,tree);
}
function reconstructBstHelper(lowerBound, upperBound, preOrderTraversalValues, tree){
    if(preOrderTraversalValues.length === tree.rootIdx) return null;
    const rootValue = preOrderTraversalValues[tree.rootIdx];
    if(rootValue < lowerBound || rootValue >= upperBound) return null;
    tree.rootIdx ++;
    const left = reconstructBstHelper(lowerBound,rootValue,preOrderTraversalValues,tree);
    const right = reconstructBstHelper(rootValue,upperBound,preOrderTraversalValues,tree)
    return new BST(rootValue,left,right);
}
// Do not edit the lines below.
exports.BST = BST;
exports.reconstructBst = reconstructBst;
  
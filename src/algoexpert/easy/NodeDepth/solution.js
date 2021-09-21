// This is the class of the input binary tree.
class BinaryTree {
    constructor(value) {
    this.value = value;
    this.left = null;
    this.right = null;
    }
}

function nodeDepthsIterative1(root) {
    // Write your code here.
    let sum = 0;
    const stack = [{node: root, depth: 0}];
    while(stack.length > 0){
        const {node, depth} = stack.pop();
        if(node === null) continue;
        sum += depth;
        stack.push({node: node.left, depth: depth+1});
				stack.push({node: node.right, depth: depth+1});
    }
    return sum;
}

function nodeDepthsIterative2(root) {
    // Write your code here.
    let sum = 0;
    const stack = [];
    stack.push(new Level(root, 0));
    while(stack.length !== 0){
        const level = stack.pop();
        let depth = level.depth;
        const node = level.node;
        if(node === null) continue;
        sum += depth;
        stack.push(new Level(node.left,depth+1));
        stack.push(new Level(node.right,depth+1));
    }
    return sum;
}
class Level {
    constructor(node, depth) {
        this.depth = depth;
        this.node = node;
    }
}

function nodeDepthsRecursive1(root) {
    // Write your code here.
      return calculateNodeDepths(root, 0);
}
function calculateNodeDepths(node, depth){
    if(node === null) return 0;
    return depth + calculateNodeDepths(node.left, depth + 1) + calculateNodeDepths(node.right, depth + 1);
}

function nodeDepthsRecursive2(root, depth = 0) {
	if(root === null) return 0;
	return depth + nodeDepthsRecursive2(root.left, depth + 1) + nodeDepthsRecursive2(root.right, depth + 1);
}

// Do not edit the line below.
exports.nodeDepths = nodeDepths;
  
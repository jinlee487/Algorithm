function minHeightBst(array) {
    // Write your code here.
    return minHeightBstHelper(array, null, 0, array.length-1);
}
function minHeightBstHelper(array, bst, start, end){
    if(end<start) return;
    const mid = Math.floor((start+end)/2);
    const newBst = new BST(array[mid]);
    if(bst===null){
        bst=newBst;
    } else {
        if(array[mid]<bst.value){
            bst.left=newBst;
            bst=bst.left;
        } else {
            bst.right=newBst;
            bst=bst.right;
        }
    }
    minHeightBstHelper(array,bst,start,mid-1);
    minHeightBstHelper(array,bst,mid+1,end);
    return bst;
}
function minHeightBst(array) {
    // Write your code here.
    return minHeightBstHelper(array, 0, array.length-1);
}
function minHeightBstHelper(array, start, end) {
    if(end<start) return null;
    const mid = Math.floor((start+end)/2);
    const bst = new BST(array[mid]);
    bst.left = minHeightBstHelper(array,start,mid-1);
    bst.right = minHeightBstHelper(array,mid+1,end);
    return bst;
}
function minHeightBstHelper(array, bst, start, end) {
	if(end<start) return;
	const mid = Math.floor((start + end)/2);
	const value = array[mid];
	if(bst===null){
		bst = new BST(value);
	} else {
		bst.insert(value);
	}
	minHeightBstHelper(array,bst,start,mid-1);
	minHeightBstHelper(array,bst,mid+1,end);
	return bst;
}

class BST {
    constructor(value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    insert(value) {
        if (value < this.value) {
        if (this.left === null) {
            this.left = new BST(value);
        } else {
            this.left.insert(value);
        }
        } else {
        if (this.right === null) {
            this.right = new BST(value);
        } else {
            this.right.insert(value);
        }
        }
    }
}

// Do not edit the line below.
exports.minHeightBst = minHeightBst;

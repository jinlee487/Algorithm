def minHeightBst(array):
    return minHeightBstHelper(array, 0, len(array)-1)
def minHeightBstHelper(array, start, end):
	if end < start:
		return None
	mid = (start+end)//2
	bst = BST(array[mid])
	bst.left = minHeightBstHelper(array,start,mid-1)
	bst.right = minHeightBstHelper(array,mid+1,end)
	return bst


def minHeightBst(array):
    return minHeightBstHelper(array, None, 0, len(array)-1)
def minHeightBstHelper(array, bst, start, end):
	if end<start:
		return
	mid = (start+end)//2
	newBst = BST(array[mid])
	if bst is None:
		bst = newBst
	else:
		if array[mid] < bst.value:
			bst.left = newBst
			bst = bst.left
		else:
			bst.right = newBst
			bst = bst.right
	minHeightBstHelper(array,bst,start,mid-1)
	minHeightBstHelper(array,bst,mid+1,end)
	return bst



def minHeightBst(array):
    return minHeightBstHelper(array,None,0,len(array)-1)
def minHeightBstHelper(array, bst, start, end):
	if end < start:
		return
	mid = (start + end) // 2
	value = array[mid]
	if bst is None:
		bst = BST(value)
	else:
		bst.insert(value)
	minHeightBstHelper(array,bst,start,mid-1)
	minHeightBstHelper(array,bst,mid+1,end)
	return bst

class BST:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

    def insert(self, value):
        if value < self.value:
            if self.left is None:
                self.left = BST(value)
            else:
                self.left.insert(value)
        else:
            if self.right is None:
                self.right = BST(value)
            else:
                self.right.insert(value)

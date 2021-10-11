# This is an input class. Do not edit.
class BST:
    def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right


def reconstructBst(preOrderTraversalValues):
    # Write your code here.
    if len(preOrderTraversalValues) == 0:
        return None
    currentValue = preOrderTraversalValues[0]
    rightSubtreeRootIdx = len(preOrderTraversalValues)
    for i in range(1,len(preOrderTraversalValues)):
        value = preOrderTraversalValues[i]
        if value >= currentValue:
            rightSubtreeRootIdx = i
            break
    bst = BST(currentValue)
    bst.left = reconstructBst(preOrderTraversalValues[1:rightSubtreeRootIdx])
    bst.right = reconstructBst(preOrderTraversalValues[rightSubtreeRootIdx:len(preOrderTraversalValues)]) 
    return bst

class Tree:
    def __init__(self, rootIdx):
        self.rootIdx = rootIdx

def reconstructBst(preOrderTraversalValues):
    # Write your code here.
    tree = Tree(0)
    return reconstructBstHelper(float('-inf'),float('inf'),preOrderTraversalValues,tree)
def reconstructBstHelper(lower,upper,array,tree):
	if len(array) == tree.rootIdx:
		return None
	rootValue = array[tree.rootIdx]
	if rootValue < lower or rootValue >= upper:
		return None
	tree.rootIdx += 1
	left = reconstructBstHelper(lower,rootValue,array,tree)
	right = reconstructBstHelper(rootValue,upper,array,tree)
	return BST(rootValue, left, right)
	


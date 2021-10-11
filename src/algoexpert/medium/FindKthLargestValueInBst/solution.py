# This is an input class. Do not edit.
class BST:
    def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right


def findKthLargestValueInBst(tree, k):
    # Write your code here.
    array = []
    findKthLargestValueInBstHelper(tree,k,array)
    return array[k-1]

def findKthLargestValueInBstHelper(tree,k,array):
	if tree is None:
		return
	findKthLargestValueInBstHelper(tree.right,k,array)
	array.append(tree.value)
	findKthLargestValueInBstHelper(tree.left,k,array)
	return


# This is an input class. Do not edit.
class BST:
    def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right

class Node:
	def __init__(self,count,value):
		self.value = value
		self.count = count

		
def findKthLargestValueInBst(tree, k):
    # Write your code here.
    node = Node(0,-1)
    findKthLargestValueInBstHelper(tree,k,node)
    return node.value
def findKthLargestValueInBstHelper(tree,k,node):
    if tree is None or node.count >= k:
        return
    findKthLargestValueInBstHelper(tree.right,k,node)
    if node.count < k:
        node.count += 1
        node.value = tree.value
        findKthLargestValueInBstHelper(tree.left,k,node)
    return

		
	



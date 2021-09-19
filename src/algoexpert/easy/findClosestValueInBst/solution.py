def findClosestValueInBst(tree, target):
    # Write your code here.
	return findClosestValueInBstRecursive(tree, target, tree.value)
	# return findClosestValueInBstIterative(tree, target, tree.value)


def findClosestValueInBstRecursive(tree, target, closest):
	if tree is None:
		return closest
	if abs(tree.value - target) < abs(closest - target):
		closest = tree.value
	if target < tree.value:
		return findClosestValueInBstRecursive(tree.left, target, closest)
	elif target > tree.value:
		return findClosestValueInBstRecursive(tree.right, target, closest)
	else: 
		return closest

def findClosestValueInBstIterative(tree, target, closest):
	currentNode = tree
	while currentNode is not None:
		if abs(currentNode.value - target) < abs(closest - target):
			closest = currentNode.value
		if target < currentNode.value:
			currentNode = currentNode.left
		elif target > currentNode.value:
			currentNode = currentNode.right
		else:
			break;
	return closest


# This is the class of the input tree. Do not edit.
class BST:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

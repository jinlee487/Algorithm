# This is an input class. Do not edit.
class BinaryTree:
    def __init__(self, value, left=None, right=None, parent=None):
        self.value = value
        self.left = left
        self.right = right
        self.parent = parent


def findSuccessor(tree, node):
    # Write your code here.
    array = findSuccessorHelper(tree)
    for i, current in enumerate(array):
        if current != node:
            continue
        if i == len(array) - 1:
            return None
        return array[i + 1]
    return None
def findSuccessorHelper(node, array = []):
	if node is None:
		return array
	findSuccessorHelper(node.left,array)
	array.append(node)
	findSuccessorHelper(node.right,array)
	return array

# This is an input class. Do not edit.
class BinaryTree:
    def __init__(self, value, left=None, right=None, parent=None):
        self.value = value
        self.left = left
        self.right = right
        self.parent = parent


def findSuccessor(tree, node):
    # Write your code here.
    if node.right is not None: 
        return leftChild(node.right)
    return rightParent(node)

def leftChild(node):
	current = node
	while current.left is not None:
		current = current.left
	return current

def rightParent(node):
	current = node
	while current.parent is not None and current.parent.right == current:
		current = current.parent
	return current.parent
		
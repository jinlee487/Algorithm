def invertBinaryTree(tree):
    # Write your code here.
	queue = [tree]
	while len(queue):
		current = queue.pop(0)
		if current is None:
			continue
		swap(current)
		queue.append(current.left)
		queue.append(current.right)
def invertBinaryTree(tree):
    # Write your code here.
	if tree is None:
		return
	swap(tree)
	invertBinaryTree(tree.left)
	invertBinaryTree(tree.right)

def swap(tree):
	tree.left, tree.right = tree.right, tree.left


# This is the class of the input binary tree.
class BinaryTree:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

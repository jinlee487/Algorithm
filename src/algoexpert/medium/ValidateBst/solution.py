# This is an input class. Do not edit.
class BST:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None


def validateBst(tree):
    # Write your code here.
	return validateBstHelper(tree,float("-inf"),float("inf"))
def validateBstHelper(tree, minimum, maximum):
	if tree is None:
		return True
	if tree.value < minimum or tree.value >= maximum:
		return False
	leftIsValid = validateBstHelper(tree.left, minimum, tree.value)
	return leftIsValid and validateBstHelper(tree.right,tree.value,maximum)

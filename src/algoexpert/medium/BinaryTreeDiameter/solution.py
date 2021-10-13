# This is an input class. Do not edit.
class BinaryTree:
    def __init__(self,value, diameter=None, height=None, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right
        self.diameter = diameter
        self.height = height

def binaryTreeDiameter(tree):
    # Write your code here
    return binaryTreeDiameterHelper(tree).diameter
def binaryTreeDiameterHelper(tree):
	if tree is None:
		return BinaryTree(0,0,0)
	left = binaryTreeDiameterHelper(tree.left)
	right = binaryTreeDiameterHelper(tree.right)
	
	longestPath = left.height + right.height
	maxDiameter = max(left.diameter, right.diameter)
	currentDiameter = max(longestPath, maxDiameter)
	currentHeight = 1 + max(left.height, right.height)
	return BinaryTree(tree.value, currentDiameter, currentHeight)

# This is an input class. Do not edit.
class BinaryTree:
    def __init__(self, value, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right
class TreeInfo:
	def __init__(self,isBalanced, height):
		self.isBalanced = isBalanced
		self.height = height

def heightBalancedBinaryTree(tree):
    # Write your code here.
	treeInfo = getTreeInfo(tree)
    return treeInfo.isBalanced
def getTreeInfo(tree):
	if tree is None:
		return TreeInfo(True, -1)
	left = getTreeInfo(tree.left)
	right = getTreeInfo(tree.right)
	isBalanced = (left.isBalanced and right.isBalanced 
					and abs(left.height-right.height) <= 1)
	height = max(left.height,right.height) + 1
	return TreeInfo(isBalanced, height)

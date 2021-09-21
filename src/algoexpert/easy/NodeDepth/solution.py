def nodeDepthsRecursive(root, depth = 0):
	if root is None:
		return 0
	return depth + nodeDepthsRecursive(root.left, depth + 1) + nodeDepthsRecursive(root.right, depth + 1)

def nodeDepthsIterative(root):
    # Write your code here.
	answer = 0
	stack = [{"node": root, "depth": 0}]
	while len(stack) > 0:
		temp = stack.pop()
		node, depth = temp["node"], temp["depth"]
		if node is None:
			continue
		answer += depth
		stack.append({"node": node.left, "depth": depth+1})
		stack.append({"node": node.right, "depth": depth+1})		
	return answer

# This is the class of the input binary tree.
class BinaryTree:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

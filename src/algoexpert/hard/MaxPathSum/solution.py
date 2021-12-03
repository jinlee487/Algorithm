def maxPathSum(tree):
    # Write your code here.
	answer = []
	maxPathSumHelper(tree,answer)
	answer.sort(reverse=True)
	return answer[0]
def maxPathSumHelper(node,answer):
	if node is None:
		return 0
	left = maxPathSumHelper(node.left,answer)
	right = maxPathSumHelper(node.right,answer)
	mps = node.value
	if 0 < left:
		mps += left
	if 0 < right:
		mps += right
	answer.append(mps)
	return max(node.value+right,node.value+left)
def maxPathSum(tree):
    # Write your code here.
	a,b = maxPathSumHelper(tree)
	return max(a,b)
def maxPathSumHelper(node):
	if node is None:
		return [float('-inf'),0]
	left = maxPathSumHelper(node.left)
	right = maxPathSumHelper(node.right)
	mps = [node.value,node.value]
	mps[0] = max(mps[0],max(mps[0]+left[1]+right[1],max(mps[0]+left[1],mps[0]+right[1])))
	mps[0] = max(mps[0],max(right[0],left[0]))
	mps[1] = max(mps[1],max(right[1]+mps[1],left[1]+mps[1]))
	return mps

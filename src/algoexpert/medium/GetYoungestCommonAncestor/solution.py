# This is an input class. Do not edit.
class AncestralTree:
    def __init__(self, name):
        self.name = name
        self.ancestor = None


def getYoungestCommonAncestor(topAncestor, descendantOne, descendantTwo):
    # Write your code here.
	myset = {topAncestor.name}
	getYoungestCommonAncestorHelper(descendantOne, myset)
	return getYoungestCommonAncestorHelper(descendantTwo, myset)
def getYoungestCommonAncestorHelper(descendant, myset):
	if descendant.name in myset:		
		return descendant
	myset.add(descendant.name)
	return getYoungestCommonAncestorHelper(descendant.ancestor,myset)

# This is an input class. Do not edit.
class AncestralTree:
    def __init__(self, name):
        self.name = name
        self.ancestor = None


def getYoungestCommonAncestor(topAncestor, descendantOne, descendantTwo):
    # Write your code here.
	depthOne = getDepth(descendantOne,topAncestor)
	depthTwo = getDepth(descendantTwo,topAncestor)
	if depthOne > depthTwo:
		return getYoungestCommonAncestorHelper(descendantOne,descendantTwo,depthOne-depthTwo)
	else :
		return getYoungestCommonAncestorHelper(descendantTwo,descendantOne,depthTwo-depthOne)
def getDepth(descendant, top):
	diff = 0
	while descendant.name != top.name:
		descendant = descendant.ancestor
		diff += 1
	return diff
def getYoungestCommonAncestorHelper(lower, upper, diff):
	while diff > 0:
		lower = lower.ancestor
		diff -= 1
	while lower.name != upper.name:
		lower = lower.ancestor
		upper = upper.ancestor
	return lower
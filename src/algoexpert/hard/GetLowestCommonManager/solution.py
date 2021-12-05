def getLowestCommonManager(topManager, reportOne, reportTwo):
    # Write your code here.
	return getOrgInfo(topManager, reportOne, reportTwo).lowestCommonManager
def getOrgInfo(node, reportOne, reportTwo):
	count = 0
	for child in node.directReports:
		orgInfo = getOrgInfo(child,reportOne, reportTwo)
		if orgInfo.lowestCommonManager is not None:
			return orgInfo
		count += orgInfo.count
	if node == reportOne or node == reportTwo:
		count += 1
	lowestCommonManager = node if count == 2 else None
	return OrgInfo(lowestCommonManager,count)

class OrgInfo:
	def __init__(self,lowestCommonManager,count):
		self.lowestCommonManager = lowestCommonManager
		self.count = count

# This is an input class. Do not edit.
class OrgChart:
    def __init__(self, name):
        self.name = name
        self.directReports = []

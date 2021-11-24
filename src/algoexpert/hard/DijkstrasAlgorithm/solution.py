def dijkstrasAlgorithm(start, edges):
    # Write your code here.
	dp = [float("inf") for _ in range(len(edges))]
	dp[start] = 0
	visited = set()
	while len(visited) != len(edges):
		vertex = -1;
		currentDistance = float("inf");
		for i in range(len(dp)):
			if i in visited: 
				continue
			if dp[i] < currentDistance:
				currentDistance = dp[i]
				vertex = i
		if currentDistance == float("inf"):
			break
		visited.add(vertex)
		for edge in edges[vertex]:
			nextVertex, nextDistance = edge
			if nextVertex in visited:
				continue
			if nextDistance + currentDistance < dp[nextVertex]:
				dp[nextVertex] = nextDistance + currentDistance
				
	return list(map(lambda x: -1 if x == float("inf") else x, dp))	
def dijkstrasAlgorithm(start, edges):
    # Write your code here.
	dp = []
	array = []
	dic = {}
	for i in range(len(edges)):
		item = Item(i,float("inf"))
		array.append(item)
		dic[i] = item
	array[start].distance = 0
	array.sort(key=lambda x: x.distance, reverse=True)
	while len(array) != 0:
		item = array.pop()
		vertex = item.vertex
		currentDistance = item.distance
		if currentDistance == float("inf"):
			break
		for edge in edges[vertex]:
			nextVertex, nextDistance = edge
			if nextDistance + currentDistance < dic[nextVertex].distance:
				dic[nextVertex].distance = nextDistance + currentDistance
				array.sort(key=lambda x: x.distance, reverse=True)
	for i in range(len(edges)):
		dp.append(dic[i].distance)
		if dp[i] == float("inf"):
			dp[i] = -1
	return dp

class Item:
	def __init__(self, vertex, distance):
		self.vertex = vertex
		self.distance = distance
	def __str__(self):
		return f'vertex: {self.vertex} distance: {self.distance}'
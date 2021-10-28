def cycleInGraph(edges):
    # Write your code here.
    visited = set()
    for i in range(len(edges)):
        if i in visited: 
            continue
        if dfs(i,edges,visited):
            return True
    return False
def dfs(node, edges, visited):
    if node in visited:
        return True
    visited.add(node)
    for i in range(len(edges[node])):
        if dfs(edges[node][i],edges,visited):
                return True
    visited.remove(node)
    return False
def cycleInGraph(edges):
    # Write your code here.
    visited = [False for _ in range(len(edges))]
    current = [False for _ in range(len(edges))]
    for node in range(len(edges)):
        if visited[node]:
            continue
        if dfs(node, edges, visited, current):
            return True
    return False
def dfs(node, edges, visited, current):
	if current[node]:
		return True
	visited[node] = True
	current[node] = True
	for neighbor in edges[node]:
		if visited[neighbor]: 
			if current[neighbor]:
				return True
			else: 
				continue
		else:
			if dfs(neighbor, edges, visited, current): 
				return True
	current[node] = False
	return False
				
	

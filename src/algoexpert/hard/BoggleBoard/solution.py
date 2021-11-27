def boggleBoard(board, words):
    # Write your code here.
	trie = Trie()
	for word in words:
		trie.add(word)
	answer = {}
	visited = [[False for letter in row] for row in board]
	for i in range(len(board)):
		for j in range(len(board[i])):
			dfs(i,j,board,trie.root,visited,answer)
	return list(answer.keys())

def dfs(x,y,board,trieNode,visited,finalWords):
	if visited[x][y] == True:
		return
	letter = board[x][y]
	if letter not in trieNode:
		return
	visited[x][y] = True
	trieNode = trieNode[letter]
	if "*" in trieNode:
		finalWords[trieNode["*"]] = True
	xarr = [-1,-1,-1,0,0,1,1,1]
	yarr = [-1,0,1,-1,1,-1,0,1]
	for i in range(len(xarr)):
		nx = xarr[i] + x
		ny = yarr[i] + y
		if check(nx,ny,board,visited) == True:
			dfs(nx,ny,board,trieNode,visited,finalWords)
	visited[x][y] = False
	return
def check(x,y,board,visited):
	if x<0 or len(board)<=x:
		return False
	if y<0 or len(board[x])<=y:
		return False
	if visited[x][y] is True:
		return False
	return True
class Trie:
	def __init__(self):
		self.root = {}
		self.endSymbol = "*"
	def add(self, word):
		current = self.root
		for letter in word:
			if letter not in current:
				current[letter] = {}
			current = current[letter]
		current[self.endSymbol] = word
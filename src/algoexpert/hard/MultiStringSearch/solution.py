def multiStringSearch(bigString, smallStrings):
    # Write your code here.
    trie = Trie()
    for s in smallStrings:
        trie.add(s)
    containedStrings = {}
    for i in range(len(bigString)):
        dfs(bigString, i , trie, containedStrings)
    return [string in containedStrings for string in smallStrings]
def dfs(string, index, trie, containedStrings):
    currentNode = trie.root
    for i in range(index,len(string)):
        currentChar = string[i]
        if currentChar not in currentNode:
            break
        currentNode = currentNode[currentChar]
        if trie.endSymbol in currentNode:
            containedStrings[currentNode[trie.endSymbol]] = True
class Trie:
    def __init__(self):
        self.root = {}
        self.endSymbol = "*"
    def add(self,word):
        current = self.root
        for i in range(len(word)):
            if word[i] not in current:
                current[word[i]] = {}
            current = current[word[i]]
        current[self.endSymbol] = word
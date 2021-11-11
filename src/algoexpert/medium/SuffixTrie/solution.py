# Do not edit the class below except for the
# populateSuffixTrieFrom and contains methods.
# Feel free to add new properties and methods
# to the class.
class SuffixTrie:
    def __init__(self, string):
        self.root = {}
        self.endSymbol = "*"
        self.populateSuffixTrieFrom(string)

    def populateSuffixTrieFrom(self, string):
        # Write your code here.
        for i in range(len(string)):
            currentNode = self.root
            for j in range(i,len(string)):
                letter = string[j]
                if letter not in currentNode:
                    currentNode[letter] = {}
                currentNode = currentNode[letter]
            currentNode[self.endSymbol] = True
    def contains(self, string):
        # Write your code here.
        currentNode = self.root
        for i in range(len(string)):
            letter = string[i]
            if letter not in currentNode:
                return False
            currentNode = currentNode[letter]
        return self.endSymbol in currentNode
    

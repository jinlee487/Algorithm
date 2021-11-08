def groupAnagrams(words):
    # Write your code here.
	if len(words) == 0:
		return []
	sortedWords = ["".join(sorted(w)) for w in words]
	indicies = [i for i in range(len(words))]
	indicies.sort(key=lambda x: sortedWords[x])
	answer = []
	current = []
	anagram = sortedWords[indicies[0]]
	for i in indicies:
		word = words[i]
		sortedWord = sortedWords[i]
		if sortedWord == anagram:
			current.append(word)
		else:
			answer.append(current)
			anagram = sortedWord
			current = [word]
	answer.append(current)
    return answer

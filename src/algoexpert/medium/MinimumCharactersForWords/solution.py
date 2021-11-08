def minimumCharactersForWords(words):
    # Write your code here.
	dic = {}
	for word in words:
		characters = {}
		for character in word:
			if character not in characters:
				characters[character] = 0
			characters[character] += 1
		for character in characters:
			if character not in dic:
				dic[character] = characters[character]
			else:
				dic[character] = max(characters[character],dic[character])
	answer = []
	for character in dic:
		for _ in range(dic[character]):
			answer.append(character)
	return answer

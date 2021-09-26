def caesarCipherEncryptor(string, key):
    # Write your code here.
	answer = []
	alphabet = "abcdefghijklmnopqrstuvwxyz"
	for a in string:
		answer.append(alphabet[(alphabet.index(a) + key%26)%26]);
	return ''.join(answer)
    
def caesarCipherEncryptor(string, key):
    # Write your code here.
	answer = []
	for c in string:
		newLetterCode = ord(c) + key%26
		newLetter = chr(newLetterCode) if newLetterCode <= 122 else chr(96 + newLetterCode%122)
		answer.append(newLetter)
	return ''.join(answer)

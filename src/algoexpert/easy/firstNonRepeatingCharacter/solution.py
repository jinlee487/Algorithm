def firstNonRepeatingCharacter(string):
    # Write your code here.
    for i in range(len(string)):
        check = True
        for j in range(len(string)):
            if i==j:
                continue
            if string[i] == string[j]:
                check = False
                break
        if check:
            return i    
    return -1

def firstNonRepeatingCharacter(string):
    # Write your code here.
    dic = {}
    for character in string:
        if character in dic:
            dic[character] += 1
        else:
            dic[character] = 1
    for i in range(len(string)):
        if dic[string[i]] == 1:
            return i
    return -1

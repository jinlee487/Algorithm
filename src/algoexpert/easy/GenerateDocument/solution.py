def generateDocument(characters, document):
    # Write your code here.
    for current in document:
        d, c = 0, 0
        for character in document:
            if current == character:
                d += 1
        for character in characters:
            if current == character:
                c += 1		
        if c < d:
            return False
    return True
def generateDocument(characters, document):
    # Write your code here.
    s = set()
    for current in document:
        if current in s:
            continue
        d, c = 0, 0
        s.add(current)
        for character in document:
            if current == character:
                d += 1
        for character in characters:
            if current == character:
                c += 1		
        if c < d:
            return False			
    return True

def generateDocument(characters, document):
    # Write your code here.
    dic = {}
    for character in characters:
        if character in dic:
            dic[character] += 1
        else: 
            dic[character] = 1
    for character in document:
        if character not in dic or dic[character] == 0:
            return False
        if character in dic:
            dic[character] -= 1
    return True

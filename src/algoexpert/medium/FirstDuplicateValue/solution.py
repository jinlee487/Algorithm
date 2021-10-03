def firstDuplicateValue(array):
    # Write your code here.
    for i in range(len(array)):
        for j in range(i):
            if array[i] == array[j]:
                return array[j]
    return -1
    
def firstDuplicateValue(array):
    # Write your code here.
    hashSet = set()
    for a in array:
        if a in hashSet:
            return a
        else:
            hashSet.add(a)
    return -1

def firstDuplicateValue(array):
    # Write your code here.
    for i in range(len(array)):
        a = abs(array[i])
        if array[a-1] < 0: 
            return a
        else:
            array[a-1] *= -1
    return -1


def powerset(array):
    # Write your code here.
    subsets = [[]]
    for value in array:
        for i in range(len(subsets)):
            current = subsets[i]
            subsets.append(current + [value])
    return subsets
def powerset(array, idx=None):
    # Write your code here.
    if idx is None:
        idx = len(array)-1
    if idx < 0:
        return [[]]
    value = array[idx]
    subsets = powerset(array,idx-1)
    for i in range(len(subsets)):
        current = subsets[i]
        subsets.append(current+[value])
    return subsets
def powerset(array):
    # Write your code here.
    answer=[]
    for i in range(1<<len(array)):
        combination = []
        for j in range(len(array)):
            if i&(1<<j) > 0:
                combination.append(array[j])
        answer.append(combination)
    return answer

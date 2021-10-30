def getPermutations(array):
    # Write your code here.
    answer = [] 
    getPermutationsHelper(array,[],answer)
    return answer
def getPermutationsHelper(array, current, answer):
    if not len(array) and len(current):
        answer.append(current)
    else:
        for i in range(len(array)):
            temp = array[:i] + array[i+1:]
            permutation = current + [array[i]]
            getPermutationsHelper(temp,permutation,answer)
			
def getPermutations(array):
    # Write your code here.
    answer = []
    getPermutationsHelper(0,array,answer)
    return answer
def getPermutationsHelper(i,array,answer):
    if i == len(array) - 1:
        answer.append(array[:])
    else: 
        for j in range(i,len(array)):
            swap(array,i,j)
            getPermutationsHelper(i+1,array,answer)
            swap(array,i,j)
def swap(array,i,j):
    array[i], array[j] = array[j], array[i]

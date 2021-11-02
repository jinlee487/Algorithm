def threeNumberSort(array, order):
    # Write your code here.
    first, second, third = 0,0,len(array)-1
    while second<=third:
        if array[second] == order[0]:
            array[first], array[second] = array[second], array[first]
            first += 1
            second += 1
        elif array[second] == order[1]:
            second += 1
        else:
            array[third], array[second] = array[second], array[third]
            third -= 1
    return array

def threeNumberSort(array, order):
    # Write your code here.
    idx = 0
    for i in range(len(array)):
        if array[i] == order[0]:
            array[idx],array[i] = array[i],array[idx]
            idx += 1
    idx = len(array) - 1
    for i in range(len(array)-1,-1,-1):
        if array[i] == order[2]:
            array[idx],array[i] = array[i],array[idx]
            idx -= 1 
    return array
def threeNumberSort(array, order):
    # Write your code here.
    count = [0 for _ in range(len(order))]
    for el in array:
        count[order.index(el)] += 1
    idx = 0
    for i in range(len(count)):
        for j in range(count[i]):
            array[idx] = order[i]
            idx+=1
    return array

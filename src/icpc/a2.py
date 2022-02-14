
def run():
    num = input() #24
    arr = [False for x in range(10)]
    for x in num:
        arr[int(x)] = True
    upperNumber = getUpperBound(arr,num)
    for x in num:
        arr[int(x)] = True
    lowerNumber = getLowerBound(arr,num)
    print(upperNumber)
    print(lowerNumber)
    if upperNumber != -1 and lowerNumber != -1:
        return upperNumber if (upperNumber - int(num)) < (int(num) - lowerNumber) else lowerNumber
    elif upperNumber == -1:
        return lowerNumber
    elif lowerNumber == -1:
        return upperNumber
    else:
        return 'Impossible'

def getUpperBound(arr, num):
    firstDigit = []
    index = int(num[0])
    while index < 10:
        if arr[index] != True:
            break
        index += 1
    if index == 10:
        return -1
    firstDigit.append(index)
    index = 0
    while index < 10:
        if arr[index] != True:
            break
        index += 1
    if index == 10:
        return -1
    print(firstDigit)
    for i in range(1, len(num)):
        firstDigit.append(index)
    return int("".join(firstDigit))

def lowerBound():
    firstDigit = []
    index = int(num[0])
    while 0 <= index:
        if arr[index] != True:
            break
        index -= 1
    if index == -1:
        return -1
    firstDigit.append(index)
    index = 9
    while 0 <= index:
        if arr[index] != True:
            break
        index -= 1
    if index == -1:
        return -1
    for i in range(1, len(num)):
        firstDigit.append(index)
    return int("".join(firstDigit))
run()

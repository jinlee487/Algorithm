
def run():
    num = input() #24
    arr = [False for x in range(10)]
    for x in num:
        arr[int(x)] = True
    upperNumber = getUpperBound(arr,num)
    for x in num:
        arr[int(x)] = True
    lowerNumber = getLowerBound(arr,num)
    # print(upperNumber)
    # print(lowerNumber)
    if upperNumber != -1 and lowerNumber != -1:
        if (upperNumber - int(num)) < (int(num) - lowerNumber):
            return upperNumber
        elif (upperNumber - int(num)) > (int(num) - lowerNumber):
            return lowerNumber
        else:
            return str(lowerNumber) + " " + str(upperNumber)
    elif upperNumber != -1:
        return upperNumber
    elif lowerNumber != -1:
        return lowerNumber
    else:
        return "Impossible"

def getUpperBound(arr, num):
    answer = []
    index = int(num[0])
    sizeOfAnswer = len(num)
    count = 0
    while count < 10:
        if arr[index] != True:
            break
        index += 1
        if index >= 10:
            index = 1
        count += 1
    if count == 10:
        return -1
    if index<int(num[0]):
        sizeOfAnswer += 1
    answer.append(str(index))
    # print(answer)
    # print(arr)
    index = 0
    while index < len(arr):
        if arr[index] != True:
            break
        index += 1
    for i in range(1, sizeOfAnswer):
        answer.append(str(index))
    return int("".join(answer))

def getLowerBound(arr, num):
    answer = []
    index = int(num[0])
    sizeOfAnswer = len(num)
    count = 0
    while count < 10:
        # print("this is index in while " + str(index))
        if arr[index] != True:
            break
        index -= 1
        if index == -1:
            index = 9
        count += 1
    if count == 10:
        return -1
    if index == 0:
        while count < 10:
            # print("this is index in while " + str(index))
            if arr[index] != True:
                break
            index -= 1
            if index <= 0 and sizeOfAnswer != 1:
                index = 9
            count += 1
        if count == 10:
            return -1
    if int(num[0])<index:
        sizeOfAnswer -= 1
    # print("this is index" + str(index))
    answer.append(str(index))
    # print(answer)

    index = 9
    count = 0
    while count < len(arr):
        if arr[index] != True:
            break
        index -= 1
        count += 1
    for i in range(1, sizeOfAnswer):
        answer.append(str(index))
    return int("".join(answer))
print(run())

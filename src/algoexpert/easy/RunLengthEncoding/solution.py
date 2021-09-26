def runLengthEncoding(string):
    # Write your code here.
    answer = []
    j = 1
    for i in range(1, len(string)):
        current = string[i]
        previous = string[i-1]
        if current != previous or j == 9:
            answer.append(str(j))
            answer.append(previous)
            j = 0
        j += 1
    answer.append(str(j))
    answer.append(string[len(string) - 1])
    return ''.join(answer)

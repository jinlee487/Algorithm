

def minimumWaitingTime1(queries):
    # Write your code here.
    queries.sort()
    answer = 0
    for i in range(len(queries)):
        answer = answer + queries[i] * (len(queries) - 1 - i)
    return answer

def minimumWaitingTime2(queries):
    # Write your code here.
    queries.sort()
    answer = 0 
    for i,v in enumerate(queries):
        answer += v * (len(queries) - 1 - i)
    return answer

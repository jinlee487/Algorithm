n, k = map(int, input().split())

result = 0 

while True: 
    target = (n//k)*k
    result += (n - target)
    # we have to get to the nearest divisible value of n for k
    # we check what is the nearest multiple of k is and subtract 1 until we reach that value
    
    print(n//k)
    print(target)
    print(result)
    
    n = target 
    if n < k:
        break
    print("not break")
    result += 1
    n //= k 
    print(result)
    print(n)

result += (n-1)
print(result)

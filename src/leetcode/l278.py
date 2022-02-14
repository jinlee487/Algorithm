import math
def firstBadVersion(n):
    """
    :type n: int
    :rtype: int
    """
    start = 0
    end = n
    mid = int(math.ceil((start + end)/2))
    lastGood = 0
    print("start: " + str(start))
    print("mid: " + str(mid))
    print("end: " + str(end))
    while start<=end:
        print("this is loop")
        v = isBadVersion(mid)
        print("this is v: " + str(v))
        if v == False: 
            start = mid+1
            lastGood = mid
            mid = end
        else:
            if lastGood+1 == mid:
                break
            end = mid-1
            mid = int(math.ceil((start + end)/2))
        print("start: " + str(start))
        print("mid: " + str(mid))
        print("end: " + str(end))
    return mid

def isBadVersion(n):
    if bad <= n:
        return True
    return False

bad = 3
number = 3
print(firstBadVersion(number))
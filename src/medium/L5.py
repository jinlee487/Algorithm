# https://leetcode.com/problems/longest-palindromic-substring/
# longest palindrom  
# solved!
def longest_palindrom(s):
    if len(s)==1 or s == s[::-1]:
        return s

    result = ''
    def check(left, right):
        while left>=0 and right<=len(s) and s[left] == s[right-1]:
            left -= 1
            right += 1
        return s[left+1:right-1]
    for idx, word in enumerate(s):
        result = max(result, check(idx, idx+1), check(idx,idx+2), key = len)
    
    return result


string = "cbbd"
print(longest_palindrom(string))   
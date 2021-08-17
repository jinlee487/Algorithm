# https://leetcode.com/problems/reverse-integer/
# 7. Reverse Integer
# Runtime: 12 ms, faster than 97.58% of Python online submissions for Reverse Integer.
# Memory Usage: 13.5 MB, less than 36.85% of Python online submissions for Reverse Integer.
class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        answer = (( x / abs(x) ) if x != 0 else 0)*int(str(abs(x))[::-1]) 
        return answer if abs(answer) <= 2**31 else 0
        
LongestPeak

For this problem, 

we can traverse until we find a peak. Then we can find the length of the peak. Separating the task can make this problem much simpler to code.

The time complexity is O(n).

When there is no peaks, it is O(n).

When there is a peak, it will also be O(n)

If there are a bunch of peaks, it will form triangles and the expansion from the tips of the triangles will never meet another node that has been visited again. 

For space complexity, it is O(1).
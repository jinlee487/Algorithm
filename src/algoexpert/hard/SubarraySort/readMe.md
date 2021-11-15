Subarray Sort

For this problem, there is two methods. 

The first method is to simply doulbe loop to find the index that needs to be swapped. Once found, we compare if this is the smallest index or the largest index array

Because this is an inner loop, it runs on a O(n^2) time | O(1) space

The second method is to loop through the array once and find the smallest and largest value to be swapped. We then perform another loop to find the index of those values. 

O(n) time | O(1) space
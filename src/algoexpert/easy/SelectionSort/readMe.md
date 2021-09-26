SelectionSort

Selection Sort is similar to insertion sort. choose an index in the beginning and loop until the end of the array and find the smallest value index. 
We then swap the original chosen index with the final new smallest value index. We then start again on the next index and loop until the end and repeat the process. 

This method has space complexity of O(1) and time complexity of O(n^2) at worst and best since even if we have a completely sorted array as an input, we have to go traverse through the loops anyway. 
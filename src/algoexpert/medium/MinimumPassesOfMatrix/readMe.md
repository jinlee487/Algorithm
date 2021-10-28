MinimumPassesOfMatrix

For this problem, 

we traverse the nodes in a bfs fashion to find the minimum number of turn in takes to change all the negative number to positive number.

The first method finds the closest positive number's distance for each negative number and the most far distance is returned. 

O(w*h*log(w*h))) time | O(w*h) space

The second method finds all the positive numbers and changes the negative numbers to positve returns how many time it takes to finish the task

O(w*h) time | O(w*h) space

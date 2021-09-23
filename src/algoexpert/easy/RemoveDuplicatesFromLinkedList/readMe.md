For this problem we have to loop through the linkedList and remove any duplicates in the list. Because the list is already sorted, all we have to do is find the duplicates and delete one at a time. 

the time complexity is O(n) because even though we have double while loops, each loop shortens the list when finding duplicates and we do not need to go backwards while searching. We only have to look at each value once.

the space complexity is O(1) since it is constant 
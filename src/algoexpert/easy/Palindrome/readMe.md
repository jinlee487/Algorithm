Palindrome

The first method is making a reverse string. This creates a new string everysingle time we add a letter to the string. How string concatnation works is the string is looped to create a new string. therefore thishas a time complexity of O(N^2) and space complexity of O(N)

The second method is a recursive approach. we have the two indexes at the two ends of the string and compare the characters. This has a time complexity of O(n) and space complexity of O(n) because at most we are using space however long the string is. 

The last method is the iterative approach. This is done the same way as the recursive except we change the indexes in the loop. This has a time complexity of O(n) and space complexity of O(1).
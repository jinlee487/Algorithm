Suffix Trie

For this problem, we have to construct a class that resembles a suffix tree. Because building a suffix tree will be complicated, most interview will only ask a suffix tree like codes.

To construct the suffix tree, we simply go through the string and adding a map for the characters in the string and moving along the nodes. 
O(n^2) time | O(n^2) space

To search through te suffix tree, we need to go through the characters in the string and checking if it is in the suffix tree. Once we reach the end symbol, we can return true. 

O(m) time | O(1) space m for whatever string we are searching for
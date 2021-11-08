Group Anagrams

For this problem, there are couple methods of solution. The easiest method is the sort method. 

We sort the alphabets of the string so that all the strings that have the same anagrams are identical. 

This allows us to store them in maps to keep track. 

O(w*n*log(n)+n*w*log(w)) time | O(wn) space where w is the number of the words and n is the longest word
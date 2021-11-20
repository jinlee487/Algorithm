Same Bsts

For this problem,

we have to try to check if the two arrays containing bst values are equal without creatinga bst node.

The first method is by simply looking at the left and right trees of each nodes.
we keep creating a left and right array until we reach an empty array.
If we can traverse the entire array without any problem, then we know that the two arrays are equal bst.

O(n^2) time | O(n^2) space
Because we have to traverse the array every single time to look for the next left and right values, we traverse the array more than once per value. 

Because we create a left and right array for each node, we create O(n^2) space of arrays

The improved method is to simply use the indexes of the first smaller or bigger/equal values instead of saving the entire left and right array.

We have to make sure that the first smaller value is greater than or equal to the minVal = which is the value of the previous parent node in the BST. If it isnt, then the value is located in the left subtree of the previous parent node.

We have to make sure that the first bigger/equal value is smaller than the maxVal which is the value of the previous parent node in the BST. if it isnt, it should be in the right subtree in the previous parent node.

O(n^2) time | O(d) space where d is the depth of the BST.


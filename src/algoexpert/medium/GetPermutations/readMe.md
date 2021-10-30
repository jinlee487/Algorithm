GetPermutations

The first method creates a temp array and adds values from the original array to create a permutation. It adds to answer list when complete and then the recursive functions returns and array is reversed to its previous recursive function. This allows us to visit every node.

upper bound: O(n^2n!) time | O(n*n!) space
O(n*n!) time | O(n*n!) space

The improved second method uses the indices and swaps the values in the array. 

O(n*n!) time | O(n*n!) space

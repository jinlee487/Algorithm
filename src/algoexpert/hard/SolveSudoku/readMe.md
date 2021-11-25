Solve Sudoku

For this problem, you need to think about back tracking. 

If you try and brute for this, it will end up with 9^81 possibilities. Therefore, we must use backtracking to minimize our possibilites. 

We can simply recursive call and check if the number works. If not, we can backtrack to our previous guess and so on until we arrive at our final guess

Even though it seems like we are doing many iterations within iterations, the complexity for this solution is 

O(1) time | O(1) space 

This is because we are given that the board is going to 9x9 size. Since we know the exact number of max iterations, this becomes a constant time operation.

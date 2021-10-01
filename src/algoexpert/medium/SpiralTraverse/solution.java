package algoexpert.medium.SpiralTraverse;

import java.util.*;

class Program2 {
    public static List<Integer> spiralTraverse(int[][] array) {
    // Write your code here.
    // O(n) time | O(n) space 
    // iterative
    ArrayList<Integer> answer = new ArrayList<Integer>();
    if (array.length == 0) {
        return answer;
    }
    var startRow = 0;
    var endRow = array.length - 1;
    var startCol = 0;
    var endCol = array[0].length - 1;
    while(startRow <= endRow && startCol <= endCol) {
        for(int col = startCol; col <= endCol; col++){
            answer.add(array[startRow][col]);
        }
        
        for(int row = startRow + 1; row <=endRow; row++){
            answer.add(array[row][endCol]);
        }
        
        for(int col = endCol -1; col>=startCol; col --){
            if(startRow == endRow) break;
            answer.add(array[endRow][col]);
        }
        
        for(int row = endRow -1; row > startRow; row --){
            if(startCol == endCol) break;
            answer.add(array[row][startCol]);
        }
        startRow++;
        endRow--;
        startCol++;
        endCol--;
    }
    return answer;
		
    }
}

class Program1 {
    public static List<Integer> spiralTraverse(int[][] array) {
        // Write your code here.
        // recursive
        var answer = new ArrayList<Integer>();
        if(array.length == 0) return answer;
        spiralTraverse(array, 0, array.length-1,0,array[0].length-1,answer);
        return answer;
    }
    public static void spiralTraverse(
        int[][] array, int startRow, int endRow, int startCol, int endCol, ArrayList<Integer> answer){
        if(startRow>endRow||startCol>endCol) return;
        for(int col = startCol; col <= endCol; col ++){
            answer.add(array[startRow][col]);
        }
        for(int row = startRow + 1; row <= endRow; row++){
            answer.add(array[row][endCol]);
        }
        for(int col = endCol -1; col >= startCol; col --){
            if(startRow == endRow) break;
            answer.add(array[endRow][col]);
        }
        for(int row = endRow -1; row >= startRow + 1; row--){
            if(startCol == endCol) break;
            answer.add(array[row][startCol]);
        }
        spiralTraverse(array, startRow + 1, endRow - 1, startCol + 1, endCol -1, answer);
    }
}

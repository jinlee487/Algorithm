package winter_internship;

import java.util.Stack;

/*
 * SOLVED!!
 * https://programmers.co.kr/learn/courses/30/lessons/64061
 * 크레인 인형뽑기 게임

*/
public class Crane2 {
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		System.out.println(solution(board,moves));
	}
    public static int solution(int[][] board, int[] moves) {
        int ans=0;
        int m=0;
        Stack<Integer> s = new Stack<Integer>();
        next:
        for(int i=0;i<moves.length;i++){
            m = moves[i]-1;
            //this is the current move
            for(int j=0;j<board.length;j++){
                if(board[j][m]!=0){
                    //found the first doll in the column
                    if(!s.isEmpty()&&s.peek()==board[j][m]){
                        //check if the doll is the same as the first in the stack
                        s.pop();
                        //since it is the same, we can eliminate the dolls
                        ans+=2;
                    }
                    else{
                        s.push(board[j][m]);
                        //doll is not the same so we simply push it to the first of the stacks
                    }
                    board[j][m]=0;
                    // we change the column to 0 since we took the doll out
                    continue next;
                    // since we finished the move, we continue to the next move
                    // withought going through the rest of the loop
                }
            }
        }
        return ans;

    }
}

package winter_internship;

import java.util.Stack;

public class Crane {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		System.out.println(solution(board,moves));
	}
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
//        for(int[] i:board)
//        	System.out.println(Arrays.toString(i));
//        System.out.println("");
        Stack<Integer> stack = new Stack<Integer>();
//        System.out.println(Arrays.toString(moves));
        next:
    	for (int i=0;i<moves.length;i++) {
//    		System.out.println("next moves new loop!");
    		int m = moves[i]-1;
//    		System.out.println("this is m => " + m);
    		for (int j=0;j<board.length;j++) {
//    			System.out.println("versing through the rows j => "+ j);
//    			System.out.println("found this value => " + board[j][m]);
    			if (board[j][m]!=0) {
    				int moving = board[j][m];
    				board[j][m] = 0;
//    				System.out.println("found a match! moving => " + moving);
    				if(!stack.isEmpty()&&stack.peek()==moving) {
    					answer +=2;
    					stack.pop();
//    					System.out.println("popped this => " + stack.pop());
    				}
    				else{
//    					System.out.println("added => " + moving);
    					stack.add(moving);
    				}
//    				System.out.println(" ** printing current board **");
//    		        for(int[] b:board)
//    		        	System.out.println(Arrays.toString(b));
    				continue next;	
    			}
    		}
    	}
        return answer;
    }
}

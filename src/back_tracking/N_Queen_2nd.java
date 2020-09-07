package back_tracking;
/*Solved!
 * 여러가지 컷팅 알고리즘이 있습니다.

1. 퀸을 N개 놔야 한다는 조건 때문에, 모든 행과 모든 열에는 퀸이 하나씩 있어야 합니다.

이 때문에, 행을 기준으로 한 DFS도 성립합니다. 

첫 번째 행에 하나를 놓아보고, 두 번재 행에 하나를 놓아보고, ... 하는 식으루요.

2. 퀸을 놓을 수 있는지 없는지를 확인할 때는, 각 행, 열 대각선에 퀸이 있는지를 체크하는 식으로 확인 가능합니다.

예를 들어, 세 번째 대각선에 퀸을 놓았다면, 세 번째 대각선에 퀸이 있다고 체크하는 식입니다.

이러면 다음에 퀸을 놓을 때 배열을 확인해서, 세 번째 대각선에 퀸이 없다는 것을 알 수 있겠죠. 
 */
import java.util.Scanner;

public class N_Queen_2nd {
	static int N=0;
	static int board[]; 
    static int total=0;

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
	    N = sc.nextInt();
	    sc.close();
	    board = new int[15];
	    //initialize
    	for(int i=1;i<N+1;i++) {
    		board[i]=1;
			dfs(2);
			board[i]=0;
	    	}
		System.out.println(total);
    }
    static void printboard() {
    	for(int i=1;i<N+1;i++) {
    		System.out.printf("%d ",board[i]); 
    	}
    	System.out.println("");
    }
    
	static void dfs(int cnt) {
    	if(cnt==N+1) {
//    		System.out.println("*** answer ***");
//    		printboard();
//    		System.out.println("**************");
    		total+=1;
    		return;
    	}
    	//row == previous q placement
    	for (int i=1;i<N+1;i++) {
    		if(checking(i,cnt)==false) {
//    			System.out.println("false everytime? i=> "+i);
//    			printboard();
    			continue;
    		}
    		board[i]=cnt;
//    		System.out.println("what");
//    		printboard();
    		dfs(cnt+1);
	    	board[i] = 0;
	    }
    		
    	
	}
	static boolean checking(int i,int cnt) {
		
		if (board[i]!=0){
			return false;
		}
		for (int j=1;j<N+1;j++) {
			if (board[j]!=0) {
				int up = j+(cnt-board[j]);
				int down = j-(cnt-board[j]);
				if (i==up||i==down)
					return false;
			}
		}
		return true;
    }
}
package kakao_Blind_2018;
import java.util.*;
/* 
Solved! 
https://programmers.co.kr/learn/courses/30/lessons/17679
프렌즈4블록
for this problem, we have to use either backtracking to find 
all the adjuacent blocks. 
afterwards we fill in the empty slots 
we repeat until the the backtracking cannot find anymore matches
*/
class Friends{
    int x;
    int y;
    char c;
    Friends(int x,int y, char c){
        this.x = x; this.y = y; this.c = c;
    }
    @Override
    public String toString(){
        return "x: " + this.x + " y: " + this.y + " c: " + this.c;
    }
}
public class P17679 {
    static char[][] arr;
    static boolean[][] visit;
    static int M,N,score=0;
    static char sc;
    static Queue<Friends> que = new LinkedList<Friends>();
    public static void main(String[] args) throws Exception {
        int m = 2;
        int n = 2;
        String[] board = {"CC", "CC"};
        System.out.println(solution(m,n,board));
    }
    public static int solution(int m, int n, String[] board) {
        arr = new char[m][n];
        M = m;
        N = n;
        for(int i=0;i<board.length;i++){
            arr[i] = board[i].toCharArray();
        }
        // System.out.println("initial this is arr => ");
        // for(char[] c : arr){
        //     System.out.println(Arrays.toString(c));
        // }
        // System.out.println("\n\n\n");
        for(int i=0;;i++){
            // System.out.println("\nnew loop i => " + i+ "\n");
            if(findBlocks()==0){
                break;
            }
            addScore();
            moveBlocks();
        }
        int answer = score;
        return answer;
    }
    public static int findBlocks(){
        int count = 0;
        for(int i=0;i<M-1;i++){
            for(int j=0;j<N-1;j++){
                if(check(i,j)){
                    count ++;
                    addQueue(i,j);
                }
            }
        }
        // System.out.println("this is the count that are found => " + count );
        return count;
    }
    public static boolean check(int x, int y){
        if(arr[x][y] == ' '){
            return false;
        }
        int[] arrx = {1,0,1};
        int[] arry = {0,1,1};
        int nx,ny;
        for(int i=0;i<3;i++){
            nx = x + arrx[i];
            ny = y + arry[i];
            if(arr[nx][ny]!=arr[x][y]){
                return false;
            }
        }
        return true;
    }
    public static void addQueue(int x, int y){
        que.add(new Friends(x,y,arr[x][y]));
        int[] arrx = {1,0,1};
        int[] arry = {0,1,1};
        int nx,ny;
        for(int i=0;i<3;i++){
            nx = x + arrx[i];
            ny = y + arry[i];
            que.add(new Friends(nx,ny,arr[nx][ny]));
        }
    }
    public static void addScore(){
        // System.out.println("before add score arr => ");
        // for(char[] c : arr){
        //     System.out.println(Arrays.toString(c));
        // }
        // System.out.println("this is queue => " + que+ "\n");

        Friends f;
        for(int i=0;!que.isEmpty();i++){
            f = que.poll();
            if(arr[f.x][f.y]!=' '){
                arr[f.x][f.y] = ' ';
                score ++;
            }
        }
        // System.out.println("after add score arr => ");
        // for(char[] c : arr){
        //     System.out.println( Arrays.toString(c));
        // }
        // System.out.println("this is score => " +score+ "\n");
    }
    public static void moveBlocks(){
        // System.out.println("before move blocks arr => ");
        // for(char[] c : arr){
        //     System.out.println(Arrays.toString(c));
        // }
        Stack<Friends> stack = new Stack<Friends>();
        Friends f;
        for(int j=0;j<N;j++){
            for(int i=0;i<M;i++){
                stack.add(new Friends(i,j,arr[i][j]));
            }
            for(int i=M-1;0<=i;i--){
                if(stack.isEmpty()){
                    arr[i][j] = ' ';
                    continue;
                }
                f = stack.pop();
                // System.out.println("this is f => " + f);
                while(!stack.isEmpty()&&f.c==' '){  
                    // System.out.println("f.c is empty so we while loop");
                    f = stack.pop();
                    // System.out.println("this is f => " + f);
                }
                arr[i][j] = f.c;
            }
        }
        // System.out.println("after move blocks arr => ");
        // for(char[] c : arr){
        //     System.out.println( Arrays.toString(c));
        // }
    }

}

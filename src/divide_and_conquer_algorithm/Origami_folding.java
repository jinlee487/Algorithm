package divide_and_conquer_algorithm;
/*
 * Solved!!
 * https://www.acmicpc.net/problem/2630
 * 색종이 접기
 */
import java.io.*;
import java.util.StringTokenizer;

public class Origami_folding {
    private static boolean[][] board;
    private static int white;
    private static int blue;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        board = new boolean[n][n];
        for(int i = 0; i < n; i++) {
    		st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++) {
                board[i][j] = st.nextToken().equals("1");
            }
        }
 
        setup(0, 0, n);
        bw.write(Integer.toString(white)+"\n"+Integer.toString(blue));
        bw.flush();
    }
 
    private static void setup(int x, int y, int n) {
//        System.out.println("x => "+x);
//        System.out.println("y => "+ y);
//        System.out.println("n => "+n);
        if(n == 1) {
            if(board[y][x]) {
                blue++;
            } else {
                white++;
            }
            return;
        }
        int newN = n/2;
        divide(x, y, newN);
        divide(x+newN, y, newN);
        divide(x, y+newN, newN);
        divide(x+newN, y+newN, newN);
    }
    public static void divide(int x, int y, int n) {
//        System.out.println("");
//        System.out.println("x => "+x);
//        System.out.println("y => "+ y);
//        System.out.println("n => "+n);
        if(n == 1) {
            if(board[y][x]) {
                blue++;
            } else {
                white++;
            }
            return;
        }
        boolean sameColor = true;
        boolean color = board[y][x];
        out: 
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[y+i][x+j] != color) {
                    sameColor = false;
                    break out;
                }
            }
        }
        if(sameColor) {
            if(board[y][x]) {
                blue++;
//                System.out.println("blue => "+ blue);
//            	System.out.printf("[%d][%d] => %b\n",y,x,board[y][x]);

            } else {
                white++;
//                System.out.println("white => "+ white);
//            	System.out.printf("[%d][%d] => %b\n",y,x,board[y][x]);
            }
            return;
        }
        int newN = n/2;
        divide(x, y, newN);
        divide(x+newN, y, newN);
        divide(x, y+newN, newN);
        divide(x+newN, y+newN, newN);
    }
}

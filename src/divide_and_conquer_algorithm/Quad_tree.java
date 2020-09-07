package divide_and_conquer_algorithm;
/*
 * Solved!
 * https://www.acmicpc.net/problem/1992
 * 쿼드트리
 */
import java.io.*;

public class Quad_tree {
    private static int[][] board;
    private static StringBuilder sb = new StringBuilder("");
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
 
        board = new int[n][n];
        for(int i = 0; i < n; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < line.length; j++) {
                board[i][j] = line[j] - '0';
            }
        }
        quadtree(0, 0, n);
 
        System.out.println(sb.toString());
    }
     
    private static void quadtree(int y, int x, int n) {
    	if(n == 1) {
            sb.append(board[y][x]);
            return;
        }
 
        boolean isSame = true;
        int color = board[y][x];
        out: for(int i = y; i < y+n; i++) {
            for(int j = x; j < x+n; j++) {
                if(board[i][j] != color) {
                    isSame = false;
                    break out;
                }
            }
        }
        if(isSame) {
            sb.append(board[y][x]);
            return;
        }
 
        int half = n >> 1;
        sb.append("(");
        quadtree(y, x, half);
        quadtree(y, x + half, half);
        quadtree(y + half, x, half);
        quadtree(y + half, x + half, half);
        sb.append(")");
    }
}

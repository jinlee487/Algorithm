package greedy_algorythm;

import java.io.*;

/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/3109
 * 
 *  빵집
 * 
 * 
*/
public class Bakery { 
    static char[][] path;
    static int R,C,ans;

    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] temp = br.readLine().split(" ");
        R = Integer.parseInt(temp[0]);
        C = Integer.parseInt(temp[1]);
        path = new char[R][C];

        for(int i=0;i<R;i++){
            path[i] = br.readLine().toCharArray(); 
        }
        // System.out.println("\n this is input => ");
        // for(int i=0;i<path.length;i++){
        //     System.out.println(Arrays.toString(path[i]));
        // }

        //to record the coordinates of each path.
        //when the pipes reach the destination, we can move the completed path to the clist
        for(int i=0;i<R;i++){
            path[0][0]='x';
            dfs(i,0);
            path[0][0]='.';
        }
        // System.out.println("this is the final path => ");
        // for(int i=0;i<path.length;i++){
        //     System.out.println(Arrays.toString(path[i]));
        // }
        bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
    }
    public static Boolean dfs(int x, int y){
        // System.out.println("this is dfs loop x=" + x + " y=" + y);
        // System.out.println("current p => " + Arrays.toString(p));
        if(y==C-1){
            // System.out.println("found a path! ending current loop ... ");
            ans++;
            return true;
        }
        if(0<=x-1&&path[x-1][y+1]!='x'){
            //upper horizontal
            // System.out.println("next loop x-1 and y+1");
            path[x-1][y+1]='x';
            if(dfs(x-1,y+1)) return true;
            // path[x-1][y+1]=".";
        }
        if(path[x][y+1]!='x'){
            //straight
            // System.out.println("next loop x and y+1");
            path[x][y+1]='x';
            if(dfs(x,y+1)) return true;
            // path[x][y+1]=".";
        }        
        if(x+1<R&&path[x+1][y+1]!='x'){
            //downward horizontal
            // System.out.println("next loop x+1 and y+1");
            path[x+1][y+1]='x';
            if(dfs(x+1,y+1)) return true;
            // path[x+1][y+1]=".";
        }
        return false;
    }
	
}


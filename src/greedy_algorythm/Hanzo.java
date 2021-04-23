package greedy_algorythm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/14659
 * 한조서열정리하고옴ㅋㅋ
*/
public class Hanzo {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
        int count=0,currentHeight=0;;
        int maxCount=0;
        int maxHeight=0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            currentHeight=Integer.parseInt(st.nextToken());


            if(maxHeight<currentHeight){
                maxHeight = currentHeight;
                if(maxCount<count){
                    maxCount=count;
                }
                count=0;
            } else {
                count++;
                // System.out.println("\nthis is currentheight=> " + currentHeight);
                // System.out.println("this is count=> " + count);
                // System.out.println("this is maxHeight=> " + maxHeight);
                // System.out.println("this is maxCount=> " + maxCount);
            }
            if(i==N-1){
                if(maxCount<count){
                    maxCount=count;
                }
            }
        }

		bw.write(Integer.toString(maxCount));
		bw.flush();
		bw.close();
		br.close();
	}

}
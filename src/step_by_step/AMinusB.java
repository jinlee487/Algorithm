package step_by_step;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/1001
 * A-B
*/
public class AMinusB {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        System.out.println(Integer.parseInt(arr[0])-Integer.parseInt(arr[1]));
    }
}
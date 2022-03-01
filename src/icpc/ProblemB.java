package icpc;
import java.io.*;
import java.util.*;

class ProblemB {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] arr = br.readLine().split(" ");
        double area = Integer.parseInt(arr[0]) * Integer.parseInt(arr[1]) / 2.0;
        bw.write(Double.toString(area));
        bw.flush();
        bw.close();
        br.close();
        return; 
    }
}
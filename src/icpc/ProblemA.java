package icpc;
import java.io.*;

class ProblemA {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] arr = br.readLine().split(" ");
        bw.write(Integer.toString(Integer.parseInt(arr[0]) + Integer.parseInt(arr[1])));
        bw.flush();
        bw.close();
        br.close();
        return; 
    }
}
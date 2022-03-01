package icpc;
import java.io.*;
import java.util.*;

class ProblemC {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        double[] xarr = new double[N];
        double[] yarr = new double[N];
        for(int i=0;i<N;i++){
            String[] arr = br.readLine().split(" ");
            xarr[i] = Double.parseDouble(arr[0]);
            yarr[i] = Double.parseDouble(arr[1]);
        }
        double[] array = new double[N];
        for(int i=1;i<N-1;i++){
            array[i] = getDistance(xarr[i], yarr[i], xarr[i+1], yarr[i+1]);
        }
        System.out.println(Arrays.toString(xarr));
        System.out.println(Arrays.toString(yarr));

        bw.write("");
        bw.flush();
        bw.close();
        br.close();
        return; 
    }
    public static double getDistance(double x1, double y1, double x2, double y2){
        double xdistance = Math.abs(x1-x2);
        double ydistance = Math.abs(y1-y2);
        return Math.sqrt(xdistance * xdistance + ydistance * ydistance);
    }
}
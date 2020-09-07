package divide_and_conquer_algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Multiply_divide_and_conquer {
	static long x,y,z;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine()," ");
    	x = Integer.parseInt(st.nextToken());
    	y = Integer.parseInt(st.nextToken());
    	z = Integer.parseInt(st.nextToken());
    	System.out.println(multiply(x%z,y));
	}
	public static long multiply(long c, long n) {
		if (n==0) {
			return 1;
		}
		long output=multiply(c,n/2)%z;
		if(n%2==0) {
			return (output*output)%z;
		}
		else {
			return ((output*output)%z*c)%z;
		}
	}
}

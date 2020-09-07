package math3;
/*
 * 
 * 정렬한 배열의 인접한 수 사이의 최대공약수를 구하는 방식으로 접근했다. 
 * 최대공약수 구하는 방법은 유클리드 호제 알고리즘을 사용하였고, 
 * 약수 구하는 부분은 그냥 i부터 최대공약수까지 반복문을 돌렸다. 
 * 하지만 약수 구하는 부분도 효율적이게 짜려면 반복문 조건을 i*i <= 최대공약수로 하고,
 *  i값과 최대공약수/i로 하여 리스트에 넣고 정렬을 하면 된다.(중복값도 제거)
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class Check {
    static int N;
    static int arr[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        
        int val = arr[1]-arr[0];
        for(int i=2; i<N; i++) {
            val = getGCD(val, arr[i] - arr[i-1]);
        }
        printDivisors(val);       
    }
    
    static void printDivisors(int n) 
    { 
    	StringBuffer sb = new StringBuffer();
        // Note that this loop runs till square root 
        for (int i=2;i<=n; i++) 
        { 
        	if (n%i==0) { 
        		sb.append(i+" "); 
            } 
        }
        System.out.println(sb.toString());
    } 
    public static int getGCD(int a, int b) {
        if(a%b == 0) {
            return b;
        }
        
        return getGCD(b, a%b);
    }
}
 


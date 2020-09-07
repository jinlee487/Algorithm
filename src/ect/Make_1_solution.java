package ect;
import java.io.*; 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.lang.Math;


public class Make_1_solution{
//    public static void main(String[] args) throws IOException {
//       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//       int number = Integer.parseInt(br.readLine());
//       int dp[] = new int[number+1];
//       dp[0] = 0;
//       dp[1] = 0;
//       for (int i = 2; i <= number; i++){
//           dp[i] = dp[i-1] + 1;
//           if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
//           if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
//       }
//       System.out.println(dp[number]);
//       br.close();
//       
//    }
//
//        
//// bottom up method
//	public static int d[];
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int number = Integer.parseInt(br.readLine());
//        d = new int[number+1];
//        System.out.println(calculate(number));
//    }
//
//    public static int calculate(int number){
//        if (number == 1){
//            return 0;
//        }
//        if (d[number] > 0){
//            return d[number];
//        }
//        d[number] = calculate(number-1) + 1;
//        // get all the times it takes to get a number down to 1 only by subtracting 1
//        // then saves it to the array. 
//        // afterwards, compare the result with either dividing 3 or 2.
//        if (number%3 == 0) {
//            d[number] = Math.min(d[number],calculate(number/3) +1);
//            // +1 is the count for each time their is calc step. 
//            // this goes in a dp and adds up all the steps to give the total minimum steps
//        }
//        if (number%2 == 0) {
//            d[number] = Math.min(d[number],calculate(number/2) +1);
//        }
//        return d[number];
//        // will return the eventual d[10] 
//    }
//}


	// Java program to minimize n to 1  
	// by given rule in minimum steps 

	  
	// function to calculate min steps 
	static int getMinSteps(int n, int memo[]) 
	{ 
	    // base case 
	    if (n == 1) 
	    return 0; 
	    if (memo[n] != -1) 
	    return memo[n]; 
	  
	    // store temp value for 
	    // n as min( f(n-1), 
	    // f(n/2), f(n/3)) +1 
	    int res = getMinSteps(n - 1, memo); 
	  
	    if (n % 2 == 0) 
	        res = Math.min(res,  
	              getMinSteps(n / 2, memo)); 
	    if (n % 3 == 0) 
	        res = Math.min(res,  
	               getMinSteps(n / 3, memo)); 
	  
	    // store memo[n] and return 
	    memo[n] = 1 + res; 
	    return memo[n]; 
	} 
	  
	// This function mainly 
	// initializes memo[] and 
	// calls getMinSteps(n, memo) 
	static int getMinSteps(int n) 
	{ 
	    int memo[] = new int[n + 1]; 
	  
	    // initialize memoized array 
	    for (int i = 0; i <= n; i++) 
	        memo[i] = -1; 
	  
	    return getMinSteps(n, memo); 
	} 
	  
	    // Driver Code 
	    public static void main (String[] args)  
	    { 
	        int n = 100000; 
	        System.out.println(getMinSteps(n)); 
	    } 
	} 
	  
	// This code is contributed by anuj_67. 


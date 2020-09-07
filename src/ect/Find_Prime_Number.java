package ect;

public class Find_Prime_Number {
	public static void main(String[] args) {
		System.out.println(find(11));
	}
	public static boolean find(int n) {
		// TODO Auto-generated method stub
        // Corner case 
        if (n <= 1) 
            return false; 
        // Check from 2 to n-1 
        for (int i = 2; i < n; i++) 
            if (n % i == 0) 
                return false; 
        return true; 
	}
	
}

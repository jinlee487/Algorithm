package forloop;

import java.util.Scanner;

//https://www.acmicpc.net/problem/2439
//별 찍기 - 2
//Solved!
public class print_star_2 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int input = sc.nextInt();
        sc.close();
        for(int i=0;i<input;i++){
            for(int j=0;j<input;j++){
                if(j+i>=(input-1)) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.print("\n");
        }
	}
}

package step_by_step;
/*
 * https://www.acmicpc.net/problem/1000
 */
import java.util.Scanner;
public class add{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] list = new int[2];
        String input=sc.nextLine();
        String[] numbers = input.split(" ");
        for (int i=0;i<2;i++){
            list[i]=Integer.parseInt(numbers[i]);
        }
        System.out.println(list[0]+list[1]);
    }
}

package greedy_algorythm;
import java.util.*;
import java.io.*;
/*
 * SOLVED!!
 * https://www.acmicpc.net/problem/1041
 * 주사위
*/
public class Dice {
    //this question is asking to minimize the sum of the numbers of the n*n*n sized cube
    // the dice in the corners of the cube will have 3 sides of the smallest number. the edges of the cube will have 2 of the smallest number. the other dice simply have one smallest number
    // three sides of the die will be one group and the other will be identicall. 
    //therefore we need to calculate the number of dice required for three sides of the cube and calculate the sum
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long N = Long.parseLong(br.readLine());
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " "); 
        Long[] arr = new Long[6];
        for(int i=0;i<6;i++){
            arr[i] = Long.parseLong(st.nextToken());
        }    
        Arrays.sort(arr);
        // System.out.println("this is sorted arr => " + Arrays.toString(arr));
        Long smallest= Long.valueOf(arr[0]);
        Long second= Long.valueOf(arr[1]);
        Long third = Long.valueOf(arr[2]);
        Long sum = 0L;
        if(N==1){
            System.out.println(arr[0]+arr[1]+arr[2]+arr[3]+arr[4]);
            System.exit(0);
        }
        // size corners 
        sum += (smallest+second)*8 ;
        sum += third*4;
        // 12 edges
        sum += (N-2)*12*(smallest);
        sum += (N-2)*8*(second);
        // single sides
        sum += (N-2)*(N-2)*5*smallest;
        System.out.println(sum);
		
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

// long n = Integer.parseInt(br.readLine());
// int arr[] = new int[6];
// long ans = 0;
// StringTokenizer st = new StringTokenizer(br.readLine(), " ");
// for(int i=0; i<6; i++) {
//     arr[i] = Integer.parseInt(st.nextToken());
// }
// long first = Math.min(arr[0], arr[5]);
// long second = Math.min(arr[1], arr[4]);
// long third = Math.min(arr[2], arr[3]);

// //first,second,third를 정렬하기 위함
// long sortArr[] = new long[3];
// sortArr[0] = first;
// sortArr[1] = second;
// sortArr[2] = third;
// Arrays.sort(sortArr);
// first = sortArr[0];
// second = sortArr[1];
// third = sortArr[2];

// int sum = 0;
// int max = 0;
// if(n == 1) {
//     for(int i=0; i<6; i++) {
//         sum += arr[i];
//     }
//     for(int i=0; i<6; i++) {
//         max = Math.max(max, arr[i]);
//     }
//     ans = sum - max;
// }
// else {
//     ans += (4 * (n - 1) * (n - 2) + (n - 2) * (n - 2)) * first;
//     ans += (((n-2) * 2 * 4) + (n-1) * 4 * 2) / 2 * first;
//     ans += 4 * first;
    
//     ans += (((n-2) * 2 * 4) + (n-1) * 4 * 2) / 2  * second;
//     ans += 4 * second;
    
//     ans += 4 * third;
// }
// bw.write(String.valueOf(ans));
// bw.flush();
// bw.close();
    }

}

package kakao_Blind_2018;

import java.util.Arrays;

/*
 * SOLVED!!
 * https://programmers.co.kr/learn/courses/30/lessons/17681
 * 비밀지도

*/
public class SecretMap {
    public static void main(String[] args) {
		// TODO Auto-generated method stub
        int n = 6;
        int[] arr1 = {46, 33, 33 ,22, 31, 50};
        int[] arr2 = {27 ,56, 19, 14, 14, 10};

		System.out.println(Arrays.toString(solution(n,arr1,arr2)));
	}
    public static  String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        //the question wants us  to add the numbers in the arrays as binary numbers
        //# == 1 && empty == 0
        String bn = "";
        for(int i=0;i<n;i++){
            // sum = arr1[i] + arr2[i];
            bn = Integer.toBinaryString(arr1[i] | arr2[i]); 
            // System.out.println("this is bn => " +  bn);
            // System.out.println("this is n => "  + n);
            // System.out.println("this is bn.lenght = >" + bn.length());
            if(n<bn.length()){
                // System.out.println("length is too long must cut short!");
                // System.out.println("bn.length = > " + bn.length());
                bn=bn.substring(bn.length()-n, bn.length()-1);
            }
            if(bn.length()<n){
                String[] temp = new String[n-bn.length()];
                Arrays.fill(temp, "0");
                bn = String.join("",temp) + bn;
            }
            bn = bn.replaceAll("[1]", "\\#");
            bn = bn.replaceAll("[0]", " ");
            answer[i] = bn; 
        }
        return answer;
    }
}

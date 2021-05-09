package kakao_Internship_2021;

public class problem1 {
   public static void main(String[] args) {
        String s = "one4seveneight";
       
        System.out.println(solution(s));
    }
    public static int solution(String s) {
        s = s.toLowerCase();
        String[] arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i=0;i<arr.length;i++) {
            s = s.replaceAll(arr[i], String.valueOf(i));
        }
        int answer = Integer.parseInt(s);
        return answer;
    }
    
}

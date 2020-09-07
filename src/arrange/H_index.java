package arrange;

import java.util.Arrays;

public class H_index {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] citations = {10, 8, 5, 3,  3 };
		System.out.println(solution(citations));

	}

    public static int solution(int[] citations) {
        int answer = 0;
        int length = citations.length;
        int h = 0;
        int k = 0;
        Arrays.sort(citations);
    	System.out.println(Arrays.toString(citations));

        for (int i = 0; i < citations.length+1; i++) {
            h = citations[i];
            System.out.println("h => " + h);
            k =  citations.length - i;
            System.out.println("k => " + k);

            if (k <= h) {
                answer = k;
                break;
            }
        }
        return answer;
    }
}

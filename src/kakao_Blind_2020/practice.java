package kakao_Blind_2020;

import java.util.HashMap;

public class practice {
	public static void main(String[] args) {
//		int[][] input = {{1, 4}, {3, 4}, {3, 10}};
		int[][] input = {{1, 1}, {2, 2}, {1, 2}};

		System.out.println(solution(input));
	}
	
    public static int[] solution(int[][] v) {
    	
        
        int x = 0,y = 0;
		HashMap<Integer, Integer> hashx = new HashMap<>(); 
		HashMap<Integer, Integer> hashy = new HashMap<>(); 
        for(int i=0;i<v.length;i++) {
        	
        	if(hashx.containsKey(v[i][0])) hashx.put(v[i][0],hashx.get(v[i][0])+1);
        	else hashx.put(v[i][0],1);
        	if(hashy.containsKey(v[i][1])) hashy.put(v[i][1],hashy.get(v[i][1])+1);
        	else hashy.put(v[i][1],1);

        }
        for(int i=0;i<v.length;i++) {
        	if(hashx.get(v[i][0])==1) {
        		x=v[i][0];
        	}
        }
        for(int i=0;i<v.length;i++) {
        	if(hashy.get(v[i][1])==1) {
        		y=v[i][1];
        	}
        }
        int[] answer = {x,y};
//        System.out.println(Arrays.toString(answer));
        return answer;
    }	
}

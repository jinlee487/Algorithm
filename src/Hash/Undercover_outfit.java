package Hash;

import java.util.HashMap;
/*
 * 각 종류 + 1) 의 곱 - 1
 */
public class Undercover_outfit {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] clothes = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, 
								{"smoky_makeup", "face"},{"yellow_hat", "headgear"},
								{"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		System.out.println(solution(clothes));
	}
    public static int solution(String[][] clothes) {
        int answer = 1;
		HashMap<String, Integer> hash = new HashMap<>(); 
        for(String[] c:clothes) {
			if(hash.get(c[1]) == null) {
				hash.put(c[1], 1);
			}
			else {
				hash.put(c[1], hash.get(c[1])+1);
			}
        }
        for(String key:hash.keySet()){
        	answer *= (hash.get(key)+1);
        }
        return answer-1;
    }
}

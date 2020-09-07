package winter_internship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Tuple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		System.out.println(Arrays.toString(solution(s)));
	}
    public static int[] solution(String s) {
		HashMap<String, Integer> hash = new HashMap<>(); 
		String[] num = s.replaceAll( "[^\\d,]", "" ).split(",");
//		System.out.println(Arrays.toString(num));
		for (int i=0;i<num.length;i++) {
			if(hash.get(num[i]) == null) {
				hash.put(num[i],1);
			}
			else {
				hash.put(num[i], hash.get(num[i])+1);
			}
		}
        List<String> sorted = new ArrayList<>(hash.keySet());

        Collections.sort(sorted, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return hash.get(o2).compareTo(hash.get(o1));
            }
        });
//        System.out.println(sorted);
        int[] answer = new int[sorted.size()];
        int cnt=0;
        for(String t:sorted) {
        	answer[cnt++]=Integer.parseInt(t);
        }
        
        return answer;
    }
}

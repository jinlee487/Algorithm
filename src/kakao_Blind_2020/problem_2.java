package kakao_Blind_2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class problem_2 {
    private static String[] l;
    private static int N;
    private static int R;
	public static void main(String[] args) {

//		String[] input = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
//		int[] course = {2,3,4};

//		String[] input = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
//		int[] course = {2,3,5};
		
		String[] input = {"XYZ", "XWY", "WXA"};
		int[] course = {2,3,5};

		System.out.println(Arrays.toString(solution(input,course)));
	}
	
	
    public static List<String[]> generate(int n, int r) {
        List<String[]> combinations = new ArrayList<>();
        dfs(combinations, new String[r], 0, n-1, 0);
        return combinations;
    }
    
    private static void dfs(List<String[]> combinations, String data[], int start, int end, int index) {
        if (index == R) {
        	String[] combination = data.clone();
            combinations.add(combination);
        } else if (start <= end) {
            data[index] = l[start];
            dfs(combinations, data, start + 1, end, index + 1);
            dfs(combinations, data, start + 1, end, index);
        }
    }
    
    public static String[] solution(String[] orders, int[] course) {
    	String[] temp;
		HashMap<String, Integer> orderCount = new HashMap<>(); 
		ArrayList<HashMap> orderlist = new ArrayList<HashMap>();			

    	for(int i=0;i<orders.length;i++) {
			HashMap<String, Integer> hashtemp = new HashMap<>(); 
			orderlist.add(hashtemp);

    		for (int j=0;j<course.length;j++) {
    			if(orders[i].length()<course[j]) continue;
    			l=orders[i].split("");
    			N=l.length;
    			R=course[j];
    			List<String[]> combinations = generate(N, R);
    	        for (String[] combination : combinations) {
    	            System.out.println(Arrays.toString(combination));
    	            String str = String.join("", combination);
    	            System.out.println("this is str => " + str);
    	            if(!orderCount.containsKey(str)) {
    	            	orderCount.put(str,1);
    	            }
    	            else {
    	            	orderCount.put(str,orderCount.get(str)+1);
    	            }
    	        }    	
    	        
    	        System.out.printf("generated %d combinations of %d items from %d ", combinations.size(), R, N);

    		}
    		System.out.println("to the next order! \n\n\n");
    	}
		System.out.println("this is the full order count after the loop=> \n" + orderCount.toString()+"\n");
    	
		ArrayList<String> orderCourse = new ArrayList<String>();	
		System.out.println("this is coures => " + Arrays.toString(course));
		HashMap<Integer, HashMap<String, Integer>> countlist = new HashMap<>(); 
		for(int i=0;i<course.length;i++) {
			countlist.put(course[i],new HashMap<String, Integer>());
		}
		System.out.println("this is key set => " + orderCount.keySet());
		Set<String> keys = orderCount.keySet();

		for (String key : keys) {
			HashMap<String, Integer> templist = countlist.get(key.length()); 
			templist.put(key,orderCount.get(key));
			countlist.put(key.length(),templist); 
		}
        List<String> sort = new ArrayList<>(orderCount.keySet());
        
        Collections.sort(sort, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
            	if(o1.length()==o2.length()) {
            		return orderCount.get(o2).compareTo(orderCount.get(o1));
            	}
            	else {
            		return Integer.compare(o2.length(),o1.length());
            	}
            }
        });
        int max=0;
        int wlength=0;
        int templength=0;
        List<String> sorted = new ArrayList<>();
		for(int i=0;i<sort.size();i++) {
			if(i==0) {
				max = orderCount.get(sort.get(i));
				wlength=sort.get(i).length();
			}
			if(orderCount.get(sort.get(i))==1) {
				continue;
			};
			if(wlength!=sort.get(i).length()) {
				max = orderCount.get(sort.get(i));
				wlength=sort.get(i).length();
			}
			if(orderCount.get(sort.get(i))<=max){
				continue;
			}
			else {
				sorted.add(sort.get(i));
			}

		}
		String[] answer = new String[sorted.size()];
		for(int i=0;i<sorted.size();i++) {
			answer[i]=sorted.get(i);
		}

		return answer;
    }
}

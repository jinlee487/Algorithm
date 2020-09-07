package Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class BestAlbum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 2500, 150, 800, 2500};
		System.out.println(Arrays.toString(solution(genres, plays)));
	}
    public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
		HashMap<String, Integer> hashgenre = new HashMap<>(); 
		HashMap<String, HashMap<Integer,Integer>> hashplays = new HashMap<>(); 
		for (int i=0;i<genres.length;i++) {
			if(hashgenre.get(genres[i]) == null) {
				hashgenre.put(genres[i], plays[i]);
			}
			else {
				hashgenre.put(genres[i], hashgenre.get(genres[i])+plays[i]);
			}
			if(hashplays.get(genres[i]) == null) {
				HashMap<Integer,Integer> temp = new HashMap<Integer,Integer>();
				temp.put(i,plays[i]);
				hashplays.put(genres[i], temp);
			}
			else {
				HashMap<Integer, Integer> temp = hashplays.get(genres[i]);
				temp.put(i,plays[i]);
				hashplays.put(genres[i], temp);
			} 
		}
        List<String> genresort = new ArrayList<>(hashgenre.keySet());

        Collections.sort(genresort, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return hashgenre.get(o2).compareTo(hashgenre.get(o1));
            }
        });
        List<Integer> final_list = new ArrayList<>();
        for (String s:genresort) {
        	HashMap<Integer,Integer> temp = hashplays.get(s);
        	List<Integer> tempsort = new ArrayList<>(temp.keySet());
            Collections.sort(tempsort, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                	if(temp.get(o1)==temp.get(o2)) {
                		return o1.compareTo(o2);
                	}
                    return temp.get(o2).compareTo(temp.get(o1));
                }
            });
            System.out.println(tempsort);
        	for (int i=0;i<tempsort.size();i++) {
        		if(i==2) break;
        		final_list.add((tempsort.get(i)));
        	}
        }
        answer = new int[final_list.size()];
        for(int i=0; i<final_list.size(); i++){
            answer[i] = final_list.get(i);
        }
        return answer;
    }
    
    

}

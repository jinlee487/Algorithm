package Hash;

import java.util.HashMap;

public class Marathon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] part = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] comp = {"josipa", "filipa", "marina", "nikola"};
		System.out.println(calc(part,comp));
	}
	public static String calc(String[] part, String[] comp) {
		String dis = "";
		HashMap<String, Integer> hash = new HashMap<>(); 
		for (int i = 0;i<part.length;i++) {
			if(hash.get(part[i]) == null) {
				hash.put(part[i], 1);
			}
			else {
				hash.put(part[i], hash.get(part[i])+1);
			}
		}
		for (int i=0; i<comp.length;i++) {
			hash.put(comp[i],hash.get(comp[i])-1);
		}
		for (String key:hash.keySet()) {
			if(hash.get(key)!=0) {
				dis = key;
			}
		}
		return dis;
	}
}

package winter_internship;

import java.util.ArrayList;
import java.util.HashMap;

public class Faulty_user {
	static HashMap<String, ArrayList<String>> hash = new HashMap<>();
	static ArrayList<HashMap<String, Boolean>> check = new ArrayList<>();
	public static void main(String[] args) {
		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id = {"*rodo", "*rodo", "******"};
		System.out.println(solution(user_id,banned_id));
	}
    public static int solution(String[] user_id, String[] banned_id) {
		for (int i=0;i<banned_id.length;i++) {
			String bi = banned_id[i];
//			System.out.println("\nthis is the current bi => " + bi);
			String[] b = bi.split("");
//			System.out.println(Arrays.toString(b));
			if (hash.get(bi)==null) {
				ArrayList<String> list = new ArrayList<String>();
				hash.put(bi,list);
			}
			else { 
//				hash.remove(bi);
				continue;
			}
			next: 
			for(int j=0;j<user_id.length;j++) {
//				System.out.println("");
				String ui = user_id[j];
//				System.out.println("checking ui => " + ui);
				if(ui.length()!=bi.length()) {
					continue next;
				}
				String[] u = ui.split("");
//				System.out.println("length is the same!");
				
				for(int k=0;k<u.length;k++) {
					if(b[k].equals("*")) {
						continue;
					}
					if(!u[k].equals(b[k])) {
//						System.out.println("it did not match!");
//						System.out.println("u[k] =>" + u[k]);
//						System.out.println("b[k] =>" + b[k]);

						continue next;
					}
				}
//				System.out.println("inputting into hash => " + ui);
				ArrayList<String> temp = hash.get(bi);
				temp.add(ui);
				hash.put(bi, temp);
			}
		
		}
		
		HashMap<String, Boolean> list = new HashMap<>(); 
		for (String t:hash.keySet()) {
			System.out.println(hash.get(t).toString());
			for(String tt: hash.get(t))
				list.put(tt,false);
		}
		 
//		int arr[][] = new int[hash.size()][user_id.length];
//	
		int answer = 0;
//
//		int[] numbers = {1, 1, 1, 1, 1};
//		int target = 3;
		dfs(0, list, banned_id, 0);
        return check.size();
    }
    public static void dfs(int cnt,HashMap<String, Boolean> list, String[] banned_id,int idx) {
    	if(idx==(banned_id.length)) {
    		HashMap<String, Boolean> checklist = new HashMap<String, Boolean>();
    		for(String s:list.keySet()) {
    			checklist.put(s,list.get(s));
    		}
    		
    		for(int i=0;i<check.size();i++) {
    			boolean notsame = false;
    			for(String s:check.get(i).keySet()) {
        			if(checklist.get(s)!=check.get(i).get(s)) {
        				notsame = true;
        				break;
        			}
        		}
    			if(!notsame) {
    				return;
    			}
    		}
    		
    		System.out.println("***adding listString = >"+checklist.toString());
    		check.add(checklist);
			return;
    	}

		for(int j=0;j<hash.get(banned_id[idx]).size();j++) {
			String ui = hash.get(banned_id[idx]).get(j);
			if(list.get(ui)==true) continue;
			list.put(ui,true);
			dfs(cnt,list,banned_id,idx+1);
			list.put(ui,false);
		}
    	

    	return;
	}

//	public static ArrayList<HashMap<String, Boolean>> dfs(int cnt,HashMap<String, Boolean> list, String[] banned_id,int idx,
//			HashMap<String, ArrayList<String>> hash,ArrayList<HashMap<String, Boolean>> check) {
//    	if(idx==(banned_id.length)) {
//    		HashMap<String, Boolean> checklist = new HashMap<String, Boolean>();
//    		for(String s:list.keySet()) {
//    			checklist.put(s,list.get(s));
//    		}
//    		
//    		for(int i=0;i<check.size();i++) {
//    			boolean notsame = false;
//    			for(String s:check.get(i).keySet()) {
//        			if(checklist.get(s)!=check.get(i).get(s)) {
//        				notsame = true;
//        				break;
//        			}
//        		}
//    			if(!notsame) {
//    				return check;
//    			}
//    		}
//    		
//    		System.out.println("***adding listString = >"+checklist.toString());
//    		check.add(checklist);
//			return check;
//    	}
//
//		for(int j=0;j<hash.get(banned_id[idx]).size();j++) {
//			String ui = hash.get(banned_id[idx]).get(j);
//			if(list.get(ui)==true) continue;
//			list.put(ui,true);
//			check = dfs(cnt,list,banned_id,idx+1,hash,check);
//			list.put(ui,false);
//		}
//    	
//
//    	return check;
//	}
}

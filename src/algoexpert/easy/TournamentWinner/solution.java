package algoexpert.easy.TournamentWinner;

import java.util.*;

class Program {

  public String tournamentWinner(
      ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
		String answer = "";
		HashMap<String, Integer> scores = new HashMap<String, Integer>();
		scores.put(answer,0);
		for(int i=0;i<competitions.size();i++){
			ArrayList<String> competition = competitions.get(i);
			int result = results.get(i);
			String home = competition.get(0);
			String away = competition.get(1);
			String win = result == 1 ? home : away;
			if(scores.containsKey(win)){
				scores.put(win, scores.get(win) + 3);
			} else {
				scores.put(win,3);
			}
			if(scores.get(win) > scores.get(answer)){
				answer = win;
			}
		}
		return answer;
	}
}

// import java.util.*;

// class Program {

//   public String tournamentWinner(
//       ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
//     // Write your code here.
// 		HashMap<String,Integer> hash = new HashMap<String,Integer>();
// 		int w;
// 		for(int i=0;i<competitions.size();i++){
// 			w = results.get(i)==1?0:1;
// 			if(hash.containsKey(competitions.get(i).get(w))){
// 				hash.put(competitions.get(i).get(w),hash.get(competitions.get(i).get(w))+3);
// 			} else {
// 				hash.put(competitions.get(i).get(w),3);
// 			}
// 		}
// 		String answer="";
// 		int max = Collections.max(hash.values());
// 		for (Map.Entry<String, Integer> entry : hash.entrySet()) {
// 			if (entry.getValue()==max) {
// 				answer = entry.getKey();
// 			}
// 		}
// 		return answer;
// 	}
// }

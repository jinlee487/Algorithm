package kakao_blind_2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/*
 * SOLVED!!
 * https://programmers.co.kr/learn/courses/30/lessons/72411
 * 메뉴 리뉴얼
*/
public class MenuRenual {   
    static HashMap<String,Integer> combinations;
    static HashSet<String> keyCheck;
    public static void main(String[] args) {
		// TODO Auto-generated method stub
        String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course = {2,3,5};
		System.out.println(Arrays.toString(solution(orders,course)));
	}
    public static String[] solution(String[] orders, int[] course) {
        //System.out.println("this is the input => ");
        //System.out.println(Arrays.toString(orders));
        //System.out.println(Arrays.toString(course));
        combinations = new HashMap<String, Integer>();
        // we are going to get all the different possible combinations 
        // for 2~10 length alphabet strings
        //System.out.println("starting loop!");
        for(int i=0;i<orders.length;i++){

            // this gets the characters from the particular order[i]
            //System.out.println("\nthis is i => " + i);
            //System.out.println("this is the orders[i] => " + orders[i]);
            for(int j=0;j<course.length;j++){
                //this is the loop for the course size
                //System.out.println("this is j => " + j);
                //System.out.println("this is course[j] => " + course[j]);
                keyCheck = new HashSet<String>();
                permute(course[j],"",orders[i],0);
            }
        }
        //System.out.println("this is all the possible combinations");
        //System.out.println(combinations);
        List<Map.Entry<String,Integer>> entries = new ArrayList<Map.Entry<String,Integer>>(
            combinations.entrySet()
        );
        Collections.sort(
            entries
        ,   new Comparator<Map.Entry<String,Integer>>() {
                public int compare(Map.Entry<String,Integer> a, Map.Entry<String,Integer> b) {
                    return Integer.compare(b.getValue(), a.getValue());
                }
            }
        );
        //now we change the hashmap to an orderable entry list
        //System.out.println("this is the sorted entry set => " );
        //System.out.println(entries);
        int[] courses = new int[11];
        Arrays.fill(courses, 0);
        String k="";
        int c = 0;
        int l = 0;
        ArrayList<String> answerList = new ArrayList<String>();
        //from the entry list, we take out the first appearance of the given letter length occurence ordered string
        for(int i=0;i<entries.size();i++){
            k = entries.get(i).getKey();
            c = entries.get(i).getValue();
            l = k.length();
            if(c<2){
                continue;
            }
            if(courses[l] == 0){
                answerList.add(k);
                courses[l] = c;
                continue;
            }
            if(0<i && courses[l] != 0 && courses[l]<=c){
                answerList.add(k);
            }
        }
       
        String[] answer = answerList.toArray(new String[0]);
        //then we change the list to an answer arr
        Arrays.sort(answer);
        return answer;
    }
    //
    // this is a combination However we need a permutation because the order of the alphabets does not matter!
    //
    // public static void possibleStrings(int maxLength, char[] alphabet, String curr) {
    //     // If the current string has reached it's maximum length
    //     if(curr.length() == maxLength) {
    //         if(combinations.containsKey(curr)&&!keyCheck.contains(curr)){
    //             combinations.put(curr,combinations.get(curr)+1);
    //             keyCheck.add(curr);
    //             //System.out.println("found contains key keycheck => " + keyCheck);
    //         }
    //         else if(!combinations.containsKey(curr)&&!keyCheck.contains(curr)) {
    //             combinations.put(curr,1);
    //             keyCheck.add(curr);
    //             //System.out.println("this is keycheck => " + keyCheck);
    //         }
    //     // Else add each letter from the alphabet to new strings and process these new strings again
    //     } else {
    //         for(int i = 0; i < alphabet.length; i++) {
    //             String oldCurr = curr;
    //             if(curr.indexOf(alphabet[i]) != -1){
    //                 continue;
    //             }
    //             curr += alphabet[i];
    //             possibleStrings(maxLength,alphabet,curr);
    //             curr = oldCurr;
    //         }
    //     }
    // }
    public static void permute(int level, String prefix, String s, int index) {

        if (level == 0) {
            char[] chars = prefix.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if(combinations.containsKey(sorted)&&!keyCheck.contains(sorted)){
                combinations.put(sorted,combinations.get(sorted)+1);
                keyCheck.add(sorted);
                //System.out.println("found contains key keycheck => " + keyCheck);
            }
            else if(!combinations.containsKey(sorted)&&!keyCheck.contains(sorted)) {
                combinations.put(sorted,1);
                keyCheck.add(sorted);
                //System.out.println("this is keycheck => " + keyCheck);
            }
            return;
        }
        for (int i = index; i < s.length(); i++){
            if(prefix.contains(Character.toString(s.charAt(i)))){
                continue;
            }
            permute(level - 1, prefix + s.charAt(i), s, i);
        }
    }

}

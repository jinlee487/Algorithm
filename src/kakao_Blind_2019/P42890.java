package kakao_Blind_2019;
import java.util.*;
/* 
Solved!
https://programmers.co.kr/learn/courses/30/lessons/42890
후보키
for this problem, I use bitwise operations to loop through all the possible combinations.
if a certain combination is in the list, we skip over that combination because of the minimality rule. 
*/
public class P42890 {
    public static void main(String[] args) throws Exception {
        String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
        System.out.println(solution(relation));
    }
    public static int solution(String[][] relation) { 
        int rowSize = relation.length; 
        int colSize = relation[0].length; 
        ArrayList<Integer> list = new ArrayList<>(); 
        for (int i = 1; i < (1 << colSize); i++) { 
            // System.out.println("this is i => " + i);
            if (!checkMinimality(i, list)) {
                continue; 
            }
            // 최소성을 만족하지 못하면 패스 
            if (!checkUniqueness(i, relation, rowSize, colSize)) {
                continue; 
            }
            // 유일성을 만족하지 못하면 패스 
            list.add(i); 
        } 
        return list.size(); 
    } 
    private static boolean checkMinimality(int set, ArrayList<Integer> list) { 
        for (int key : list) { 
            if ((set & key) == key) {
                // System.out.println("set is already in set & key: "+(set & key)+ " set: "+set+ " key: " + key);
                return false; 
            }
            // 중복 되어 있으면 false 
        } 
        return true; 
    } 
    private static boolean checkUniqueness(int set, String[][] relation, int rowSize, int colSize) { 
        ArrayList<Integer> s = getSet(set, colSize); 
        // System.out.println("this is s => " + s);
        HashSet<String> hashSet = new HashSet<>(); 
        for (int i = 0; i < rowSize; i++) { 
            StringBuilder sb = new StringBuilder(); 
            for (int j : s) { 
                sb.append(relation[i][j]).append(" "); 
            } 
            hashSet.add(sb.toString()); 
        } 
        return hashSet.size() == rowSize;
    } 
    private static ArrayList<Integer> getSet(int set, int colSize) { 
        // 0101 -> [0, 2]로 변환 
        ArrayList<Integer> result = new ArrayList<>(); 
        for (int i = 0; i < colSize; i++) { 
            if (((set >> i) & 1) == 1) result.add(i); 
        } 
        return result; 
    }


}

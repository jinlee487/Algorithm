package kakao_Blind_2019;
import java.util.*;
/* 
https://programmers.co.kr/learn/courses/30/lessons/42888
오픈채팅방
this problem is a simple array + hashmap problem.
we are going to use the hashmap to solve the time complexity.
we loop once through and add the changes to the nicknames in the hashmap. 
next, we loop the second time to make a new string array with the final nickname changes.
this way, we only loop 2no not no^2
 */
public class P42888 {
    public static void main(String[] args) throws Exception {
        String[] input = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(Arrays.toString(solution(input)));
    }

    public static String[] solution(String[] record) {
        HashMap<String,String> hash = new HashMap<String,String>();
        ArrayList<String> arrayList = new ArrayList<String>();
        String[] arr;
        for(int i=0;i<record.length;i++){
            arr = record[i].split(" "); // the id is always the second in the array, 첫 단어는 Enter, Leave, Change 중 하나이다.
            if(arr[0].equals("Enter")){
                hash.put(arr[1],arr[2]);
            } else if(arr[0].equals("Change")){
                hash.put(arr[1],arr[2]);
            }
        }
        for(int i=0;i<record.length;i++){
            arr = record[i].split(" ");
            if(arr[0].equals("Enter")){
                arrayList.add(hash.get(arr[1])+"님이 들어왔습니다.");
            } else if(arr[0].equals("Leave")){
                arrayList.add(hash.get(arr[1])+"님이 나갔습니다.");
            }
        }
        String[] answer = new String[arrayList.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = arrayList.get(i);
        }
        return answer;
    }


}
package kakao_blind_2021;

import java.util.*;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/72412
 * 순위 검색
 * 해답=> https://girawhale.tistory.com/94
 * 비트연산 => dfs나 루핑으로 바꿔도 됨 어짜피 128개 밖에 안됨
 * & 
 * 이분탐색
 * 문제
*/
public class SearchRankingSolution {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        System.out.println(Arrays.toString(solution(info,query)));
    }
    public static int[] solution(String[] info, String[] query) {
        Map<String, List<Integer>> infos = new HashMap<>();
        for (String in : info) {
            String[] split = in.split(" ");
            int score = Integer.parseInt(split[4]);
            for (int i = 0; i < (1 << 4); i++) {
                StringBuilder key = new StringBuilder();
                for (int j = 0; j < 4; j++) {
                    if ((i & (1 << j)) > 0) key.append(split[j]);
                }
                infos.computeIfAbsent(key.toString(), s -> new ArrayList<>()).add(score);
            }
        }
        System.out.println("this is infos => " + infos);

        List<Integer> empty = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : infos.entrySet()){
            entry.getValue().sort(null);
        }
        System.err.println("this is sorted infos => " + infos);
        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            String[] split = query[i].replaceAll("-", "").split(" and | ");
            String key = String.join("", split[0], split[1], split[2], split[3]);
            int score = Integer.parseInt(split[4]);
           
            List<Integer> list = infos.getOrDefault(key, empty);

            int s = 0, e = list.size();
            // 이분탐색!
            while (s < e) {
                int mid = (s + e) / 2;
                System.out.println("s => " + s);
                System.out.println("e => " + e);
                System.out.println("mid => " + mid);
                if (list.get(mid) < score) {
                    s = mid + 1;
                    System.out.println("list.get(mid) < score => true");
                    System.out.println("s = mid + 1 => " + s);
                }
                else {                    
                    e = mid;
                    System.out.println("=> false");
                    System.out.println("e = mid => " + e);
                }
            }
            System.out.println("this is the answer[" +i+ "] =>" + (list.size() - s));
            answer[i] = list.size() - s;
        }

        return answer;
    }

}

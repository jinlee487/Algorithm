package kakao_Blind_2018;

import java.util.*;

/* 
https://programmers.co.kr/learn/courses/30/lessons/17677
뉴스 클러스터링

str1 = aa1+aa2
str2 = AAAA12
이라면
str1 에서는 ['aa', 'aa']
str2 에서는 ['AA', 'AA', 'AA'] 가 나오겠죠??

그럼 이 상태에서 교집합 = ['aa', 'aa'], 합집합 = ['aa', 'aa', 'aa'] 이 나옵니다.(대소문자 무시)
따라서 정답은 int(2 / 3 * 65536) = 43690 이 됩니다.
 */
public class P17677 {
    public static void main(String[] arg) throws Exception {
        StringBuilder str = new StringBuilder();
        for(int i=0;i<10;i++){
            if(i%2==0){
                str.append("+=");
            } else {
                str.append("TA");
            }
        }
        String str1 = str.toString();
        str = new StringBuilder();
        for(int i=0;i<10;i++){
            if(i%3==0){
                str.append(" ");
            } else {
                str.append("AB");
            }
        }
        String str2 = str.toString()
    ;
        System.out.println(solution(str1,str2));
    }
    public static int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        // System.out.println("str1 => " + str1);
        // System.out.println("str2 => " + str2);

        HashMap<String,Integer> hash1 = new HashMap<String,Integer>(); 
        HashMap<String,Integer> hash2 = new HashMap<String,Integer>(); 
        ArrayList<String> intersection = new ArrayList<String>();
        ArrayList<String> union = new ArrayList<String>();
        String str;
        for(int i=0;i<str1.length()-1;i++){
            str = str1.substring(i, i+2);
            if(!str.matches("^[a-zA-Z]*$")){
                continue;
            }
            if(hash1.containsKey(str)){
                hash1.put(str,hash1.get(str)+1);
            } else{
                hash1.put(str,1);
            }
        }
        for(int i=0;i<str2.length()-1;i++){
            str = str2.substring(i, i+2);
            if(!str.matches("^[a-zA-Z]*$")){
                continue;
            }
            if(hash2.containsKey(str)){
                hash2.put(str,hash2.get(str)+1);
            } else{
                hash2.put(str,1);
            }
        }
        // System.out.println("hash1 => " + hash1);
        // System.out.println("hash2 => " + hash2);
        String k1,k2;
        int v1,v2;
        for (Map.Entry<String,Integer> entry : hash1.entrySet()){
            k1 = entry.getKey();
            v1 = entry.getValue();
            if(hash2.containsKey(k1)){
                k2 = k1;
                v2 = hash2.get(k2);
                if(v1<v2){
                    for(int i=0;i<v1;i++){
                        intersection.add(k1);
                    }
                    for(int i=0;i<v2;i++){
                        union.add(k2);
                    }
                } else {
                    for(int i=0;i<v1;i++){
                        union.add(k1);
                    }
                    for(int i=0;i<v2;i++){
                        intersection.add(k2);
                    }
                }
                hash2.remove(k2);
            } else{
                for(int i=0;i<v1;i++){
                    union.add(k1);
                }
            }
        }
        for (Map.Entry<String,Integer> entry : hash2.entrySet()){
            k2 = entry.getKey();
            v2 = entry.getValue();
            for(int i=0;i<v2;i++){
                union.add(k2);
            }
        } 
        // System.out.println("this is intersection => " + intersection);
        // System.out.println("this is union => " + union);
        float f = (float) intersection.size()/union.size();
        int answer = (int) (f*65536);
        if(intersection.size()==0&&union.size()==0){
            answer = 65536;
        }
        return answer; 
    }
}

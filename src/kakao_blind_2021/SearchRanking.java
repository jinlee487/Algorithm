package kakao_blind_2021;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/72412
 * 순위 검색
 * 효율성  테스트
 * 테스트 1 〉	실패 (시간 초과)
 * 테스트 2 〉	실패 (시간 초과)
 * 테스트 3 〉	실패 (시간 초과)
 * 테스트 4 〉	실패 (시간 초과)
*/
public class SearchRanking {   
    static HashMap<String,int[]> data;
    static String[] lang,job,exp,food;
    public static void main(String[] args) {
		// TODO Auto-generated method stub
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		//System.out.println(Arrays.toString(solution(info,query)));
	}
    public static int[] solution(String[] info, String[] query) {
        data = new HashMap<String,int[]>();
        
        //언어	직군	경력	소울 푸드	점수
        //first, we are going to get all the possible outcomes for the choices using permutation
        //코딩테스트 참여 개발언어 항목에 cpp, java, python 중 하나를 선택해야 합니다.
        // 지원 직군 항목에 backend와 frontend 중 하나를 선택해야 합니다.
        // 지원 경력구분 항목에 junior와 senior 중 하나를 선택해야 합니다.
        // 선호하는 소울푸드로 chicken과 pizza 중 하나를 선택해야 합니다.
        String[] lang = {"cpp","java","python","-"};
        String[] job = {"backend","frontend","-"};
        String[] exp = {"junior","senior","-"};
        String[] food = {"chicken","pizza","-"};
        String[] arr = new String[4];
        String key;
        for(int j=0;j<lang.length;j++){
            arr[0] = lang[j];
            for(int k=0;k<job.length;k++){
                arr[1] = job[k];
                for(int l=0;l<exp.length;l++){
                    arr[2] = exp[l];
                    for(int m=0;m<food.length;m++){
                        arr[3] = food[m];
                        key = String.join(" ", arr);
                        data.put(key,new int[100001]);
                        // //System.out.println("this is keycheck => " + data.keySet());
                    }
                }
            }
        }

        //we are making all the possible combinations of resume
        // //System.out.println("this is the data key set = >" + data.size()); 
        // //System.out.println(data.keySet());
        // now that we have a key set, we can go through the applicants and input them into the data
        String[] applicant;
        int score;
        int[] scoreBoard;
        String[] temp;
        for(int i=0;i<info.length;i++){
            applicant = info[i].split(" ");
            score = Integer.parseInt(applicant[4]);
            applicant = Arrays.copyOf(applicant, applicant.length-1);
            temp = Arrays.copyOf(applicant,applicant.length);
            key = String.join(" ", applicant);
            if(!data.containsKey(key)){
                //System.out.println("found an applicant resume not in data key! => " + key);
            }
           
            scoreBoard = data.get(key);
            scoreBoard[score]  = scoreBoard[score] + 1;
            //System.out.println("this is the added key => " + key);
            //System.out.println("added score on => scoreBoard[score] + score " + scoreBoard[score] +" " + score);
            data.put(key,scoreBoard);

            for(int j=0;j<2;j++){
                if(j==0) temp[0] = applicant[0];
                else temp[0] = "-";
                for(int k=0;k<2;k++){
                    if(k==0) temp[1] = applicant[1];
                    else temp[1] = "-"; 
                    for(int l=0;l<2;l++){
                        if(l==0) temp[2] = applicant[2];
                        else temp[2] = "-";
                        for(int m=0;m<2;m++){
                            if(m==0) temp[3] = applicant[3];
                            else temp[3] = "-";
                            if(Arrays.equals(temp, applicant)){
                                continue;
                            }
                            key = String.join(" ", temp);
                            if(!data.containsKey(key)){
                                //System.out.println("found an applicant resume not in data key! => " + key);
                            }
                            
                            scoreBoard = data.get(key);
                            scoreBoard[score]  = scoreBoard[score] + 1;
                            //System.out.println("this is the added key => " + key);
                            //System.out.println("added score on => scoreBoard[score] + score " + scoreBoard[score] +" " + score);
                            data.put(key,scoreBoard);
                        }
                    }
                }
            }

        }
        // //System.out.println(data);
        //now we have al the data and the score ranks in the for querying 
        String q;
        String[] qarr;
        int sco;
        int[] answer = new int[query.length];
        int[] pass;
        int count;
        for(int i=0;i<query.length;i++){
            //System.out.println("this is query => " + query[i]);

            qarr = query[i].split(" ");
            sco = Integer.parseInt(qarr[7]);
            q = String.join(" ", new String[] {qarr[0],qarr[2],qarr[4],qarr[6]});

            if(!data.containsKey(q)){
                //System.out.println("query is not in the data key! => " + q);
            }
            scoreBoard = data.get(q);
            pass = Arrays.copyOfRange(scoreBoard, sco, scoreBoard.length);
            //System.out.println("this is i => " + i);
            //System.out.println("this is sco => " + sco);
            //System.out.println("this is key => " + q);
            count=IntStream.of(pass).sum();
            //System.out.println("count is " + count);

            answer[i]=count;
            
        }
        return answer;
    }

}

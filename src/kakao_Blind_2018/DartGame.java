package kakao_Blind_2018;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/*
 * SOLVED!!
 * https://programmers.co.kr/learn/courses/30/lessons/17682
 * 다트게임
*/
public class DartGame {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String dartResult = "1D2S#10S";

		System.out.println(solution(dartResult));
	}
    public static int solution(String dartResult) {
        int answer = 0;
        ArrayList<Integer> l = new ArrayList<Integer>();
        Queue<String> qe = new LinkedList<String>();
        String[] temp = dartResult.split("");
        for(int i=0;i<temp.length;i++){
            qe.add(temp[i]);
        }
        // System.out.println("this is qe => " + qe);

        //this is the list where all the equations will go
        String t;
        Double s;
        //this is the character for the dart string loop
        for(;!qe.isEmpty();){
            if(Character.isDigit(qe.peek().charAt(0))){
                //check to see if it is a score
                // System.out.println("new score incoming!");
                t = qe.poll();
                
                if(Character.isDigit(qe.peek().charAt(0))){
                    // System.out.println("there is a 10!");
                    //if the score is 1, we need to check if the value is 10 or not
                    t += qe.poll();
                }
                s = Double.parseDouble(t);

                // System.out.println("this is our s => " + s);
                if(qe.peek().equals("S")){
                    l.add((int)Math.pow(s,1));
                } else if(qe.peek().equals("D")){
                    l.add((int)Math.pow(s,2));
                } else if(qe.peek().equals("T")){
                    l.add((int)Math.pow(s,3));
                }
                qe.poll();
                if(!qe.isEmpty()&&qe.peek().equals("*")){
                    //check to see if we have a * or # 
                    l.set(l.size()-1, l.get(l.size()-1)*2);
                    if(1<l.size()){
                        l.set(l.size()-2, l.get(l.size()-2)*2);
                    }
                    qe.poll();
                }
                if(!qe.isEmpty()&&qe.peek().equals("#")){
                    //check to see if we have a * or # 
                    l.set(l.size()-1, l.get(l.size()-1)*-1);
                    qe.poll();
                }
                
            }
        }
        // System.out.println("this is arraylist => \n" +  l);
        for(int i = 0; i < l.size(); i++){
            answer += l.get(i);
        }
        return answer;
    }
}

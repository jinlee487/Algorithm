package kakao_Internship_2021;

import java.util.*;

class Cmd{
    int value;
    int idx;
    int before;
    int after;
    Cmd(int idx, int before, int after, int value){
        this.idx = idx; this.before = before; this.after = after; this.value =value;
    }
}
public class problem3 {
    public static void main(String[] args) {
        int n = 5;
        int k = 4;
        String[] cmd = {"C", "U 2", "C", "C", "C", "C", "Z"};
        
        System.out.println(solution(n, k, cmd));
    }
   
    public static String solution(int n, int k, String[] cmd) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int[] arr;
        int loc = k;
        arr = new int[n];
        for(int i=0;i<arr.length;i++){
            list.add(i);
            arrayList.add(i);
        }
        Stack<Cmd> stack = new Stack<Cmd>();
        String command;
        int movement;
        Cmd recent;
        for(int i=0;i<cmd.length;i++){
            String[] commandArray = cmd[i].split(" ");
            command = commandArray[0];
            if(command.equals("D")) {
                movement = Integer.parseInt(commandArray[1]);
                loc += movement;
            }else if(command.equals("U")) {
                movement = Integer.parseInt(commandArray[1]);
                loc -= movement;
            }else if(command.equals("C")) {
                stack.add(new Cmd(loc,loc-1,loc+1,list.get(loc)));
                list.remove(loc);
                if(list.size()<loc){
                    loc--;
                }
            }else if(command.equals("Z")){
                recent = stack.pop();
                list.add(recent.idx,recent.value);
                if(recent.idx<loc){
                    loc ++;
                }
            }
        } 
        StringBuilder str = new StringBuilder();
        for(int i=0;i<arrayList.length;i++){
            if(list.size()<i){
                str.append("X");
            } else {
                if(arrayList.get(i).equals(list.get(i))){
                    str.append("O");
                } else {
                    str.append("X");
                } 
            }
        }

        for(int i=0;i<n;i++) {
            if(!tableList.isEmpty()) {
                if(tableIndex < tableList.size()) {
                    if(tableList.get(tableIndex) == i) {
                        answer += "O";
                        tableIndex++;
                    }else {
                        answer += "X";
                    }
                }else {
                    answer += "X";
                }
            }else {
                answer += "X";
            }
        }

        return answer;
    }
}
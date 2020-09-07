package arrange;

import java.util.Arrays;

public class Kth_number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		System.out.println(Arrays.toString(solution(array,commands)));
	}
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];        
        for (int i=0, cnt=0;i<commands.length;i++,cnt++) {        	
        	int[] temp = new int[commands[i][1]-commands[i][0]+1];
        	for (int j=commands[i][0]-1, c=0;j<commands[i][1];j++,c++) {
        		temp[c] = array[j];       		                 
        	}
        	Arrays.sort(temp);
        	answer[cnt] = temp[commands[i][2]-1];
        }
        return answer;
    }
}

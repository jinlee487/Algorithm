package Internship2020;

import java.util.Arrays;

public class first {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {2,4,0,0,3,1,5};
		int[] temp = new int[999];
		for(int i=0,cnt=0;cnt<temp.length;cnt++,i++) {
			temp[cnt]=i;
			if(i==9) {
				i=0;
			}
		}
//		System.out.println(Arrays.toString(temp));
		String hand = "right";
		System.out.println(solution(numbers,hand));
		//"LRLLLRLLRRL"
	}
	
    public static String solution(int[] numbers, String hand) {
        String answer = "";
        int[] leftloc = {3,0,1};
        int[] rightloc = {3,2,2};
        int[] current = new int[3];
        String h ="";
        for (int i=0;i<numbers.length;i++) {
        	System.out.println("this is number => " + numbers[i]);
        	current = position(numbers[i]).clone();
        	System.out.println("this is the current => " + Arrays.toString(current));
        	h=choose(hand,leftloc,rightloc,current);
        	System.out.println("this is h => " + h);
        	if(h.equals("R")) {
        		rightloc = current.clone();
        	}
        	else {
        		leftloc = current.clone();
        	}
        	answer+=h;
        	System.out.println("this is answer => " + answer);
        }
        return answer;
    }
    
    public static String choose(String hand, int[] leftloc,int[] rightloc, int[] loc) {
    	if (loc[2]==1) return "L";
    	else if(loc[2]==2) return "R";
    	int left = Math.abs(leftloc[0] - loc[0]) + Math.abs(leftloc[1] - loc[1]);
    	System.out.println(Arrays.toString(leftloc));
    	System.out.println(left);
    	int right = Math.abs(rightloc[0] - loc[0]) + Math.abs(rightloc[1] - loc[1]);
    	System.out.println(Arrays.toString(rightloc));
    	System.out.println(right);
    	if(hand.equals("right")) {
    		if(left>=right) {
    			return "R";
    		}
    		else {
    			return "L";
    		}
    	}
    	else {
        	if(left<=right) {
        		return "L";
        	}
        	else {
        		return "R";
        	}   	
    	}
    }
    
    public static int[] position(int num) {
    	String key = Integer.toString(num);
    	int[] loc = new int[3];
    	switch (key) {
		case "1":
			loc[0] = 0;
			loc[1] = 0;
			loc[2] = 1;
			break;
		case "2":
			loc[0] = 0;
			loc[1] = 1;
			break;
		case "3":
			loc[0] = 0;
			loc[1] = 2;
			loc[2] = 2;
			break;
		case "4":
			loc[0] = 1;
			loc[1] = 0;
			loc[2] = 1;
			break;
		case "5":
			loc[0] = 1;
			loc[1] = 1;
			break;
		case "6":
			loc[0] = 1;
			loc[1] = 2;
			loc[2] = 2;
			break;
		case "7":
			loc[0] = 2;
			loc[1] = 0;
			loc[2] = 1;
			break;
		case "8":
			loc[0] = 2;
			loc[1] = 1;
			break;
		case "9":
			loc[0] = 2;
			loc[1] = 2;
			loc[2] = 2;
			break;
		case "0":
			loc[0] = 3;
			loc[1] = 1;
			break;
		}
    	return loc;
    }
}

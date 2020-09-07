package Internship2020;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class second {
	static long sum = Integer.MIN_VALUE;
	static String[] operator = {"+", "-", "*"};
	static HashMap<String,Boolean> check; 
	public static void main(String[] args) {
		//String expression = "100-200*300-500+20";
		String expression = "999";
		for (int i=0;i<100;i++) {
			expression += "*999";
		} 
		System.out.println(expression);
		//String expression = "50*6-3*2";
		//String expression = "1+2+3+4+5";
		//String expression = "2-2+3-4+5";
		System.out.println(solution(expression));
	}
	
    public static long solution(String expression) {
    	String[] split = expression.split("(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)");
        System.out.println(Arrays.toString(split));
        
        LinkedList<String> numlist = new LinkedList<String>(Arrays.asList(split));
    	System.out.println(numlist.toString());
    	
    	check = new HashMap<String,Boolean>();   	
    	for(String s:operator) {
    		check.put(s,false);
    	}
    	
    	System.out.println(check.toString());
    	
    	dfs(numlist);
    	long answer = sum;
        return answer;
    }
    
    public static void dfs(LinkedList<String> numlist) {
    	if (numlist.size()==1) {
    		
    		System.out.println("\n***we have reached the end!");
    		System.out.println("current end product => " + numlist.get(0));
    		System.out.println("current sum => "+ sum);
    		sum = Math.max(sum, Math.abs(Long.parseLong(numlist.get(0))));    		
    		return;
    	}
    	
    	next:
    	for(int i=0;i<operator.length;i++) {	
    		String op = operator[i];
    		if(check.get(op)==true) {
    			System.out.println("op is already used! => " + op);
    			continue next;
    		}
    		else {
    			System.out.println("op is not used => " + op);
    			check.put(op,true);
    		}
    		
    		System.out.println("***this is the current operator => " + op);
    		System.out.println(check.toString());
        	LinkedList<String> templist = new LinkedList<String>();
        	for(String t:numlist) {
        		templist.add(t);
        	}
        	System.out.println("this is the templist => " + templist.toString());
    		for (int j=0;j<numlist.size();j++) {
    			if(numlist.get(j).equals(op)) {
    				System.out.println("\nwe found a match!");
    				System.out.println("this is the current numlist => " + numlist.toString());
    				
    				long first = Long.parseLong(numlist.get(j-1));
    				long second = Long.parseLong(numlist.get(j+1));
    				String value = Long.toString(calc(first,second,op));
    				
    				System.out.println("first => " + first);
    				System.out.println("second => " + second);
    				System.out.println("value => " + value);

    				numlist.set(j,value);
    				numlist.remove(j+1);
    				numlist.remove(j-1);
    				System.out.println("this is the new numist => " + numlist.toString());
    				System.out.println("");
    				j--;
    			}
    		}
    		System.out.println("this is going into the next dfs => ");
    		System.out.println("numlist => " + numlist.toString());
    		dfs(numlist);
        	numlist = new LinkedList<String>();
        	for(String t:templist) {
        		numlist.add(t);
        	}
    		check.put(op,false);
    		System.out.println("");
    	}
    	
    	return;
    	
    }
	public static long calc(long firstValue, long secondValue, String operator) {
	    switch (operator){
        case "+":
            return firstValue + secondValue;
        case "-":
            return firstValue - secondValue;
        case "*":
            return firstValue * secondValue;
	    }
		return 0;
	}
}

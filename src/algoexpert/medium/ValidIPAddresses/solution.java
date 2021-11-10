package algoexpert.medium.ValidIPAddresses;

import java.util.*;

class Program {

  public ArrayList<String> validIPAddresses(String string) {
    // Write your code here.
		ArrayList<String> answer = new ArrayList<String>();
		for(int i=1;i<Math.min((int) string.length(),4);i++){
			String[] current = new String[] {"","","",""};
			current[0] = string.substring(0,i);
			if(!check(current[0])) continue;
			for(int j=i+1;j<i+Math.min((int) string.length()-i,4);j++){
				current[1] = string.substring(i,j);
				if(!check(current[1])) continue;			
				for(int k=j+1;k<j+Math.min((int) string.length()-j,4);k++){
					current[2] = string.substring(j,k);
					current[3] = string.substring(k);
					if(check(current[2])&&check(current[3])) {
						StringBuilder sb = new StringBuilder();
						for(String str : current) sb.append(str+".");
						answer.add(sb.toString().substring(0,sb.length()-1));
					}				
				}
			}
		}
		return answer;
  }
	public boolean check(String string){
		int num = Integer.parseInt(string);
		if(num>255) return false;
		return string.length() == Integer.toString(num).length();
	}
}

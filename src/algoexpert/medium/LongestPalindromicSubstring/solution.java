package algoexpert.medium.LongestPalindromicSubstring;

import java.util.*;

class Program1 {
  public static String longestPalindromicSubstring(String str) {
    // Write your code here.
		// O(n^3) time | O(n) space
		String answer = "";
		for(int i=0;i<str.length();i++){
			for(int j=i;j<str.length();j++){
				String substring = str.substring(i,j+1);
				if(substring.length()>answer.length()&&isPalindrome(substring)){
					answer = substring;
				}
			}
		}
    return answer;
  }
	public static boolean isPalindrome(String str){
		int left = 0;
		int right = str.length()-1;
		while(left<right){
			if(str.charAt(left)!=str.charAt(right)){
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}


class Program2 {
    public static String longestPalindromicSubstring(String str) {
      // Write your code here.
          int[] current = {0,1};
          for(int i=1;i<str.length();i++){
              int[] odd = longestPalindromicSubstring(str,i-1,i+1);
              int[] even = longestPalindromicSubstring(str,i-1,i);
              int[] longest = odd[1]-odd[0] > even[1]-even[0] ? odd:even;
              current = current[1]-current[0] > longest[1]-longest[0]?current:longest;		
          }
      return str.substring(current[0],current[1]);
    }
      public static int[] longestPalindromicSubstring(String str, int left, int right){
          while(left>=0&&right<str.length()){
              if(str.charAt(left)!=str.charAt(right)){
                  break;
              }
              left--;
              right++;
          }
          return new int[] {left+1, right};
      }
  }
  
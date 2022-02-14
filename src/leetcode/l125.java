package leetcode;

public class l125 {
    public static void main(String[] args){
        String[] input = new String[] {"A man, a plan, a canal: Panama","race a car"," ",",.","0P","0P0","0P0P"};
        for(String s : input) System.out.println(isPalindrome(s));
    }
    public static boolean isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        // System.out.println(s);
        while(i<j){
            char left = Character.toLowerCase(s.charAt(i));
            char right = Character.toLowerCase(s.charAt(j));
            while(!Character.isLetterOrDigit(left)&&i<j){
                left = Character.toLowerCase(s.charAt(++i));
            }
            while(!Character.isLetterOrDigit(right)&&i<j){
                right = Character.toLowerCase(s.charAt(--j));
            }
            // System.out.println(i);
            // System.out.println(j);
            // System.out.println(left);
            // System.out.println(right);
            if(!Character.isLetterOrDigit(right)||!Character.isLetterOrDigit(left)) {
                break;
            }
            if(left != right){
                return false;
            }

            i++;
            j--;
        }
        return true;
    }

}

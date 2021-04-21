package kakao_blind_2021;
/*
 * SOLVED!!
 * https://programmers.co.kr/learn/courses/30/lessons/72410
 * 신규 아이디 추천

*/
public class NewIdRecommendation {
    public static void main(String[] args) {
		// TODO Auto-generated method stub
        String new_id = "-----------------------------------"; 
        String[] arr = new String[20]; 
        for(int i=0;i<20;i++){
            arr[i] = "!-_.~!@#$%^&*()=+[{]}:?,<>/";
        }
        new_id = String.join("", arr);
        System.out.println("this is new_id = >" + new_id);
		System.out.println(solution(new_id));
	}
    public static String solution(String new_id) {
        //1stage
        new_id = new_id.toLowerCase();
        //2stage
        new_id=new_id.replaceAll("[^a-z0-9_.-]", "");
        //Hyphen - has to be at the end of charlist, else it means interval.
        System.out.println(new_id);
        //3stage
        new_id=new_id.replaceAll("\\.\\.+", "\\."); 
        System.out.println(new_id);

        //4stage
        if(new_id.length()!=0&&new_id.charAt(0)=='.'){
            new_id=new_id.substring(1,new_id.length());
        }
        System.out.println(new_id);

        if(new_id.length()!=0&&new_id.charAt(new_id.length()-1)=='.'){
            new_id=new_id.substring(0,new_id.length()-1);
        }
        System.out.println(new_id);

        //5stage
        if(new_id.length()==0){
            new_id="a";
        }

        //6stage
        if(15<new_id.length()){
            new_id=new_id.substring(0, 15);
        }
        if(new_id.length()!=0&&new_id.charAt(new_id.length()-1)=='.'){
            new_id=new_id.substring(0,new_id.length()-1);
        }
        System.out.println(new_id);

        //7stage
        if(new_id.length()<3){
            char l = new_id.charAt(new_id.length()-1);
            while(new_id.length()!=3){
                new_id=new_id+Character.toString(l);
            }
        }
        System.out.println("this is the final new _id => " + new_id);
        System.out.println("this is the length => "  + new_id.length());
        return new_id;
    }
}

package KakaoTalk_2020_first;

/*
 * 
 */
public class Compress_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "aaaaaaaaaabbb";
		System.out.println(solution(test));
	}
	public static int solution(String s) {
		int len = s.length();
		int answer = len;
		String c,d; 
		int temp=0, count=0;
		for (int i=1;i<(len/2+1);i++) {
			d = s.substring(0,i);
			for (int j=i;j<len-i+1;j+=i) {
				c = s.substring(j,j+i);
				if (c.equals(d)) {
					count++;
					if(!(j+i<len-i+1)) {
						temp+=(count*i)-Integer.toString(count+1).length();
						count=0;
					}
				}
				else {
					d = c;
					if(count!=0)
						temp+=(count*i)-Integer.toString(count+1).length();
					count=0;
				}
			}
			answer=Math.min(answer,len-temp);
			temp=0;count=0;
		}
		return answer;
	}
}

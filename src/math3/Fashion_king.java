package math3;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/*
 *
 * https://www.acmicpc.net/problem/9375
 * 패션왕
 * 

예) 하의 2벌, 상의1벌, 신발 3켤레 : (2+1)*(1+1)*(3+1)-1 = 23가지
 */

public class Fashion_king {
	public static void main(String[] args) throws Exception {
    	StringBuffer sb = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int c = 0;
		String kind="";
		while((c++)!=N) {
			HashMap<String, Integer> Clothes = new HashMap<>();
			int n = Integer.parseInt(br.readLine());
			for (int i=0;i<n;i++) {
				kind = br.readLine().split(" ")[1];
				if (Clothes.containsKey(kind)) {
                    Clothes.put(kind, Clothes.get(kind) + 1);
                } else {
                    Clothes.put(kind, 1);
                }
            }
			int result = 1;
			for(int a:Clothes.values()) {
				result *= a+1;
			}
			sb.append(result-1+"\n");
		}
		System.out.println(sb);
	}
}

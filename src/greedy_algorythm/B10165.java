package greedy_algorythm;

import java.util.*;
import java.io.*;
/*
 * Solved!
 * https://www.acmicpc.net/problem/B10165
 * 버스 노선
 */
public class B10165 {
    
    static int n, m, BsMin = Integer.MAX_VALUE, BeMax = Integer.MIN_VALUE;
    static Vector<info> A = new Vector<info>();
    static Vector<info> B = new Vector<info>();
    static boolean[] ans;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        
        ans = new boolean[m + 1];
        int s, e;
        
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            
            if(s < e) {
                A.add(new info(s, e, i + 1));
            }
            else {
                B.add(new info(s, e, i + 1));
                BsMin = Math.min(BsMin, s); // 그룹 B의 출발점(s)의 최솟값
                BeMax = Math.max(BeMax, e); // 그룹 B의 도착점(e)의 최댓값
            }
        }
        Collections.sort(A, new Comparator<info>() {
            public int compare(info a, info b) {
                if(a.s < b.s) {
                    return -1;
                }
                else if(a.s == b.s){
                    if(a.e < b.e) {
                        return 1;
                    }
                    else {
                        return -1;
                    }
                }
                else {
                    return 1;
                }
            }
        });
        
        Collections.sort(B, new Comparator<info>() {
            public int compare(info a, info b) {
                if(a.s < b.s) {
                    return -1;
                }
                else if(a.s == b.s){
                    if(a.e < b.e) {
                        return 1;
                    }
                    else {
                        return -1;
                    }
                }
                else {
                    return 1;
                }
            }
        });
		//System.out.println("this is A => " + A);
		//System.out.println("this is B => " + B);
		//System.out.println("BsMin => " + BsMin + "\n BsMax => " + BeMax);

        int em = Integer.MIN_VALUE;
        
        for(info i : A) {
            //System.out.println("\ni => " + i);
            // 1. 그룹 A에 있는 노선들이 그룹 A의 노선들을 포함하는 경우
            if(em < i.e) {
                em = i.e;
				//System.out.println("em => " + em );

            }
            else {
				//if the end point is lower than the end point of the last bus, 
				// that means that the previous bus encompasses the current bus
                ans[i.idx] = true;
				//System.out.println("i.idx => " + i.idx );

            }
            
            // 2. 그룹 B에 있는 노선들이 그룹 A의 노선들을 포함하는 경우
            // 그룹 B의 출발점(s) 최솟값보다 크거나 같거나
            // 또는
            // 그룹 B의 도착점(e) 최댓값보다 작거나 같으면
            // 무시(포함되기 때문에)
			// this works because the backwards idx
			// cannot have a gap in the middle 
			// ex 5 0 
			// 9 4
			// BsMin = 5 and BeMax = 4
			// if there were to be a gap between the two, 
			// then it would have to be 
			// 5 0 
			// 1 9
			// then 1 9 would not be in the B array. 
			// everything in arr B becomes continuous
            if(BsMin <= i.s || BeMax >= i.e) {
                ans[i.idx] = true; 
				//System.out.println("this hits? ");
				//System.out.println("i.idx => " + i.idx );

            }
        }
        
        em = Integer.MIN_VALUE;
        
        // 3. 그룹 B에 있는 노선들이 그룹 B의 노선들을 포함하는 경우
        for(info i : B) {
			//System.out.println("\ni => " + i);

            if(em < i.e) {
                em = i.e;
				//System.out.println("em => " + em );

            }
            else {
                ans[i.idx] = true;
				//System.out.println("i.idx => " + i.idx );

            }
        }
		//System.out.println(Arrays.toString(ans));
        for(int i=1; i<=m; i++) {
            if(!ans[i]) {
                bw.write(String.valueOf(i) + " ");
            }
        }
        
        bw.write(String.valueOf("\n"));
        bw.flush();
        bw.close();
		br.close();
    }
}
 
class info {
    
    int s, e, idx;
    
    info(int s, int e, int idx) {
        this.s = s;
        this.e = e;
        this.idx = idx;
    }
	@Override
	public String toString(){
		return "\ns:" + s + " e: " + e + " idx: " + idx;
	}
}

package Internship2020;
import java.util.*;
public class third {
	public static void main(String[] args) {
		String[] germ = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		System.out.println(Arrays.toString(solution(germ)));
	}
	public static int[] solution ( String[] germ) {
		int[] solution = new int[2];
		Map<String, Integer> hashEnd = new HashMap<>();
		Map<String, Integer> hashStart = new HashMap<>();
		int endIndex = -1;
		int startIndex = germ.length+1;
		for( int i = germ.length-1; i > -1; i-- ) {
			hashEnd.put(germ[i], i);
		}
		for( int i = 0; i<germ.length; i++ ) {
			hashStart.put(germ[i],i);
		}
		for ( String str : hashEnd.keySet()) {
			int temp = hashEnd.get(str);
			if( temp > endIndex) {
				endIndex = temp;
			}
		}
		for ( String str : hashStart.keySet()) {
			int temp = hashStart.get(str);
			if( temp < startIndex) {
				startIndex = temp;
			}
		}
		solution[0] = startIndex+1;
		solution[1] = endIndex+1;
		return solution;
	}
}
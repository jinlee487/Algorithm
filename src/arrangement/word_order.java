package arrangement;
import java.util.Arrays;
import java.util.List;
/*
 * solved!
 * https://www.acmicpc.net/problem/1181
 */
import java.util.Scanner;
import java.util.Comparator;

public class word_order {
	public static String[] list;
	public static int len;
	public static String[] slist;	

	public static void Input() {
		Scanner sc = new Scanner(System.in);
		len = sc.nextInt();
		list = new String[len];
		sc.nextLine(); 
		for (int i=0;i<len;i++) {
			list[i]=sc.nextLine();
		}
		sc.close();
	}
    public static void sorting() {
    	List<String> slist = Arrays.asList(list);
    	slist.sort(Comparator.comparing(String::length).thenComparing(String::compareTo));
    	slist.stream().distinct().forEach(System.out::println);
    }
//	public static void sort() {
//		Arrays.sort(list);
//		System.out.println("");
//		List<String> output = Arrays.asList(list);
//		output.stream().forEach(System.out::println);
//		slist = new String[len];
//		for (int i=0;i<list.length;i++) {
//			slist[i] = list[i];	
//			for (int j=i;j<list.length;j++) {
//				if(list[j].length()<slist[i].length()) {
//					String temp = list[j];
//					list[j] = slist[i];
//					slist[i] = temp;
//				}
//			}
//		}
//		System.out.println("");
//		List<String> output1 = Arrays.asList(slist);
//		output1.stream().forEach(System.out::println);
//	}
//	public static void arrayprint() {
//		List<String> output = Arrays.asList(slist);
//		output.stream().distinct().forEach(System.out::println);
//	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Input();
		sorting();
	}
}

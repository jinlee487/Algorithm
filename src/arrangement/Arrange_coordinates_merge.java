package arrangement;

import java.util.Scanner;

/*
 * solved!
 * https://www.acmicpc.net/problem/2751
 * https://javannspring.tistory.com/242
 * 수 정렬하기 2
 */
public class Arrange_coordinates_merge {
    static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		int[] arr = new int[N];
		String[] yarr = new String[200000];
		String[] temp_string = new String[2];
		int idx = 0;
		String input;
		int x;
		while(idx<N) {
			input = sc.nextLine();
			temp_string = input.split(" ");
			x = Integer.parseInt(temp_string[0]);
			arr[idx]= x;
			if (yarr[x]==null)
				yarr[x]="";
			yarr[x] = yarr[x] +" "+ Integer.toString(Integer.parseInt(temp_string[1])-100000);
			idx++;
		}
		sc.close();
		arr=mergeSort(arr);
		String[] temp;
		for (int i=0;i<yarr.length;i++) {
			if(yarr[i]!=null)
			{
				temp=(yarr[i].substring(1)).split(" ");
				
			}
		}
		for(int i=0;i<N;i++)
			sb.append(arr[i]+" "+yarr[i].substring(1)+"\n");
		System.out.println(sb);
	}
	static int[] mergeSort(int[] arr) {
		if(arr.length==1)
			return arr;
		else {
			int midA=(int)arr.length/2;
			int midB=arr.length-midA;
			
			int arrA[] = new int[midA];
			int arrB[] = new int[midB];
			// public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
			System.arraycopy(arr,0,arrA,0,midA);
			System.arraycopy(arr,midA,arrB,0,midB);
			
			arrA = mergeSort(arrA);
			arrB = mergeSort(arrB);
			
			arr = mergeOperator(arrA,arrB);
		}
		return arr;
	}
	
	static int[] mergeOperator(int[] arrA, int[] arrB) {
		int length = arrA.length+arrB.length;
		int[] mergeArr = new int[length];
		int idx = 0;
		int idxA = 0;
		int idxB = 0;
		
		while(idxA<arrA.length&&idxB<arrB.length) {
			if(arrA[idxA]<arrB[idxB]) {
				mergeArr[idx]=arrA[idxA];
				idx++;
				idxA++;
			}
			else {
				mergeArr[idx]=arrB[idxB];
				idx++;
				idxB++;
			}
		}
	    if(idxA<arrA.length) {
	        System.arraycopy(arrA, idxA, mergeArr, idx, length-idx);
	    }
	    else if(idxB<arrB.length) {
	        System.arraycopy(arrB, idxB, mergeArr, idx, length-idx);
	    }
	 
	 
	    return mergeArr;
	}

}


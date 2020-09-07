package arrangement;

import java.util.Scanner;

/*
 * solved!
 * https://www.acmicpc.net/problem/2751
 * https://javannspring.tistory.com/242
 * 수 정렬하기 2
 */
public class num_order_2_merge_sort {
    static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int idx = 0;
		while(idx<N) {
			arr[idx]=sc.nextInt();
			idx++;
		}
		sc.close();
		arr=mergeSort(arr);
		for(int i=0;i<N;i++)
			sb.append(arr[i]+"\n");
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


package arrangement;
/*
 * Solved!
 * https://www.acmicpc.net/problem/11650
 * 좌표 정렬하기
 * https://joshuajangblog.wordpress.com/2016/09/21/time_complexity_big_o_in_easy_explanation/
 * https://www.acmicpc.net/board/view/31887 
 * 병합 정렬을 할 때, merge를 수행할 때마다 배열의 전체 크기, 
 * 혹은 right만큼을 할당하고 해제하기를 반복하면 안 됩니다. 
 * 크기가 N인 메모리를 할당하는 것은 O(N) 시간이 걸리고, 
 * merge가 O(N)번 호출되기 때문에 총 시간복잡도가 O(N^2)이 됩니다. 
 * 이를 해결하기 위한 방법으로는,
 * 복사를 하기 위한 큰 배열 하나를 미리 할당해두고 계속 사용
 * merge가 담당하는 구간의 크기(right - left + 1)만큼만 메모리를 할당 등이 있습니다.
 * 힙 정렬은 복잡한 편입니다. 
 * 힙 정렬이 요구하는 것이 무엇인지 정확하게 알고 사용해야 합니다. 
 * 힙 정렬에서 시간 초과가 났다면 힙 정렬에서 해야 할 일을 정확하게 하지 않고 비효율적인 연산들을 했을 가능성이 매우 높습니다.
 * https://fbtmdwhd33.tistory.com/85
 * https://mygumi.tistory.com/308
 */
import java.util.Scanner;

public class Arrange_coordinates_quick_sort {
	
	static int[] yarray;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 
		 int n =sc.nextInt();
		 int arr[] = new int[n];
		 yarray = new int[n];
		 for(int i=0;i<n;i++) {
			 arr[i] = sc.nextInt();
			 yarray[i] = sc.nextInt();
		 }
		 sc.close();
		 quicksort(arr,0,n-1);
	       
		 for(int i=0;i<n;i++) {
				sb.append(arr[i]+" "+yarray[i]+"\n");
		 }
		System.out.println(sb);
     
	}
	
	public static int partition(int[] array, int left, int right) { // 구분점을 만드는 메소드
	    int mid = (left + right) / 2; // 원소의 중앙값을 첫 번째 원소와 교환하기 위함
	    swap(array, left, mid); // 중앙 값을 첫 번째 요소로 이동
	 
	    int pivot = array[left]; // 첫 번째 인덱스가 pivot이 된다.
	    
        int i = left, j = right;
	 
	    while (i < j) { // left < right 즉, 교차하기 전 까지 반복한다.
	        while (pivot < array[j]) { // j는 오른쪽에서 왼쪽으로 피봇보다 작거나 같은 값을 찾는다.
	            j--;
	        }
	 
	        while (i < j && pivot >= array[i]) { // i는 왼쪽에서 오른쪽으로 피봇보다 큰 값을 찾는다.
	            i++;
	        }
	        swap(array, i, j); // 찾은 i와 j를 교환
	    }
	    // 반복문을 벗어난 경우는 i와 j가 만난경우
	    // 피봇과 교환
	    array[left] = array[i]; // 어차피 i와 j가 만나기 때문에 i 또는 j를 사용하면 된다.
	    array[i] = pivot; // array[left]값을 담아 둔 pivot을 구분점의 요소에 저장
	    return i; // 구분점이 되는 인덱스를 반환한다.
	}
	 
	public static void swap(int[] array, int a, int b) { // 단순 swap 메소드
	    int temp;
		if (array[b] != array[a]) {
	    	temp = yarray[b];
		    yarray[b] = yarray[a];
		    yarray[a] = temp;
		    System.out.println("different x");
	    }
	    else {
	    	if(yarray[a]>yarray[b]) {
		    	temp = yarray[b];
			    yarray[b] = yarray[a];
			    yarray[a] = temp;
			    System.out.println("same x ");
	    	}
	    }
	    temp = array[b];
	    array[b] = array[a];
	    array[a] = temp;  
	    System.out.println("x=> "+ array[a]+" "+array[b]+" y=> "+yarray[a]+" "+yarray[b]);
	}
	 
	public static void quicksort(int[] array, int left, int right) { // 실질적인 quickSort 재귀호출을 이룬다.
	    if (left >= right) { // 이 경우는 비교할 요소가 한 개일 경우이므로 메소드를 종료한다.
	        return;
	    }
	 
	    int pi = partition(array, left, right); // 위의 메소드를 통해서 구한 구분점을 저장
	    quicksort(array, left, pi - 1); // left부터 구분점 전까지 다시 한 번 재귀호출
	    quicksort(array, pi + 1, right); // 구분점 다음부터 right까지 다시 한 번 재귀호출
	}
}
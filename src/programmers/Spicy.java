package programmers;

import java.util.LinkedList;

public class Spicy {

	public static void main(String[] args) {
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int k = 7;
		System.out.println(solution(scoville, k));
	}
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        int mix=0;
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i=0;i<scoville.length;i++) {
        	list.add(scoville[i]);
        }

        for (int i=0;i<list.size();i++) {
        	sort(list);
        	if(list.get(i)<K) {
        		mix = list.get(i)+list.get(i+1)*2;
        		list.set(i+1, mix);
        		list.remove(i);
        		i--;
        	}
        }
        
        System.out.println(list.toString());
        
        printArray(scoville);
        return answer;
    }
   public static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
    } 
   
   public static void sort(LinkedList<Integer> list) 
    { 
        int n = list.size(); 

        // Build heap (rearrange array) 
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(list, n, i); 
        }
        // One by one extract an element from heap 
        for (int i=n-1; i>0; i--) 
        { 
            // Move current root to end 
            int temp = list.get(0); 
            list.set(0, list.get(i)); 
            list.set(i, temp); 
            // call max heapify on the reduced heap 
            heapify(list, i, 0); 
        } 
    } 
  
    // To heapify a subtree rooted with node i which is 
    // an index in arr[]. n is size of heap 
   public static void heapify(LinkedList<Integer> list, int n, int i) 
    { 
        int largest = i; // Initialize largest as root 
        int l = 2*i + 1; // left = 2*i + 1 
        int r = 2*i + 2; // right = 2*i + 2 
        
        // If left child is larger than root 
        if (l < n && list.get(l) > list.get(largest)) {
            largest = l; 
        }
        // If right child is larger than largest so far 
        if (r < n && list.get(r) > list.get(largest)) {
            largest = r; 
        }
        // If largest is not root 
        if (largest != i) 
        { 		  
        	
            int swap = list.get(i); 
            list.set(i, list.get(largest)); 
            list.set(largest, list.get(swap)); 
            
            
            // Recursively heapify the affected sub-tree 
            heapify(list, n, largest); 
        } 
    } 

}

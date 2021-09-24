package algoexpert.easy.BinarySearch;

import java.util.*;

class Program {
    public static int binarySearch(int[] array, int target) {
        // Write your code here.
        return binarySearchRecursive(array,target, 0, array.length -1);
    }
	public static int binarySearchRecursive(int[] array, int target, int left, int right){
		if(left>right) return -1;
		int mid = (left + right)/2;
		if(array[mid] == target) return mid;
		else if(target < array[mid]) return binarySearchRecursive(array, target, left, mid -1);
		else return binarySearchRecursive(array,target, mid + 1, right);
	}
    public static int binarySearchIterative(int[] array, int target, int left, int right){
		while(left <= right) {
			int mid = (left + right) / 2;
			if (target == array[mid]) return mid;
			else if (target < array[mid]) right = mid - 1;
			else left = mid + 1; 
		}
		return -1;
	}
}

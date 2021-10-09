package algoexpert.medium.MinHeightBst;

import java.util.*;

class Program {
    // public static BST minHeightBst(List<Integer> array) {
    //     // Write your code here.
    //     // O(nlog(n)) time | O(n) space
    //     return minHeightBst(array,null,0,array.size()-1);
    // }
    // public static BST minHeightBst(List<Integer> array, BST bst, int start, int end){
    //     if(end < start) return null;
    //         int mid = (start + end)/2;
    //         int value = array.get(mid);
    //     if(bst == null){
    //         bst = new BST(value);
    //     } else {
    //         bst.insert(value);
    //     }
    //     minHeightBst(array,bst,start,mid-1);
    //     minHeightBst(array,bst,mid+1,end);
    //     return bst;
    // }
    // public static BST minHeightBst(List<Integer> array) {
    //     // Write your code here.
    //     // O(n) time | O(n) space
    //     return minHeightBst(array, null, 0, array.size()-1);
    // }
    // public static BST minHeightBst(List<Integer> array, BST bst, int start, int end){
    //     if(end<start) return null;
    //     int mid = (start + end)/2;
    //     BST newBst = new BST(array.get(mid));
    //     if(bst == null){
    //         bst = newBst;
    //     } else {
    //         if(array.get(mid) < bst.value){
    //             bst.left = newBst;
    //             bst = bst.left;
    //         } else {
    //             bst.right = newBst;
    //             bst = bst.right;
    //         }
    //     }
    //     minHeightBst(array, bst, start, mid - 1);
    //     minHeightBst(array, bst, mid + 1, end);
    //     return bst;
    // }
    public static BST minHeightBst(List<Integer> array) {
        // Write your code here.
        // O(n) time | O(n) space
        return minHeightBst(array, 0, array.size() -1);
    }
    public static BST minHeightBst(List<Integer> array, int start, int end){
        if(end < start) return null;
        int mid = (start+end)/2;
        BST bst = new BST(array.get(mid));
        bst.left = minHeightBst(array, start, mid -1);
        bst.right = minHeightBst(array, mid + 1, end);
        return bst;
    }
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                left = new BST(value);
                } else {
                left.insert(value);
                }
            } else {
                if (right == null) {
                right = new BST(value);
                } else {
                right.insert(value);
                }
            }
        }
    }
}

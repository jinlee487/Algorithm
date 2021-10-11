package algoexpert.medium.FindKthLargestValueInBst;

import java.util.*;

class Program {
    // This is an input class. Do not edit.
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
        this.value = value;
        }
    }
    // o(n) time | o(n) space 
    public int findKthLargestValueInBst(BST tree, int k) {
        // Write your code here.
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            findKthLargestValueInBst(tree,arrayList);
            return arrayList.get(k-1);
    }
    public void findKthLargestValueInBst(BST tree, ArrayList<Integer> arrayList){
        if(tree == null) return;
        
        findKthLargestValueInBst(tree.right,arrayList);
        arrayList.add(tree.value);
        findKthLargestValueInBst(tree.left,arrayList);
        return;
    }
}

class Program1 {
    // This is an input class. Do not edit.
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
        this.value = value;
        }
    }
    static class Node {
        public int count;
        public int value;
        public Node(int count, int value) {
            this.count = count;
            this.value = value;
        }
    }
    public int findKthLargestValueInBst(BST tree, int k) {
        // Write your code here.
            // O(h+k) time | O(h) space - height of the tree
            Node node = new Node(0,-1);
        findKthLargestValueInBst(tree,k, node);
            return node.value;
    }
    public void findKthLargestValueInBst(BST tree, int k, Node node){
        if(tree == null || node.count >= k) return;
        findKthLargestValueInBst(tree.right,k,node);
        if(node.count < k){
            node.count += 1;
            node.value = tree.value;
            findKthLargestValueInBst(tree.left, k , node);
        }
        return;
    }
}       


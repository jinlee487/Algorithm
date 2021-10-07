package algoexpert.medium.ValidateBst;

import java.util.*;

class Program {
    public static boolean validateBst(BST tree) {
        // Write your code here.
            return validateBst(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
        public static boolean validateBst(BST tree, int minimum, int maximum){
            
            if(minimum<=tree.value && tree.value < maximum){
                if(tree.left != null){
                    if(!validateBst(tree.left,minimum,tree.value)){
                        return false;
                    }
                } 
                if(tree.right != null) {
                    if(!validateBst(tree.right,tree.value,maximum)){
                        return false;
                    }
                }
            } else {
                return false;
            }
            return true;
        }
            

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
        this.value = value;
        }
    }
}

class Program1 {
    public static boolean validateBst(BST tree) {
        // Write your code here.
        return validateBst(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
        public static boolean validateBst(BST tree, int minimum, int maximum){
            if(tree.value < minimum || tree.value >= maximum) {
                return false;
            }
            if(tree.left != null && !validateBst(tree.left, minimum, tree.value)){
                return false;
            }
            if(tree.right != null && !validateBst(tree.right, tree.value, maximum)){
                return false;
            }
            return true;
        }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
        this.value = value;
        }
    }
}

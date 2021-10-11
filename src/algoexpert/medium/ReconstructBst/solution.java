package algoexpert.medium.ReconstructBst;
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
    static class TreeInfo {
        public int rootIdx;
        public TreeInfo(int rootIdx){
            this.rootIdx = rootIdx;
        }
    }
    public BST reconstructBst(List<Integer> preOrderTraversalValues) {
        // Write your code here.
        // O(n) time | O(n) space
        TreeInfo treeInfo = new TreeInfo(0);
        return reconstrucBst(Integer.MIN_VALUE,Integer.MAX_VALUE, preOrderTraversalValues, treeInfo);
    }
    public BST reconstrucBst(int lowerBound,int upperBound, List<Integer> preOrderTraversalValues,TreeInfo treeInfo) {
        if(treeInfo.rootIdx == preOrderTraversalValues.size()){
            return null;
        }	
        int rootValue = preOrderTraversalValues.get(treeInfo.rootIdx);
        if(rootValue < lowerBound || rootValue >= upperBound){
            return null;
        }
        treeInfo.rootIdx += 1;
        BST bst = new BST(rootValue);
        bst.left = reconstrucBst(lowerBound,rootValue,preOrderTraversalValues,treeInfo);
        bst.right = reconstrucBst(rootValue,upperBound,preOrderTraversalValues,treeInfo);
        return bst;
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

    public BST reconstructBst(List<Integer> preOrderTraversalValues) {
        // Write your code here.
        // O(n^2) time | O(n) space
        if(preOrderTraversalValues.size() == 0){
            return null;
        }
        int currentValue = preOrderTraversalValues.get(0);
        int rightSubTreeRootIdx = preOrderTraversalValues.size();
        
        for(int i=1;i<rightSubTreeRootIdx;i++){
            int value = preOrderTraversalValues.get(i);
            if(value >= currentValue){
                rightSubTreeRootIdx = i;
                break;
            }
        }
        BST bst = new BST(currentValue);
        bst.left = reconstructBst(preOrderTraversalValues.subList(1,rightSubTreeRootIdx));
        bst.right = reconstructBst(preOrderTraversalValues.subList(rightSubTreeRootIdx,preOrderTraversalValues.size()));
        return bst;
    }
}

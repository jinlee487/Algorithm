package algoexpert.easy.BranchSums;
import java.util.*;

public class solutions {
    // This is the class of the input root. Do not edit it.
    // my version
	static ArrayList<Integer> answer;

    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;
  
        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    
    public static List<Integer> branchSums(BinaryTree root) {
        // Write your code here.
        answer = new ArrayList<Integer>();
        int sum = 0;
        branchSums(root, sum);
      return answer;
    }
    public static void branchSums(BinaryTree root, int sum){
        sum += root.value;
        if(root.left != null){
            branchSums(root.left, sum);
        }
        if(root.right != null){
            branchSums(root.right, sum);
        }
        if(root.left == null && root.right == null){
            answer.add(sum);
        }
        return;
    }
    // solution. Does not need to use static because the pointer for sums. 
    public static List<Integer> calculateBranchSums(BinaryTree root) {
        // Write your code here.
        List<Integer> sums = new ArrayList<Integer>();
        calculateBranchSums(root,0,sums);
        return sums;
    }
    public static void calculateBranchSums(BinaryTree node, int runningSum, List<Integer> sums) {
        if (node == null) return;
        int newRunningSum = runningSum + node.value;
        if(node.left == null && node.right == null){
            sums.add(newRunningSum);
            return;
        }
        calculateBranchSums(node.left, newRunningSum, sums);
        calculateBranchSums(node.right, newRunningSum, sums);
    }
}

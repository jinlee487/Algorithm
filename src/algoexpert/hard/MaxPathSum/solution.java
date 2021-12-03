package algoexpert.hard.MaxPathSum;
import java.util.*;

class Program2 {
  public static int maxPathSum(BinaryTree tree) {
    // Write your code here.
    // O(n) time | O(log(n)) space
		int[] answer = maxPathSumHelper(tree);
    return Math.max(answer[0],answer[1]);
  }
	public static int[] maxPathSumHelper(BinaryTree node){
		if(node == null) return new int[] {Integer.MIN_VALUE,0};
		int[] left = maxPathSumHelper(node.left);
		int[] right = maxPathSumHelper(node.right);
		int[] mps = {node.value, node.value};
		mps[0] = Math.max(mps[0],Math.max(mps[0]+right[1]+left[1],Math.max(mps[0]+right[1],mps[0]+left[1])));
		mps[0] = Math.max(mps[0],Math.max(left[0],right[0]));
		mps[1] = Math.max(node.value,Math.max(right[1]+node.value,left[1]+node.value));
		return mps;
	}

  static class BinaryTree {
    public int value;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree(int value) {
      this.value = value;
    }
  }
}

class Program1 {
  public static int maxPathSum(BinaryTree tree) {
    // Write your code here.
		// O(n+nlog(n)) time | O(n) space
		PriorityQueue<Integer> answer = new PriorityQueue<Integer>(Collections.reverseOrder());
    answer.add(maxPathSum(tree,answer));
		return answer.poll();
  }
	public static int maxPathSum(BinaryTree node, PriorityQueue<Integer> answer) {
		if(node == null) return 0;
		int left = maxPathSum(node.left,answer);
		int right = maxPathSum(node.right,answer);
		int current = node.value;
		int sum = current;
		if(0<left) sum += left;
		if(0<right) sum += right;
		answer.add(sum);
		return Math.max(left,right) + current;
	}

  static class BinaryTree {
    public int value;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree(int value) {
      this.value = value;
    }
  }
}

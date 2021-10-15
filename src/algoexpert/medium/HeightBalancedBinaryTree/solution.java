package algoexpert.medium.HeightBalancedBinaryTree;



import java.util.*;

class Program {
  // This is an input class. Do not edit.
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }
static class TreeInfo{
	public boolean isBalanced;
	public int height;
	public TreeInfo(boolean isBalanced, int height) {
		this.isBalanced = isBalanced;
		this.height = height; 
	}
}
  public boolean heightBalancedBinaryTree(BinaryTree tree) {
    // Write your code here.
		TreeInfo treeInfo = getTreeInfo(tree);
    return treeInfo.isBalanced;
  }
	public TreeInfo getTreeInfo(BinaryTree node){
		if(node == null) return new TreeInfo(true, -1);
		TreeInfo left = getTreeInfo(node.left);
		TreeInfo right = getTreeInfo(node.right);
		boolean isBalanced = left.isBalanced && right.isBalanced 
												&& Math.abs(left.height - right.height) <= 1;
		int height = Math.max(left.height, right.height) + 1;
		return new TreeInfo(isBalanced, height);
	}
}

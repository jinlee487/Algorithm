package algoexpert.medium.BinaryTreeDiameter;

import java.util.*;

class Program {
  // This is an input class. Do not edit.
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;
		public int diameter;
		public int height;
    public BinaryTree(int value) {
      this.value = value;
    }
		public BinaryTree(int diameter, int height, int value) {
      this.diameter = diameter;
      this.height = height;
			this.value = value;
    }
  }

  public int binaryTreeDiameter(BinaryTree tree) {
    // Write your code here.
    return binaryTreeDiameterHelper(tree).diameter;
  }
	public BinaryTree binaryTreeDiameterHelper(BinaryTree tree){
		if(tree == null) {
			return new BinaryTree(0,0,0);
		}
		BinaryTree left = binaryTreeDiameterHelper(tree.left);
		BinaryTree right = binaryTreeDiameterHelper(tree.right);
		
		int longestPath = left.height + right.height;
		int maxDiameter = Math.max(left.diameter,right.diameter);
		int currentDiameter = Math.max(longestPath,maxDiameter);
		int currentHeight = 1 + Math.max(left.height,right.height);
		return new BinaryTree(currentDiameter, currentHeight, tree.value);
		
	}
}

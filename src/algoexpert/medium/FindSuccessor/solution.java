package algoexpert.medium.FindSuccessor;
import java.util.*;

class Program {
  // This is an input class. Do not edit.
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;
    public BinaryTree parent = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
    // Write your code here.
		// O(n) time | O(n) space iterative
		ArrayList<BinaryTree> arrayList = new ArrayList<BinaryTree>();
		findSuccessorHelper(tree, arrayList);
		for(int i=0;i<arrayList.size();i++){
			BinaryTree current = arrayList.get(i);
			if(current != node) continue;
			if(i == arrayList.size() - 1) return null;
			return arrayList.get(i+1);
		}
    return null;
  }
	public void findSuccessorHelper(BinaryTree tree, ArrayList<BinaryTree> arrayList){
		if(tree == null) return;
		findSuccessorHelper(tree.left, arrayList);
		arrayList.add(tree);
		findSuccessorHelper(tree.right, arrayList);
	}
}

class Program1 {
  // This is an input class. Do not edit.
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;
    public BinaryTree parent = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
    // Write your code here.
		// O(h) time | O(1) space h is the height of the tree. recursive
		if(node.right != null) return leftChild(node.right);
		return rightParent(node);
  }
	public BinaryTree leftChild(BinaryTree node){
		BinaryTree current = node;
		while(current.left != null){
			current = current.left;
		}
		return current;
	}
	public BinaryTree rightParent(BinaryTree node){
		BinaryTree current = node;
		while(current.parent != null && current.parent.right == current){
			current = current.parent; 
		}
		return current.parent;
	}
}

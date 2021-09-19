package algoexpert.easy.findClosestValueInBst;
import java.util.*;

class solution {
	public static int findClosestValueInBst(BST tree, int target) {
	// Write your code here.
		// Avergae: 0(log(n)) time | 0(log(n)) space
		// worst: 0(n) time | 0(n) space
	return findClosestValueInBstRecursive(tree, target, tree.value);
	// return findClosestValueinBstIterative(tree, target, tree.value);
	}
	static int findClosestValueInBstRecursive(BST tree, int target, int closest){
		if(Math.abs(tree.value - target) < Math.abs(closest - target)){
			closest = tree.value;
		} 
		if(target < tree.value && tree.left != null){
			return findClosestValueInBstRecursive(tree.left, target, closest);
		} else if(target > tree.value && tree.right != null){
			return findClosestValueInBstRecursive(tree.right, target, closest);
		} else {
			return closest;
		}
	}
	public static int findClosestValueinBstIterative(BST tree, int target, int closest){
		BST currentNode = tree;
		while (currentNode != null){
			if(Math.abs(currentNode.value - target) < Math.abs(closest - target)){
				closest = currentNode.value;
			}
			if(target < currentNode.value){
				currentNode = currentNode.left;
			} else if(target > currentNode.value){
				currentNode = currentNode.right;
			} else { 
				break;
			}
		}
		return closest;
	}
	static class BST {
	public int value;
	public BST left;
	public BST right;

	public BST(int value) {
		this.value = value;
	}
		@Override
		public String toString(){
			return "value: " + value + " left: " + left + " right: " + right;
		}
	}
}


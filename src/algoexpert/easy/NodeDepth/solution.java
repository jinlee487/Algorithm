package algoexpert.easy.NodeDepth;


import java.util.*;

class Program {

    static class BinaryTree {

        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
    
    // **************recursive approach******************

    static int sum1;
    public static int nodeDepthsRecursive1(BinaryTree root) {
    // Write your code here.
        sum1 = 0; 
        calculateNodeDepths1(root, -1);
        return sum1;
    }
        
    public static void calculateNodeDepths1(BinaryTree node, int depth){
        if(node == null) return; 
        depth += 1;
        //System.out.println("depth: " + depth + " node: "+ node.value);
        sum1 += depth;
        calculateNodeDepths1(node.left, depth);
        calculateNodeDepths1(node.right, depth);
        return;     
    }

    public static int nodeDepthsRecursive2(BinaryTree root) {
        // Write your code here.
        return calculateNodeDepths2(root, 0);
    }

    public static int calculateNodeDepths2(BinaryTree node, int depth){
        if(node == null) return 0;
        return depth + calculateNodeDepths2(node.left, depth + 1) + calculateNodeDepths2(node.right, depth + 1);
    }

    // *********************iterative approach************************
    public static int nodeDepthsIterative(BinaryTree root) {
        // Write your code here
        // iterative.
        int sum = 0;
        Stack<Level> stack = new Stack<Level>();
        stack.add(new Level(root, 0));
        while(!stack.isEmpty()){
            Level top = stack.pop();
            BinaryTree node = top.root;
            int depth = top.depth;
            if(node == null) continue;
            sum += depth;
            stack.add(new Level(node.left, depth +1 ));
            stack.add(new Level(node.right, depth +1 ));
        }
        return sum;
    }

    static class Level {

        public BinaryTree root; 
        int depth;

        public Level(BinaryTree root, int depth){
            this.root = root; 
            this.depth = depth;
        }
    }
}

package algoexpert.medium.BreadthFirstSearch;

import java.util.*;

class Program {
  // Do not edit the class below except
  // for the breadthFirstSearch method.
  // Feel free to add new properties
  // and methods to the class.
  static class Node {
    String name;
    List<Node> children = new ArrayList<Node>();

    public Node(String name) {
      this.name = name;
    }

    public List<String> breadthFirstSearch(List<String> array) {
      // Write your code here.
			// O(v+e) time | O(v) space
			Queue<Node> que = new LinkedList<Node>();
			que.add(this);
			while(!que.isEmpty()){
				Node current = que.poll();
				array.add(current.name);
				que.addAll(current.children);
			}
      return array;
    }

    public Node addChild(String name) {
      Node child = new Node(name);
      children.add(child);
      return this;
    }
  }
}

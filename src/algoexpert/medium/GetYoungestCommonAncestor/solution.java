package algoexpert.medium.GetYoungestCommonAncestor;

import java.util.*;

class Program {
  public static AncestralTree getYoungestCommonAncestor(
      AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
    // Write your code here.\
		// O(d) time | O(d) space
		HashSet<AncestralTree> set = new HashSet<AncestralTree>();
		set.add(topAncestor);
		getYoungestCommonAncestor(set,descendantOne);
    return getYoungestCommonAncestor(set,descendantTwo); // Replace this line
  }
	public static AncestralTree getYoungestCommonAncestor(HashSet<AncestralTree> set, AncestralTree descendant){
		if(set.contains(descendant)) return descendant;
		set.add(descendant);
		return getYoungestCommonAncestor(set,descendant.ancestor);
	}
  static class AncestralTree {
    public char name;
    public AncestralTree ancestor;
	
    AncestralTree(char name) {
      this.name = name;
      this.ancestor = null;
    }
		public char getName(){
			return this.name;
		}
    // This method is for testing only.
    void addAsAncestor(AncestralTree[] descendants) {
      for (AncestralTree descendant : descendants) {
        descendant.ancestor = this;
      }
    }
  }
}

class Program1 {
    public static AncestralTree getYoungestCommonAncestor(
        AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
      // Write your code here.
          // O(d) time | O(1) space
          int depthOne = getDepth(descendantOne,topAncestor);
          int depthTwo = getDepth(descendantTwo,topAncestor);
          if(depthOne>depthTwo) return backtrackAncestralTree(descendantOne,descendantTwo,depthOne-depthTwo);
          else return backtrackAncestralTree(descendantTwo,descendantOne,depthTwo-depthOne);
    }
      public static int getDepth(AncestralTree descendant, AncestralTree topAncestor){
          int depth = 0;
          while(descendant != topAncestor){
              depth ++;
              descendant = descendant.ancestor;
          }
          return depth;
      }
  public static AncestralTree backtrackAncestralTree(AncestralTree lowerDescendant, AncestralTree higherDescendant, int diff){
      while(diff>0){
          lowerDescendant = lowerDescendant.ancestor;
          diff--;
      }
      while(lowerDescendant != higherDescendant){
          lowerDescendant = lowerDescendant.ancestor;
          higherDescendant = higherDescendant.ancestor;
      }
      return lowerDescendant;
  }
    static class AncestralTree {
      public char name;
      public AncestralTree ancestor;
  
      AncestralTree(char name) {
        this.name = name;
        this.ancestor = null;
      }
  
      // This method is for testing only.
      void addAsAncestor(AncestralTree[] descendants) {
        for (AncestralTree descendant : descendants) {
          descendant.ancestor = this;
        }
      }
    }
  }
  
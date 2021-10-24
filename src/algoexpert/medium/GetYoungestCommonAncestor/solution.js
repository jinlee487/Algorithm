// This is an input class. Do not edit.
class AncestralTree {
    constructor(name) {
      this.name = name;
      this.ancestor = null;
    }
  }
  
  function getYoungestCommonAncestor(topAncestor, descendantOne, descendantTwo) {
    // Write your code here.
      const set = new Set();
      set.add(topAncestor);
      getYoungestCommonAncestorHelper(descendantOne,set);
      return getYoungestCommonAncestorHelper(descendantTwo,set);
  }
  function getYoungestCommonAncestorHelper(descendant, set){
      if(set.has(descendant)) return descendant;
      set.add(descendant);
      return getYoungestCommonAncestorHelper(descendant.ancestor,set);
  }

  // This is an input class. Do not edit.
class AncestralTree {
    constructor(name) {
      this.name = name;
      this.ancestor = null;
    }
  }
  
  function getYoungestCommonAncestor(topAncestor, descendantOne, descendantTwo) {
    // Write your code here.
      const depthOne = getDepth(descendantOne, topAncestor);
      const depthTwo = getDepth(descendantTwo, topAncestor);
      if(depthOne>depthTwo) return getYoungestCommonAncestorHelper(descendantOne, descendantTwo, depthOne-depthTwo);
      else return getYoungestCommonAncestorHelper(descendantTwo, descendantOne, depthTwo-depthOne);
  }
  function getDepth(descendant,top){
      let depth = 0;
      while(descendant !== top){
          descendant = descendant.ancestor;
          depth ++;
      }
      return depth;
  }
  function getYoungestCommonAncestorHelper(lower,upper,diff){
      while(diff>0){
          lower = lower.ancestor;
          diff--;
      }
      while(lower !== upper){
          lower = lower.ancestor;
          upper = upper.ancestor;
      }
      return lower;
  }
  // Do not edit the lines below.
  exports.AncestralTree = AncestralTree;
  exports.getYoungestCommonAncestor = getYoungestCommonAncestor;
  
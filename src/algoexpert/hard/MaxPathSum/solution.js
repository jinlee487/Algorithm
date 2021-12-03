function maxPathSum(tree) {
    // Write your code here.
      // O(nlog(n)+n) time | O(n) space
      const answer = [];
      answer.push(maxPathSumHelper(tree,answer));
      answer.sort((a,b) => b-a);
      return answer[0];
  }
  function maxPathSumHelper(node,answer){
      if(node === null) return 0;
      const left = maxPathSumHelper(node.left,answer);
      const right = maxPathSumHelper(node.right,answer);
      let mps = node.value;
      mps = Math.max(mps,Math.max(mps+left+right,Math.max(mps+left,mps+right)));
      answer.push(mps);
      return Math.max(left+node.value,right+node.value);
  }
  
  function maxPathSum(tree) {
    // Write your code here.
      
      const [a,b] = maxPathSumHelper(tree);
      return Math.max(a,b);
  }
  function maxPathSumHelper(node){
      if(node === null) return [-Infinity,0];
      const left = maxPathSumHelper(node.left);
      const right = maxPathSumHelper(node.right);
      const mps = [node.value,node.value];
      mps[0] = Math.max(mps[0],Math.max(mps[0]+left[1]+right[1],Math.max(mps[0]+left[1],mps[0]+right[1])));
      mps[0] = Math.max(mps[0],Math.max(left[0],right[0]));
      mps[1] = Math.max(mps[1],Math.max(left[1]+mps[1],right[1]+mps[1]));
      return mps;
  }
  
  // Do not edit the line below.
  exports.maxPathSum = maxPathSum;
  
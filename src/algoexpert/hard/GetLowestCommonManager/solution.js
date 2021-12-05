function getLowestCommonManager(topManager, reportOne, reportTwo) {
    // Write your code here.
      return getOrgInfo(topManager, reportOne, reportTwo).lowestCommonManager;
  }
  function getOrgInfo(node,reportOne, reportTwo){
      let count = 0;
      for(const child of node.directReports){
          const orgInfo = getOrgInfo(child,reportOne, reportTwo);
          if(!!orgInfo.lowestCommonManager) return orgInfo;
          count += orgInfo.count;
      }
      if(node === reportOne || node === reportTwo) count ++;
      const lowestCommonManager = count === 2 ? node : null;
      return {lowestCommonManager, count};
  }
  function getLowestCommonManager(topManager, reportOne, reportTwo) {
    // Write your code here.
      const arr1 = [topManager];
      const arr2 = [topManager];
      getLowestCommonManagerHelper(topManager, reportOne, arr1);
      getLowestCommonManagerHelper(topManager, reportTwo, arr2);
      let index = arr1.length < arr2.length ? arr1.length-1 : arr2.length-1;
      for(;0<=index;index--){
          if(arr1[index] === arr2[index]) break;
      }
      return arr1[index];
  }
  function getLowestCommonManagerHelper(node, target, array){
      if(node===null) return false;
      if(node===target) return true;
      for(let i=0;i<node.directReports.length;i++){
          array.push(node.directReports[i]);
          if(getLowestCommonManagerHelper(node.directReports[i], target, array)) return true;
          array.pop();
      }
      return false;
  }
  
  // This is an input class. Do not edit.
  class OrgChart {
    constructor(name) {
      this.name = name;
      this.directReports = [];
    }
  }
  
  // Do not edit the line below.
  exports.getLowestCommonManager = getLowestCommonManager;
  
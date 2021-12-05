package algoexpert.hard.GetLowestCommonManager;
import java.util.*;

class Program1 {
  public static OrgChart getLowestCommonManager(
      OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {
    // Write your code here.
		ArrayList<OrgChart> arr1 = new ArrayList<OrgChart>();
		ArrayList<OrgChart> arr2 = new ArrayList<OrgChart>();
		arr1.add(topManager);
		find(arr1, topManager, reportOne);
		arr2.add(topManager);
		find(arr2, topManager, reportTwo);
		int index = arr1.size()<arr2.size() ? arr1.size()-1 : arr2.size()-1;
		for(;0<=index;index--){
			OrgChart one = arr1.get(index);
			OrgChart two = arr2.get(index);
			if(one.equals(two)) break;
		}
    return  arr1.get(index); // Replace this line.
  }
	public static boolean find(ArrayList<OrgChart> array, OrgChart node, OrgChart target){
		if(node == null) return false;
		if(node.equals(target)) return true;
		List<OrgChart> children = node.directReports;
		for(int i=0;i<children.size();i++){
			array.add(children.get(i));
			if(find(array,children.get(i),target)) return true;
			array.remove(array.size()-1);
		}
		return false;
	}

  static class OrgChart {
    public char name;
    public List<OrgChart> directReports;

    OrgChart(char name) {
      this.name = name;
      this.directReports = new ArrayList<OrgChart>();
    }

    // This method is for testing only.
    public void addDirectReports(OrgChart[] directReports) {
      for (OrgChart directReport : directReports) {
        this.directReports.add(directReport);
      }
    }
  }
}

class Program2 {
  public static OrgChart getLowestCommonManager(
      OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {
    // Write your code here.
    return getOrgInfo(topManager,reportOne,reportTwo).common; // Replace this line.
  }
  public static OrgInfo getOrgInfo(
      OrgChart node, OrgChart reportOne, OrgChart reportTwo) {
    // Write your code here.
		// O(n) time | O(d) space
		int count = 0;
		for(OrgChart children : node.directReports){
			OrgInfo orgInfo = getOrgInfo(children, reportOne, reportTwo);
			if(orgInfo.common != null) return orgInfo;
			count += orgInfo.count;
		}
		if(node == reportOne || node == reportTwo) count ++;
		OrgChart common = count == 2 ? node : null;
		OrgInfo newOrgInfo = new OrgInfo(common, count);
		return newOrgInfo;
 }
	static class OrgInfo{
		public OrgChart common;
		int count;
		OrgInfo(OrgChart common, int count){
			this.common = common;
			this.count = count;
		}
	}
  static class OrgChart {
    public char name;
    public List<OrgChart> directReports;

    OrgChart(char name) {
      this.name = name;
      this.directReports = new ArrayList<OrgChart>();
    }

    // This method is for testing only.
    public void addDirectReports(OrgChart[] directReports) {
      for (OrgChart directReport : directReports) {
        this.directReports.add(directReport);
      }
    }
  }
}

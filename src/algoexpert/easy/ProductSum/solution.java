package algoexpert.easy.ProductSum;

import java.util.*;

class Program {
  // Tip: You can use `element instanceof ArrayList` to check whether an item
  // is an array or an integer.
  public static int productSum(List<Object> array) {
    // Write your code here.
		return productSum(array,1);
  }
	public static int productSum(List<Object> array, int depth){
		int sum = 0; 
		for(int i=0;i<array.size();i++){
			if(array.get(i) instanceof ArrayList){
				@SuppressWarnings("unchecked")
				ArrayList<Object> a = (ArrayList<Object>) array.get(i);
				sum += (productSum(a, depth + 1));
			} else {
				sum += (int) array.get(i);				
			}
		}
		return sum * depth; 
	}
}

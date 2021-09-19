package algoexpert.easy.TwoNumberSum;

import java.util.*;
// O(n^2) time
// class Program {
//   public static int[] twoNumberSum(int[] array, int targetSum) {
//     // Write your code here.
// 		Arrays.sort(array);
// 		for(int i=0;i<array.length-1;i++){
// 			for(int j=i+1;j<array.length;j++){
// 				if(array[i]+array[j] == targetSum){
// 					return new int[] {array[i], array[j]};
// 				}
// 			}
// 		}
//     return new int[0];
//   }
// }

// O(n) time 
class Program {
    public static int[] twoNumberSum(int[] array, int targetSum) {
      // Write your code here.
          Set<Integer> set = new HashSet<Integer>();
          for(int num: array){
              int temp = targetSum - num;
              if(set.contains(temp)){
                  return new int[] {temp, num};
              }
              else {
                  set.add(num);
              }
          }
      return new int[0];
    }
}

// O(nlog(n))
// class Program {
//     public static int[] twoNumberSum(int[] array, int targetSum) {
//       // Write your code here.
//           Arrays.sort(array);
//           int left = 0, right = array.length -1;
//           while(left<right){
//               int temp = array[left] + array[right];
//               if(temp == targetSum){
//                   return new int[] {array[left], array[right]};
//               }
//               else if(temp < targetSum){
//                   left += 1;
//               }
//               else if(temp > targetSum){
//                   right -= 1;
//               }
//           }
//       return new int[0];
//     }
// }
  

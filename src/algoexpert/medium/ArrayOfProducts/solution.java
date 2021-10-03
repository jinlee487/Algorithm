package algoexpert.medium.ArrayOfProducts;

import java.util.*;

class Program {
    public int[] arrayOfProducts(int[] array) {
        // Write your code here.
            int product = 1;
            int countZeroes = 0;
            for(int a : array){
                if(a == 0) {
                    countZeroes ++;
                    continue;
                }
                product *= a;
            }
            for(int i=0;i<array.length;i++){
                if(array[i] == 0 && countZeroes == 1) {
                    array[i] = product;
                } else if(countZeroes > 0) {
                    array[i] = 0;
                } else {
                    array[i] = product/array[i];
                }
            }
            
        return array;
    }
}


class Program1 {
    public int[] arrayOfProducts(int[] array) {
      // Write your code here.
          int[] answer = new int[array.length];
          int[] left = new int[array.length];
          int[] right = new int[array.length];
          
          int leftProduct = 1;
          int rightProduct = 1;
          
          for(int i=0;i<array.length;i++){
              left[i] = leftProduct;
              leftProduct *= array[i];
          }
          
          for(int i=array.length-1;0<=i;i--){
              right[i] = rightProduct; 
              rightProduct *= array[i];
          }
          for(int i=0; i<array.length; i++){
              answer[i] = left[i] * right[i];
          }
      return answer;
    }
}


class Program2 {
    public int[] arrayOfProducts(int[] array) {
      // Write your code here.
          int[] answer = new int[array.length]; 
          int[] left = new int[array.length]; 
          
          int leftProduct = 1;
          for(int i=0;i<array.length;i++){
              left[i] = leftProduct;
              leftProduct *= array[i];
          }
          int rightProduct = 1;
          for(int i=array.length-1;0<=i;i--){
              answer[i] = left[i] * rightProduct;
              rightProduct *= array[i];
          }
      return answer;
    }
}
  
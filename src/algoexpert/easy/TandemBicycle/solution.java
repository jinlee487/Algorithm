package algoexpert.easy.TandemBicycle;
import java.util.*;
public class solution {
    public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        // Write your code here.
        int answer=0;
        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);
        if(fastest) reverseArrayInPlace(blueShirtSpeeds);
        for(int i=0; i<blueShirtSpeeds.length; i++){
            if(redShirtSpeeds[i]<blueShirtSpeeds[i]) answer+=blueShirtSpeeds[i];
            else answer+=redShirtSpeeds[i];
        }
        return answer;
      }
    public void reverseArrayInPlace(int[] array){
        int start = 0; 
        int end = array.length - 1;
        while(start < end){
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}

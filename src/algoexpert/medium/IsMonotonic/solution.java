package algoexpert.medium.IsMonotonic;

class Program {
    public static boolean isMonotonic(int[] array) {
        // Write your code here.
        if(array.length==0||array.length==1) return true;
        int current = array[0];
        int end = array[array.length-1];
        if(current < end){
            for(int a : array){
                if(a  < current){
                    return false;
                }
                current = a;
            }
        } else if(end < current){
            for(int a : array){
                if(current < a){
                    return false;
                }
                current = a;
            }
        } else { 
            for(int a : array){
                if(current != a){
                    return false;
                }
                current = a;
            }
        }
        return true;
    }
}



class Program1 {
    public static boolean isMonotonic(int[] array) {
        // Write your code here.
        // O(n) time | O(1) space
        if (array.length <= 2) return true;
        var direction = array[1] - array[0];
        for (int i = 2; i < array.length; i++) {
            if (direction == 0) {
                direction = array[i] - array[i-1];
                continue;
            }
            var difference = array[i] - array[i-1];
            if (direction > 0){
                if(difference < 0){
                    return false;
                } 
            } else {
                if(difference > 0) {
                    return false;	
                }
            }
        }
            
        return true;
    }
}


class Program2 {
    public static boolean isMonotonic(int[] array) {
        // Write your code here.
        var isNonDecreasing = true;
        var isNonIncreasing = true;
        for (int i=1;i<array.length;i++){
            if(array[i] < array[i-1]){
                isNonDecreasing = false; 
            }
            if(array[i] > array[i-1]){
                isNonIncreasing = false;
            }
        }
        return isNonDecreasing || isNonIncreasing;
    }
}

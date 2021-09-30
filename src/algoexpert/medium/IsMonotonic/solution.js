function isMonotonic(array) {
    // Write your code here.
    if(array.length <=2) return true;
    let direction = array[1] - array[0];
    for(let i=2;i<array.length;i++){
        if(direction == 0) {
            direction = array[i] - array[i-1];
            continue;
        }
        const difference = array[i] - array[i-1];
        if(direction < 0){
            if(difference > 0 ){
                return false;
            }
        } else {
            if(difference < 0) {
                return false;
            }
        }
    }
    return true;
}
function isMonotonic(array) {
    // Write your code here.
    let isNonIncreasing = true;
    let isNonDecreasing = true; 
    for(let i=1;i<array.length;i++){
        if(array[i] < array[i-1]) isNonIncreasing = false;
        if(array[i] > array[i-1]) isNonDecreasing = false;
    }
    return isNonIncreasing || isNonDecreasing;
}

// Do not edit the line below.
exports.isMonotonic = isMonotonic;
  



  
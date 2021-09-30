function moveElementToEnd(array, toMove) {
    // Write your code here.
    let count = 0;
    const answer = [];
    for(const a of array) {
        if(a === toMove) count ++;
        else answer.push(a);
    }
    for(let i=0;i<count;i++){
        answer.push(toMove);
    }
    return answer; 
}
function moveElementToEnd(array, toMove) {
    // Write your code here.
    let left = 0;
    let right = array.length-1;
    while(left<right){
        while(left<right && array[right] === toMove) right--;
        if(array[left] === toMove) {
            let temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }
        left ++;
    }
    return array;
}

// Do not edit the line below.
exports.moveElementToEnd = moveElementToEnd;
  
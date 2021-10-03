function firstDuplicateValue(array) {
    // Write your code here.
    for(let i=0;i<array.length;i++){
        for(let j=0;j<i;j++){
            if(array[i]===array[j]) return array[j];
        }
    }
    return -1;
}

function firstDuplicateValue(array) {
    // Write your code here.
    const set = new Set();
    for(const a of array){
        if(set.has(a)){
            return a;
        } else {
            set.add(a);
        }
    }
    return -1;
}

function firstDuplicateValue(array) {
    // Write your code here.
    for(const a of array) { 
        const abs = Math.abs(a);
        if(array[abs-1]<0){
            return abs;
        }
        array[abs-1] *= -1;
    }
    return -1;
}
// Do not edit the line below.
exports.firstDuplicateValue = firstDuplicateValue;

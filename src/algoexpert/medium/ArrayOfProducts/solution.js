function arrayOfProducts(array) {
    // Write your code here.
    let product = 1;
    let countZeroes = 0;
    for(const num of array){
        if(num === 0){
            countZeroes ++;
            continue;
        } 
        product *= num;
    }
    for(let i=0;i<array.length;i++){
    if(array[i] === 0 && countZeroes === 1){
            array[i] = product;
        } else if(countZeroes > 0){
            array[i] = 0;
        } else {
            array[i] = product/array[i];
        }
    }
    return array;
}
function arrayOfProducts(array) {
    // Write your code here.
    const answer = [];
    const left = [];
    const right = [];
    let leftProduct = 1;
    let rightProduct = 1;
    for(let i=0;i<array.length;i++){
        left[i] = leftProduct;
        leftProduct *= array[i]; 
    }
    for(let i=array.length-1;0<=i;i--){
        right[i] = rightProduct;
        rightProduct *= array[i]; 
    }
    for(let i=0;i<array.length;i++){
        answer[i] = left[i] * right[i]; 
    }
    return answer; 
}

function arrayOfProducts(array) {
    // Write your code here.
    const answer = [];
    const left = [];
    let leftProduct = 1;
    let rightProduct = 1;
    
    for(let i=0;i<array.length;i++){
        left[i] = leftProduct;
        leftProduct *= array[i];
    }
    for(let i=array.length-1;0<=i;i--){
        answer[i] = left[i] * rightProduct;
        rightProduct *= array[i];
    }
    return answer; 
}

// Do not edit the line below.
exports.arrayOfProducts = arrayOfProducts;
   
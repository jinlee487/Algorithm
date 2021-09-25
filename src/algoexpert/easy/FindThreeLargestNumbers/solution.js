function findThreeLargestNumbers(array) {
    // Write your code here.
    array.sort((o1,o2) => o2 - o1);
    return [array[2], array[1], array[0]]
}
  
function findThreeLargestNumbers(array) {
// Write your code here.
    const answer = [null, null, null];
    for(const n of array){
        if(answer[2] === null || n > answer[2]) findThreeLargestNumberHelper(answer, n, 2);
        else if (answer[1] === null ||  n > answer[1]) findThreeLargestNumberHelper(answer, n, 1);
        else if (answer[0] === null ||  n > answer[0]) findThreeLargestNumberHelper(answer, n, 0);
    }
    return answer;
}

function findThreeLargestNumberHelper(answer, n, idx){
    for(let i=0;i<=idx;i++){
        if(i === idx){
            answer[i] = n;
        } else {
            answer[i] = answer[i+1];
        }
    }
}
  
// Do not edit the line below.
exports.findThreeLargestNumbers = findThreeLargestNumbers;

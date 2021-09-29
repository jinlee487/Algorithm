function smallestDifference(arrayOne, arrayTwo) {
    // Write your code here.
    const answer = [0,0];
    let diff = Infinity;
    for(let i=0;i<arrayOne.length;i++){
        for(let j=0;j<arrayTwo.length;j++){
            if(Math.abs(arrayOne[i] - arrayTwo[j])<diff){
                diff = Math.abs(arrayOne[i] - arrayTwo[j]);
                answer[0] = arrayOne[i];
                answer[1] = arrayTwo[j];
            }
        }
    }
    return answer;
  }
function smallestDifference(arrayOne, arrayTwo) {
    // Write your code here.
    arrayOne.sort((o1,o2)=>o1-o2);
    arrayTwo.sort((o1,o2)=>o1-o2);
    let idxOne = 0;
    let idxTwo = 0;
    let smallest = Infinity;
    let current = Infinity;
    const answer = [0,0];
    while(idxOne < arrayOne.length && idxTwo < arrayTwo.length){
        let first = arrayOne[idxOne];
        let second = arrayTwo[idxTwo];
        if(first < second){
            current = second - first;
            idxOne ++;
        } else if(second < first){
            current = first - second;
            idxTwo ++;
        } else {
            return [first, second];
        }
        if(current < smallest){
            smallest = current;
            answer[0] = first;
            answer[1] = second;
        }
    }
    return answer;
}

// Do not edit the line below.
exports.smallestDifference = smallestDifference;
  

  
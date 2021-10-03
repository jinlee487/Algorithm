function longestPeak(array) {
    // Write your code here.
    let answer = 0;
    for(let i=1;i<array.length-1;){
        const isPeak = array[i-1] < array[i] && array[i+1] < array[i];
        if(!isPeak){
            i ++;
            continue;
        }
        let leftIdx = i - 2;
        while(0<=leftIdx && array[leftIdx] < array[leftIdx+1]){
            leftIdx -- ;
        }
        let rightIdx = i + 2;
        while(rightIdx < array.length && array[rightIdx] < array[rightIdx-1]){
            rightIdx ++ ;
        }
        let currentLength = rightIdx - leftIdx -1;
        if(currentLength > answer){
            answer = currentLength;
        }
        i = rightIdx;
    }
    return answer;
}

// Do not edit the line below.
exports.longestPeak = longestPeak;
  
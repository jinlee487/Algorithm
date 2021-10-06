function mergeOverlappingIntervals(array) {
    // Write your code here.
    const answer = [];
    array.sort((o1,o2) => o1[0]-o2[0]);
    
    let currentInterval = array[0];
    answer.push(currentInterval);
    
    for(const nextInterval of array) {
        const currentEnd = currentInterval[1];
        const [nextStart,nextEnd] = nextInterval;
        
        if(currentEnd >= nextStart) {
            currentInterval[1] = Math.max(nextEnd,currentEnd);
        } else {
            currentInterval = nextInterval;
            answer.push(currentInterval);
        }
    }
    return answer;
}

// Do not edit the line below.
exports.mergeOverlappingIntervals = mergeOverlappingIntervals;

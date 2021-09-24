function getNthFib(n) {
    // Write your code here.
    if(n===1) return 0;
    if(n===2) return 1;
    return getNthFib(n-1) + getNthFib(n-2);
}

function getNthFib(n, memoize = {1: 0, 2: 1}) {
// Write your code here.
    if(n in memoize) {
        return memoize[n];
    } 
    memoize[n] = getNthFib(n-1, memoize) + getNthFib(n-2, memoize);
    return memoize[n];
}

function getNthFib(n) {
    // Write your code here.
    const firstTwo = [0,1];
    let count = 3;
    while(count <= n){
        let nextFib = firstTwo[0] + firstTwo[1];
        firstTwo[0] = firstTwo[1];
        firstTwo[1] = nextFib;
        count ++;
    }
    return n > 1 ? firstTwo[1] : firstTwo[0];
}

// Do not edit the line below.
exports.getNthFib = getNthFib;

function firstNonRepeatingCharacter(string) {
    // Write your code here.
    for(let i=0;i<string.length;i++){
        let bool = true;
        for(let j=0;j<string.length;j++){
            if(i==j) continue;
            if(string.charAt(i) === string.charAt(j)){
                bool = false;
                break;
            }
        }
        if(bool) return i;
    }
    return -1;
}

function firstNonRepeatingCharacter(string) {
    // Write your code here.
    const hash = {};
    for(const char of string){
        if(char in hash){
            hash[char] += 1;
        } else {
            hash[char] = 1;
        }
    }
    for(let i=0;i<string.length;i++){
        if(hash[string.charAt(i)] === 1) return i;
    }
    return -1;
}

// Do not edit the line below.
exports.firstNonRepeatingCharacter = firstNonRepeatingCharacter;

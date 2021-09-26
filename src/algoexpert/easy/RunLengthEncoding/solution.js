function runLengthEncoding(string) {
    // Write your code here.
    const str = [];
    let j = 1;
    for(let i=1;i<string.length;i++,j++){
        const current = string.charAt(i);
        const previous = string.charAt(i-1);
        if(current != previous || j == 9) {
            str.push(j);
            str.push(previous);
            j = 0;
        }		
    }
    str.push(j);
    str.push(string.charAt(string.length-1));
    return str.join('');
}

// Do not edit the line below.
exports.runLengthEncoding = runLengthEncoding;
  
function caesarCipherEncryptor(string, key) {
    // Write your code here.
    const answer = [];
    for(const a of string){
        const letterCode = a.charCodeAt() + key%26;
        const newLetter = letterCode <= 122 ? 
                    String.fromCharCode(letterCode) : 
                    String.fromCharCode(96 + (letterCode % 122));
        answer.push(newLetter)
    }
    return answer.join('');
}

function caesarCipherEncryptor(string, key) {
    // Write your code here.
    const answer = [];
    const alphabet = "abcdefghijklmnopqrstuvwxyz";
    for(const a of string){
        answer.push(alphabet.charAt((alphabet.indexOf(a)+key%26)%26));
    }
    return answer.join('');
}

// Do not edit the line below.
exports.caesarCipherEncryptor = caesarCipherEncryptor;
  
function minimumCharactersForWords(words) {
  // Write your code here.
	const obj = {};
	for(const word of words){
		const characters = {};
		for(const c of word){
			if(!(c in characters)){
				characters[c] = 0;
			}
			characters[c]+=1;
		}
		for(const c in characters){
			if(c in obj){
				obj[c] = Math.max(characters[c],obj[c]);
			} else {
				obj[c] = characters[c];
			}
		}
	}
	const answer = [];
	for(const c in obj){
		for(let i=0;i<obj[c];i++){
			answer.push(c);
		}
	}
  return answer;
}

// Do not edit the line below.
exports.minimumCharactersForWords = minimumCharactersForWords;

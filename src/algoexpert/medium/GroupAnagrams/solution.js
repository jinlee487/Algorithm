function groupAnagrams(words) {
    // Write your code here.
	const sorted = words.map(word=>word.split('').sort().join(''));
	const indicies = [...Array(words.length).keys()];
	indicies.sort((a,b) => {
		if(sorted[a]<sorted[b]) return -1;
		else if(sorted[a]>sorted[b]) return 1;
		else return 0;
	});
    const answer = [];
    let current = [];
    let anagram = "";
    for(const idx of indicies){
        const word = words[idx];
        const sortedWord = sorted[idx];
        if(anagram === "") anagram = sortedWord;
        if(sortedWord === anagram) current.push(word);
        else {
            answer.push(current);
            current = [word];
            anagram = sortedWord;
        }
    }
    return answer;



  }
  
  // Do not edit the line below.
  exports.groupAnagrams = groupAnagrams;
  
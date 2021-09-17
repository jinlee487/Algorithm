function isValidSubsequence(array, sequence) {
	// O(n) time | O(1) space n is the length of the array
	let j = 0;
	for(let i=0;i<array.length && j<sequence.length; i++){
		if(array[i]==sequence[j]){
			j++;
		}
	}
	return j==sequence.length;
}

// Do not edit the line below.
exports.isValidSubsequence = isValidSubsequence;

function largestRange(array) {
  // Write your code here.
	let answer = [];
	let longestLength = 0;
	const obj = {};
	for (const v of array) {
		obj[v] = true;
	}
	for (const v of array){
		if(!obj[v]) continue;
		obj[v] = false;
		let currentLength = 1;
		let left = v-1;
		let right = v+1;
		while(left in obj){
			obj[v] = false;
			currentLength ++;
			left --;
		}
		while(right in obj){
			obj[v] = false;
			currentLength ++;
			right ++;
		}
		if(currentLength > longestLength) {
			longestLength = currentLength;
			answer = [left+1,right-1];		
		}
	}
	return answer;
}

// Do not edit the line below.
exports.largestRange = largestRange;

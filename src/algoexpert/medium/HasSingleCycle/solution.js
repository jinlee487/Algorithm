function hasSingleCycle(array) {
  // Write your code here.
	let visited = 0;
	let current = 0;
	while(visited < array.length){
		if(visited > 0 && current ==0) return false;
		visited ++;
		current = getNext(current, array);
	}
	return current === 0;
}
function getNext(current, array){
	const jump = array[current];
	const next = (current + jump) % array.length;
	return next >= 0 ? next : next + array.length;
}

// Do not edit the line below.
exports.hasSingleCycle = hasSingleCycle;

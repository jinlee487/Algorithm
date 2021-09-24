function binarySearch(array, target) {
    // Write your code here.
    return binarySearchHelper(array, target, 0, array.length-1);
  }
  function binarySearchHelper(array, target, left, right) {
    if(left > right) return -1;
    const mid = Math.floor((left + right) / 2);
    if(array[mid] === target) return mid;
    else if(target < array[mid]) return binarySearchHelper(array, target, left, mid - 1);
    else return binarySearchHelper(array, target, mid + 1, right);
  }
  function binarySearchHelper(array, target, left, right) { 
	while(left <= right){
		const mid = Math.floor((left + right ) / 2);
		if(array[mid] === target) return mid;
		else if (target < array[mid]) right = mid - 1;
		else left = mid + 1;
	}
	return -1; 
}
// Do not edit the line below.
exports.binarySearch = binarySearch;
  
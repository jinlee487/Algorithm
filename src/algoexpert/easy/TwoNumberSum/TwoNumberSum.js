// O(n^2)time | O(1) space
function twoNumberSum(array, targetSum) {
  
	for(let i=0;i<array.length-1;i++){
		for(let j=i+1;j<array.length;j++){
			if(array[i]+array[j]==targetSum){
				return [array[i],array[j]]
			}
		}
	}
	return []
}

// Do not edit the line below.
exports.twoNumberSum = twoNumberSum;

function twoNumberSum(array, targetSum) {
// O(n) tine | O(n) space
    const nums = {};
    for(const num of array){
        const temp = targetSum - num;
        if(temp in nums){
            return [temp, num];
        } else {
            nums[num] = true;
        }
    }
    return []
    
}

// Do not edit the line below.
exports.twoNumberSum = twoNumberSum;

function twoNumberSum(array, targetSum) {
// O(nlog(n)) | O(1) space
    array.sort((a,b) => a-b);
    let left = 0;
    let right = array.length -1;
    while (left < right) {
        const temp = array[left] + array[right];
        if(temp == targetSum){
            return [array[left],array[right]];
        }
        else if (temp < targetSum){
            left += 1;
        }
        else if (temp > targetSum){
            right -= 1;
        }
    }
    return []
}

// Do not edit the line below.
exports.twoNumberSum = twoNumberSum;

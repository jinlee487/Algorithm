function balancedBrackets(string) {
  // Write your code here.
	const open = '([{';
	const close = ')}]';
	const match = {')':'(','}':'{',']':'['};
	const stack = [];
	for(const char of string){
		if(open.includes(char)) stack.push(char);
		else if(close.includes(char)){
			if(stack.length === 0) return false;
			if(stack.pop() !== match[char]) return false;
		}
	}
	return stack.length === 0;
}

// Do not edit the line below.
exports.balancedBrackets = balancedBrackets;

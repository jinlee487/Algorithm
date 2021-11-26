function shortenPath(path) {
  // Write your code here.
	const arr = path.split('/');
	let isRelative = false;
	const stack = [];
	if(arr.length===0) return "/";
	let i=0;
	if(arr[0] === "") {
		isRelative = true;
		i++;
	}
	for(;i<arr.length;i++) {
		const str = arr[i];
		if(str==="" || str===".") continue;
		else if(str===".."){
			if(stack.length != 0) {
				if(stack[stack.length-1] === "..") stack.push(str);
				else stack.pop();
			} else {
				if(!isRelative) stack.push(str);
			}
		} else stack.push(str);
	}
	if(isRelative) return "/" + stack.join("/");
	else return stack.join("/");
}

// Do not edit the line below.
exports.shortenPath = shortenPath;

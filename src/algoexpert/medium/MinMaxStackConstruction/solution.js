// Feel free to add new properties and methods to the class.
class MinMaxStack {
	constructor(){
		this.minMaxStack = [];
		this.stack = [];
	}
  peek() {
    // Write your code here.
		return this.stack[this.stack.length-1];
  }

  pop() {
    // Write your code here.
		this.minMaxStack.pop();
		return this.stack.pop();
  }

  push(number) {
    // Write your code here.
		const newMinMax = [number,number];
		if(this.minMaxStack.length){
			const lastMinMax = this.minMaxStack[this.minMaxStack.length-1];
			newMinMax[0] = Math.min(lastMinMax[0],number);
			newMinMax[1] = Math.max(lastMinMax[1],number);
		}
		this.minMaxStack.push(newMinMax);
		this.stack.push(number);
  }

  getMin() {
    // Write your code here.
		return this.minMaxStack[this.minMaxStack.length-1][0];
  }

  getMax() {
    // Write your code here.
		return this.minMaxStack[this.minMaxStack.length-1][1];
  }
}

// Do not edit the line below.
exports.MinMaxStack = MinMaxStack;

# Feel free to add new properties and methods to the class.
class MinMaxStack:
    def __init__(self):
        self.minMaxStack = []
        self.stack = []
		
    def peek(self):
        # Write your code here.
        return self.stack[len(self.stack)-1]

    def pop(self):
        # Write your code here.
        self.minMaxStack.pop()
        return self.stack.pop()

    def push(self, number):
        # Write your code here.
        newMinMax = [number,number]
        if len(self.minMaxStack):
            lastMinMax = self.minMaxStack[len(self.minMaxStack)-1]
            newMinMax[0] = min(lastMinMax[0],number)
            newMinMax[1] = max(lastMinMax[1],number)
        self.minMaxStack.append(newMinMax)
        self.stack.append(number)

    def getMin(self):
        # Write your code here.
        return self.minMaxStack[len(self.minMaxStack)-1][0]

    def getMax(self):
        # Write your code here.
        return self.minMaxStack[len(self.minMaxStack)-1][1]


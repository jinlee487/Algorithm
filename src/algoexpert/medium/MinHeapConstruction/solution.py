# Do not edit the class below except for the buildHeap,
# siftDown, siftUp, peek, remove, and insert methods.
# Feel free to add new properties and methods to the class.
class MinHeap:
    def __init__(self, array):
        # Do not edit the line below.
        self.heap = self.buildHeap(array)

    def buildHeap(self, array):
        # Write your code here.
		firstParentIdx = (len(array)-2)//2
		for i in reversed(range(firstParentIdx+1)):
			self.siftDown(i,len(array)-1, array)
		return array

    def siftDown(self, currentIdx, endIdx, heap):
        # Write your code here.
		childOneIdx = currentIdx * 2 + 1
		childTwoIdx = currentIdx * 2 + 2
		while childOneIdx <= endIdx:
			if childTwoIdx <= endIdx and heap[childTwoIdx] < heap[childOneIdx]:
				idxToSwap = childTwoIdx
			else:
				idxToSwap = childOneIdx
    
			if heap[idxToSwap] < heap[currentIdx]:
				self.swap(currentIdx, idxToSwap, heap)
				currentIdx = idxToSwap
				childOneIdx = currentIdx * 2 + 1
				childTwoIdx = currentIdx * 2 + 2
			else:
				return

    def siftUp(self, currentIdx, heap):
        # Write your code here.
		parentIdx = (currentIdx - 1) // 2
		while currentIdx > 0 and heap[currentIdx] < heap[parentIdx]:
			self.swap(currentIdx, parentIdx, heap)
			currentIdx = parentIdx
			parentIdx = (currentIdx - 1) // 2
        pass

    def peek(self):
        # Write your code here.
        return self.heap[0]

    def remove(self):
        # Write your code here.
		self.swap(0,len(self.heap)-1,self.heap)
		valueToSwap = self.heap.pop()
		self.siftDown(0,len(self.heap)-1,self.heap)
		return valueToSwap

    def insert(self, value):
        # Write your code here.
		self.heap.append(value)
		self.siftUp(len(self.heap)-1,self.heap)
    
	def swap(self, i, j, heap):
		heap[i], heap[j] = heap[j], heap[i]

# This is an input class. Do not edit.
class LinkedList:
    def __init__(self, value):
        self.value = value
        self.next = None


def sumOfLinkedLists(linkedListOne, linkedListTwo):
    # Write your code here.
    answer = LinkedList(0)
    sumOfLinkedListsHelper(linkedListOne,linkedListTwo,answer,0)
    return answer
def sumOfLinkedListsHelper(linkedListOne,linkedListTwo,answer,carry):
	answer.value = linkedListOne.value + linkedListTwo.value + carry
	carry = answer.value // 10
	answer.value = answer.value % 10
	if linkedListOne.next is None and linkedListTwo.next is None and carry == 0:
		return
	answer.next = LinkedList(0)
	nextOne = LinkedList(0) if linkedListOne.next is None else linkedListOne.next
	nextTwo = LinkedList(0) if linkedListTwo.next is None else linkedListTwo.next
	sumOfLinkedListsHelper(nextOne,nextTwo,answer.next,carry)

def sumOfLinkedLists(linkedListOne, linkedListTwo):
    # Write your code here.
    answer = LinkedList(0)
    current = answer
    carry = 0
    nodeOne = linkedListOne
    nodeTwo = linkedListTwo
    while nodeOne is not None or nodeTwo is not None or carry != 0:
        valueOne = nodeOne.value if nodeOne is not None else 0
        valueTwo = nodeTwo.value if nodeTwo is not None else 0
        current.next = LinkedList(valueOne + valueTwo + carry)
        current = current.next
        carry = current.value // 10
        current.value = current.value % 10
        nodeOne = nodeOne.next if nodeOne is not None else None
        nodeTwo = nodeTwo.next if nodeTwo is not None else None
    return answer.next


	
	
	
	
	
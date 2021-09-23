# This is an input class. Do not edit.
class LinkedList:
    def __init__(self, value):
        self.value = value
        self.next = None


def removeDuplicatesFromLinkedList(linkedList):
    # Write your code here.
    node = linkedList
    while node is not None:
        nextNode = node.next
        while nextNode is not None and nextNode.value == node.value:
            nextNode = nextNode.next
        node.next = nextNode
        node = nextNode 
    return linkedList

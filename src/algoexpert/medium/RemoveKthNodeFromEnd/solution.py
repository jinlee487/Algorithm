# This is an input class. Do not edit.
class LinkedList:
    def __init__(self, value):
        self.value = value
        self.next = None


def removeKthNodeFromEnd(head, k):
    # Write your code here.
    count = removeKthNodeFromEndHelper(head,k,0) 
    if count == k:
        head.value = head.next.value
        head.next = head.next.next
    return
def removeKthNodeFromEndHelper(node,k,count):
    if node.next is None:
        return count + 1
    count = removeKthNodeFromEndHelper(node.next,k,count)
    if count == k:
        node.next = node.next.next
    return count + 1
    # This is an input class. Do not edit.
class LinkedList:
    def __init__(self, value):
            self.value = value
            self.next = None


def removeKthNodeFromEnd(head, k):
    # Write your code here.
    count = 1
    first = head
    second = head
    while count <= k:
        count += 1
        second = second.next
    if second is None:
        head.value = head.next.value
        head.next = head.next.next
        return
    while second.next is not None:
        second = second.next
        first = first.next
    first.next = first.next.next

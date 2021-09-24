# Tip: You can use the type(element) function to check whether an item
# is a list or an integer.
def productSum(array, depth = 1):
    # Write your code here.
    sum = 0
    for element in array:
        if type(element) is list:
            sum += productSum(element, depth + 1)
        else: 
            sum += element
    return sum * depth

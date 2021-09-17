def isValidSubsequence(array, sequence):
    # Write your code here.
	i = 0
	j = 0
	while i < len(array) and j < len(sequence):
		if array[i] == sequence[j]:
			j += 1
		i += 1
	return j == len(sequence)

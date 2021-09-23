def classPhotos(redShirtHeights, blueShirtHeights):
    # Write your code here.
	redShirtHeights.sort()
	blueShirtHeights.sort()
	red = True if redShirtHeights[0] < blueShirtHeights[0] else False
	for i in range(len(redShirtHeights)):
		if red:
			if redShirtHeights[i] >= blueShirtHeights[i]:
				return False
		else:
			if redShirtHeights[i] <= blueShirtHeights[i]:
				return False
	return True

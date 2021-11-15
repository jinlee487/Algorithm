Four Number Sum

For this problem, we have to create a map to keep track of the sums of the numbers. To resolve the issue of the duplicate keys being used more than once, we only add the second time the combination appears. We can achieve only adding the previous numbers before our loop to check for the combinations. 

		// Average: )(n^2) time | O(n^2) space
		// worst O(n^3) time | O(n^2) space
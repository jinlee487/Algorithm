For this problem, we have to sort the two arrays and compare the values by index.

If we want the smallest total speed, we can compare the two ascending arrays. 

if we want the biggest total speed, we can compare the ascending array with the descending array.

 This will result in a O(nlog(n)) time because sorting takes nlog(n) time max. and O(1) since we are calling by the index therefore constant time.

For Java, we have to take in to consideration of the following... 

4. Sorting in Descending Order
4.1. Primitives
Sorting a primitive array in descending order is not quite as simple as sorting it in ascending order because Java doesn't support the use of Comparators on primitive types. To overcome this shortfall we have a few options.

First, we could sort our array in ascending order and then do an in-place reversal of the array.

Second, could convert our array to a list, use Guava's Lists.reverse() method and then convert our list back into an array.

https://www.baeldung.com/java-sorting-arrays
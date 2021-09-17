
competitions = [
  ["HTML", "C#"],
  ["C#", "Python"],
  ["Python", "HTML"]
]
results = [0, 0, 1]

for this problem, I solved it by using a hashmap. Using a hashmap is the best option.

We can loop through competitions array and check who the winning team is. 

We then add the winning team to the hash map. 

Afterwards, we can retrieve the current total points for the winner and compare it to the last winner's point tally.

If the current winner has higher points, we can replace the answer. 

We repeat the process until the loop is done. 

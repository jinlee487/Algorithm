def tournamentWinner(competitions, results):
    # Write your code here.
	answer = ""
	scores = {answer : 0}
	for i, competition in enumerate(competitions):
		home, away = competition
		win = home if results[i]==1 else away
		if win in scores:
			scores[win] = scores[win] + 3
		else: 
			scores[win] = 3		
		if scores[answer]<scores[win]:
			answer=win
    return answer

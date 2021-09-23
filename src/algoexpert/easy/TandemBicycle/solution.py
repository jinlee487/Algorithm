def tandemBicycle(redShirtSpeeds, blueShirtSpeeds, fastest):
    # Write your code here.
    answer = 0
    redShirtSpeeds.sort()
    if fastest:
        blueShirtSpeeds.sort(reverse=True)
    else: 
        blueShirtSpeeds.sort()
    for i in range(len(blueShirtSpeeds)):
        if redShirtSpeeds[i] < blueShirtSpeeds[i]:
            answer += blueShirtSpeeds[i]
        else:
            answer += redShirtSpeeds[i]
    return answer

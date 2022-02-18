class Solution:
    def check(self, digit: int, currentDigit: int) -> bool:
        if digit == 4 and currentDigit != 5:
            return False
        elif digit == 9 and currentDigit != 1: 
            return False
        return True
    def intToRoman(self, num: int) -> str:
        dic = {
            "I" : 1,
            "IV": 4,
            "V" : 5,
            "IX": 9,
            "X" : 10,
            "LX": 40,
            "L" : 50,
            "XC": 90,
            "C" : 100,
            "CD": 400,
            "D" : 500,
            "CM": 900, 
            "M" : 1000
        }
        dic = {value : key for (key, value) in dic.items()}
        nums = sorted (dic.keys(),reverse=True)
        l = []
        
        for number in nums:
            if num<number: 
                continue
            current = number
            count = int(num/current)
            num = num%current
           
            l.append(dic[current]*count)                 
        return "".join(l)

p = Solution()
input = 1994
print(p.intToRoman(input))
print(p.intToRoman(input)=="MCMXCIV")
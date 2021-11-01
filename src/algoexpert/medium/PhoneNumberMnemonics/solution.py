def phoneNumberMnemonics(phoneNumber):
    # Write your code here.
    arr = ["0"]*len(phoneNumber)
    answer = []
    phoneNumberMnemonicsHelper(0,phoneNumber,arr,answer)
    return answer
def phoneNumberMnemonicsHelper(
	idx,phoneNumber,arr,answer):
	if idx == len(phoneNumber):
		answer.append(''.join(arr))
		return
	mnemonics = DIC[phoneNumber[idx]]
	for i in range(len(mnemonics)):
		arr[idx] = mnemonics[i]
		phoneNumberMnemonicsHelper(idx+1,phoneNumber,arr,answer)
	return
DIC = {
	"0":["0"],
	"1":["1"],
	"2":["a","b","c"],
	"3":["d","e","f"],
	"4":["g","h","i"],
	"5":["j","k","l"],
	"6":["m","n","o"],
	"7":["p","q","r","s"],
	"8":["t","u","v"],
	"9":["w","x","y","z"]
}
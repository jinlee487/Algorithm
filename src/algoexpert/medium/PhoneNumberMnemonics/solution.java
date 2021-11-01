package algoexpert.medium.PhoneNumberMnemonics;

import java.util.*;

class Program {

  public ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
    // Write your code here.
		// O(4^n*n) time | O(4^n*n) space where n is the length of the phone number
		List<Character[]> arrayList = new ArrayList<Character[]>();
		arrayList.add(new Character[]{'0'});
		arrayList.add(new Character[]{'1'});
		arrayList.add(new Character[]{'a','b','c'});
		arrayList.add(new Character[]{'d','e','f'});
		arrayList.add(new Character[]{'g','h','i'});
		arrayList.add(new Character[]{'j','k','l'});
		arrayList.add(new Character[]{'m','n','o'});
		arrayList.add(new Character[]{'p','q','r','s'});
		arrayList.add(new Character[]{'t','u','v'});
		arrayList.add(new Character[]{'w','x','y','z'});
		ArrayList<String> answer = new ArrayList<String>();
		char[] arr = new char[phoneNumber.length()];
		// String string = new String(charArray);
    return phoneNumberMnemonics(0,phoneNumber, arr, arrayList, answer);
  }
	public ArrayList<String> phoneNumberMnemonics(int idx, String phoneNumber, 
			char[] arr, List<Character[]> arrayList, ArrayList<String> answer){
		if(idx==phoneNumber.length()){
			answer.add(new String(arr));
			return answer ;
		}
		Character[] mnemonics = arrayList.get(Character.getNumericValue(phoneNumber.charAt(idx)));
		for(int i=0;i<mnemonics.length;i++){
			arr[idx] = mnemonics[i];
			answer = phoneNumberMnemonics(idx+1,phoneNumber, arr, arrayList, answer);
		}
		return answer;
	} 
}

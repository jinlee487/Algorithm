package algoexpert.easy.CaesarCipherEncryptor;

class Program {
  public static String caesarCypherEncryptor(String str, int key) {
    // Write your code here.
		char[] answer = new char[str.length()];
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		for(int i=0;i<str.length();i++){
			answer[i] = alphabet.charAt((alphabet.indexOf(str.charAt(i)) + key % 26)%26);
		}
    return new String(answer);
    }
}

class Program1 {
    public static String caesarCypherEncryptor(String str, int key) {
        // Write your code here.
            char[] answer= new char[str.length()];
            for(int i=0;i<str.length();i++){
                answer[i] = getLetterCode(str.charAt(i), key%26);
            }
        return new String(answer);
    }
    public static char getLetterCode(char letter, int key){
        int newLetterCode = letter + key;
        return newLetterCode <= 122 ? (char) newLetterCode : (char) (96 + newLetterCode % 122);
    }
}
